/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import com.segurosthona.scg.modelo.generic.GenericModel;



/**
 * Modelo del repositorio de las Empresas disponibles 
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class Empresa extends GenericModel<Empresa> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nombre;
	private String rfc;
		
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

	public String getNombre() {
		return nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public String getUsuarioModifica() {
		return usuarioModifica;
	}

	public Date getFechaModifica() {
		return fechaModifica;
	}
	
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
}
