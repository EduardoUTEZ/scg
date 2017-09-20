/**
 * 
 */
package com.segurosthona.scg.modelo.generic;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Clase abstracta que implementa las operaciones de la interfase 
 * IGenericModel ({@link IGenericModel}) para uso común de un campo identificador. 
 * De igual manera sobreescribe las operaciones de comparación de instancias y de representaci�n en texto
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo de la clase a la que se asocia el modelo gen�rico 
 */
@SuppressWarnings("serial")
public abstract class GenericModelStr<T extends IGenericModelStr> implements Serializable, IGenericModelStr {	
	
	/**
	 * Sobre-escribe la representaci�n a texto del objeto. Genera una cadena de par "NombrePropiedad=valor" 
	 * para todas las propiedades de la clase
	 * 
	 * @return Cadena de texto que representa al objeto
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
				
				if(f.getType().toString().contains("com.segurosargos.egresoslife.modelo.entidad")){
					str.append(f.getName()).append("=").append(this.getClave());
				}
				else{
					str.append(f.getName()).append("=").append(PropertyUtils.getProperty(this, f.getName()));
				}
				i++;
			} catch (Exception e) {
				//e.printStackTrace();
			}
		} 
		str.append("]");
		return str.toString();
	}	
	
	
	/** 
	 * Sobre-escribe la operaci�n de comparaci�n de objetos, para considerar objetos iguales aquellos 
	 * que comparten el mismo ID
	 * 
	 * @return regresa True en caso de que el objeto pasado como par�metro sea considerado igual al objeto actual
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o == null || !o.getClass().equals(getClass())) {
			return false;
		} else {
			T that = (T) o;
			String thisId = this.getClave();
			String thatId = that.getClave();
			if (thisId == null || thatId == null) {
				return super.equals(that);
			} else {
				return thatId.equals(thisId);
			}
		}
	}	
}
