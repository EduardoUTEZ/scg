package com.segurosthona.scg.service.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.segurosthona.scg.modelo.generic.IOperations;






/**
 * Servicio abstracto que implementa las operaciones CRUD b�sicas
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo del modelo al que se asocian los servicios
 */
//@TransactionConfiguration(transactionManager="txManager")
@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

    @Override
    public T findOne(final Serializable id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }
    
    @Override
    public T findOne(final Serializable id, final String[] propertiesToInitialize){
    	return getDao().findOne(id, propertiesToInitialize);
    }
    
    @Override
    public List<T> findAll(final String[] propertiesToInitialize){
    	return getDao().findAll(propertiesToInitialize);
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final Serializable entityId) {
        getDao().deleteById(entityId);
    }

    @Override
    public long countDuplicates(T object, String[] propertiesToCheck){
    	return getDao().countDuplicates(object, propertiesToCheck);
    }

    protected abstract IOperations<T> getDao();
    
    
	@Override
	public void validateSoftDelete(T entity) throws DataIntegrityViolationException {
		getDao().validateSoftDelete(entity);
	}

}