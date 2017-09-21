/**
 * 
 * Seguros Thona
 * @author Miguel Figueroa Salgado
 *
 */
package com.segurosthona.scg.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
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

import com.segurosthona.scg.controller.beans.Mensaje;
import com.segurosthona.scg.controller.beans.ProveedorForm;
import com.segurosthona.scg.controller.beans.generic.GenericModelEditor;
import com.segurosthona.scg.modelo.entidad.Empresa;
import com.segurosthona.scg.modelo.entidad.Proveedor;
import com.segurosthona.scg.service.EmpresaService;
import com.segurosthona.scg.service.ProveedorService;
import com.segurosthona.scg.util.SecurityUtils;
import com.segurosthona.scg.util.enums.EstadoCatalogo;
import com.segurosthona.scg.util.enums.TipoProveedor;




@Controller
@RequestMapping("proveedores")
public class ProveedorController {


	@Autowired
	MessageSource messageSource;

	@Autowired
	private ProveedorService usuarioService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private ProveedorService proveedorService;

	/**
	 * Metodo para inicializar el proceso de recuperación de contraseña.
	 */
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView index() {

		System.out.println("proveedor index");
		System.out.println("Entra a controller");
		ModelMap map = new ModelMap();
		feedList(map);
		return new ModelAndView("catalogos/proveedores/proveedores", map);
	}

	/**
	 * Agregar un elemento al catálogo
	 * 
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(Authentication authentication) {

		ModelMap map = new ModelMap();
		map.put("proveedor", new ProveedorForm());
		feedCatalogs(map);

		System.out.println("Entra a add");
		return new ModelAndView("catalogos/proveedores/altaEditaProveedor", map);
	
	}

	/**
	 * Editar un elemento del catálogo
	 * 
	 * @param id
	 * @return
	 */

	/**
	 * Salvar/Actualizar un elemento del catálogo
	 * 
	 * @param usuario
	 * @param result
	 * @param request
	 * @param ra
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(
			@Valid @ModelAttribute("proveedor") ProveedorForm proveedor,
			BindingResult result, HttpServletRequest request,
			RedirectAttributes ra) {

		
		String usuarioSesion = SecurityUtils.getCurrentUser();
		ModelMap map = new ModelMap();

		// revisa validaciones simples
		if (result.hasErrors()) {
			map.put("proveedor", proveedor);
			feedCatalogs(map);
			System.out.println("Existen errores: " + result.getAllErrors());
			
			return new ModelAndView("proveedores/"
					+ (proveedor.getId() == null ? "add" : "edit"), map);
		}

		// convierte la Forma al Modelo
		Proveedor modelo = proveedor.toOrmModel(Proveedor.class);

		// validaciones de negocio antes de persistir
		this.usuarioService.validateBeforeCreate(modelo, result);
		if (result.hasErrors()) {
			map.put("proveedor", proveedor);
			feedCatalogs(map);
			System.out.println("Existen errores: " + result.getAllErrors());
			
			return new ModelAndView("usuarios/"
					+ (proveedor.getId() == null ? "add" : "edit"), map);
		}

		String[] msg = { "Proveedor" };
		// persiste el modelo
		if (modelo.getId() == null) {
			modelo.setUsuarioAlta(usuarioSesion);
			modelo.setFechaAlta(new Date());

			this.proveedorService.create(modelo);

			map.put("mensaje",
					new Mensaje(Mensaje.TIPO_SUCCESS, messageSource.getMessage(
							"entity.create.success", msg, null)));
		} else {
			
			modelo.setUsuarioModifica(usuarioSesion);
			modelo.setFechaModifica(new Date());
			this.proveedorService.update(modelo);

			map.put("mensaje",
					new Mensaje(Mensaje.TIPO_SUCCESS, messageSource.getMessage(
							"entity.update.success", msg, null)));
		}

		// return new ModelAndView("redirect:list");
		feedList(map);
		return new ModelAndView("catalogos/proveedores/proveedores", map);
	}
	

	/**
	 * Eliminar un elemento del catálogo
	 * 
	 * @param authentication
	 * @param id
	 * @return
	 */

	/**
	 * Realiza la conversión de objetos de los formularios.
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Empresa.class, new GenericModelEditor<Empresa>(
				this.empresaService));
	}

	private void feedList(ModelMap map) {

		//map.put("proveedores", usuarioService.findAll());
	}

	/**
	 * Provee catálogos requeridos en el formulario
	 * 
	 * @param map
	 *            mapa de atributos del formulario
	 */
	private void feedCatalogs(ModelMap map) {

		map.put("grupos", empresaService.findAll());
		map.put("tipos", TipoProveedor.getTipos());
		map.put("estados", EstadoCatalogo.getEstados());
	}

}
