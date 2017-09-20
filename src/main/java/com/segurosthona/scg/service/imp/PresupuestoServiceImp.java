package com.segurosthona.scg.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;



import com.segurosthona.scg.dao.PresupuestoDao;
import com.segurosthona.scg.modelo.entidad.Presupuesto;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.PresupuestoService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class PresupuestoServiceImp extends AbstractService<Presupuesto> implements PresupuestoService {

	@Autowired
	private PresupuestoDao dao;

	public PresupuestoServiceImp() {
		super();
	}

	@Override
	protected IOperations<Presupuesto> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(Presupuesto entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(Presupuesto entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(Presupuesto entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(Presupuesto entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"cuentaContable"});
		DuplicateValidator<Presupuesto> validator = new DuplicateValidator<Presupuesto>(
				Presupuesto.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.segurosthona.scg.service.PresupuestoService#getByIdClavePresupuestal(java.lang.Integer)
	 */
	public List<Presupuesto> getByIdClavePresupuestal(Integer idClave) {
		return dao.getByIdClavePresupuestal(idClave);
	}

	

}
