/**
 * 
 */
package com.segurosthona.scg.service.generic;

import java.io.Serializable;

import org.springframework.validation.BindingResult;

import com.segurosthona.scg.modelo.generic.IOperations;



/**
 * Clase gen�rica que representa operaciones comunes a un servicio b�sico CRUD
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> tipo del modelo al que se asocian los servicio
 */
public interface CrudService<T extends Serializable> extends IOperations<T> {

	/**
	 * Funci�n de validación (reglas de negocio) invocada antes de persistir una entidad nuevo
	 * @param entity entidad a crear
	 * @param result resultado de la validación
	 */
	public void validateBeforeCreate(T entity, BindingResult result);
	
	/**
	 * Funci�n de validación (reglas de negocio) invocada antes de actualizar una entidad 
	 * @param entity entidad a actualizar
	 * @param result resultado de la validación
	 */
	public void validateBeforeUpdate(T entity, BindingResult result);
	
	/**
	 * Funci�n de validación (reglas de negocio) invocada antes de eliminar una entidad
	 * @param entity entidad a eliminar
	 * @param result resultado de la validación
	 */
	public void validateBeforeDelete(T entity, BindingResult result);
	
}
