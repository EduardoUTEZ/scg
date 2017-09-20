package com.segurosthona.scg.util.enums;

import java.util.LinkedHashMap;



/**
 * Permisos relacionados a acciones dentro del sistema. Para uso en la configuraciÓn de roles y asignaciÓn del usuario
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public enum Permisos {

	//Permisos
	BORRA_ASEGURADO("Borra Información"),
	BUSCA_INFORMACION("Buscar Información"),	
	CAPTURA_ASEGURADOS("Captura Asegurados"),
	CONSULTA_INFORMACION("Consulta de Información"),
	CONFIRMA_REGISTRO("Confirma Registro"),
	EDITA_INFORMACION("Edita Información"),
	EXTRAE_INFORMACION("Extracción de Información"),
	GESTIONA_USUARIOS("Gestión de Usuarios"),
	GESTIONA_ROLES("Gestión de Roles"),
	IMPRIME("Imprime individual/masivamente")
	;
	
	private String label;		
	
	private Permisos(String label){
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
	 * @return Regresa la lista de permisos disponibles.
	 */
	public static LinkedHashMap<String, String> getPermisos(){
		
		LinkedHashMap<String, String> tipopermisos = new LinkedHashMap<String, String>();
		// permisos estáticos (de acuerdo a funcionalidades sistema)
		for (Permisos p : Permisos.values()) {
			tipopermisos.put(p.name(), p.getLabel());
		}
		
		return tipopermisos;
	}
	
}
