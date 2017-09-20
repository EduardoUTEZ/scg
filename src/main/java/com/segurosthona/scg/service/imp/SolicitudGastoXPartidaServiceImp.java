package com.segurosthona.scg.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import com.segurosthona.scg.dao.GastosDao;
import com.segurosthona.scg.dao.RolDao;
import com.segurosthona.scg.dao.SolicitudGastoXPartidaDao;
import com.segurosthona.scg.modelo.entidad.Gastos;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.modelo.entidad.SolicitudGastoXPartida;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.GastosService;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.service.SolicitudGastosXPartidaService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;

@Service
public class SolicitudGastoXPartidaServiceImp extends AbstractService<SolicitudGastoXPartida> implements SolicitudGastosXPartidaService {

	@Autowired
	private SolicitudGastoXPartidaDao dao;

	public SolicitudGastoXPartidaServiceImp() {
		super();
	}

	@Override
	protected IOperations<SolicitudGastoXPartida> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(SolicitudGastoXPartida entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(SolicitudGastoXPartida entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(SolicitudGastoXPartida entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(SolicitudGastoXPartida entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"rol"});
		DuplicateValidator<SolicitudGastoXPartida> validator = new DuplicateValidator<SolicitudGastoXPartida>(
				SolicitudGastoXPartida.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}
	

}
