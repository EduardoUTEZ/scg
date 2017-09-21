/**
 * 
 * Seguros Thona
 * @author Miguel Figueroa Salgado
 *
 */
package com.segurosthona.scg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.segurosthona.scg.controller.beans.generic.GenericModelEditor;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.service.UsuarioService;

@Controller
public class PrincipalController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RolService rolService;

	/**
	 * Metodo para inicializar el proceso de recuperación de contraseña.
	 */
	@ResponseBody
	@RequestMapping("/principal")
	public ModelAndView principal() {

		ModelMap map = new ModelMap();

		feedList(map);
		return new ModelAndView("inicio", map);
	}

	/**
	 * Realiza la conversión de objetos de los formularios.
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Rol.class, new GenericModelEditor<Rol>(
				this.rolService));
	}

	private void feedList(ModelMap map) {

	}

	/**
	 * Provee catálogos requeridos en el formulario
	 * 
	 * @param map
	 *            mapa de atributos del formulario
	 */
	private void feedCatalogs(ModelMap map) {

		map.put("roles", rolService.findAll());
	}

}
