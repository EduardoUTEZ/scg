package com.segurosthona.scg.service.imp;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import com.segurosthona.scg.dao.SolicitudReasignacionDao;
import com.segurosthona.scg.dao.SolicitudReasignacionPresupuestoDao;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacionPresupuesto;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.SolicitudReasignacionPresupuestoService;
import com.segurosthona.scg.service.SolicitudReasignacionService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class SolicitudReasignacionPresupuestoServiceImp extends AbstractService<SolicitudReasignacionPresupuesto> implements SolicitudReasignacionPresupuestoService {

	@Autowired
	private SolicitudReasignacionPresupuestoDao dao;

	public SolicitudReasignacionPresupuestoServiceImp() {
		super();
	}

	@Override
	protected IOperations<SolicitudReasignacionPresupuesto> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(SolicitudReasignacionPresupuesto entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(SolicitudReasignacionPresupuesto entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(SolicitudReasignacionPresupuesto entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. 
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(SolicitudReasignacionPresupuesto entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"id"});
		DuplicateValidator<SolicitudReasignacionPresupuesto> validator = new DuplicateValidator<SolicitudReasignacionPresupuesto>(
				SolicitudReasignacionPresupuesto.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	

}
