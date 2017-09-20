package com.segurosthona.scg.service.imp;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.PresupuestoSolicitudRDao;
import com.segurosthona.scg.dao.SolicitudReasignacionDao;
import com.segurosthona.scg.modelo.entidad.PresupuestoSolicitudR;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.PresupuestoSolicitudRService;
import com.segurosthona.scg.service.SolicitudReasignacionService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class PresupuestoSolicitudRServiceImp extends AbstractService<PresupuestoSolicitudR> implements PresupuestoSolicitudRService {

	@Autowired
	private PresupuestoSolicitudRDao dao;

	public PresupuestoSolicitudRServiceImp() {
		super();
	}

	@Override
	protected IOperations<PresupuestoSolicitudR> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(PresupuestoSolicitudR entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(PresupuestoSolicitudR entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(PresupuestoSolicitudR entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. 
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(PresupuestoSolicitudR entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"id"});
		DuplicateValidator<PresupuestoSolicitudR> validator = new DuplicateValidator<PresupuestoSolicitudR>(
				PresupuestoSolicitudR.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	

}
