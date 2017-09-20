package com.segurosthona.scg.controller.beans;

import java.util.ArrayList;

public class Mensaje {
	
	public static final String TIPO_SUCCESS="SUCCESS";
	public static final String TIPO_ERROR = "DANGER";
	public static final String TIPO_INFO = "INFO";
	
	
	private String tipo;
	private String mensaje;
	private ArrayList<String> mensajeFijo = new ArrayList<String>();
	
	public Mensaje(){}
	
	public ArrayList<String> getMensajeFijo() {
		return mensajeFijo;
	}

	public void setMensajeFijo(ArrayList<String> mensajeFijo) {
		this.mensajeFijo = mensajeFijo;
	}

	public Mensaje(String tipo, String mensaje) {
		super();
		this.tipo = tipo;
		this.mensaje = mensaje;
	}
	public static String getTipoSuccess() {
		return TIPO_SUCCESS;
	}
	public static String getTipoError() {
		return TIPO_ERROR;
	}
	public static String getTipoInfo() {
		return TIPO_INFO;
	}
	public String getTipo() {
		return tipo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

	
}
