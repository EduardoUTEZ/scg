/**
 * 
 * Seguros Thona
 * @author Juan antonio silva flores
 *
 */
package com.segurosthona.scg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.segurosthona.scg.controller.beans.RolForm;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.service.EmpresaGrupoService;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.util.ExceptionUtils;
import com.segurosthona.scg.util.enums.Permisos;





@Controller
@RequestMapping("grupos")
public class EmpresaGrupoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmpresaGrupoController.class);
	
	@Autowired
	MessageSource messageSource; 
	
	@Autowired
	private EmpresaGrupoService rolService;
	

	
 	/**
 	 * Metodo para inicializar el proceso de recuperación de contraseña.
 	 */
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView index(){
		
		System.out.println("rols index");
		ModelMap map = new ModelMap();		
		feedList(map);
		return new ModelAndView("catalogos/grupos/grupos", map);
	}

	/**
	 * Agregar un elemento al catálogo
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(Authentication authentication) {
				
		ModelMap map = new ModelMap();
		map.put("rol",new Rol());
		
		feedCatalogs(map);
		
		return new ModelAndView("catalogos/grupos/altaEditaGrupos", map);
	}
	
	@InitBinder
	void initBinder(WebDataBinder binder) {		
	}
	
	private void feedList(ModelMap map){

		map.put("grupos", rolService.findAll());
	}
	
	/**
	 * Provee catálogos requeridos en el formulario
	 * 
	 * @param map
	 *            mapa de atributos del formulario
	 */
	private void feedCatalogs(ModelMap map) {
		
		//map.put("permisos", Permisos.getPermisos());
	}		

}
