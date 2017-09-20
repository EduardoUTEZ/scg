/**
 * 
 */
package com.segurosthona.scg.service.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.segurosthona.scg.modelo.generic.IOperations;




/**
 * Validador gen�rico de duplicados. Se basa en la operaci�n countDuplicates de los DAO (see {@link IOperations})
 * @author OWL - Oscar Lithgow
 *
 * @param <T> Tipo de la clase que se validar�
 */
public class DuplicateValidator<T extends Serializable> implements Validator {

	private Class<T> clazzOfT;
	private IOperations<T> service;
	private List<String[]> propertiesToCheck;
	
	public DuplicateValidator(Class<T> targetClass, IOperations<T> service, List<String[]> propertiesToCheck){
		this.clazzOfT = targetClass;
		this.service = service;
		this.propertiesToCheck = propertiesToCheck;
	}
	
	@Override
	public boolean supports(Class<?> classObject) {
		return clazzOfT.isAssignableFrom(classObject);
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public void validate(Object object, Errors errors) {
		
		T model = (T)object;
		
		if(this.service == null){
			errors.reject("validator.error", "Duplicate validator was not initialized properly.");
		}
		
		if(this.propertiesToCheck == null || this.propertiesToCheck.isEmpty()){
			errors.reject("validator.error", "Duplicate validator not initialized properly [properties to check not passed].");
		}		
		
		for (String[] props : this.propertiesToCheck) {
			long count = this.service.countDuplicates(model, props);
			Object[] errorArgs = new Object[props.length];
			for (int i = 0; i < props.length; i++) {				
				errorArgs[i] = new DefaultMessageSourceResolvable(errors.getObjectName() + "." + props[i]);  
			}
			if(count > 0){
				errors.rejectValue(props[0], "DuplicateEntry", errorArgs, "Field data already exist in repository.");
			}
		}		
		
		
	}


}


