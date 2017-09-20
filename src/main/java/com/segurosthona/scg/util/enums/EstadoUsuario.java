package com.segurosthona.scg.util.enums;

import java.util.LinkedHashMap;



/**
 * Estados del catálogo de usuarios
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public enum EstadoUsuario {

	//Permisos
	INACTIVO(0,"Inactivo"),
	ACTIVO(1,"Activo")
	;
	
	private Integer value;
	private String label;		
	
	private EstadoUsuario(Integer value, String label){
		this.label = label;
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
	public static LinkedHashMap<Integer, String> getEstados(){
		
		LinkedHashMap<Integer, String> tipopermisos = new LinkedHashMap<Integer, String>();
		// permisos estáticos (de acuerdo a funcionalidades sistema)
		for (EstadoUsuario p : EstadoUsuario.values()) {
			tipopermisos.put(p.value, p.getLabel());
		}
		
		return tipopermisos;
	}
	
}
