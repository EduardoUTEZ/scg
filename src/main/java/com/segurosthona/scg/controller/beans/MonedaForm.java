package com.segurosthona.scg.controller.beans;

import java.util.Date;

import com.segurosthona.scg.controller.beans.generic.GenericForm;
import com.segurosthona.scg.modelo.entidad.Moneda;

public class MonedaForm  extends GenericForm<MonedaForm,Moneda>{
	

	private Integer id;
	private String claveMoneda;

	private String nombreMoneda;

	private String usuarioAlta;

	private Date fechaAlta;

	private String usuarioModifica;

	private Date fechaModifica;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClaveMoneda() {
		return claveMoneda;
	}

	public void setClaveMoneda(String claveMoneda) {
		this.claveMoneda = claveMoneda;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
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
