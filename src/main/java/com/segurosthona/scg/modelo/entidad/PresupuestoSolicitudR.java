package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;

import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacionPresupuesto;
import com.segurosthona.scg.modelo.generic.GenericModel;

public class PresupuestoSolicitudR extends GenericModel<PresupuestoSolicitudR> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private SolicitudReasignacionPresupuesto solicitud;
	private ClavePresupuestaria clavePresupuestariaOrigen;
	private Integer mesPresupuestariaOrigen;
	private ClavePresupuestaria clavePresupuestariaDestino;
	private Integer mesPresupuestariaDestino;
	private Double importe;
	private Double pptoOrigenAntes;
	private Double pptoDestinoAntes;

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

}
