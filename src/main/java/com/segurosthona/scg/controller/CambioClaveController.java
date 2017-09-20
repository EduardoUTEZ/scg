/**
 * 
 * Seguros Thona
 * @author Juan antonio silva flores
 *
 */
package com.segurosthona.scg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.segurosthona.scg.controller.beans.CambioClaveForm;
import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.service.UsuarioService;
import com.segurosthona.scg.util.Encripta;
import com.segurosthona.scg.util.SecurityUtils;


@Controller
@RequestMapping("cambioClave")
public class CambioClaveController {
	
	@Autowired
	MessageSource messageSource; 
	@Autowired
	private UsuarioService usuarioService;
	
	
 	/**
 	 * Metodo para inicializar el proceso de recuperación de contraseña.
 	 */
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView index(){
		
		String usuario = SecurityUtils.getCurrentUser();
		CambioClaveForm cambioClave = new CambioClaveForm();
		
		Usuario modelo = usuarioService.getUsuarioPorNombreAcceso(usuario);
		cambioClave.setIdUsuario(modelo.getId());
		
		return new ModelAndView("cambioClave/cambio", "cambioClave", cambioClave);
	}

	
	
	/**
	 * Actualiza la clave de acceso
	 * @param usuario
	 * @param result
	 * @param request
	 * @param ra
	 * @return
	 */
	@RequestMapping(value = "/cambiar", method = RequestMethod.POST)
	public ModelAndView cambiar(
			@Valid @ModelAttribute("cambioClave") CambioClaveForm cc,
			BindingResult result, HttpServletRequest request,
			RedirectAttributes ra) {
		
		
			Usuario modelo = usuarioService.findOne(cc.getIdUsuario());
			
			if(modelo.getClaveAcceso().equals(Encripta.encripta(cc.getClaveAccesoActual()))){
				modelo.setCambioClave(false);
				modelo.setClaveAcceso(Encripta.encripta(cc.getClaveAccesoNueva()));
				this.usuarioService.update(modelo);
				ra.addFlashAttribute("succmsg", messageSource.getMessage("entity.update.success", null, null));
				
			}else{
				ra.addFlashAttribute("errmsg","La clave de acceso no coincide con la actual.");
				return new ModelAndView("redirect:/cambioClave/");
			}
			
			
			
			
		
		return new ModelAndView("redirect:/principal");
	}
	
	
	
	
	/**
	 * Realiza la conversión de objetos de los formularios.
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(WebDataBinder binder) {		
		
	}
	

	

}
