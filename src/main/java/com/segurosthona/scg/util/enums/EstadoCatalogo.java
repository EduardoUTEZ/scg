package com.segurosthona.scg.util.enums;

import java.util.LinkedHashMap;



/**
 * Estados del catálogo de usuarios
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public enum EstadoCatalogo {

	//Permisos
	SELECCIONE(-1,"Seleccione..."),
	INACTIVO(0,"Inactivo"),
	ACTIVO(1,"Activo")
	;
	
	private Integer value;
	private String label;		
	
	private EstadoCatalogo(Integer value, String label){
		this.label = label;
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
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
		
		LinkedHashMap<String, String> estados = new LinkedHashMap<String, String>();
		// permisos estáticos (de acuerdo a funcionalidades sistema)
		for (EstadoCatalogo p : EstadoCatalogo.values()) {
			estados.put(p.getValue()+"", p.getLabel());
		}
		
		return estados;
	}
	
}
