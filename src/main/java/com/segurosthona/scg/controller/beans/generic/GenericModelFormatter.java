package com.segurosthona.scg.controller.beans.generic;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.segurosthona.scg.modelo.generic.IGenericModel;




/**
 * Formateador gen�rico para modelos
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo del modelo a formatear
 */
public class GenericModelFormatter<T extends IGenericModel> implements Formatter<T>  {
	

		private Class<T> entityClass;

		public GenericModelFormatter(Class<T> entityClass) {
			this.entityClass = entityClass;
		}

		/* (non-Javadoc)
		 * @see org.springframework.format.Printer#print(java.lang.Object, java.util.Locale)
		 */
		@Override
		public String print(T entity, Locale locale) {
			String id = entity.getId().toString();
			return id;
		}

		/* (non-Javadoc)
		 * @see org.springframework.format.Parser#parse(java.lang.String, java.util.Locale)
		 */
		@Override
		public T parse(String id, Locale locale) throws ParseException {

			// Spring calls this method on the way into the controller.
			try {
				//System.out.println("Creating new entity instance for class={}, id={}" + entityClass + "-->" +  id);
				T entity = entityClass.newInstance();
				entity.setId(Integer.parseInt(id));
				return entity;
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}	
}
