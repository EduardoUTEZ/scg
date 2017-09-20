package com.segurosthona.scg.dao;


import java.util.List;

import com.segurosthona.scg.modelo.entidad.Presupuesto;
import com.segurosthona.scg.modelo.generic.IOperations;


/**
 * Acceso a datos del catálogo de Presupuestos, implementa inteface genérica CRUD 
 * 
 * @author Miguel Figueroa
 *
 * @version 1.0
 */
public interface PresupuestoDao extends IOperations<Presupuesto>{
	
	/**
	 * Obtiene el presupuesto por la clave Presupuestal Ordenado 
	 * por meses.
	 * @param idClave	Clave presupuestaria.
	 * @return	Lista del presupuesto correspondiente a la clave presupuestaria.
	 */
	List<Presupuesto> getByIdClavePresupuestal(Integer idClave);

}
