package com.segurosthona.scg.service;
import com.segurosthona.scg.modelo.entidad.NombreNivel;
import com.segurosthona.scg.service.generic.*;

public interface NombreNivelService extends CrudService<NombreNivel>{
	/**
	 * Obtiene los nombres de los niveles segun el Id de la empresa
	 * @param idEmpresa		identificador único de la empresa
	 * @return	Nombres de los niveles de la clave presupuestal
	 */
	public NombreNivel getByEmpresa(Integer idEmpresa);

}
