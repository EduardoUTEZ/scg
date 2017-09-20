package com.segurosthona.scg.util.enums;

import java.util.LinkedHashMap;



/**
 * Estados de una solicitud de reasignación.
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public enum EstadoReasigancion {

	//Estados
	PENDIENTE("PENDIENTE","Pendiente"),
	AUTORIZADA("AUTORIZADA","Autorizada"),
	RECHAZADA("RECHAZADA","Rechazada")
	;
	
	private String value;
	private String label;		
	
	private EstadoReasigancion(String value, String label){
		this.label = label;
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
		
		LinkedHashMap<String, String> estados = new LinkedHashMap<String, String>();
		// permisos estáticos (de acuerdo a funcionalidades sistema)
		for (EstadoReasigancion p : EstadoReasigancion.values()) {
			estados.put(p.value, p.getLabel());
		}
		
		return estados;
	}
	
}
