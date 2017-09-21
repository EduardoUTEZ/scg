package com.segurosthona.scg.controller.beans;

import com.segurosthona.scg.controller.beans.generic.GenericForm;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.modelo.entidad.PresupuestoSolicitudR;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacionPresupuesto;
import com.segurosthona.scg.util.enums.TipoPresupuesto;

public class PresupuestoSolicitudRForm extends GenericForm<PresupuestoSolicitudRForm, PresupuestoSolicitudR> {

	private Integer id;
	private SolicitudReasignacionPresupuesto solicitud;
	private ClavePresupuestaria clavePresupuestariaOrigen;
	private Integer mesPresupuestariaOrigen;
	private ClavePresupuestaria clavePresupuestariaDestino;
	private Integer mesPresupuestariaDestino;
	private Double importe;
	
	private Double pptoOrigenAntes;
	private Double pptoDestinoAntes;

	private PresupuestoDetalle pptoDestino = new PresupuestoDetalle(TipoPresupuesto.PROGRAMADO);
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SolicitudReasignacionPresupuesto getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudReasignacionPresupuesto solicitud) {
		this.solicitud = solicitud;
	}

	public ClavePresupuestaria getClavePresupuestariaOrigen() {
		return clavePresupuestariaOrigen;
	}

	public void setClavePresupuestariaOrigen(ClavePresupuestaria clavePresupuestariaOrigen) {
		this.clavePresupuestariaOrigen = clavePresupuestariaOrigen;
	}

	public Integer getMesPresupuestariaOrigen() {
		return mesPresupuestariaOrigen;
	}

	public void setMesPresupuestariaOrigen(Integer mesPresupuestariaOrigen) {
		this.mesPresupuestariaOrigen = mesPresupuestariaOrigen;
	}

	public ClavePresupuestaria getClavePresupuestariaDestino() {
		return clavePresupuestariaDestino;
	}

	public void setClavePresupuestariaDestino(ClavePresupuestaria clavePresupuestariaDestino) {
		this.clavePresupuestariaDestino = clavePresupuestariaDestino;
	}

	public Integer getMesPresupuestariaDestino() {
		return mesPresupuestariaDestino;
	}

	public void setMesPresupuestariaDestino(Integer mesPresupuestariaDestino) {
		this.mesPresupuestariaDestino = mesPresupuestariaDestino;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getPptoOrigenAntes() {
		return pptoOrigenAntes;
	}

	public void setPptoOrigenAntes(Double pptoOrigenAntes) {
		this.pptoOrigenAntes = pptoOrigenAntes;
	}

	public Double getPptoDestinoAntes() {
		return pptoDestinoAntes;
	}

	public void setPptoDestinoAntes(Double pptoDestinoAntes) {
		this.pptoDestinoAntes = pptoDestinoAntes;
	}

	public PresupuestoDetalle getPptoDestino() {
		return pptoDestino;
	}

	public void setPptoDestino(PresupuestoDetalle pptoDestino) {
		this.pptoDestino = pptoDestino;
	}
	
	
	

}
