/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import com.segurosthona.scg.modelo.generic.GenericModel;
import com.segurosthona.scg.util.enums.EstadoReasigancion;



/**
 * Modelo del repositorio de una Solicitud de Reasignación.
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class SolicitudReasignacion extends GenericModel<SolicitudReasignacion> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Empresa empresa;
	private EstadoReasigancion estado;
	private Integer anio;
	
	private String usuarioSolicita;
	private Date fechaSolicitud;
	
	private Integer idClavePresupuestariaOrigen;
	private Integer idClavePresupuestariaDestino;
	
	private Double totalPptoOrigenAntes;
	private Double totalPptoDestinoAntes;
	
	private String justificacion;

	public EstadoReasigancion getEstado() {
		return estado;
	}

	public void setEstado(EstadoReasigancion estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public Integer getAnio() {
		return anio;
	}

	public String getUsuarioSolicita() {
		return usuarioSolicita;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public Integer getIdClavePresupuestariaOrigen() {
		return idClavePresupuestariaOrigen;
	}

	public Integer getIdClavePresupuestariaDestino() {
		return idClavePresupuestariaDestino;
	}

	public Double getTotalPptoOrigenAntes() {
		return totalPptoOrigenAntes;
	}

	public Double getTotalPptoDestinoAntes() {
		return totalPptoDestinoAntes;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public void setUsuarioSolicita(String usuarioSolicita) {
		this.usuarioSolicita = usuarioSolicita;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public void setIdClavePresupuestariaOrigen(Integer idClavePresupuestariaOrigen) {
		this.idClavePresupuestariaOrigen = idClavePresupuestariaOrigen;
	}

	public void setIdClavePresupuestariaDestino(Integer idClavePresupuestariaDestino) {
		this.idClavePresupuestariaDestino = idClavePresupuestariaDestino;
	}

	public void setTotalPptoOrigenAntes(Double totalPptoOrigenAntes) {
		this.totalPptoOrigenAntes = totalPptoOrigenAntes;
	}

	public void setTotalPptoDestinoAntes(Double totalPptoDestinoAntes) {
		this.totalPptoDestinoAntes = totalPptoDestinoAntes;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
}
