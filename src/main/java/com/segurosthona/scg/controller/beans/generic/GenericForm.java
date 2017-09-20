/**
 * 
 */
package com.segurosthona.scg.controller.beans.generic;

import org.springframework.beans.BeanUtils;


/**
 * Forma genérica para representación de modelos.
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo de la forma representada
 * @param <S> Tipo del modelo asociado a la forma
 */
public class GenericForm<T, S> extends AbstractForm{
	
	/**
	 * Convierte de un Modelo a una Forma
	 * @param model objeto modelo a ser convertido a su representaci�n de forma
	 * @param clazzForm clase de la forma a convertir
	 * @return Representaci�n del modelo en una Forma para presentaci�n 
	 */
	public T fromOrmModel(S model, Class<T> clazzForm){
		T form;
		try {
			form = clazzForm.newInstance();
			BeanUtils.copyProperties(model, form);
			return form;
		} catch (Exception e) {
			//e.printStackTrace();
		}
				
		return null;
	}
	
	/**
	 * Convierte de una Forma a un Modelo
	 * @param clazzModel clase del modelo a convertir
	 * @return Modelo derivado de la representaci�n de la Forma
	 */
	public S toOrmModel(Class<S> clazzModel){
		S model;
		try {
			model = clazzModel.newInstance();			
			BeanUtils.copyProperties(this, model);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return null;
	}
	
	
}
