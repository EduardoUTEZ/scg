package com.segurosthona.scg.controller.beans;

import java.util.Date;

import com.segurosthona.scg.controller.beans.generic.GenericForm;
import com.segurosthona.scg.modelo.entidad.EmpresaGrupo;
import com.segurosthona.scg.modelo.entidad.Proveedor;

public class ProveedorForm extends GenericForm<ProveedorForm, Proveedor>{

	private Integer id;
	
	private EmpresaGrupo empresaGrupo;

	private String tipoProveedor;
	
	private String razonSocial;
	
	private String nombre;
	
	private String primerApellido;
	
	private String segundoApellido;
	
	private String  rfc;
	
	private String dirCalle;
	
	private String dirNoExt;
	
	private String dirNoInt;
	
	private String dirCol;
	
	private String dirMunDel;
	
	private String dirEstado;
	
	private String dirPais;
	
	private Integer dirCP;
	
	private Integer telefono;
	
	private String contrato;
	
	private String retenciones;
	
	private String usuarioAlta;
	
	private Date fechaAlta;
	
	private String usuarioModifica;
	
	private Date fechaModifica;
    
	private Integer estado;
	
	private String banco;
	
	private String cuentaBanco;
	
	
	public ProveedorForm () {}
	
	public ProveedorForm (Integer estado) {
		this.estado=estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmpresaGrupo getEmpresaGrupo() {
		return empresaGrupo;
	}

	public void setEmpresaGrupo(EmpresaGrupo empresaGrupo) {
		this.empresaGrupo = empresaGrupo;
	}

	public String getTipoProveedor() {
		return tipoProveedor;
	}

	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getDirCalle() {
		return dirCalle;
	}

	public void setDirCalle(String dirCalle) {
		this.dirCalle = dirCalle;
	}

	public String getDirNoExt() {
		return dirNoExt;
	}

	public void setDirNoExt(String dirNoExt) {
		this.dirNoExt = dirNoExt;
	}

	public String getDirNoInt() {
		return dirNoInt;
	}

	public void setDirNoInt(String dirNoInt) {
		this.dirNoInt = dirNoInt;
	}

	public String getDirCol() {
		return dirCol;
	}

	public void setDirCol(String dirCol) {
		this.dirCol = dirCol;
	}

	public String getDirMunDel() {
		return dirMunDel;
	}

	public void setDirMunDel(String dirMunDel) {
		this.dirMunDel = dirMunDel;
	}

	public String getDirEstado() {
		return dirEstado;
	}

	public void setDirEstado(String dirEstado) {
		this.dirEstado = dirEstado;
	}

	public String getDirPais() {
		return dirPais;
	}

	public void setDirPais(String dirPais) {
		this.dirPais = dirPais;
	}

	public Integer getDirCP() {
		return dirCP;
	}

	public void setDirCP(Integer dirCP) {
		this.dirCP = dirCP;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(String retenciones) {
		this.retenciones = retenciones;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCuentaBanco() {
		return cuentaBanco;
	}

	public void setCuentaBanco(String cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	
}
