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

import com.segurosthona.scg.controller.beans.Archivo;
import com.segurosthona.scg.controller.beans.BusquedaPresupuestoForm;
import com.segurosthona.scg.controller.beans.ClavePresupuestariaForm;
import com.segurosthona.scg.controller.beans.Mensaje;
import com.segurosthona.scg.controller.beans.generic.FechaEditor;
import com.segurosthona.scg.controller.beans.generic.GenericModelEditor;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.modelo.entidad.Empresa;
import com.segurosthona.scg.modelo.entidad.NombreNivel;
import com.segurosthona.scg.modelo.entidad.Presupuesto;
import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.service.ClavePresupuestariaService;
import com.segurosthona.scg.service.EmpresaService;
import com.segurosthona.scg.service.NombreNivelService;
import com.segurosthona.scg.service.PresupuestoService;
import com.segurosthona.scg.service.UsuarioService;
import com.segurosthona.scg.util.SecurityUtils;

@Controller
@RequestMapping("/partidas")
public class PartidaPresupuestalController {

	private static final Logger LOG = LoggerFactory
			.getLogger(PartidaPresupuestalController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	private UsuarioService usuarioService;	
	@Autowired
	private NombreNivelService nombreNivelService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private	ClavePresupuestariaService clavePresupuestariaService;
	@Autowired
	private	PresupuestoService presupuestoService;


	/**
	 * Metodo para mostrar página de busqueda y acciones.
	 */
	@ResponseBody
	@RequestMapping("/partidas")
	public ModelAndView principal() {

		ModelMap map = new ModelMap();

		feedList(map);
		return new ModelAndView("presupuesto/claves/clave", map);
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
		map.put("clave", new ClavePresupuestariaForm());
		feedCatalogs(map);

		return new ModelAndView("presupuesto/claves/altaEditaClave", map);
	}
	
	
	/**
	 * Muestra pantalla de Carga masiva.
	 * 
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/cargaMasiva", method = RequestMethod.GET)
	public ModelAndView cargaMasiva(Authentication authentication) {

		ModelMap map = new ModelMap();
		map.put("archivo", new Archivo());

		return new ModelAndView("presupuesto/claves/cargaMasiva", map);
	}
	
	
	/**
	 * Ejecuta la carga masiva del presupuesto.
	 * 
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/ejecutaCargaMasiva", method = RequestMethod.POST)
	public ModelAndView ejecutaCargaMasiva(Authentication authentication,  
			@ModelAttribute("archivo") Archivo archivo) {
		
		System.out.println("Entra a ejecutaCargaMasiva");
		ModelMap map = new ModelMap();
		Mensaje men = clavePresupuestariaService.cargaMasivaPresupuesto(archivo);
		map.put("mensaje", men);

		return new ModelAndView("mensaje", map);
	}
	
	
	
	/**
	 * Edita un elemento de Clave de Presupuesto
	 * 
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(Authentication authentication,
			@RequestParam(required=true) Integer id) {

		ModelMap map = new ModelMap();
		
		ClavePresupuestaria clave = clavePresupuestariaService.findOne(id);		
		ClavePresupuestariaForm claveForm= (new ClavePresupuestariaForm()).fromOrmModel(clave,
				ClavePresupuestariaForm.class);
		
		//Agrega Presupuesto:
		List<Presupuesto> presupuesto = presupuestoService.getByIdClavePresupuestal(id);
		
		//Establece el año para fines informativos.
		//if(presupuesto.size()>0) claveForm.setAnio(presupuesto.get(0).getAnio());
		
		Presupuesto totales = new Presupuesto();
		for(Presupuesto p : presupuesto){
			//Calcula dispoinible:
			p.setPptoDisponible(p.getPptoProgramado()-p.getPptoComprometido()-p.getPptoEjercido());
			
			totales.setPptoProgramado(totales.getPptoProgramado()+p.getPptoProgramado());
			totales.setPptoComprometido(totales.getPptoComprometido()+p.getPptoComprometido());
			totales.setPptoEjercido(totales.getPptoEjercido()+p.getPptoEjercido());
			totales.setPptoDisponible(totales.getPptoDisponible()+p.getPptoDisponible());
	
		}
		presupuesto.add(totales);
		
		map.put("presupuesto", presupuesto);
		map.put("clave", claveForm);
		
		feedCatalogs(map);
		return new ModelAndView("presupuesto/claves/editaClave", map);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(
			@Valid @ModelAttribute("clave") ClavePresupuestariaForm clave,
			BindingResult result, HttpServletRequest request,
			RedirectAttributes ra) {
		
		ModelMap map = new ModelMap();	
		String usuarioSesion = SecurityUtils.getCurrentUser();

		// revisa validaciones simples
		if (result.hasErrors()) {
			map.put("clave", clave);
			feedCatalogs(map);
			System.out.println("Existen errores: " + result.getAllErrors());
			LOG.debug("Errores: {}", result.getAllErrors());
			return new ModelAndView("presupuesto/claves/altaEditaClave", map);
		}
		
		// convierte la Forma al Modelo
		ClavePresupuestaria modelo = clave.toOrmModel(ClavePresupuestaria.class);
		System.out.println(modelo);		
		// validaciones de negocio antes de persistir
		this.clavePresupuestariaService.validateBeforeCreate(modelo, result);
		if (result.hasErrors()) {
			map.put("clave", clave);
			feedCatalogs(map);
			System.out.println("Existen errores: " + result.getAllErrors());
			LOG.debug("Errores Validación: {}", result.getAllErrors());
			return new ModelAndView("presupuesto/claves/altaEditaClave", map);		
		}		
		
		String[] msg = {"Clave Presupuestaria"};
		// persiste el modelo
		if(modelo.getId() == null){
			modelo.setUsuarioAlta(usuarioSesion);
			modelo.setFechaAlta(new Date());
			this.clavePresupuestariaService.create(modelo);
		
			
			//Agrega Partidas Presupuestales:
			clave.setId(modelo.getId());
			ArrayList<Presupuesto> array = getPresupuestoAnual(clave);
			System.out.println("Tamaño de array: " + array);
			for(Presupuesto p : array){
				presupuestoService.create(p);
			}
			
			
			map.put("succmsg", messageSource.getMessage("entity.create.success",msg, null));
		} else{
			modelo.setUsuarioModifica(usuarioSesion);
			modelo.setFechaModifica(new Date());
			this.clavePresupuestariaService.update(modelo);
			map.put("succmsg", messageSource.getMessage("entity.update.success", msg, null));
		}
		
		
//		return new ModelAndView("redirect:list");
		feedList(map);
		return new ModelAndView("presupuesto/claves/clave", map);
	}
	
	
	/**
	 * Delete un elemento de Clave de Presupuesto
	 * 
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Authentication authentication,
			@RequestParam(required=true) Integer id) {

		ModelMap map = new ModelMap();
		
		clavePresupuestariaService.deleteById(id);
			

		map.put("mensaje", new Mensaje(Mensaje.TIPO_SUCCESS,messageSource.getMessage("entity.delete.success", null, null)));
		feedList(map);
		return new ModelAndView("presupuesto/claves/clave", map);
	}
	
	
	/**
	 * Obtiene datos de la cuenta
	 * @return
	 */
	@RequestMapping(value="/getNombreNivel", method=RequestMethod.GET)
	public @ResponseBody NombreNivel getNombreNivel(
			@RequestParam(required=true) Integer idEmpresa){			
		
		return nombreNivelService.getByEmpresa(idEmpresa);
	}

	/**
	 * Realiza la conversión de objetos de los formularios.
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Empresa.class, new GenericModelEditor<Empresa>(this.empresaService));
		binder.registerCustomEditor(Usuario.class, new GenericModelEditor<Usuario>(this.usuarioService));
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		binder.registerCustomEditor(Date.class, new FechaEditor(sdf));
	}
	
	
	public static ArrayList<Presupuesto> getPresupuestoAnual(ClavePresupuestariaForm clave){
		ArrayList<Presupuesto> array = new ArrayList<Presupuesto>();
		
		Presupuesto p1 = new Presupuesto();
		//p1.setAnio(clave.getAnio());
		p1.setIdClavePresupuestaria(clave.getId());
		p1.setMes(1);
		p1.setPptoProgramado(clave.getPptoProgramado().getMes1());
		p1.setPptoEjercido(clave.getPptoEjercido().getMes1());
		p1.setPptoComprometido(clave.getPptoComprometido().getMes1());
		array.add(p1);
		
		Presupuesto p2 = new Presupuesto();
		//p2.setAnio(clave.getAnio());
		p2.setIdClavePresupuestaria(clave.getId());
		p2.setMes(2);
		p2.setPptoProgramado(clave.getPptoProgramado().getMes2());
		p2.setPptoEjercido(clave.getPptoEjercido().getMes2());
		p2.setPptoComprometido(clave.getPptoComprometido().getMes2());
		array.add(p2);
		
		Presupuesto p3 = new Presupuesto();
		//p3.setAnio(clave.getAnio());
		p3.setIdClavePresupuestaria(clave.getId());
		p3.setMes(3);
		p3.setPptoProgramado(clave.getPptoProgramado().getMes3());
		p3.setPptoEjercido(clave.getPptoEjercido().getMes3());
		p3.setPptoComprometido(clave.getPptoComprometido().getMes3());
		array.add(p3);
		
		Presupuesto p4 = new Presupuesto();
		//p4.setAnio(clave.getAnio());
		p4.setIdClavePresupuestaria(clave.getId());
		p4.setMes(4);
		p4.setPptoProgramado(clave.getPptoProgramado().getMes4());
		p4.setPptoEjercido(clave.getPptoEjercido().getMes4());
		p4.setPptoComprometido(clave.getPptoComprometido().getMes4());
		array.add(p4);
		
		Presupuesto p5 = new Presupuesto();
		//p5.setAnio(clave.getAnio());
		p5.setIdClavePresupuestaria(clave.getId());
		p5.setMes(5);
		p5.setPptoProgramado(clave.getPptoProgramado().getMes5());
		p5.setPptoEjercido(clave.getPptoEjercido().getMes5());
		p5.setPptoComprometido(clave.getPptoComprometido().getMes5());
		array.add(p5);
		
		Presupuesto p6 = new Presupuesto();
		//p6.setAnio(clave.getAnio());
		p6.setIdClavePresupuestaria(clave.getId());
		p6.setMes(6);
		p6.setPptoProgramado(clave.getPptoProgramado().getMes6());
		p6.setPptoEjercido(clave.getPptoEjercido().getMes6());
		p6.setPptoComprometido(clave.getPptoComprometido().getMes6());
		array.add(p6);
		
		Presupuesto p7 = new Presupuesto();
		//p7.setAnio(clave.getAnio());
		p7.setIdClavePresupuestaria(clave.getId());
		p7.setMes(7);
		p7.setPptoProgramado(clave.getPptoProgramado().getMes7());
		p7.setPptoEjercido(clave.getPptoEjercido().getMes7());
		p7.setPptoComprometido(clave.getPptoComprometido().getMes7());
		array.add(p7);
		
		Presupuesto p8 = new Presupuesto();
		//p8.setAnio(clave.getAnio());
		p8.setIdClavePresupuestaria(clave.getId());
		p8.setMes(8);
		p8.setPptoProgramado(clave.getPptoProgramado().getMes8());
		p8.setPptoEjercido(clave.getPptoEjercido().getMes8());
		p8.setPptoComprometido(clave.getPptoComprometido().getMes8());
		array.add(p8);
		
		Presupuesto p9 = new Presupuesto();
		//p9.setAnio(clave.getAnio());
		p9.setIdClavePresupuestaria(clave.getId());
		p9.setMes(9);
		p9.setPptoProgramado(clave.getPptoProgramado().getMes9());
		p9.setPptoEjercido(clave.getPptoEjercido().getMes9());
		p9.setPptoComprometido(clave.getPptoComprometido().getMes9());
		array.add(p9);
		
		Presupuesto p10 = new Presupuesto();
		//p10.setAnio(clave.getAnio());
		p10.setIdClavePresupuestaria(clave.getId());
		p10.setMes(10);
		p10.setPptoProgramado(clave.getPptoProgramado().getMes10());
		p10.setPptoEjercido(clave.getPptoEjercido().getMes10());
		p10.setPptoComprometido(clave.getPptoComprometido().getMes10());
		array.add(p10);
		
		Presupuesto p11 = new Presupuesto();
		//p11.setAnio(clave.getAnio());
		p11.setIdClavePresupuestaria(clave.getId());
		p11.setMes(11);
		p11.setPptoProgramado(clave.getPptoProgramado().getMes11());
		p11.setPptoEjercido(clave.getPptoEjercido().getMes11());
		p11.setPptoComprometido(clave.getPptoComprometido().getMes11());
		array.add(p11);
		
		Presupuesto p12 = new Presupuesto();
		//p12.setAnio(clave.getAnio());
		p12.setIdClavePresupuestaria(clave.getId());
		p12.setMes(12);
		p12.setPptoProgramado(clave.getPptoProgramado().getMes12());
		p12.setPptoEjercido(clave.getPptoEjercido().getMes12());
		p12.setPptoComprometido(clave.getPptoComprometido().getMes12());
		array.add(p12);
		
		return array;
	}
	

	private void feedList(ModelMap map) {
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Integer> anios = new ArrayList<Integer>();
		for(int i = 2017; i < anioActual + 5; i++){
			anios.add(i);
		}
		map.put("anios", anios);
		map.put("busquedaPresupuesto", new BusquedaPresupuestoForm());
		map.put("claves", clavePresupuestariaService.getClaves());
	}

	/**
	 * Provee catálogos requeridos en el formulario
	 * 
	 * @param map
	 *            mapa de atributos del formulario
	 */
	private void feedCatalogs(ModelMap map) {
		List<Empresa> empresas = empresaService.findAll();
		map.put("empresas", empresas);
		
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Integer> anios = new ArrayList<Integer>();
		for(int i = 2017; i < anioActual + 5; i++){
			anios.add(i);
		}
		map.put("anios", anios);
		
		map.put("usuarios",usuarioService.findAll());

		
	}

}
