package com.segurosthona.scg.service.imp;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import com.segurosthona.scg.dao.BitacoraReasignacionDao;
import com.segurosthona.scg.modelo.entidad.BitacoraReasignacion;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.BitacoraReasignacionService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class BitacoraReasignacionServiceImp extends AbstractService<BitacoraReasignacion> implements BitacoraReasignacionService {

	@Autowired
	private BitacoraReasignacionDao dao;

	public BitacoraReasignacionServiceImp() {
		super();
	}

	@Override
	protected IOperations<BitacoraReasignacion> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(BitacoraReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(BitacoraReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(BitacoraReasignacion entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. 
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(BitacoraReasignacion entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"id"});
		DuplicateValidator<BitacoraReasignacion> validator = new DuplicateValidator<BitacoraReasignacion>(
				BitacoraReasignacion.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	

}
