package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.EmpresaDao;
import com.segurosthona.scg.modelo.entidad.Empresa;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.EmpresaService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class EmpresaServiceImp extends AbstractService<Empresa> implements EmpresaService {

	@Autowired
	private EmpresaDao dao;

	public EmpresaServiceImp() {
		super();
	}

	@Override
	protected IOperations<Empresa> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(Empresa entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(Empresa entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(Empresa entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(Empresa entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"nombre"});
		DuplicateValidator<Empresa> validator = new DuplicateValidator<Empresa>(
				Empresa.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}
	

}
