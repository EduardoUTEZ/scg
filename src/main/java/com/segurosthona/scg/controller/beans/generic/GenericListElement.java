/**
 * 
 */
package com.segurosthona.scg.controller.beans.generic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

import com.segurosthona.scg.modelo.generic.IGenericModel;






/**
 * Representaci�n gen�rica de un elemento de listado
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo del elemento de listado
 * @param <S> Tipo del modelo asociado
 */
public class GenericListElement<T extends IGenericModel, S> extends AbstractListElement {
	
	/**
	 * Convierte de una lista de Modelos a una lista de Elementos de listado 
	 * @param models modelos a convertir
	 * @param clazzList classe del elemento de listado
	 * @return lista de elementos de listado para capa de presentaci�n
	 */
	public List<T> fromOrmModel(List<S> models, Class<T> clazzList){
		List<T> list = new ArrayList<T>();		
		for (S element : models) {
			list.add(this.fromOrmModel(element, clazzList));
		}
		
		return list;
	}
	
	/**
	 * Convierte un Modelo a un elemento de listado
	 * @param model modelo a convertir
	 * @param clazzList classe del elemento de listado
	 * @return elemento de listado para representar modelo en capa de presentaci�n
	 */
	public T fromOrmModel(S model, Class<T> clazzList){
		T form;
		try {
			form = clazzList.newInstance();
			BeanUtils.copyProperties(model, form);
			return form;
		} catch (Exception e) {
			//e.printStackTrace();
		}
				
		return null;
	}
	
	/**
	 * Convierte un elemento de listado a un modelo
	 * @param clazzModel classe del modelo
	 * @return Modelo representado por el elemento de listado
	 */
	public S toOrmModel(Class<S> clazzModel){
		S model;
		try {
			model = clazzModel.newInstance();			
			BeanUtils.copyProperties(this, model);
			return model;
		} catch (Exception e) {
			//e.printStackTrace();
		}
				
		return null;
	}
	
	/**
	 * @return cadena representando el elemento de listado (sólo id) 	
	 */
	@Override
	public String toString(){
		try {
			return PropertyUtils.getProperty(this, "id").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "";
	}
	
	
}
