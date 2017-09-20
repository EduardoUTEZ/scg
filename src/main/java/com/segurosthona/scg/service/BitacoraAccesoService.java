package com.segurosthona.scg.service;
import java.util.List;

import com.segurosthona.scg.controller.beans.BusquedaBitacoraForm;
import com.segurosthona.scg.modelo.entidad.BitacoraAcceso;
import com.segurosthona.scg.service.generic.*;

public interface BitacoraAccesoService extends CrudService<BitacoraAcceso>{

	/**
	 * Obtiene Lista de Bitacoras de acuerdo a los parámetros de fecha
	 * @param 	busqueda	filtros de búsqueda
	 * @return	Lista de Bitacoras de acceso. 
	 */
	public List<BitacoraAcceso> getBitacorasAcceso(BusquedaBitacoraForm busqueda);
	
}
