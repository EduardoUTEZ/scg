package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.NombreNivelDao;
import com.segurosthona.scg.modelo.entidad.NombreNivel;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.NombreNivelService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class NombreNivelServiceImp extends AbstractService<NombreNivel> implements NombreNivelService {

	@Autowired
	private NombreNivelDao dao;

	public NombreNivelServiceImp() {
		super();
	}

	@Override
	protected IOperations<NombreNivel> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(NombreNivel entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(NombreNivel entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(NombreNivel entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(NombreNivel entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"nombre"});
		DuplicateValidator<NombreNivel> validator = new DuplicateValidator<NombreNivel>(
				NombreNivel.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	/*
	 * (non-Javadoc)
	 * @see com.segurosthona.scg.service.NombreNivelService#getByEmpresa(java.lang.Integer)
	 */
	@Override
	public NombreNivel getByEmpresa(Integer idEmpresa) {
		return dao.getByEmpresa(idEmpresa);
	}
	

}
