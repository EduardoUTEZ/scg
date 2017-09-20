package com.segurosthona.scg.dao;

import java.util.List;

import com.segurosthona.scg.controller.beans.ClavePresupuestariaList;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.modelo.generic.IOperations;


/**
 * Acceso a datos del catálogo de ClavePresupuestarias, implementa inteface genérica CRUD 
 * 
 * @author Miguel Figueroa
 *
 * @version 1.0
 */
public interface ClavePresupuestariaDao extends IOperations<ClavePresupuestaria>{

	/**
	 * Obtiene todas las claves presupuestarias del sistema
	 * @return	Claves presupuestarias
	 */
	public List<ClavePresupuestariaList> getClaves();
	
	public List<ClavePresupuestariaList> getCuentasPresupuestales();
	
	/**
	 * Obtiene todas las claves presupuestarias del sistema
	 * @return	Claves presupuestarias
	 */
	public List<ClavePresupuestariaList> getClaves(Integer idEmpresa, Integer anio);
}
