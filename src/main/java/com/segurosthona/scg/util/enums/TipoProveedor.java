package com.segurosthona.scg.util.enums;

import java.util.LinkedHashMap;



/**
 * Estados del catálogo de usuarios
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public enum TipoProveedor {

	//Permisos
	MORAL("Moral"),
	FISICA("Física")
	;
	
	private String label;		
	
	private TipoProveedor(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Obtiene permisos
	 * @return Regresa la lista de TipoProveedor
	 */
	public static LinkedHashMap<String, String> getTipos(){
		
		LinkedHashMap<String, String> tipos = new LinkedHashMap<String, String>();
		// permisos estáticos (de acuerdo a funcionalidades sistema)
		for (TipoProveedor p : TipoProveedor.values()) {
			tipos.put(p.name(),  p.getLabel());
		}
		return tipos;
	}
	
}
