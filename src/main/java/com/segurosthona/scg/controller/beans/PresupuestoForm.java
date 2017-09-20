package com.segurosthona.scg.controller.beans;

import com.segurosthona.scg.controller.beans.generic.GenericForm;
import com.segurosthona.scg.modelo.entidad.Presupuesto;

public class PresupuestoForm extends GenericForm<PresupuestoForm, Presupuesto>{

	private Integer id;
	private Integer idClavePresupuestaria;
	private Integer anio;
	private Integer mes;
	private Double pptoProgramado;
	private Double pptoComprometido;
	private Double pptoEjercido;
	
	public Integer getId() {
		return id;
	}
	public Integer getIdClavePresupuestaria() {
		return idClavePresupuestaria;
	}
	public Integer getAnio() {
		return anio;
	}
	public Integer getMes() {
		return mes;
	}
	public Double getPptoProgramado() {
		return pptoProgramado;
	}
	public Double getPptoComprometido() {
		return pptoComprometido;
	}
	public Double getPptoEjercido() {
		return pptoEjercido;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdClavePresupuestaria(Integer idClavePresupuestaria) {
		this.idClavePresupuestaria = idClavePresupuestaria;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public void setPptoProgramado(Double pptoProgramado) {
		this.pptoProgramado = pptoProgramado;
	}
	public void setPptoComprometido(Double pptoComprometido) {
		this.pptoComprometido = pptoComprometido;
	}
	public void setPptoEjercido(Double pptoEjercido) {
		this.pptoEjercido = pptoEjercido;
	}
}
