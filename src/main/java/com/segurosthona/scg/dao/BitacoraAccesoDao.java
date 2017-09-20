package com.segurosthona.scg.dao;

import java.util.List;

import com.segurosthona.scg.controller.beans.BusquedaBitacoraForm;
import com.segurosthona.scg.modelo.entidad.BitacoraAcceso;
import com.segurosthona.scg.modelo.generic.IOperations;


/**
 * Acceso a datos del catálogo de usuarios, implementa inteface genérica CRUD 
 * 
 * @author Miguel figueroa
 *
 * @version 1.0
 */
public interface BitacoraAccesoDao extends IOperations<BitacoraAcceso>{

	/**
	 * Obtiene Lista de Bitacoras de acuerdo a los parámetros de fecha
	 * @param 	f1	Fecha inicial
	 * @param	f2	Fecha final
	 * @return	Lista de Bitacoras de acceso. 
	 */
	public List<BitacoraAcceso> getBitacorasAcceso(BusquedaBitacoraForm busqueda);
}
