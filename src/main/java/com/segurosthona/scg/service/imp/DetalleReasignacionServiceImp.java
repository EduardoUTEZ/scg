package com.segurosthona.scg.service.imp;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import com.segurosthona.scg.dao.DetalleReasignacionDao;
import com.segurosthona.scg.modelo.entidad.DetalleReasignacion;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.DetalleReasignacionService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class DetalleReasignacionServiceImp extends AbstractService<DetalleReasignacion> implements DetalleReasignacionService {

	@Autowired
	private DetalleReasignacionDao dao;

	public DetalleReasignacionServiceImp() {
		super();
	}

	@Override
	protected IOperations<DetalleReasignacion> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(DetalleReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(DetalleReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(DetalleReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. 
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(DetalleReasignacion entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"id"});
		DuplicateValidator<DetalleReasignacion> validator = new DuplicateValidator<DetalleReasignacion>(
				DetalleReasignacion.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	

}
