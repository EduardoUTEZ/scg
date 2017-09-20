<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:insertDefinition name="defaultTemplate">
	<fmt:message key="gastos" var="entity" />

	<tiles:putAttribute name="title">
		Solicitudes de Gastos
	</tiles:putAttribute>

	<tiles:putAttribute name="body">

		<style>
input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
		<div class="row">

			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">transform</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">
							<c:if test="${empty usuario.id}">
								<fmt:message key="labels.forms.newform.title">
									<fmt:param value="${entity}" />
								</fmt:message>
							</c:if>
							<c:if test="${not empty usuario.id}">
								<fmt:message key="labels.forms.editform.title">
									<fmt:param value="${entity}" />
								</fmt:message>
							</c:if>
						</h4>
						
						
						
						<div class="toolbar">
                            <a href="addPartida" class="btn brn-success"> <i
								class="fa fa-plus"></i> <span class="hidden-480"> Agregar Partida </span>
							</a>
							
							 <a href="print" class="btn brn-success"> <i
								class="fa fa-print"></i> <span class="hidden-480">Imprimir</span>
							</a>
							
							 <a href="download" class="btn brn-success"> <i
								class="fa fa-download"></i> <span class="hidden-480">Exportar</span>
							</a>      
                        </div>
                        
                       <div class="row">

								<div class="col-md-3">
									<div class="form-group">
										<label><fmt:message key="gastos.estadoSolicitud" />:
										</label>
										<div style="color: red;" >Nueva</div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
										<label><fmt:message key="gastos.fechaCreacion" />:
										</label>
										<div style="color: red;" id="fechaA"></div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
										<label><fmt:message key="gastos.folio" />:
										</label>
										<div></div>
									</div>
								</div>
					</div>			
                        
						<small><fmt:message key="labels.forms.hint.requiredfields" /></small>


						<form:form id="add" action="save" method="POST"
							modelAttribute="gasto" usuario="form">




							<div class="form-body">
								<!-- Mensaje de error, validación backend -->
								<spring:hasBindErrors name="gasto">
									<div class="alert alert-danger" style="display: block;">
										<button class="close" data-close="alert"></button>
										<fmt:message key="error.form.globalmessage" />
									</div>
								</spring:hasBindErrors>

								<div class="row">
								
								
								<spring:bind path="gasto.empresa">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="gastos.empresa" /> *</label>
												<form:select path="empresa" required="true" multiple="false"
													class="select2-container form-control select2me">
													<form:option value="NONE">Seleccione...</form:option>
													<form:options itemValue="id" itemLabel="nombre"
														items="${empresas}" />
												</form:select>
												<form:errors path="empresa" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
								

									

									<spring:bind path="gasto.importe">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="gastos.importe" /> *</label>

												<form:input path="importe" required="true" type="number"
													class="form-control input"
													readonly="${empty usuario.id?'false':'true'}" />
												<form:errors path="importe" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
									
							<spring:bind path="gasto.descripcion">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="gastos.descripcion"/>*</label>									
									<form:input path="descripcion" maxlength="80" required="true" type="text" class="form-control input upper" />					
									<form:errors path="descripcion" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>

									

								</div>





								<div class="row">
								
								<spring:bind path="gasto.proveedor">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="gastos.proveedor" /> *</label>
												<form:select path="proveedor" required="true" multiple="false"
													class="select2-container form-control select2me">
													<form:option value="NONE">Seleccione...</form:option>
													<form:options itemValue="id" itemLabel="nombre"
														items="${proveedores}" />
												</form:select>
												<form:errors path="proveedor" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
								
								
								<spring:bind path="gasto.moneda">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="gastos.moneda" /> *</label>
												<form:select path="moneda" required="true" multiple="false"
													class="select2-container form-control select2me">
													<form:option value="NONE">Seleccione...</form:option>
													<form:options itemValue="id" itemLabel="claveMoneda"
														items="${monedas}" />
												</form:select>
												<form:errors path="moneda" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
									
									
							<spring:bind path="gasto.anexos">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="gastos.anexos"/>*</label>									
									<form:input path="anexos"  required="true" type="text" class="form-control input upper" />					
									<form:errors path="anexos" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
									
								
								</div>

								<div class="row">
								
								<spring:bind path="gasto.justificacion">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="gastos.justificacion"/>*</label>									
									<form:input path="justificacion" maxlength="80" required="true" type="text" class="form-control input upper" />					
									<form:errors path="justificacion" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
								
								
						  <spring:bind path="gasto.anio">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="gastos.anio"/>*</label>									
									<form:input  path="anio" maxlength="80" required="true" type="text" class="form-control input upper" disabled="" readonly="true" />					
									<form:errors path="anio" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="gasto.mes">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="gastos.mes"/>*</label>									
									<form:input  path="mes" maxlength="80" required="true" type="text" class="form-control input upper"  disabled="" readonly="true"/>					
									<form:errors path="mes" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
								
								</div>







							</div>
							




       <table id="tableSolicitudesGastosPartidas" class="table table-striped table-no-bordered table-hover">
							<thead>
								<tr>
									<th>Seleccionar</th>
									<th>No.Partida</th>
									<th>Cuenta</th>
									<th>Descripcion</th>
									<th>Cantidad</th>
									<th>Unidad</th>
									<th>P.U.</th>
									<th>Importe</th>
									<th>Tasa IVA</th>
									<th>Total</th>
									<th>Acciones</th>

								</tr>
							</thead>
							<tbody>
								
									<tr>

										<td>*</td>
										<td><!--<a href="edit?id=${r.id}">${r.id}</a>--> <a>1</a></td>
										<td>1234-5678-9023-4353</td>
										<td>Toner Impresora</td>
										<td>5</td>
										<td>Pz.</td>
										<td>$1,300.00</td>
										<td>$6,500.00</td>
										<td>16%</td>
										<td>$7,540.00</td>
										<td><a href="#" onclick=""><i
												class="fa fa-trash-o"></i></a></td>
									</tr>
							
							</tbody>

						</table>							
							
							<h4 class="form-section">Datos Informativos</h4>
							<div class="row">

								<div class="col-md-3">
									<div class="form-group">
										<label><fmt:message key="catalogos.general.fechaAlta" />:
										</label>
										<div>
											<fmt:formatDate value="${usuario.fechaAlta}"
												pattern="yyyy/MM/dd HH:mm:ss" />
										</div>
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label><fmt:message
												key="catalogos.general.usuarioAlta" />: </label>
										<div>
											<c:out value="${usuario.usuarioAlta}" />
										</div>
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label><fmt:message
												key="catalogos.general.fechaModifica" />: </label>
										<div>
											<fmt:formatDate value="${usuario.fechaModifica}"
												pattern="yyyy/MM/dd HH:mm:ss" />
										</div>
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label><fmt:message
												key="catalogos.general.usuarioModifica" />: </label>
										<div>
											<c:out value="${usuario.usuarioModifica}" />
										</div>
									</div>
								</div>
							</div>
							
							<div class="form-actions">
								<button type="submit" class="btn btn-success">
									<fmt:message key="labels.buttons.save" />
								</button>
								<a id="cancelar" href="<c:url value="/gastos/"/>"
									type="button" class="btn btn-default"><fmt:message
										key="labels.buttons.cancel" /></a>
							<a  href="#" type="button" class="btn btn-info">Guardar Borrador</a>			
							</div>

							<form:hidden path="id" />
						</form:form>





					</div>
				</div>
			</div>



		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="ready"> 
	
	var fechaActual= new Date ();
	
	$('#fechaA').html('<p>'+fechaActual.getDate()+'/'+(fechaActual.getMonth()+1)+'/'+fechaActual.getFullYear()+'</p>');
	
	
	
	
	
	$('#tableSolicitudesGastosPartidas').DataTable({
	
	 "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        }
	
	});
	
	$('#add').validate({
		 lang: 'es',
       submitHandler: function(form) {
          guardar(form);
        }
	});
	
	$('#cancelar').click(function(e) {
      e.preventDefault(); // Prevent the href from redirecting directly
      var linkURL = $(this).attr("href");
      cancelar(linkURL);
    });
	

	
	
	</tiles:putAttribute>

</tiles:insertDefinition>