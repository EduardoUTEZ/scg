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
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.util.ExceptionUtils;
import com.segurosthona.scg.util.enums.Permisos;





@Controller
@RequestMapping("roles")
public class RolesController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RolesController.class);
	
	@Autowired
	MessageSource messageSource; 
	
	@Autowired
	private RolService rolService;
	

	
 	/**
 	 * Metodo para inicializar el proceso de recuperación de contraseña.
 	 */
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView index(){
		
		System.out.println("rols index");
		ModelMap map = new ModelMap();		
		feedList(map);
		return new ModelAndView("catalogos/roles/roles", map);
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
		
		return new ModelAndView("catalogos/roles/altaEditaRol", map);
	}
	
	/**
	 * Editar un elemento del catálogo
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam(required=true) Integer id)
	{		
		Rol rol = this.rolService.findOne(id);
			
		if(rol==null){
			return new ModelAndView("roles/");	
		}
						
		ModelMap map = new ModelMap();				
		map.put("rol", rol);
		feedCatalogs(map);
				
		return new ModelAndView("catalogos/roles/altaEditaRol", map);		
	}	
	
	/**
	 * Salvar/Actualizar un elemento del catálogo
	 * @param rol
	 * @param result
	 * @param request
	 * @param ra
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(
			@Valid @ModelAttribute("rol") RolForm rol,
			BindingResult result, HttpServletRequest request,
			RedirectAttributes ra) {
		
		
		System.out.println("Enable login: "+LOG.isErrorEnabled());
		
		
		LOG.debug("Updating rol {}.", rol.getId());	
		ModelMap map = new ModelMap();		

		// revisa validaciones simples
		if (result.hasErrors()) {
			map.put("rol", rol);
			feedCatalogs(map);
			System.out.println("Existen errores: " + result.getAllErrors());
			LOG.debug("Errores: {}", result.getAllErrors());
			return new ModelAndView("rol/" + (rol.getId()==null?"add":"edit"), map);
		}
		
		// convierte la Forma al Modelo
		Rol modelo = rol.toOrmModel(Rol.class);
				
		// validaciones de negocio antes de persistir
		this.rolService.validateBeforeCreate(modelo, result);
		if (result.hasErrors()) {
			map.put("rol", rol);
			feedCatalogs(map);
			System.out.println("Existen errores: " + result.getAllErrors());
			LOG.debug("Errores Validación: {}", result.getAllErrors());
			return new ModelAndView("rol/" + (rol.getId()==null?"add":"edit"), map);		
		}		
		
		String[] msg = {"Rol"};
		// persiste el modelo
		if(modelo.getId() == null){
			this.rolService.create(modelo);			
			map.put("succmsg", messageSource.getMessage("entity.create.success",msg, null));
		}
		else{
			this.rolService.update(modelo);
			map.put("succmsg", messageSource.getMessage("entity.update.success", msg, null));
		}
		
//		return new ModelAndView("redirect:list");
		feedList(map);
		return new ModelAndView("catalogos/roles/roles", map);
	}
	
	/**
	 * Eliminar un elemento del catálogo
	 * @param authentication
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView delete(Authentication authentication, 
			@RequestParam(required=true) Integer id)
	{			
		try {
			this.rolService.deleteById(id);
		} catch (DataIntegrityViolationException e){										
			ModelMap map = new ModelMap();			
			feedList(map);			
			map.put("errmsg", ExceptionUtils.getDataIntegrityViolationMessage(e, this.messageSource));
			return new ModelAndView("catalogos/rol/rols", map);			
		}
		
		ModelMap map = new ModelMap();			
		feedList(map);					
		map.put("succmsg", messageSource.getMessage("entity.delete.success", null, null));
		return new ModelAndView("catalogos/rol/roles", map);
	}		
	
	
	/**
	 * Realiza la conversión de objetos de los formularios.
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(WebDataBinder binder) {		
	}
	
	private void feedList(ModelMap map){

		map.put("roles", rolService.findAll());
	}
	
	/**
	 * Provee catálogos requeridos en el formulario
	 * 
	 * @param map
	 *            mapa de atributos del formulario
	 */
	private void feedCatalogs(ModelMap map) {
		
		map.put("permisos", Permisos.getPermisos());
	}		

}
