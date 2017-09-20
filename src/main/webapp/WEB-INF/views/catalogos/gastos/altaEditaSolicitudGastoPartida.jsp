<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:insertDefinition name="defaultTemplate">
	<fmt:message key="partidas" var="entity" />

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
                            <a href="#" class="btn brn-success"> <i
								class="fa fa-plus"></i> <span class="hidden-480"> Agregar Partida </span>
							</a>     
                        </div>
                        
                    	<small><fmt:message key="labels.forms.hint.requiredfields" /></small>


						<form:form id="add" action="save" method="POST"
							modelAttribute="partida" usuario="form">




							<div class="form-body">
								<!-- Mensaje de error, validación backend -->
								<spring:hasBindErrors name="partida">
									<div class="alert alert-danger" style="display: block;">
										<button class="close" data-close="alert"></button>
										<fmt:message key="error.form.globalmessage" />
									</div>
								</spring:hasBindErrors>

								<div class="row">
								
								
								<spring:bind path="partida.idClavePresupuestaria">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="partidas.cuenta" /> *</label>
												<form:select path="idClavePresupuestaria" required="true" multiple="false"
													class="select2-container form-control select2me">
													<form:option value="NONE">Seleccione...</form:option>
												</form:select>
												<form:errors path="idClavePresupuestaria" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
								

									

									<spring:bind path="partida.presupuesto.pptoDisponible">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="partidas.disponible" /> *</label>

												<form:input path="presupuesto.pptoDisponible" required="true" type="number"
													class="form-control input upper"
													readonly="${empty usuario.id?'false':'true'}" />
												<form:errors path="presupuesto.pptoDisponible" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
									
							<spring:bind path="partida.autorizante">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.autorizante"/>*</label>									
									<form:input path="autorizante" maxlength="80" required="true" type="text" class="form-control input upper" />					
									<form:errors path="autorizante" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>


                          
									

								</div>





								<div class="row">
								
							  <spring:bind path="partida.descripcion">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.descripcion"/>*</label>									
									<form:input path="descripcion" maxlength="80" required="true" type="text" class="form-control input upper" />					
									<form:errors path="descripcion" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
                            
							<spring:bind path="partida.cantidad">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.cantidad"/>*</label>									
									<form:input path="cantidad"  required="true" type="number" class="form-control input upper" />					
									<form:errors path="cantidad" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
									
									
							<spring:bind path="partida.unidad">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.unidad"/>*</label>									
									<form:input path="unidad"  required="true" type="text" class="form-control input upper" />					
									<form:errors path="unidad" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>		
								
								
								
							
								</div>

								<div class="row">
								
								
								<spring:bind path="partida.precioUnitario">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.precio"/>*</label>									
									<form:input path="precioUnitario"  required="true" type="number" class="form-control input upper" />					
									<form:errors path="precioUnitario" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>	
							
							
							<spring:bind path="partida.importe">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.importe"/>*</label>									
									<form:input path="importe"  required="true" type="number" class="form-control input upper" />					
									<form:errors path="importe" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>	
								<spring:bind path="partida.ivaAplicable">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.iva"/> *</label>									
									<form:select path="ivaAplicable" required="true" multiple="false" class="select2-container form-control select2me">
									<form:option value="NONE">Seleccione...</form:option>
									<form:option value="16">16%</form:option>
									
								</form:select>															
								<form:errors path="ivaAplicable" class="help-block"></form:errors>			
									</div>
								</div>
							</spring:bind>
							
							
							<spring:bind path="partida.anexos">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="partidas.anexos"/>*</label>									
									<form:input path="anexos"  required="true" type="text" class="form-control input upper" />					
									<form:errors path="anexos" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>	
								
								</div>







							</div>
							




       <table id="tableSolicitudesGastosXPartidas" class="table table-striped table-no-bordered table-hover">
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
							
							
							<div class="form-actions">
								<button type="submit" class="btn btn-success">
									<fmt:message key="labels.buttons.save" />
								</button>
								<a id="cancelar" href="<c:url value="/gastos/"/>"
									type="button" class="btn btn-default"><fmt:message
										key="labels.buttons.cancel" /></a>			
							</div>

							<form:hidden path="id" />
						</form:form>





					</div>
				</div>
			</div>



		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="ready"> 
	$('#presupuesto.pptoDisponible').val("");
	
	$.getJSON("getCuentasPresupuestales", {
				vo:""
				}, function(cuentas) {				
				var origenSelect = $("#idClavePresupuestaria");
				
				$('#idClavePresupuestaria option').remove();
				
				 $("#idClavePresupuestaria").append($('<option>Seleccione....</option>'));	
				
				for(var i =0; i < cuentas.length; i++){
					var option = $('<option/>');
					option.attr({
						'value' : cuentas[i].id
					}).text(cuentas[i].cuenta);
					origenSelect.append(option);
					
					
							
				}
				
			
				
			});	
	
	
	$('#tableSolicitudesGastosXPartidas').DataTable({
	
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