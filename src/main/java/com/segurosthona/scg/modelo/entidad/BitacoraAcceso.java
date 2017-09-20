/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import com.segurosthona.scg.modelo.generic.GenericModel;



/**
 * Modelo del repositorio de Bitacora de Acceso
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class BitacoraAcceso extends GenericModel<BitacoraAcceso> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombreAcceso;
	private Date fechaAcceso;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreAcceso() {
		return nombreAcceso;
	}
	public void setNombreAcceso(String nombreAcceso) {
		this.nombreAcceso = nombreAcceso;
	}
	public Date getFechaAcceso() {
		return fechaAcceso;
	}
	public void setFechaAcceso(Date fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}
}
