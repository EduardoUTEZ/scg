package com.segurosthona.scg.service;
import java.util.List;

import com.segurosthona.scg.controller.beans.Archivo;
import com.segurosthona.scg.controller.beans.ClavePresupuestariaList;
import com.segurosthona.scg.controller.beans.Mensaje;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.service.generic.*;

public interface ClavePresupuestariaService extends CrudService<ClavePresupuestaria>{
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
	
	/**
	 * Ejecuta la carga masiva del presupuesto a través de un archivo de 
	 * Excel
	 * @param cm	formulario que contiene los datos de importación
	 * @return	Mensaje informativo de las acciones.
	 */
	public Mensaje cargaMasivaPresupuesto (Archivo cm);
}
