package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.MonedaDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.modelo.entidad.Moneda;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.MonedaService;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class MonedaServiceImp extends AbstractService<Moneda> implements MonedaService {

	@Autowired
	private MonedaDao dao;

	public MonedaServiceImp() {
		super();
	}

	@Override
	protected IOperations<Moneda> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(Moneda entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(Moneda entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(Moneda entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(Moneda entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"rol"});
		DuplicateValidator<Moneda> validator = new DuplicateValidator<Moneda>(
				Moneda.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}
	

}
