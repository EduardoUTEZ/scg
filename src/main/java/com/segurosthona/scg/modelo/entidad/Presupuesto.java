/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;

import com.segurosthona.scg.modelo.generic.GenericModel;



/**
 * Modelo del repositorio de Presupuesto 
 * 
 * @author MFS - Miguel Figueroa
 * @version 1.0
 *
 */
public class Presupuesto extends GenericModel<Presupuesto> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idClavePresupuestaria;
	private Integer anio;
	private Integer mes;
	private Double pptoProgramado;
	private Double pptoComprometido;
	private Double pptoEjercido;
	
	//Calculado:
	private Double pptoDisponible;

	
	public Presupuesto(){
		pptoProgramado=0.0;
		pptoComprometido=0.0;
		pptoEjercido=0.0;
		pptoDisponible =0.0;
	}


	public Double getPptoDisponible() {
		return pptoDisponible;
	}


	public void setPptoDisponible(Double pptoDisponible) {
		this.pptoDisponible = pptoDisponible;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPptoComprometido() {
		return pptoComprometido;
	}

	public Double getPptoEjercido() {
		return pptoEjercido;
	}

	public void setPptoComprometido(Double pptoComprometido) {
		this.pptoComprometido = pptoComprometido;
	}

	public void setPptoEjercido(Double pptoEjercido) {
		this.pptoEjercido = pptoEjercido;
	}

	public Integer getIdClavePresupuestaria() {
		return idClavePresupuestaria;
	}


	public Integer getAnio() {
		return anio;
	}

	public Integer getMes() {
		return mes;
	}

	public Double getPptoProgramado() {
		return pptoProgramado;
	}

	public void setIdClavePresupuestaria(Integer idClavePresupuestaria) {
		this.idClavePresupuestaria = idClavePresupuestaria;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public void setPptoProgramado(Double pptoProgramado) {
		this.pptoProgramado = pptoProgramado;
	}
}
