package com.segurosthona.scg.controller.beans.generic;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.SimpleTypeConverter;


/** A editor which allows the translation between {@link String} and
* {@link Timestamp}.
* 
* 
* @author Miguel Figueroa
* @since 0.1
* 
*/
public class FechaEditor extends PropertyEditorSupport {

	private SimpleDateFormat sdf;

	public FechaEditor(SimpleDateFormat sdf) {
		super();		
		this.sdf = sdf;
	}

	SimpleTypeConverter typeConverter = new SimpleTypeConverter();

	public String getAsText() {
		
		Object obj = getValue();
		
		if (obj == null) {
			
			return null;
		}
		
		return (String) typeConverter.convertIfNecessary(sdf.format(new Date(((Date) obj).getTime())), String.class);
	}

	
	public void setAsText(String text) {
		
		if (text == null || text.length() == 0) {
			setValue(null);
			return;
		}

		Date identifier = null; 
		
		try{
			identifier = sdf.parse(text);
		}catch(Exception exc){
			//System.out.println(exc);
			identifier = null;
		}
		
		if (identifier == null) {
			setValue(null);
			return;
		}
		setValue(new Date(identifier.getTime()));
	}
}