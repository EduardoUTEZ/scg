package com.segurosthona.scg.service;
import java.util.List;

import com.segurosthona.scg.modelo.entidad.Presupuesto;
import com.segurosthona.scg.service.generic.*;

public interface PresupuestoService extends CrudService<Presupuesto>{
	
	/**
	 * Obtiene el presupuesto por la clave Presupuestal Ordenado 
	 * por meses.
	 * @param idClave	Clave presupuestaria.
	 * @return	Lista del presupuesto correspondiente a la clave presupuestaria.
	 */
	List<Presupuesto> getByIdClavePresupuestal(Integer idClave);
}
