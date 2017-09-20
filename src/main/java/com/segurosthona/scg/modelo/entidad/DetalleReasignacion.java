/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import com.segurosthona.scg.modelo.generic.GenericModel;



/**
 * Modelo del detelle de una Solicitud de Reasignación.
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class DetalleReasignacion extends GenericModel<DetalleReasignacion> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idSolicitudReasignacion;
	private Integer mesDestino;
	private Double importe;
	
	
	public Integer getId() {
		return id;
	}
	public Integer getIdSolicitudReasignacion() {
		return idSolicitudReasignacion;
	}
	public Integer getMesDestino() {
		return mesDestino;
	}
	public Double getImporte() {
		return importe;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdSolicitudReasignacion(Integer idSolicitudReasignacion) {
		this.idSolicitudReasignacion = idSolicitudReasignacion;
	}
	public void setMesDestino(Integer mesDestino) {
		this.mesDestino = mesDestino;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
}
