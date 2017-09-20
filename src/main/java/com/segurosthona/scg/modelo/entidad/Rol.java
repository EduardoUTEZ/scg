/**
 * 
 */
package com.segurosthona.scg.modelo.entidad;

import java.io.Serializable;
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
public class Rol extends GenericModel<Rol> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private Set<String> permisos = new HashSet<String>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<String> getPermisos() {
		return permisos;
	}
	public void setPermisos(Set<String> permisos) {
		this.permisos = permisos;
	}
	
	
	


}
