<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:insertDefinition name="defaultTemplate">
	<fmt:message key="reasignacion" var="entity" />

	<tiles:putAttribute name="title">Solicitudes de Reasignacion Presupuestal</tiles:putAttribute>






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
							<c:if test="${empty solicitud.id}">
								<fmt:message key="labels.forms.newform.title">
									<fmt:param value="${entity}" />
								</fmt:message>
							</c:if>

						</h4>
						<small><fmt:message key="labels.forms.hint.requiredfields" /></small>


						<form:form id="add" action="save" method="POST"
							modelAttribute="solicitud">

							<div class="form-body">
								<!-- Mensaje de error, validación backend -->
								<spring:hasBindErrors name="solicitud">
									<div class="alert alert-danger" style="display: block;">
										<button class="close" data-close="alert"></button>
										<fmt:message key="error.form.globalmessage" />
									</div>
								</spring:hasBindErrors>

								<div class="row">
									<spring:bind path="solicitud.solicitud.empresaGrupo">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="presupuesto.reasignacion.empresa" /> *</label>
												<form:select path="solicitud.empresaGrupo" required="true"
													class="select2-container form-control select2me"
													multiple="false">
													<form:option value="NONE">Seleccione....</form:option>
													<form:options items="${empresas}" itemLabel="nombre"
														itemValue="id" />
												</form:select>
												<form:errors path="solicitud.empresaGrupo"
													class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>



									<spring:bind path="solicitud.clavePresupuestariaOrigen.id">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="presupuesto.reasignacion.idClavePresupuestariaOrigen" />
													*</label>
												<form:select path="id" required="true"
													title="Selecciona Cuenta Origen"
													class="select2-container form-control select2me"
													multiple="false">
													<form:option value="0">Seleccione....</form:option>
												</form:select>
												<form:errors path="id" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="solicitud.solicitud.motivo">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="presupuesto.reasignacion.descripcion" /> *</label>
												<form:input path="solicitud.motivo" maxlength="15"
													required="true" type="text" disabled=""
													class="form-control input" readonly="true" />
												<form:errors path="solicitud.motivo" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>

								</div>



								<div class="row"></div>







								<table class="table table-striped table-no-bordered table-hover">

									<thead>
										<tr>
											<th></th>
											<th>Ene</th>
											<th>Feb</th>
											<th>Mar</th>
											<th>Abr</th>
											<th>May</th>
											<th>Jun</th>
											<th>Jul</th>
											<th>Ago</th>
											<th>Sep</th>
											<th>Oct</th>
											<th>Nov</th>
											<th>Dic</th>
											<th>Total</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td>Presupuesto Disponible</td>
											<td><input id="pptoDisponibleMes1" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes2" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes3" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes4" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes5" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes6" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes7" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes8" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes9" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes10" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes11" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleMes12" type="number"
												class="form-control" readonly="readonly"></td>
											<td><input id="pptoDisponibleTotal" type="number"
												class="form-control" readonly="readonly"></td>
										</tr>




									</tbody>
								</table>
								<div class="row">
									<spring:bind path="solicitud.clavePresupuestariaDestino.id">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="presupuesto.reasignacion.idClavePresupuestariaDestino" />
													*</label>
												<form:select path="id" required="true"
													title="Selecciona Cuenta Origen"
													class="select2-container form-control select2me"
													multiple="false">
													<form:option value="0">Seleccione....</form:option>
												</form:select>
												<form:errors path="id" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="solicitud.solicitud.motivo">
										<div class="col-md-4">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label class="control-label"><fmt:message
														key="presupuesto.reasignacion.descripcion" /> *</label>
												<form:input path="solicitud.motivo" maxlength="15"
													required="true" type="text" class="form-control input"
													disabled="disabled" readonly="true" />
												<form:errors path="solicitud.motivo" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
								</div>


								<table class="table table-striped table-no-bordered table-hover">

									<thead>
										<tr>
											<th></th>
											<th>Ene</th>
											<th>Feb</th>
											<th>Mar</th>
											<th>Abr</th>
											<th>May</th>
											<th>Jun</th>
											<th>Jul</th>
											<th>Ago</th>
											<th>Sep</th>
											<th>Oct</th>
											<th>Nov</th>
											<th>Dic</th>
											<th>Total</th>
										</tr>
									</thead>

									<tbody>

										<tr>
											<td>Presupuesto a Reasignar</td>
											<td><form:input path="pptoDestino.mes1" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes2" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes3" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes4" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes5" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes6" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes7" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes8" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes9" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes10" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes11" type="number"
													class="form-control pptoDest" /></td>
											<td><form:input path="pptoDestino.mes12" type="number"
													class="form-control pptoDest" /></td>
											<td><input id="pptoDestinoTotal" type="text"
												class="form-control" readonly="readonly"></td>
										</tr>


									</tbody>
								</table>






								<div class="row">
									<spring:bind path="solicitud.solicitud.motivo">
										<div class="col-md-12">
											<div
												class="form-group label-floating ${status.error ? 'has-error' : ''}">
												<label id="justificacion" class="control-label"><fmt:message
														key="presupuesto.reasignacion.justificacion" /> *</label>
												<form:textarea path="solicitud.motivo" required="true"
													maxlength="300" rows="2" class="form-control" />
												<form:errors path="solicitud.motivo" class="help-block"></form:errors>
											</div>
										</div>
									</spring:bind>
								</div>

							</div>


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
								<a id="cancelar" href="<c:url value="/reasignacion/"/>"
									type="button" class="btn btn-default"><fmt:message
										key="labels.buttons.cancel" /></a>
							</div>
						</form:form>





					</div>
				</div>
			</div>



		</div>
	</tiles:putAttribute>



	<tiles:putAttribute name="functions"> 
		
		function sumaPptoDestino(){
			var total = 0.0;
			
			total += parseFloat($("#pptoDestino\\.mes1").val());
			total += parseFloat($("#pptoDestino\\.mes2").val());
			total += parseFloat($("#pptoDestino\\.mes3").val());
			total += parseFloat($("#pptoDestino\\.mes4").val());
			total += parseFloat($("#pptoDestino\\.mes5").val());
			total += parseFloat($("#pptoDestino\\.mes6").val());
			total += parseFloat($("#pptoDestino\\.mes7").val());
			total += parseFloat($("#pptoDestino\\.mes8").val());
			total += parseFloat($("#pptoDestino\\.mes9").val());
			total += parseFloat($("#pptoDestino\\.mes10").val());
			total += parseFloat($("#pptoDestino\\.mes11").val());
			total += parseFloat($("#pptoDestino\\.mes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoDestinoTotal").val(total);
		}
		
		function sumaPptoDisponible(){
			var total = 0.0;
			
			total += parseFloat($("#pptoDisponibleMes1").val());
			total += parseFloat($("#pptoDisponibleMes2").val());
			total += parseFloat($("#pptoDisponibleMes3").val());
			total += parseFloat($("#pptoDisponibleMes4").val());
			total += parseFloat($("#pptoDisponibleMes5").val());
			total += parseFloat($("#pptoDisponibleMes6").val());
			total += parseFloat($("#pptoDisponibleMes7").val());
			total += parseFloat($("#pptoDisponibleMes8").val());
			total += parseFloat($("#pptoDisponibleMes9").val());
			total += parseFloat($("#pptoDisponibleMes10").val());
			total += parseFloat($("#pptoDisponibleMes11").val());
			total += parseFloat($("#pptoDisponibleMes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoDisponibleTotal").val(total);
		}
		
		function getCuentas(empresa, anio){
			
			
			$.getJSON("getCuentas", {
				idEmpresa : empresa,
				anio : anio	
			}, function(cuentas) {				
				var origenSelect = $("#idClavePresupuestariaOrigen");
				var destinoSelect = $("#idClavePresupuestariaDestino");
				
				$('#idClavePresupuestariaOrigen option').remove();	
				$('#idClavePresupuestariaDestino option').remove();	
				

				for(var i =0; i < cuentas.length; i++){
					var option = $('<option />');
					option.attr({
						'value' : cuentas[i].id
					}).text(cuentas[i].cuenta+" - "+cuentas[i].descripcion);
					origenSelect.append(option);
					
					
					var option2 = $('<option />');
					option2.attr({
						'value' : cuentas[i].id
					}).text(cuentas[i].cuenta+" - "+cuentas[i].descripcion);
					destinoSelect.append(option2);				
				}
				
				$('#idClavePresupuestariaOrigen').selectpicker('refresh');
				$('#idClavePresupuestariaDestino').selectpicker('refresh');	
				
			});	
		
			
		}
		
		function validaMonto(){
			var disponibleTotal = $("#pptoDisponibleTotal");
			var destinoTotal = $("#pptoDestinoTotal");
			var mensaje="";
			
			if(disponibleTotal.val() == ""){
				mensaje += "Favor de capturar una cuenta Origen que tenga presupuesto.<br>";
			}
			
			if(destinoTotal.val() == ""){
				mensaje += "Favor de especificar el presupuesto a reasignar.<br>";
			}
			
			if(destinoTotal.val() > disponibleTotal.val()){
				mensaje += "El presupuesto a reasignar es mayor que el presupuesto disponible. Favor de ajustar.<br>";
			}
			//alert(mensaje);
			return mensaje;
		}
		
		
	</tiles:putAttribute>

	<tiles:putAttribute name="ready"> 
	
	
	var d = new Date();
	var n = d.getMonth();
	
	for(var i=0; i < n; i++){
		$("#pptoDestino\\.mes"+(i+1)).prop('readonly', true);
	}
	
	
	$('#add').validate({
		 lang: 'es',
       submitHandler: function(form) {
       	  //Validaciones
       	  var mensaje = validaMonto();  
       	  
       	  if(mensaje.length > 0){
       	  	mensajeInfo(mensaje);
       	  	return false;
       	  }else{
       	  	guardar(form);
       	  }
          
        }
	});
	
	$('#cancelar').click(function(e) {
      e.preventDefault(); // Prevent the href from redirecting directly
      var linkURL = $(this).attr("href");
      cancelar(linkURL);
    });
	
	var clave = $("#idClavePresupuestariaOrigen");
	clave.change(function(event){
		$.getJSON("getPresupuestoDeCuenta", {
			idClave : clave.val()
		}, function(presupuesto) {			
			
			for(var i =0; i < presupuesto.length; i++){
				if(presupuesto[i].mes == (i+1)){
					$("#pptoDisponibleMes"+(i+1)).val(presupuesto[i].pptoDisponible);
				}
			}
			sumaPptoDisponible();
		
		});
	});
	
	
	
	var empresa = $("#empresa");
	var anio = $("#anio");
	
	empresa.change(function(event){		
		//alert(empresa.val()+" - "+anio.val());	
		if(empresa.val() != "" && anio.val() != ""){
			getCuentas(empresa.val(), anio.val());
		}		
	});
	
	anio.change(function(event){
		//alert(empresa.val()+" - "+anio.val());			
		if(empresa.val() != "" && anio.val() != ""){
			getCuentas(empresa.val(), anio.val());
		}		
	});
	



	$(".pptoDest").change(function(){
		sumaPptoDestino();
	});
	

	</tiles:putAttribute>





</tiles:insertDefinition>