/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import com.segurosthona.scg.modelo.generic.GenericModel;
import com.segurosthona.scg.util.enums.EstadoReasigancion;



/**
 * Modelo del repositorio de una Solicitud de la Bitacora de Reasignación.
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class BitacoraReasignacion extends GenericModel<BitacoraReasignacion> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer idBitacoraReasignacion;
	private Date fechaRegistro;
	private String usuarioRegistra;
	private EstadoReasigancion estadoReasignacion;
	private String observaciones;
	
	
	public Integer getId() {
		return id;
	}
	public Integer getIdBitacoraReasignacion() {
		return idBitacoraReasignacion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}
	public EstadoReasigancion getEstadoReasignacion() {
		return estadoReasignacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdBitacoraReasignacion(Integer idBitacoraReasignacion) {
		this.idBitacoraReasignacion = idBitacoraReasignacion;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}
	public void setEstadoReasignacion(EstadoReasigancion estadoReasignacion) {
		this.estadoReasignacion = estadoReasignacion;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
	
}
