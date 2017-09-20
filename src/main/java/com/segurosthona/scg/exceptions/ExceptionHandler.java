package com.segurosthona.scg.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Clase para manejar las excepciones
 * 
 * Seguros argos
 *
 */
public class ExceptionHandler extends SimpleMappingExceptionResolver {


	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) {
		ex.printStackTrace();		
		return super.doResolveException(request, response, handler, ex);
	}
}
