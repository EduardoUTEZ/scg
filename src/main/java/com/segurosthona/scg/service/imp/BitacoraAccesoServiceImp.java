package com.segurosthona.scg.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.controller.beans.BusquedaBitacoraForm;
import com.segurosthona.scg.dao.BitacoraAccesoDao;
import com.segurosthona.scg.modelo.entidad.BitacoraAcceso;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.BitacoraAccesoService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class BitacoraAccesoServiceImp extends AbstractService<BitacoraAcceso> implements BitacoraAccesoService {

	@Autowired
	private BitacoraAccesoDao dao;

	public BitacoraAccesoServiceImp() {
		super();
	}

	@Override
	protected IOperations<BitacoraAcceso> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(BitacoraAcceso entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(BitacoraAcceso entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(BitacoraAcceso entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(BitacoraAcceso entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"nombre"});
		DuplicateValidator<BitacoraAcceso> validator = new DuplicateValidator<BitacoraAcceso>(
				BitacoraAcceso.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	/*
	 * (non-Javadoc)
	 * @see com.segurosthona.scg.service.BitacoraAccesoService#getBitacorasAcceso(com.segurosthona.scg.controller.beans.BusquedaBitacoraForm)
	 */
	@Override
	public List<BitacoraAcceso> getBitacorasAcceso(BusquedaBitacoraForm busqueda) {
		return dao.getBitacorasAcceso(busqueda);
	}

	
	

}
