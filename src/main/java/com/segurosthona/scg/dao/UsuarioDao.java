package com.segurosthona.scg.dao;

import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.modelo.generic.IOperations;


/**
 * Acceso a datos del catálogo de usuarios, implementa inteface genérica CRUD 
 * 
 * @author Miguel figueroa
 *
 * @version 1.0
 */
public interface UsuarioDao extends IOperations<Usuario>{

	/**
	 * Obtiene al usuario de acuerdo al correo electrónico
	 * @param correoElectronico	correo electrónico del usuario
	 * @return	Usuario 
	 */
	public Usuario getUsuario(String correoElectronico);
	
	/**
	 * Obtiene al usuario de acuerdo al correo electrónico
	 * @param nombreAcceso	del usuario
	 * @return	Usuario 
	 */
	public Usuario getUsuarioPorNombreAcceso(String nombreAcceso);
}
