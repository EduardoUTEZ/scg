/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import com.segurosthona.scg.modelo.generic.GenericModel;
import com.segurosthona.scg.util.enums.EstadoReasigancion;



/**
 * Modelo del repositorio de una Solicitud de Reasignación.
 * 
 * @author EGM - Eduardo Guillen Maldonado
 * @version 1.0
 *
 */
public class SolicitudReasignacionPresupuesto extends GenericModel<SolicitudReasignacionPresupuesto> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Empresa empresaGrupo;
	
	private Integer anio;
	private String motivo;
	private String estatus;
	private Date fechaEvaluacion;
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
	public Empresa getEmpresaGrupo() {
		return empresaGrupo;
	}
	public void setEmpresaGrupo(Empresa empresaGrupo) {
		this.empresaGrupo = empresaGrupo;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
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
