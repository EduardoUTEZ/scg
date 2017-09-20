/**
 * 
 * Seguros Thona
 * @author Miguel Figueroa Salgado
 *
 */
package com.segurosthona.scg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.segurosthona.scg.controller.beans.BusquedaBitacoraForm;
import com.segurosthona.scg.controller.beans.generic.FechaEditor;
import com.segurosthona.scg.modelo.entidad.BitacoraAcceso;
import com.segurosthona.scg.service.BitacoraAccesoService;

@Controller
@RequestMapping("bitacoraAccesos")
public class BitacoraAccesoController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private BitacoraAccesoService bitacoraAccesoService;

	/**
	 * Metodo para inicializar el proceso de recuperación de contraseña.
	 */
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView index() {

		System.out.println("Bitacoras");
		ModelMap map = new ModelMap();
		map.put("busquedaBitacora", new BusquedaBitacoraForm());
		return new ModelAndView("catalogos/bitacoraAccesos/bitacoras", map);
	}
	
	
	/**
	 * Salvar/Actualizar un elemento del catálogo
	 * 
	 * @param usuario
	 * @param result
	 * @param request
	 * @param ra
	 * @return
	 */
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ModelAndView buscar(
			@Valid @ModelAttribute("busquedaBitacora") BusquedaBitacoraForm busqueda,
			BindingResult result, HttpServletRequest request,
			RedirectAttributes ra) {
		ModelMap map = new ModelMap();
		
		System.out.println(busqueda.toString());
		
		
		List<BitacoraAcceso> bitacoras = bitacoraAccesoService.getBitacorasAcceso(busqueda);
		map.put("bitacoras", bitacoras);
		map.put("busquedaBitacora", busqueda);
		return new ModelAndView("catalogos/bitacoraAccesos/bitacoras", map);
	}
	
	

	/**
	 * Realiza la conversión de objetos de los formularios.
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new FechaEditor(sdf));
	}
}
