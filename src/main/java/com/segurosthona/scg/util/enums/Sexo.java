package com.segurosthona.scg.util.enums;

import java.util.LinkedHashMap;



/**
 * Estados del Asegurado
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public enum Sexo {

	//Permisos
	MASCULINO(1,"Masculino"),
	FEMENINO(2,"Femenino")
	;
	
	private Integer value;
	private String label;		
	
	private Sexo(Integer value, String label){
		this.label = label;
		this.value=value;
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
	public static LinkedHashMap<Integer, String> getList(){
		
		LinkedHashMap<Integer, String> tipopermisos = new LinkedHashMap<Integer, String>();
		// permisos estáticos (de acuerdo a funcionalidades sistema)
		for (Sexo p : Sexo.values()) {
			tipopermisos.put(p.getValue(), p.getLabel());
		}
		
		return tipopermisos;
	}
	
}
