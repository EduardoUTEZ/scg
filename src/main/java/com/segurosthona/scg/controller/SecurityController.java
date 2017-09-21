package com.segurosthona.scg.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.segurosthona.scg.modelo.entidad.BitacoraAcceso;
import com.segurosthona.scg.service.BitacoraAccesoService;
import com.segurosthona.scg.service.UsuarioService;
import com.segurosthona.scg.util.SecurityUtils;


/**
 * Controller encargado del login.
 * 
 *
 *
 */
@Controller
public class SecurityController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private BitacoraAccesoService bitacoraAccesoService;

	
	/**
	 * Metodo de redireccionamiento a la pagina principal.
	 */
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init(ModelMap  model, Principal principal ) {
		
		
		
		
		String usuario = SecurityUtils.getCurrentUser();
		//TODO Pendiente...
		/*Usuario modelo = usuarioService.getUsuarioPorNombreAcceso(usuario);
		if(modelo.getCambioClave()){
			return new ModelAndView("redirect:cambioClave/");
		}
		*/
		BitacoraAcceso bit = new BitacoraAcceso();
		bit.setNombreAcceso(usuario);
		bit.setFechaAcceso(new Date());
		bitacoraAccesoService.create(bit);
		System.out.println("init");
		
		return new ModelAndView("redirect:principal");
	}
	
	/**
	 * Metodo de entrada al sistema.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap  model, Principal principal) {
		System.out.println("login");
		
		return "login";
	}
	
	/**
	 * Metodo de entrada al sistema.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap  model, Principal principal) {
		System.out.println("principal");
		return new ModelAndView("redirect:principal");
	}
	
	/**
	 * Metodo de entrada al sistema.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "redirect:login";
	}
	
	/**
	 * Metodo de manejo cuando el login ha fallado.
	 */
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginfailed(ModelMap  model) {
		model.addAttribute("error", "true");
		return "redirect:/login";
	}
	
	/**
	 * Metodo de manejo cuando el acceso ha sido denegado.
	 */
	@RequestMapping(value = "/denegado", method = RequestMethod.GET)
	public String denegado(ModelMap model) {
		model.addAttribute("error", "true");
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/lock", method = RequestMethod.GET)
	public String lock(ModelMap model) {
		
		return "lock";
	}
	
	/**
	 * Metodo para el error 404.
	 */
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String fourofour(ModelAndView model) {
		return "errors/404";
	}
	
	
	
}
