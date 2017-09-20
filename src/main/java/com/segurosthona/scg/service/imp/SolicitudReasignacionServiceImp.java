package com.segurosthona.scg.service.imp;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import com.segurosthona.scg.dao.SolicitudReasignacionDao;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.SolicitudReasignacionService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class SolicitudReasignacionServiceImp extends AbstractService<SolicitudReasignacion> implements SolicitudReasignacionService {

	@Autowired
	private SolicitudReasignacionDao dao;

	public SolicitudReasignacionServiceImp() {
		super();
	}

	@Override
	protected IOperations<SolicitudReasignacion> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(SolicitudReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(SolicitudReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(SolicitudReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. 
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(SolicitudReasignacion entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"id"});
		DuplicateValidator<SolicitudReasignacion> validator = new DuplicateValidator<SolicitudReasignacion>(
				SolicitudReasignacion.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	

}
