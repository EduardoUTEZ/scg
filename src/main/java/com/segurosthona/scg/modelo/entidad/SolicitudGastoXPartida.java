package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Calendar;

import com.segurosthona.scg.modelo.generic.GenericModel;

public class SolicitudGastoXPartida extends GenericModel<SolicitudGastoXPartida> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	private Gastos gasto;

	private Presupuesto presupuesto;

	private Double importe;

	private Integer anio;

	private Integer mes;

	private String ivaAplicable;

	private Integer idArticulo;

	private String descripcion;

	private String unidad;

	private Integer cantidad;

	private Double precioUnitario;

	private Integer idClavePresupuestaria;

	private String autorizante;

	private String anexos;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Gastos getGasto() {
		return gasto;
	}

	public void setGasto(Gastos gasto) {
		this.gasto = gasto;
	}

	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getIvaAplicable() {
		return ivaAplicable;
	}

	public void setIvaAplicable(String ivaAplicable) {
		this.ivaAplicable = ivaAplicable;
	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getIdClavePresupuestaria() {
		return idClavePresupuestaria;
	}

	public void setIdClavePresupuestaria(Integer idClavePresupuestaria) {
		this.idClavePresupuestaria = idClavePresupuestaria;
	}

	public String getAutorizante() {
		return autorizante;
	}

	public void setAutorizante(String autorizante) {
		this.autorizante = autorizante;
	}

	public String getAnexos() {
		return anexos;
	}

	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}

}
