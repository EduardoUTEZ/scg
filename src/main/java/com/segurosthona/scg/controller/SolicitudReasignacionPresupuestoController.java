/**
 * 
 * Seguros Thona
 * @author Miguel Figueroa Salgado
 *
 */
package com.segurosthona.scg.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.segurosthona.scg.controller.beans.BusquedaPresupuestoForm;
import com.segurosthona.scg.controller.beans.ClavePresupuestariaForm;
import com.segurosthona.scg.controller.beans.ClavePresupuestariaList;
import com.segurosthona.scg.controller.beans.Mensaje;
import com.segurosthona.scg.controller.beans.PresupuestoDetalle;
import com.segurosthona.scg.controller.beans.PresupuestoSolicitudRForm;
import com.segurosthona.scg.controller.beans.SolicitudReasignacionForm;
import com.segurosthona.scg.controller.beans.SolicitudReasignacionPresupuestoForm;
import com.segurosthona.scg.controller.beans.generic.FechaEditor;
import com.segurosthona.scg.controller.beans.generic.GenericModelEditor;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.modelo.entidad.DetalleReasignacion;
import com.segurosthona.scg.modelo.entidad.Empresa;
import com.segurosthona.scg.modelo.entidad.Presupuesto;
import com.segurosthona.scg.modelo.entidad.PresupuestoSolicitudR;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacion;
import com.segurosthona.scg.modelo.entidad.SolicitudReasignacionPresupuesto;
import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.service.ClavePresupuestariaService;
import com.segurosthona.scg.service.DetalleReasignacionService;
import com.segurosthona.scg.service.EmpresaGrupoService;
import com.segurosthona.scg.service.EmpresaService;
import com.segurosthona.scg.service.NombreNivelService;
import com.segurosthona.scg.service.PresupuestoService;
import com.segurosthona.scg.service.PresupuestoSolicitudRService;
import com.segurosthona.scg.service.SolicitudReasignacionPresupuestoService;
import com.segurosthona.scg.service.SolicitudReasignacionService;
import com.segurosthona.scg.service.UsuarioService;
import com.segurosthona.scg.util.SecurityUtils;

@Controller
@RequestMapping("reasignacion")
public class SolicitudReasignacionPresupuestoController {

	private static final Logger LOG = LoggerFactory.getLogger(SolicitudReasignacionPresupuestoController.class);

	@Autowired
	MessageSource messageSource;

	//@Autowired
	//private UsuarioService usuarioService;
	// @Autowired
	// private NombreNivelService nombreNivelService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private ClavePresupuestariaService clavePresupuestariaService;
	@Autowired
	private PresupuestoSolicitudRService solicitudReasignacionService;
	@Autowired
	private SolicitudReasignacionPresupuestoService solicitudReasignacionService1;
	//@Autowired
	//private PresupuestoService presupuestoService;

	/**
	 * Metodo para mostrar página de busqueda y acciones.
	 */
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView principal() {

		ModelMap map = new ModelMap();

		feedList(map);
		return new ModelAndView("catalogos/reasignacion/reasignacion", map);
	}

	/**
	 * Agregar un elemento al presupuesto
	 * 
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(Authentication authentication) {

		ModelMap map = new ModelMap();
		map.put("solicitud", new PresupuestoSolicitudRForm());
		feedCatalogs(map);

		return new ModelAndView("catalogos/reasignacion/altaEditaSolicitud", map);
	}

	/**
	 * Obtiene cuentas presupuestales segun el año y empresa.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCuentas", method = RequestMethod.GET)
	public @ResponseBody List<ClavePresupuestariaList> getCuentas(@RequestParam(required = true) Integer idEmpresa,
			@RequestParam(required = true) Integer anio) {

		return clavePresupuestariaService.getClaves(idEmpresa, anio);
	}

	/**
	 * Obtiene cuentas presupuestales segun el año y empresa.
	 * 
	 * @return
	 */
	//@RequestMapping(value = "/getPresupuestoDeCuenta", method = RequestMethod.GET)
	//public @ResponseBody List<Presupuesto> getPresupuestoDeCuenta(@RequestParam(required = true) Integer idClave) {

		//List<Presupuesto> presupuesto = presupuestoService.getByIdClavePresupuestal(idClave);
		//for (Presupuesto p : presupuesto) {
		//	p.setPptoDisponible(p.getPptoProgramado() - p.getPptoComprometido() - p.getPptoEjercido());
		//}

		//return presupuesto;
	//}

	/**
	 * Realiza la conversión de objetos de los formularios.
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Empresa.class, new GenericModelEditor<Empresa>(this.empresaService));
		binder.registerCustomEditor(SolicitudReasignacionPresupuesto.class, new GenericModelEditor<SolicitudReasignacionPresupuesto>(this.solicitudReasignacionService1));
		binder.registerCustomEditor(ClavePresupuestaria.class, new GenericModelEditor<ClavePresupuestaria>(this.clavePresupuestariaService));
		
		//binder.registerCustomEditor(Usuario.class, new GenericModelEditor<Usuario>(this.usuarioService));
		
		//SimpleDateFormat sdf = new SimpleDateFormat();
		//binder.registerCustomEditor(Date.class, new FechaEditor(sdf));
	}

	public static ArrayList<DetalleReasignacion> getDetalleReasignacion(PresupuestoDetalle pd) {
		ArrayList<DetalleReasignacion> array = new ArrayList<DetalleReasignacion>();

		// TODO

		return array;
	}

	private void feedList(ModelMap map) {
		//int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		//ArrayList<Integer> anios = new ArrayList<Integer>();
		//for (int i = 2017; i < anioActual + 5; i++) {
		//	anios.add(i);
		//}
		map.put("solicitudes", solicitudReasignacionService.findAll());
		// map.put("anios", anios);
		// map.put("busquedaPresupuesto", new BusquedaPresupuestoForm());
		// map.put("claves", clavePresupuestariaService.getClaves());
	}

	/**
	 * Provee catálogos requeridos en el formulario
	 * 
	 * @param map
	 *            mapa de atributos del formulario
	 */
	private void feedCatalogs(ModelMap map) {
		//List<Empresa> empresas = empresaService.findAll();
		map.put("empresas", empresaService.findAll());

		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Integer> anios = new ArrayList<Integer>();
		 for(int i = 2017; i < anioActual + 5; i++){
		 anios.add(i);
		 }
		 //map.put("anios", anios);

		//map.put("usuarios", usuarioService.findAll());

		//map.put("clavesR", clavePresupuestariaService.findAll());

	}

}
