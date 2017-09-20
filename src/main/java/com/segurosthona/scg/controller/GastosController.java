/**
 * 
 * Seguros Thona
 * @author Miguel Figueroa Salgado
 *
 */
package com.segurosthona.scg.controller;

import java.util.Date;
import java.util.List;

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

import com.segurosthona.scg.controller.beans.ClavePresupuestariaList;
import com.segurosthona.scg.controller.beans.GastosForm;
import com.segurosthona.scg.controller.beans.Mensaje;
import com.segurosthona.scg.controller.beans.ProveedorForm;
import com.segurosthona.scg.controller.beans.SolicitudGastosXPartidaForm;
import com.segurosthona.scg.controller.beans.UsuarioForm;
import com.segurosthona.scg.controller.beans.generic.GenericModelEditor;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.modelo.entidad.Empresa;
import com.segurosthona.scg.modelo.entidad.EmpresaGrupo;
import com.segurosthona.scg.modelo.entidad.Moneda;
import com.segurosthona.scg.modelo.entidad.Proveedor;
import com.segurosthona.scg.modelo.entidad.Rol;
import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.service.ClavePresupuestariaService;
import com.segurosthona.scg.service.EmpresaGrupoService;
import com.segurosthona.scg.service.EmpresaService;
import com.segurosthona.scg.service.GastosService;
import com.segurosthona.scg.service.MonedaService;
import com.segurosthona.scg.service.ProveedorService;
import com.segurosthona.scg.service.RolService;
import com.segurosthona.scg.service.UsuarioService;
import com.segurosthona.scg.util.Encripta;
import com.segurosthona.scg.util.ExceptionUtils;
import com.segurosthona.scg.util.SecurityUtils;
import com.segurosthona.scg.util.enums.EstadoUsuario;

@Controller
@RequestMapping("gastos")
public class GastosController {

	private static final Logger LOG = LoggerFactory
			.getLogger(GastosController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	private GastosService  gastosService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MonedaService monedaService;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private ClavePresupuestariaService claveService;
	
	//@Autowired
	//private ClavePresupuestariaService claveService;
	/**
	 * Metodo para inicializar el proceso de recuperación de contraseña.
	 */
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView index() {

		System.out.println("gastos index");
		ModelMap map = new ModelMap();
		feedList(map);
		return new ModelAndView("catalogos/gastos/gastos", map);
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
		map.put("gasto", new GastosForm());
		feedCatalogs(map);

		return new ModelAndView("catalogos/gastos/altaEditaSolicitudGastoNormal", map);
	}
	
	
	
	@RequestMapping(value = "/addPartida", method = RequestMethod.GET)
	public ModelAndView addPartida(Authentication authentication) {

		ModelMap map = new ModelMap();
		map.put("partida", new SolicitudGastosXPartidaForm());
		feedCatalogs(map);

		return new ModelAndView("catalogos/gastos/altaEditaSolicitudGastoPartida", map);
	}

	
	@RequestMapping(value="/getCuentasPresupuestales", method=RequestMethod.GET)
	public @ResponseBody List<ClavePresupuestariaList> getCuentasPresupuestales(){			
		
		return claveService.getCuentasPresupuestales();
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
		binder.registerCustomEditor(Moneda.class, new GenericModelEditor<Moneda>(
				this.monedaService));
		binder.registerCustomEditor(Usuario.class, new GenericModelEditor<Usuario>(
				this.usuarioService));
		binder.registerCustomEditor(ClavePresupuestaria.class, new GenericModelEditor<ClavePresupuestaria>(
				this.claveService));
		binder.registerCustomEditor(Proveedor.class, new GenericModelEditor<Proveedor>(
				this.proveedorService));
		//binder.registerCustomEditor(ClavePresupuestaria.class, new GenericModelEditor<ClavePresupuestaria>(
			//	this.claveService));
		
	}

	private void feedList(ModelMap map) {

		map.put("gastos", gastosService.findAll());
	   // map.put("claves",claveService.findAll());
	}

	/**
	 * Provee catálogos requeridos en el formulario
	 * 
	 * @param map
	 *            mapa de atributos del formulario
	 */
	private void feedCatalogs(ModelMap map) {

		//map.put("grupos", rolService.findAll());
		map.put("monedas",monedaService.findAll());
		map.put("empresas",empresaService.findAll());
		map.put("proveedores",proveedorService.findAll());
		//map.put("cuentas", claveService.getCuentasPresupuestales());
	}

}
