package com.segurosthona.scg.controller.beans;

import java.util.Date;

import com.segurosthona.scg.controller.beans.generic.GenericForm;
import com.segurosthona.scg.modelo.entidad.Usuario;

/**
 * Campos de búsqueda de datos de bitácora de Acceso.
 * 
 * @author Miguel Figueroa Salgado
 *
 */
public class BusquedaBitacoraForm extends GenericForm<BusquedaBitacoraForm, Usuario>{
	
	private Date f1;
	private Date f2;
	
	public BusquedaBitacoraForm(){
		f1 = new Date();
		f2 = new Date();
	}

	public Date getF1() {
		return f1;
	}

	public Date getF2() {
		return f2;
	}

	public void setF1(Date f1) {
		this.f1 = f1;
	}

	public void setF2(Date f2) {
		this.f2 = f2;
	}

	@Override
	public String toString() {
		return "BusquedaBitacoraForm [f1=" + f1 + ", f2=" + f2 + "]";
	}
	
	
}
