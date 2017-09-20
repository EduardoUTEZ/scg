package com.segurosthona.scg.controller.beans;

public class ClavePresupuestariaList {

	private Integer id;
	private String empresa;
	private String cuenta;
	private String descripcion;
	private String cuentaContable;

	// private Integer anio;

	public ClavePresupuestariaList(Integer id, String empresa, String cuenta, String descripcion,
			String cuentaContable) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cuenta = cuenta;
		this.descripcion = descripcion;
		this.cuentaContable = cuentaContable;
	}

	public ClavePresupuestariaList(Integer id, String empresa, String cuenta, String descripcion, String cuentaContable,
			Integer anio) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cuenta = cuenta;
		this.descripcion = descripcion;
		this.cuentaContable = cuentaContable;
		// this.anio = anio;
	}

	public ClavePresupuestariaList(Integer id, String cuenta) {
		super();
		this.id = id;
		this.cuenta = cuenta;

	}

	// public Integer getAnio() {
	// return anio;
	// }

	// public void setAnio(Integer anio) {
	// this.anio = anio;
	// }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getCuenta() {
		return cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

}
