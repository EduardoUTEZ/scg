package com.segurosthona.scg.controller.beans;

public class CambioClaveForm {

	private Integer idUsuario;
	
	private String claveAccesoActual;
	private String claveAccesoNueva;
	private String claveAccesoNueva2;
	
	
	public CambioClaveForm(){}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getClaveAccesoActual() {
		return claveAccesoActual;
	}


	public void setClaveAccesoActual(String claveAccesoActual) {
		this.claveAccesoActual = claveAccesoActual;
	}


	public String getClaveAccesoNueva() {
		return claveAccesoNueva;
	}


	public void setClaveAccesoNueva(String claveAccesoNueva) {
		this.claveAccesoNueva = claveAccesoNueva;
	}


	public String getClaveAccesoNueva2() {
		return claveAccesoNueva2;
	}


	public void setClaveAccesoNueva2(String claveAccesoNueva2) {
		this.claveAccesoNueva2 = claveAccesoNueva2;
	}
}
