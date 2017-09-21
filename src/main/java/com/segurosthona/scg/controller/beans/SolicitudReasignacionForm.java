package com.segurosthona.scg.controller.beans;

import java.util.Date;

import com.segurosthona.scg.controller.beans.generic.GenericForm;
import com.segurosthona.scg.modelo.entidad.Empresa;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;
import com.segurosthona.scg.util.enums.EstadoReasigancion;
import com.segurosthona.scg.util.enums.TipoPresupuesto;

public class SolicitudReasignacionForm extends
		GenericForm<SolicitudReasignacionForm, SolicitudReasignacion> {

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

	
	//Auxiliares:
	private PresupuestoDetalle pptoDestino = new PresupuestoDetalle(TipoPresupuesto.PROGRAMADO);


	public Integer getId() {
		return id;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public EstadoReasigancion getEstado() {
		return estado;
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


	public PresupuestoDetalle getPptoDestino() {
		return pptoDestino;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public void setEstado(EstadoReasigancion estado) {
		this.estado = estado;
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


	public void setPptoDestino(PresupuestoDetalle pptoDestino) {
		this.pptoDestino = pptoDestino;
	}
}
