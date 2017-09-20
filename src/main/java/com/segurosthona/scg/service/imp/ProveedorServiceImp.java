package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;


import com.segurosthona.scg.dao.ProveedorDao;
import com.segurosthona.scg.modelo.entidad.Proveedor;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.ProveedorService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class ProveedorServiceImp extends AbstractService<Proveedor> implements ProveedorService {

	@Autowired
	private ProveedorDao dao;

	public ProveedorServiceImp() {
		super();
	}

	@Override
	protected IOperations<Proveedor> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(Proveedor entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(Proveedor entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(Proveedor entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(Proveedor entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"proveedor"});
		DuplicateValidator<Proveedor> validator = new DuplicateValidator<Proveedor>(
				Proveedor.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}
	

}
