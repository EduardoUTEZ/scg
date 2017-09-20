package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.UsuarioDao;
import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.UsuarioService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class UsuarioServiceImp extends AbstractService<Usuario> implements UsuarioService {

	@Autowired
	private UsuarioDao dao;

	public UsuarioServiceImp() {
		super();
	}

	@Override
	protected IOperations<Usuario> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(Usuario entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(Usuario entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(Usuario entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(Usuario entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"nombre"});
		DuplicateValidator<Usuario> validator = new DuplicateValidator<Usuario>(
				Usuario.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	/*
	 * (non-Javadoc)
	 * @see com.segurosargos.scg.service.UsuarioService#getUsuario(java.lang.String)
	 */
	@Override
	public Usuario getUsuario(String correoElectronico) {
		return dao.getUsuario(correoElectronico);
	}

	/*
	 * (non-Javadoc)
	 * @see com.segurosargos.scg.service.UsuarioService#getUsuarioPorNombreAcceso(java.lang.String)
	 */
	@Override
	public Usuario getUsuarioPorNombreAcceso(String nombreAcceso) {
		return dao.getUsuarioPorNombreAcceso(nombreAcceso);
	}
	

}
