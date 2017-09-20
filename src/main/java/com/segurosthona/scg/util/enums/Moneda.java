package com.segurosthona.scg.util.enums;

import java.util.LinkedHashMap;



/**
 * Monedas disponibles
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public enum Moneda {

	//Permisos
	MXP("MXP","Pesos"),
	USD("USD","Dólares")
	;
	
	private String value;
	private String label;		
	
	private Moneda(String value, String label){
		this.label = label;
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Obtiene permisos
	 * @return Regresa la lista de permisos disponibles.
	 */
	public static LinkedHashMap<String, String> getEstados(){
		
		LinkedHashMap<String, String> tipopermisos = new LinkedHashMap<String, String>();
		// permisos estáticos (de acuerdo a funcionalidades sistema)
		for (Moneda p : Moneda.values()) {
			tipopermisos.put(p.getValue(), p.getLabel());
		}
		
		return tipopermisos;
	}
	
	public static Moneda getMoneda(String value){
		for (Moneda p : Moneda.values()) {
			if(p.getValue().equals(value))
				return p;
		}
		return null;
	}
	
}
