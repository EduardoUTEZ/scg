package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.GastosDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.modelo.entidad.Gastos;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.GastosService;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class GastosServiceImp extends AbstractService<Gastos> implements GastosService {

	@Autowired
	private GastosDao dao;

	public GastosServiceImp() {
		super();
	}

	@Override
	protected IOperations<Gastos> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(Gastos entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(Gastos entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(Gastos entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(Gastos entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"rol"});
		DuplicateValidator<Gastos> validator = new DuplicateValidator<Gastos>(
				Gastos.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}
	

}
