package com.segurosthona.scg.dao;

import com.segurosthona.scg.modelo.entidad.NombreNivel;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.NombreNivelService;


/**
 * Acceso a datos del catálogo de NombreNivel, implementa inteface genérica CRUD 
 * 
 * @author Miguel Figueroa
 *
 * @version 1.0
 */
public interface NombreNivelDao extends IOperations<NombreNivel>{
	
	/**
	 * Obtiene los nombres de los niveles segun el Id de la empresa
	 * @param idEmpresa		identificador único de la empresa
	 * @return	Nombres de los niveles de la clave presupuestal
	 */
	public NombreNivel getByEmpresa(Integer idEmpresa);

}
