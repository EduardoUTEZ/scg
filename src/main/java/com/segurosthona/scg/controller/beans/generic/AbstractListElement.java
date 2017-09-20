/**
 * 
 */
package com.segurosthona.scg.controller.beans.generic;

import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Representaci�n abstracta de un elemento de listado
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 */
public abstract class AbstractListElement {
	
	
	/**
	 * @return cadena de tipo [propiedad=valor] de las propiedades del objeto
	 */
	public String toString()		
	{				
		int i = 0;
		StringBuilder str = new StringBuilder(this.getClass().getSimpleName()).append(" [");
		for (Field f : this.getClass().getDeclaredFields()) {
			try {
				if(i>0){
					str.append(", ");
				}
				str.append(f.getName()).append("=").append(PropertyUtils.getProperty(this, f.getName()));				
				i++;
			} catch (Exception e) {
				//e.printStackTrace();
			}
		} 
		str.append("]");
		return str.toString();
	}	
	
}
