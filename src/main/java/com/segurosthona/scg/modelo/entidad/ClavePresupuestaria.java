/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import com.segurosthona.scg.modelo.generic.GenericModel;
import com.segurosthona.scg.util.enums.Moneda;



/**
 * Modelo del repositorio de ClavePresupuestaria 
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class ClavePresupuestaria extends GenericModel<ClavePresupuestaria> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Empresa empresa;
	
	private String nivel1;
	private String nivel2;
	private String nivel3;
	private String nivel4;
	private String nivel5;
	private String nivel6;
	private String nivel7;
	private String nivel8;
	private String nivel9;
	private String nivel10;

	
	private String descripcion;
	private String cuentaContable;

	//private Integer anio;
	private Moneda moneda;
	private String version;	
	private Usuario usuarioResponsable;
	private Usuario usuarioSuplente;
	
	private String usuarioAlta;
	private Date fechaAlta;
	private String usuarioModifica;
	private Date fechaModifica;
	

	//public Integer getAnio() {
		//return anio;
	//}

	//public void setAnio(Integer anio) {
		//this.anio = anio;
	//}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public String getVersion() {
		return version;
	}

	public Usuario getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public Usuario getUsuarioSuplente() {
		return usuarioSuplente;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setUsuarioResponsable(Usuario usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public void setUsuarioSuplente(Usuario usuarioSuplente) {
		this.usuarioSuplente = usuarioSuplente;
	}

	public String getNivel1() {
		return nivel1;
	}

	public String getNivel2() {
		return nivel2;
	}

	public String getNivel3() {
		return nivel3;
	}

	public String getNivel4() {
		return nivel4;
	}

	public String getNivel5() {
		return nivel5;
	}

	public String getNivel6() {
		return nivel6;
	}

	public String getNivel7() {
		return nivel7;
	}

	public String getNivel8() {
		return nivel8;
	}

	public String getNivel9() {
		return nivel9;
	}

	public String getNivel10() {
		return nivel10;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public String getCuentaContable() {
		return cuentaContable;
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

	public void setNivel1(String nivel1) {
		this.nivel1 = nivel1;
	}

	public void setNivel2(String nivel2) {
		this.nivel2 = nivel2;
	}

	public void setNivel3(String nivel3) {
		this.nivel3 = nivel3;
	}

	public void setNivel4(String nivel4) {
		this.nivel4 = nivel4;
	}

	public void setNivel5(String nivel5) {
		this.nivel5 = nivel5;
	}

	public void setNivel6(String nivel6) {
		this.nivel6 = nivel6;
	}

	public void setNivel7(String nivel7) {
		this.nivel7 = nivel7;
	}

	public void setNivel8(String nivel8) {
		this.nivel8 = nivel8;
	}

	public void setNivel9(String nivel9) {
		this.nivel9 = nivel9;
	}

	public void setNivel10(String nivel10) {
		this.nivel10 = nivel10;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
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
