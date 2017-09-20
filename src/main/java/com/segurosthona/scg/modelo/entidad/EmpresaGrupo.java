/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.segurosthona.scg.modelo.generic.GenericModel;



/**
 * Modelo del repositorio de roles para asignación de permisos 
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class EmpresaGrupo extends GenericModel<EmpresaGrupo> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombreEmpresa;
	private String rfcEmpresa;
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
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getRfcEmpresa() {
		return rfcEmpresa;
	}
	public void setRfcEmpresa(String rfcEmpresa) {
		this.rfcEmpresa = rfcEmpresa;
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
