package com.segurosthona.scg.modelo.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * Interfase que representa las operaciones CRUD básicas y genéricas.
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T>
 */
public interface IOperations<T extends Serializable> {

    /**
     * Busca la instancia identificada por id
     * @param id id de la instancia a buscar
     * @return instancia encontrada
     */
	T findOne(final Serializable id);
    T findOne(final Serializable id, final String[] propertiesToInitialize);
    

    /**
     * Lista todas las instancias persistidas
     * @return lista de las instancias tipo <T>
     */
    List<T> findAll();
    List<T> findAll(final String[] propertiesToInitialize);

    /**
     * Persiste una instancia nueva en el repositorio
     * @param entity instancia a persistir
     */
    void create(final T entity);

    /**
     * Actualiza la instancia en el repositorio
     * @param entity instancia a actualizar
     * @return instancia de tipo <T> actualizada 
     */
    T update(final T entity);

    /**
     * Elimina la instancia del repositorio
     * @param entity instancia a ser eliminada
     */
    void delete(final T entity);

    /**
     * Elimina del repositorio la instancia identificada por id
     * @param entityId identificador de la instancia a eliminar
     */
    void deleteById(final Serializable entityId);
    
    /**
     * Cuenta el n�mero de instancias registradas en el repositorio que comparten los mismos valores en 
     * las propiedades indicadas
     * @param object instancia objetivo para la cual queremos saber si existen otras con los mismos valores
     * @param propertiesToCheck propiedades que ser�n revisadas para determinar duplicados 
     * @return n�mero de registros que comparten los mismos valores de las propiedades especificadas que 
     * la instancia objetivo
     */
    long countDuplicates(T object, String[] propertiesToCheck);
    

    /**
     * Valida la integridad de datos para un softdelete
     * @param entity entity to be deleted
     * @throws DataIntegrityViolationException en caso de que la entidad que se pretende borrar se encuentre aun relacionada
     */
	void validateSoftDelete(T entity) throws DataIntegrityViolationException;
    
}