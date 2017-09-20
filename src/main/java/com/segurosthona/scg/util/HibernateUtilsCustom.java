package com.segurosthona.scg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.persister.collection.BasicCollectionPersister;
import org.hibernate.persister.collection.OneToManyPersister;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.tuple.StandardProperty;
import org.hibernate.type.ManyToOneType;
import org.hibernate.type.OneToOneType;
import org.hibernate.type.Type;

public class HibernateUtilsCustom {
	
    /**
     * Get the Hibernate associations 
     * @param sessionFactory
     * @param filterPackage [Optional] package to filter Ex: sisaa
     * @param targetEntity [Optional] entity to get associations from. Ex: Role
     * @return
     */
    public static Map<String, List<String[]>> getMappingAssocations(SessionFactory sessionFactory, String filterPackage, String targetEntity){
    	targetEntity="";    	
    	Map<String, ClassMetadata> metas = sessionFactory.getAllClassMetadata();
    	        	
    	@SuppressWarnings("unchecked")
		Map<String,CollectionMetadata> map = sessionFactory.getAllCollectionMetadata();
            	
    	// get Standard property by class field for all classes
    	HashMap<String, StandardProperty> stdProps = new HashMap<String, StandardProperty>();
    	for (String className : metas.keySet()) {
	    	AbstractEntityPersister aep=((AbstractEntityPersister) metas.get(className));
	    	for (StandardProperty prop : aep.getEntityMetamodel().getProperties()) {	    		
	    		stdProps.put(className+"."+ prop.getName(), prop);
	    	}	    	    	
    	}
    	
        // <Entity, List<[AsocEntity, AsocProperty, AsocType]>>
        Map<String, List<String[]>> associations = new HashMap<String, List<String[]>>();
        for (String entityName1 : metas.keySet()) {
        	if(filterPackage==null || filterPackage.isEmpty() || entityName1.toLowerCase().contains(filterPackage.toLowerCase()) ){
	        	ClassMetadata meta1 = metas.get(entityName1);
	        	for (String entityName2 : metas.keySet()) {
	        		ClassMetadata meta2 = metas.get(entityName2);
	        		if(filterPackage == null || filterPackage.isEmpty() || entityName2.toLowerCase().contains(filterPackage.toLowerCase()) ){
	        			if(targetEntity == null || targetEntity.isEmpty() || entityName2.toLowerCase().endsWith(targetEntity.toLowerCase()) ){
	        				getAssociation(entityName1, entityName2, meta1, meta2, map, stdProps, associations, sessionFactory);
	        			}
	        		}
	        	}
        	}
        }
        
        unConstrain(associations);
        
//        for (String ent : associations.keySet()) {
//        	System.out.println("---->" + ent);        	
//			for (String[] vals : associations.get(ent)) {
//				System.out.println("\t" + StringUtils.join(vals, ", "));				
//			}
//		}
        
        return associations;
    }
    
    /**
     * TRaverse associations to unconstraint those with inverse relation
     * @param associations
     */
    private static void unConstrain(Map<String, List<String[]>> associations){
    	for (String targetClass : associations.keySet()) {
			for (String[] relatedClass : associations.get(targetClass)) {
				if(associations.containsKey(relatedClass[0])){				
					List<String[]> assocs = associations.get(relatedClass[0]);
					for (String[] assoc : assocs) {
						if(assoc[0].equalsIgnoreCase(targetClass) && (assoc[3].contains("STYLE_DELETE") || assoc[3].contains("STYLE_ALL") ) ){
							assoc[4]="";
							relatedClass[4]="";
						}
					}  
				}
				if(!relatedClass[4].isEmpty() && 
						( (relatedClass[3].contains("STYLE_DELETE") || relatedClass[3].contains("STYLE_ALL")) || relatedClass[2].equalsIgnoreCase("ONE_TO_MANY") ) ) {
					relatedClass[4] = "";
				}
			}
		}
    }

    
    /**
     * Get associations between class1 and class2 and put them into the associations Map
     * @param class1
     * @param class2
     * @param classMetadata1 Metadata of class1
     * @param allCollectionMetadata all collections metadata to inspect
     * @param associations Map where found associations would be added
     */
    private static void getAssociation(String class1, String class2, ClassMetadata classMetadata1, ClassMetadata classMetadata2, 
    		Map<String,CollectionMetadata> allCollectionMetadata, HashMap<String, StandardProperty> stdProps, 
    		Map<String, List<String[]>> associations, SessionFactory sessionFactory){
    	
    	// Retrieve all properties of the first class
        String[] propertyNames = classMetadata1.getPropertyNames();
        String asocType="";

        //Loop through the retrieved properties
        for (String name : propertyNames) {

            //Retrieve type of each property
            Type type = classMetadata1.getPropertyType(name.trim());

            //Check if the type is association type
            if (type.isAssociationType()) {
            	String keyProp = class1 + "." + name;
            	String cascadeType = stdProps.containsKey(keyProp)? stdProps.get(keyProp).getCascadeStyle().toString():"";
            	
            	String relation = "CONSTRAIN";

                //Check if it is collection type.
                if (type.isCollectionType()) {

                    //From retrieved collection metadata (Strp 3) get value of the property we are refering to.
                    CollectionMetadata collectionMetadata = allCollectionMetadata.get( class1 + "." + name);                                                           

                    //Check if the elements of the collection are of desiered type
                    if (collectionMetadata!=null && collectionMetadata.getElementType().getName().trim().equals(class2)) {
                        //Check if the value is of type OneToManyPersister
                        if (collectionMetadata instanceof OneToManyPersister) {
                        	asocType="ONE_TO_MANY";
                            if(!associations.containsKey(class2)) associations.put(class2, new ArrayList<String[]>());
                            associations.get(class2).add(new String[]{class1,name,asocType,cascadeType,relation});
                            continue;
                        } //Check if the value is of type BasicCollectionPersister. Note that for many to many relationship it would return an object of type BasicCollectionPersister.
                        else if (collectionMetadata instanceof BasicCollectionPersister) {
                            if (((BasicCollectionPersister) collectionMetadata).isManyToMany()) {
                            	asocType="MANY_TO_MANY";
                                if(!associations.containsKey(class2)) associations.put(class2, new ArrayList<String[]>());
                                associations.get(class2).add(new String[]{class1,name,asocType,cascadeType, relation});
                                continue;
                            }
                        }
                    }
                } //If property is not a collection then retrieve the class of the type and check if it is the same as Second class.
//                else if (type.getReturnedClass().getTypeName().equals(class2)) {
                else if (type.getReturnedClass().getCanonicalName().equals(class2)) {
                    if (type instanceof ManyToOneType) {                    	
                    	asocType="MANY_TO_ONE";
                        if(!associations.containsKey(class2)) associations.put(class2, new ArrayList<String[]>());
                        associations.get(class2).add(new String[]{class1,name,asocType, cascadeType,relation});
                        continue;
                    } else if (type instanceof OneToOneType) {
                    	asocType="ONE_TO_ONE";
                        if(!associations.containsKey(class2)) associations.put(class2, new ArrayList<String[]>());
                        associations.get(class2).add(new String[]{class1,name,asocType,cascadeType, relation});
                        continue;
                    }
                }
            }
        }
    }	
    
    
}
