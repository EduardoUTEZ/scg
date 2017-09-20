package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.EmpresaDao;
import com.segurosthona.scg.dao.EmpresaGrupoDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.modelo.entidad.EmpresaGrupo;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.EmpresaGrupoService;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class EmpresaGrupoServiceImp extends AbstractService<EmpresaGrupo> implements EmpresaGrupoService {

	@Autowired
	private EmpresaGrupoDao dao;

	public EmpresaGrupoServiceImp() {
		super();
	}

	@Override
	protected IOperations<EmpresaGrupo> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(EmpresaGrupo entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(EmpresaGrupo entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(EmpresaGrupo entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(EmpresaGrupo entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"rol"});
		DuplicateValidator<EmpresaGrupo> validator = new DuplicateValidator<EmpresaGrupo>(
				EmpresaGrupo.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}
	

}
