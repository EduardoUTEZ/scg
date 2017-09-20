package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class RolServiceImp extends AbstractService<Rol> implements RolService {

	@Autowired
	private RolDao dao;

	public RolServiceImp() {
		super();
	}

	@Override
	protected IOperations<Rol> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(Rol entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(Rol entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(Rol entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(Rol entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"rol"});
		DuplicateValidator<Rol> validator = new DuplicateValidator<Rol>(
				Rol.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}
	

}
