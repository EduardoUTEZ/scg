package com.segurosthona.scg.service.imp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.multipart.MultipartFile;

import com.segurosthona.scg.controller.PartidaPresupuestalController;
import com.segurosthona.scg.controller.beans.Archivo;
import com.segurosthona.scg.controller.beans.CargaMasivaPresupuestoForm;
import com.segurosthona.scg.controller.beans.ClavePresupuestariaForm;
import com.segurosthona.scg.controller.beans.ClavePresupuestariaList;
import com.segurosthona.scg.controller.beans.Mensaje;
import com.segurosthona.scg.dao.ClavePresupuestariaDao;
import com.segurosthona.scg.dao.EmpresaDao;
import com.segurosthona.scg.dao.UsuarioDao;
import com.segurosthona.scg.modelo.entidad.ClavePresupuestaria;
import com.segurosthona.scg.modelo.entidad.Empresa;
import com.segurosthona.scg.modelo.entidad.Presupuesto;
import com.segurosthona.scg.modelo.entidad.Usuario;
import com.segurosthona.scg.modelo.generic.IOperations;
import com.segurosthona.scg.service.ClavePresupuestariaService;
import com.segurosthona.scg.service.PresupuestoService;
import com.segurosthona.scg.service.generic.AbstractService;
import com.segurosthona.scg.service.generic.DuplicateValidator;
import com.segurosthona.scg.util.enums.Moneda;

@Service
public class ClavePresupuestariaServiceImp extends AbstractService<ClavePresupuestaria> implements ClavePresupuestariaService {

	@Autowired
	private ClavePresupuestariaDao dao;
	@Autowired
	private EmpresaDao empresaDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PresupuestoService presupuestoService; 
	
	
	private Hashtable<String, Empresa> empresas = new Hashtable<String, Empresa>();

	public ClavePresupuestariaServiceImp() {
		super();
	}

	@Override
	protected IOperations<ClavePresupuestaria> getDao() {
		return dao;
	}

	@Override
	public void validateBeforeCreate(ClavePresupuestaria entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeUpdate(ClavePresupuestaria entity, BindingResult result) {
		validateDuplicates(entity, result);
	}

	@Override
	public void validateBeforeDelete(ClavePresupuestaria entity, BindingResult result) {
		validateDuplicates(entity, result);
	}
	
	/**
	 * Valida existencia de duplicados antes de guardar. Se basa en los campos: rol
	 * 
	 * @param entity
	 * @param result
	 */
	private void validateDuplicates(ClavePresupuestaria entity, BindingResult result){
		ArrayList<String[]> props = new ArrayList<String[]>();
		props.add(new String[]{"cuentaContable"});
		DuplicateValidator<ClavePresupuestaria> validator = new DuplicateValidator<ClavePresupuestaria>(
				ClavePresupuestaria.class, this, props);
		ValidationUtils.invokeValidator(validator, entity, result);		
	}

	/*
	 * (non-Javadoc)
	 * @see com.segurosthona.scg.service.ClavePresupuestariaService#getClaves()
	 */
	@Override
	public List<ClavePresupuestariaList> getClaves() {
		return dao.getClaves();
	}
	@Override
	public List<ClavePresupuestariaList> getCuentasPresupuestales(){
		
		
		return dao.getCuentasPresupuestales();
	}
	
	
	@Override
	public Mensaje cargaMasivaPresupuesto(Archivo cm) {
		Mensaje men = new Mensaje();
		men.setTipo(Mensaje.TIPO_SUCCESS);
		
		String nombreAcceso = ((UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUsername();

		System.out.println("Entra a carga masiva del Presupuesto.");

		if (cm.getArchivo() != null) {
			if (!cm.getArchivo().isEmpty()) {
				
				cargaEmpresas(); //Realiza la carga de empreas para hacer mas eficiente el acceso a la base de datos.
				
				MultipartFile multipartFile = cm.getArchivo();

				try {
					ArrayList<ClavePresupuestariaForm> array = new ArrayList<ClavePresupuestariaForm>();

					InputStream excel = multipartFile.getInputStream();
					HSSFWorkbook wb = new HSSFWorkbook(excel);

					HSSFSheet sheet = wb.getSheetAt(0);
					// Iterate through each rows one by one
					Iterator<Row> rowIterator = sheet.iterator();
					rowIterator.next(); //renglon 1
					rowIterator.next(); //renglon 2
					int renglon = 3;
					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						Iterator<Cell> cellIterator = row.cellIterator();

						ClavePresupuestariaForm clave = new ClavePresupuestariaForm();

						while (cellIterator.hasNext()) {
							Cell cell = cellIterator.next();
							cell.setCellType(Cell.CELL_TYPE_STRING);

							if (cell.getStringCellValue() == null)
								break;

							try {
								switch (cell.getColumnIndex()) {
								case 0:
									clave.setNivel1(cell
											.getStringCellValue().toUpperCase());
									break;
								case 1:
									clave.setNivel2(cell
											.getStringCellValue().toUpperCase());
									break;
								case 2:
									clave.setNivel3(cell
											.getStringCellValue().toUpperCase());
									break;
								case 3:
									clave.setNivel4(cell
											.getStringCellValue().toUpperCase());
									break;
								case 4:
									clave.setNivel5(cell
											.getStringCellValue().toUpperCase());
									break;
								case 5:
									clave.setNivel6(cell
											.getStringCellValue().toUpperCase());
									break;
								case 6:
									clave.setNivel7(cell
											.getStringCellValue().toUpperCase());
									break;
								case 7:
									clave.setNivel8(cell
											.getStringCellValue().toUpperCase());
									break;
								case 8:
									clave.setNivel9(cell
											.getStringCellValue().toUpperCase());
									break;
								case 9:
									clave.setNivel10(cell
											.getStringCellValue().toUpperCase());
									break;
								case 10:
									Empresa empresa = empresas.get(cell.getStringCellValue());
									if (empresa == null){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("No existe la empresa. Renglon "+ renglon);
									}else{
										clave.setEmpresa(empresa);
									}									
									break;
								case 11:
									Moneda mon = Moneda.getMoneda(cell.getStringCellValue());
									if (mon == null){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("No existe la moneda. Renglon "+ renglon);
									}else{
										clave.setMoneda(mon);
									}									
									break;
								case 12:
									clave.setDescripcion(cell.getStringCellValue());
									break;
								case 13:
									clave.setCuentaContable(cell.getStringCellValue());
									break;
								case 14:
									Usuario responsable = usuarioDao.getUsuarioPorNombreAcceso(cell.getStringCellValue());
									if(responsable == null){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("No existe usuario responsable. Renglon "+ renglon);
									}else{
										clave.setUsuarioResponsable(responsable);
									}
									break;
								case 15:
									Usuario suplente = usuarioDao.getUsuarioPorNombreAcceso(cell.getStringCellValue());
									if(suplente == null){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("No existe usuario suplente. Renglon "+ renglon);
									}else{
										clave.setUsuarioSuplente(suplente);
									}
									break;
								case 16:
									try{
										//int anio = Integer.parseInt(cell.getStringCellValue());
										//clave.setAnio(anio);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El año debe ser un número entero en formato YYYY. Renglon "+ renglon);
									}
									
									break;
									
								case 17:
									try{
										double mes1 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes1(mes1);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Enero debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 18:
									try{
										double mes2 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes2(mes2);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Febrero debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 19:
									try{
										double mes3 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes3(mes3);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Marzo debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 20:
									try{
										double mes4 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes4(mes4);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Abril debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 21:
									try{
										double mes5 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes5(mes5);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Mayo debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 22:
									try{
										double mes6 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes6(mes6);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Junio debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 23:
									try{
										double mes7 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes7(mes7);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Julio debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 24:
									try{
										double mes8 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes8(mes8);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Agosto debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 25:
									try{
										double mes9 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes9(mes9);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Septiembre debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 26:
									try{
										double mes10 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes10(mes10);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Octubre debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 27:
									try{
										double mes11 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes11(mes11);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Noviembre debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;
								case 28:
									try{
										double mes12 = Double.parseDouble(cell.getStringCellValue());
										clave.getPptoProgramado().setMes12(mes12);
									}catch(NumberFormatException nfe){
										men.setTipo(Mensaje.TIPO_ERROR);
										men.getMensajeFijo().add("El presupuesto para Diciembre debe ser numérico decimal. Renglon "+ renglon);
									}
									
									break;

								}
								
							} catch (NumberFormatException nfe) {
								array.clear();
								break;
							}
						}
						
					
						
						
						//Agrega si no existen errores.
						if(men.getTipo() != Mensaje.TIPO_ERROR){						
							array.add(clave);
						}else{
							array.clear();
						}
						

						renglon++;
					}
					

					// Si no hubo problema en agregar Registro del archivo de
					// excel se procede a la alta.
					if (men.getTipo() == Mensaje.TIPO_SUCCESS) {
						for (ClavePresupuestariaForm claveP : array) {
							
							ClavePresupuestaria modelo = claveP.toOrmModel(ClavePresupuestaria.class);
							modelo.setFechaAlta(new Date());
							modelo.setUsuarioAlta(nombreAcceso);
							
							//System.out.println(user.toString());
							dao.create(modelo);
							if(modelo.getId() != null){
								claveP.setId(modelo.getId());
								ArrayList<Presupuesto> presupuestoArray = PartidaPresupuestalController.getPresupuestoAnual(claveP);
								for(Presupuesto p : presupuestoArray){
									presupuestoService.create(p);
								}
							}else{
								men.setTipo(Mensaje.TIPO_ERROR);
								men.getMensajeFijo().add(
										"Ocurrió un error al agregar el presupuesto con clave: "+
								modelo.getNivel1()+" "+
								modelo.getNivel2()+" "+
								modelo.getNivel3()+" "+
								modelo.getNivel4()+" "+
								modelo.getNivel5()+" "+
								modelo.getNivel6()+" "+
								modelo.getNivel7()+" "+
								modelo.getNivel8()+" "+
								modelo.getNivel9()+" "+
								modelo.getNivel10());
							}
							
						}
						men.setMensaje("Se cargaron " + array.size()
								+ " registros.");
					}
					excel.close();
					
				} catch (Exception e) {
					men.setTipo(Mensaje.TIPO_ERROR);
					men.setMensaje("Error al realizar la carga masiva.");
					e.printStackTrace();
				}

			} else {
				men.setTipo(Mensaje.TIPO_ERROR);
				men.setMensaje("El archivo no contiene información valida.");
			}
		} else {
			men.setTipo(Mensaje.TIPO_ERROR);
			men.setMensaje("El archivo no contiene información valida.");
		}
		empresas.clear();
		return men;
	}
	
	
	
	/**
	 * Asigna oficina al usuario si es que le corresponden según el Negocio.
	 * 
	 * @param user
	 *            Usuario a que se le agregarán los flujos
	 * @param nombreOficina
	 *            Lista de flujos separados por comas
	 * @param negocio
	 *            Negocio al que aplica la carga masiva.
	 * @return True si la asignación de la oficina es correcta, false de lo
	 *         contrario.
	 */
	private boolean cargaEmpresas() {
		List<Empresa> empresasList = empresaDao.findAll();
		for(Empresa em : empresasList){
			empresas.put(em.getId().toString(), em);
		}
		return true;
	}

	@Override
	public List<ClavePresupuestariaList> getClaves(Integer idEmpresa,
			Integer anio) {
		return dao.getClaves(idEmpresa, anio);
	}

}
