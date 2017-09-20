package com.segurosthona.scg.dao.generic;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.dao.DataIntegrityViolationException;

import com.google.common.base.Preconditions;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.util.HibernateUtilsCustom;


/**
 * Clase abstracta de acceso a datos. Esta clase implementa las operaciones CRUD gen�ricas de una
 * clase que ser� persistida.
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo de clase a la que se aplicar�n las operaciones CRUD
 * 
 *  Hitos:
 *  [OWL 20160331] - validate constraints when no associations
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {
    protected Class<T> clazz;

    //@Autowired    
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    // API

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    @Override
    public T findOne(final Serializable id) {
        return (T) getCurrentSession().get(clazz, id);
    }
    

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }
    
    /**
     * Find one instance and initialize the lazy properties specified
     * @param id id of the instance to find
     * @param propertiesToInitialize array of properties to be initialized. Just the property name (ex. Name) not the getter method name
     * @return Object
     */
    public T findOne(final Serializable id, final String[] propertiesToInitialize) {    	
    	T obj = this.findOne(id);    	
    	initializeLazyProperties(obj, propertiesToInitialize);    	    	
        return obj;
    }

    /**
     * Get all the instances and initialize the lazy properties specified
     * @param propertiesToInitialize array of properties to be initialized. Just the property name (ex. Name) not the getter method name
     * @return Object
     */    
    public final List<T> findAll(final String[] propertiesToInitialize) {    	
    	List<T> objs = this.findAll();    	
    	initializeLazyProperties(objs, propertiesToInitialize);    	
        return objs;
    }    
    

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        // getCurrentSession().persist(entity);
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        
        // validate SoftDelete
        //validateSoftDelete(entity);
        
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final Serializable entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }
    
    public final long countDuplicates(T object, String[] propertiesToCheck){

    	String idProperty = this.getIdProperty(object.getClass()); // entity's id property    	
		List<String> ptc = Arrays.asList(propertiesToCheck);
		HashMap<String, Object> values = new HashMap<String, Object>();
    	int numPropsChecked = 0;
    	int numProps = 0;
    	String entity = object.getClass().getName();
    	String entityAlias = entity.substring(entity.lastIndexOf(".")+1).toLowerCase();
    	StringBuilder str = new StringBuilder("select count(*) from ");
    	str.append(entity).append(" ").append(entityAlias);
    	str.append(" where ");

    	for (Field f : object.getClass().getDeclaredFields()) {
    		Object value = null;
    		if(ptc.contains(f.getName()) || f.getName().equals(idProperty)){
    			f.setAccessible(true);
    			try {
    				value = f.get(object);
    				if(value != null){
    					values.put(f.getName(), value);
    				}
    				f.setAccessible(false);
    			} catch (IllegalArgumentException e) {
    				e.printStackTrace();
    			} catch (IllegalAccessException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
        		if(value != null){
        			if(numProps > 0){
        				str.append(" and ");
        			}
        			str.append(entityAlias).append(".").append(f.getName()); //entity.field
        			if(f.getName().equals(idProperty)){
        				str.append("!= :"); // comparison operator
        			}
        			else{
	    				str.append("= :");  // comparison operator
	    				numPropsChecked++; // id property doesn't count
        			}
        			numProps++;
        			str.append(f.getName()); // placeholder
        		}
    		}
    	}    	    	
    	
    	if(numPropsChecked > 0){ 		
	    	Query query = getCurrentSession().createQuery(str.toString());	    	
	    	for (String key : values.keySet()) {
	    		query.setParameter(key, values.get(key));	    		
			}
	    	Long count = (Long)query.uniqueResult();	    	
	    	return count;
    	}
    	
    	return 0;
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * Obtiene el nombre de la propiedad que identifica a un objeto
     * @param entityClass clase del objeto
     * @return nombre de la propiedad identificadora (Ej. id)
     */
    protected String getIdProperty(@SuppressWarnings("rawtypes") Class entityClass) {    	
    	String idProperty=getCurrentSession().getSessionFactory()
    	                                              .getClassMetadata(entityClass)
    	                                              .getIdentifierPropertyName();
    	return idProperty;
    }
    
    
    /**
     * Search and return the getter methods for the given properties 
     * @param properties
     * @return the found getters
     */
    public final List<Method> getGetters(String[] properties){

    	ArrayList<Method> methods = new ArrayList<Method>();
    	
    	for (String property : properties) {
    		System.out.println("Inicializa lazy: " + property);
    		
        	PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(clazz, property);
        	if(pd!=null){
        		Method getter = pd.getReadMethod();        	
        		methods.add(getter);
        	}
		}
    	
    	return methods;
    	
    }
    
    /**
     * Initialize properties of the object
     * @param object object to be initialized
     * @param propertiesToInitialize name of properties to be initialized
     */
    public final void initializeLazyProperties(T object, String[] propertiesToInitialize ){
    	
    	System.out.println("propertiesToInitialize: " + propertiesToInitialize);
    	
       	// initialize lazy properties
    	if(propertiesToInitialize!=null && propertiesToInitialize.length > 0){    		
    		if(propertiesToInitialize[0].equals("*")){ // initialize all object properties    			
    			Hibernate.initialize(object);
    		}
    		else{ // initialize properties specified
    			System.out.println("Inicializa una propiedad específica"); //TODO Verifica
		    	for(Method getter : this.getGetters(propertiesToInitialize)){
		    		try {
						Hibernate.initialize(getter.invoke(object, (Object[])null));					
					} catch (HibernateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
    		}
    	}
    }
    
    /**
     * Initialize properties of the objects
     * @param object objects to be initialized
     * @param propertiesToInitialize name of properties to be initialized
     */    
    private final void initializeLazyProperties(List<T> objects, String[] propertiesToInitialize ){
    	
       	// initialize lazy properties
    	if(propertiesToInitialize!=null && propertiesToInitialize.length > 0){    		
    		if(propertiesToInitialize[0].equals("*")){ // initialize all object properties
    			for (T obj : objects) {
    				Hibernate.initialize(obj);
    			}
    		}
    		else{ // initialize properties specified    			    		
	    		for (T obj : objects) {
			    	for(Method getter : this.getGetters(propertiesToInitialize)){
			    		try {
							Hibernate.initialize(getter.invoke(obj, (Object[])null));					
						} catch (HibernateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}
	    		}
    		}
    	}
    }    
    
	@Override
	public void validateSoftDelete(T entity) throws DataIntegrityViolationException {
		
		Map<String, List<String[]>> assoc = HibernateUtilsCustom.getMappingAssocations(getCurrentSession().getSessionFactory(), "scg", ""); //, clazz.getName());
		
		if(assoc==null || assoc.isEmpty()) return; // if there are not assocs... do not search constraints
		
		String idProperty = this.getIdProperty(entity.getClass()); // entity's id property	
		String id = new BeanWrapperImpl(entity).getPropertyValue(idProperty).toString();
		
		StringBuilder refs = new StringBuilder();
		
		String entityName = clazz.getName();
		if(entityName==null || entityName.isEmpty()) return; // if no entity name... do not search constraints
		
		//System.out.println("VALIDATE-->" + entityName);
		List<String[]> assocXentity = assoc.get(entityName);
		if(assocXentity==null || assocXentity.isEmpty()) return; // no association for entity... do not search constraints //[OWL 20160331] - validate constraints when no associations
		for (String[] asoc : assocXentity) {
			try{
				if(asoc[4].equals("CONSTRAIN")){
					StringBuilder hql = new StringBuilder("SELECT count(e) FROM ");
					hql.append(asoc[0]).append(" e ");
					hql.append(" WHERE e.").append(asoc[1].trim()).append(".id = ").append(id);
					//System.out.println("\tHQL-->" + hql.toString());				
		
					Query query = getCurrentSession().createQuery(hql.toString());						
					Long rs = Long.parseLong(query.uniqueResult().toString());
					if(rs != null && rs>0){
						//System.out.println("\tRS-->" +  rs);					
						if(refs.length()>0) refs.append(",");
						refs.append(asoc[0].contains(".") ? asoc[0].substring(asoc[0].lastIndexOf(".")+1) : asoc[0]);					
					}
				}
			}
			catch(Exception e){					
				e.printStackTrace();
			}
		}

		
		if(refs.length()>0){
			throw new DataIntegrityViolationException("referenced_entities:" + refs.toString());
		}
		
	}    

}