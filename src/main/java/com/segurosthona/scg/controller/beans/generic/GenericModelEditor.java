package com.segurosthona.scg.controller.beans.generic;



import java.beans.PropertyEditorSupport;

import org.springframework.beans.SimpleTypeConverter;

import com.segurosthona.scg.modelo.generic.GenericModel;
import com.segurosthona.scg.modelo.generic.IOperations;





/**
 * Property editor de tipo gen�rico para aplicar a la capa de presentaci�n de los modelos
 * 
 * @author OWL - Oscar Lithgow
 * @version 1.0
 *
 * @param <T> Tipo del modelo representado
 */
public class GenericModelEditor<T extends GenericModel<T>> extends PropertyEditorSupport{
	
	private IOperations<T> daoService;

	public GenericModelEditor(IOperations<T> daoService) {
		super();
		this.daoService = daoService;
	}

	SimpleTypeConverter typeConverter = new SimpleTypeConverter();

	@SuppressWarnings("unchecked")
	public String getAsText() {				
		Object obj = getValue();		
		if (obj == null) {			
			return null;
		}
				
		return (String) typeConverter.convertIfNecessary(((T) obj).getId() , String.class);
	}
	
	public void setAsText(String text) {
		
		if (text == null || text.length() == 0) {
			setValue(null);
			return;
		}
				
		String identifier = text;
		if(identifier.equalsIgnoreCase("-1")){
			setValue(null);
			return;
		}		
		
		setValue((T) this.daoService.findOne(Integer.parseInt(identifier)));
	}
}
