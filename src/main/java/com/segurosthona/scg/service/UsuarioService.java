package com.segurosthona.scg.service;
import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.service.generic.*;

public interface UsuarioService extends CrudService<Usuario>{

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
