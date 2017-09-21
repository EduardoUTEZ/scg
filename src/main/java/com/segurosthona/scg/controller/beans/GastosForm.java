package com.segurosthona.scg.controller.beans;

import java.util.Calendar;
import java.util.Date;

import com.segurosthona.scg.controller.beans.generic.GenericForm;
import com.segurosthona.scg.modelo.entidad.Empresa;

import com.segurosthona.scg.modelo.entidad.Gastos;
import com.segurosthona.scg.modelo.entidad.Moneda;
import com.segurosthona.scg.modelo.entidad.Proveedor;
import com.segurosthona.scg.modelo.entidad.Usuario;

public class GastosForm extends GenericForm<GastosForm, Gastos> {

	private Integer id;

	private Empresa empresa;

	private Usuario usuario;
	
	private Proveedor proveedor;

	private Double importe;

	private Moneda moneda;

	private Integer paridad;

	private String estatus;
    
	private String subestatus;
	
	private Date estadoFechaHora;
	
	private String tipo;
	
	
	private String descripcion;
	
	private String justificacion;
	
	private Byte anexos[];
	
	private String usuarioAlta;
	
	private Integer anio;
	
	private Integer mes;
	
	private Date fechaAlta;
	
	private String usuarioModifica;
	
	private Date fechaModifica;

	
	public GastosForm() {
		Calendar c = Calendar.getInstance();

		mes = c.get(Calendar.MONTH);
		anio = c.get(Calendar.YEAR);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Integer getParidad() {
		return paridad;
	}

	public void setParidad(Integer paridad) {
		this.paridad = paridad;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getSubestatus() {
		return subestatus;
	}

	public void setSubestatus(String subestatus) {
		this.subestatus = subestatus;
	}

	public Date getEstadoFechaHora() {
		return estadoFechaHora;
	}

	public void setEstadoFechaHora(Date estadoFechaHora) {
		this.estadoFechaHora = estadoFechaHora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	

	public Byte[] getAnexos() {
		return anexos;
	}

	public void setAnexos(Byte[] anexos) {
		this.anexos = anexos;
	}

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public Date getFechaModifica() {
		return fechaModifica;
	}

	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
	
	
	
	
	
	
}
