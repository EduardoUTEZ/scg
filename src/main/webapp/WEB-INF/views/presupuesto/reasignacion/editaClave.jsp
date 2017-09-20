<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="defaultTemplate">
<fmt:message key="clave" var="entity"/> 

	<tiles:putAttribute name="title">${entity}</tiles:putAttribute>

	<tiles:putAttribute name="body">		
		<div class="row">	
		
		<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">code</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">
						<c:if test="${empty clave.id}"><fmt:message key="labels.forms.newform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						<c:if test="${not empty clave.id}"><fmt:message key="labels.forms.editform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						</h4>
						<small><fmt:message key="labels.forms.hint.requiredfields"/></small>
						
						
						<form:form id="add" action="save" method="POST" modelAttribute="clave" clave="form" >
						
						<div class="form-body">
							<!-- Mensaje de error, validación backend -->
							<spring:hasBindErrors name="clave">							
							<div class="alert alert-danger" style="display: block;"><button class="close" data-close="alert"></button><fmt:message key="error.form.globalmessage"/></div>
							</spring:hasBindErrors>
							
							<div class="row">
							<spring:bind path="clave.empresa">
								<div class="col-md-4">
								<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
									<label class="control-label"><fmt:message key="presupuesto.clave.empresa"/> *</label>
										<div><c:out value="${clave.empresa.nombre}"/></div>
										<form:hidden path="empresa"/>													
										<form:errors path="empresa" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	
							
							<spring:bind path="clave.anio">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
										<label class="control-label"><fmt:message key="presupuesto.clave.anio" /> *</label>
										<div><c:out value="${clave.anio}"/></div>
										<form:hidden path="anio"/>					
										<form:errors path="anio" class="help-block"></form:errors>
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="clave.version">
								<div class="col-md-3">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
										<label class="control-label"><fmt:message key="presupuesto.clave.version" /> *</label>
										<div><c:out value="${clave.version}"/></div>
										<form:hidden path="version"/>					
										<form:errors path="version" class="help-block"></form:errors>
									</div>
								</div>
							</spring:bind>						
							
							
							
						</div>
							
							<h4>Cuenta Presupuestal</h4>
							<div class="row">
							<spring:bind path="clave.nivel1">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel1Label" class="control-label">-</label>									
									<form:input path="nivel1" maxlength="10" type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel1" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel2">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel2Label" class="control-label">-</label>									
									<form:input path="nivel2" maxlength="10" type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel2" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel3">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel3Label" class="control-label">-</label>									
									<form:input path="nivel3" maxlength="10"  type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel3" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel4">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel4Label" class="control-label">-</label>									
									<form:input path="nivel4" maxlength="10"  type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel4" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel5">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel5Label" class="control-label">-</label>									
									<form:input path="nivel5" maxlength="10" type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel5" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							</div>
							<div class="row">
							<spring:bind path="clave.nivel6">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel6Label" class="control-label">-</label>									
									<form:input path="nivel6" maxlength="10" type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel6" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel7">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel7Label" class="control-label">-</label>									
									<form:input path="nivel7" maxlength="10" type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel7" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel8">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel8Label" class="control-label">-</label>									
									<form:input path="nivel8" maxlength="10"  type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel8" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel9">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel9Label" class="control-label">-</label>									
									<form:input path="nivel9" maxlength="10" type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel9" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.nivel10">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label id="nivel10Label" class="control-label">-</label>									
									<form:input path="nivel10" maxlength="10"  type="text" class="form-control input upper" readonly="true"/>					
									<form:errors path="nivel10" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
						</div>
						<h4>Reglas de la Partida Presupuestal</h4>
						<div class="row">
							<spring:bind path="clave.descripcion">
								<div class="col-md-3">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label  class="control-label"><fmt:message key="presupuesto.clave.descripcion"/> *</label>									
									<form:input path="descripcion" maxlength="255" required="true" type="text" class="form-control input upper" />					
									<form:errors path="descripcion" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="clave.cuentaContable">
								<div class="col-md-3">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label  class="control-label"><fmt:message key="presupuesto.clave.cuentaContable"/> *</label>									
									<form:input path="cuentaContable" maxlength="50" required="true" type="text" class="form-control input upper"/>					
									<form:errors path="cuentaContable" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="clave.moneda">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
										<label class="control-label"><fmt:message key="presupuesto.clave.moneda" /> *</label>
										<div><c:out value="${clave.moneda.label}"/></div>
										<form:hidden path="moneda"/>
										<form:errors path="moneda" class="help-block"></form:errors>
									</div>
								</div>
							</spring:bind>
							
							
							<spring:bind path="clave.usuarioResponsable">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
										<label class="control-label"><fmt:message key="presupuesto.clave.usuarioResponsable" /> *</label>
										<form:select path="usuarioResponsable" required="true" 
											class="selectpicker"  data-style="select-with-transition"
											multiple="false" title="Selecciona Usuario Responsable" data-size="7">
											<form:options items="${usuarios}" itemLabel="nombre"
												itemValue="id" />
										</form:select>
										<form:errors path="usuarioResponsable" class="help-block"></form:errors>
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="clave.usuarioSuplente">
								<div class="col-md-2">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
										<label class="control-label"><fmt:message key="presupuesto.clave.usuarioSuplente" /> *</label>
										<form:select path="usuarioSuplente" required="true" 
											class="selectpicker" data-style="select-with-transition"
											multiple="false" title="Selecciona Usuario Suplente" data-size="7">
											<form:options items="${usuarios}" itemLabel="nombre"
												itemValue="id" />
										</form:select>
										<form:errors path="usuarioSuplente" class="help-block"></form:errors>
									</div>
								</div>
							</spring:bind>
							
							
						</div>
						
						
						<!--  Presupuesto -->
						
						<h4>Desglose del Presupuesto</h4>
								
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
							
							<td>Presupuesto Programado</td>
							
							<c:forEach items="${presupuesto}" var="ppto">
							<td><c:out value="${ppto.pptoProgramado}"></c:out> </td>
							</c:forEach>						
							</tr>
							
							
							<tr>
							<td>Presupuesto Comprometido</td>
							<c:forEach items="${presupuesto}" var="ppto">
							<td><c:out value="${ppto.pptoComprometido}"></c:out> </td>
							</c:forEach>									
							</tr>
							
							<tr>
							<td>Presupuesto Ejercido</td>
							<c:forEach items="${presupuesto}" var="ppto">
							<td><c:out value="${ppto.pptoEjercido}"></c:out> </td>
							</c:forEach>								
							</tr>
							
							<tr>
							<td>Presupuesto Disponible</td>
							<c:forEach items="${presupuesto}" var="ppto">
							<td><c:out value="${ppto.pptoDisponible}"></c:out> </td>
							</c:forEach>						
							</tr>
							
							
						</tbody>
						</table>
						

						
						
							
							<c:if test="${not empty clave.id}">
							
							<h4 class="form-section">Datos Informativos </h4>
							<div class="row">
								
								<div class="col-md-3">
									<div class="form-group">
									<label ><fmt:message key="catalogos.general.fechaAlta"/>: </label>									
									<div ><fmt:formatDate value="${clave.fechaAlta}" pattern="yyyy/MM/dd HH:mm:ss"/> </div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
									<label><fmt:message key="catalogos.general.usuarioAlta"/>: </label>									
									<div><c:out value="${clave.usuarioAlta}"/></div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
									<label><fmt:message key="catalogos.general.fechaModifica"/>: </label>									
									<div ><fmt:formatDate value="${clave.fechaModifica}" pattern="yyyy/MM/dd HH:mm:ss"/> </div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
									<label><fmt:message key="catalogos.general.usuarioModifica"/>: </label>									
									<div><c:out value="${clave.usuarioModifica}"/></div>
									</div>
								</div>				
							</div>
							</c:if>
							
													
						</div>
						<div class="form-actions">
							<button type="submit" class="btn btn-success"><fmt:message key="labels.buttons.save"/></button>									
							<a id="cancelar" href="<c:url value="/partidas/"/>" type="button" class="btn btn-default"><fmt:message key="labels.buttons.cancel"/></a>
						</div>
						
						<form:hidden path="id"/>
						<form:hidden path="fechaAlta"/>
						<form:hidden path="usuarioAlta"/>
					</form:form>
						
						
						
						
						
                   	</div>
               	</div>
        </div>
		
		
		
	</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="functions"> 
		function presupuestoDisponible(){
			$("#pptoDisponibleMes1").val($("#pptoProgramado\\.mes1").val() - $("#pptoComprometido\\.mes1").val()- $("#pptoEjercido\\.mes1").val());
			$("#pptoDisponibleMes2").val($("#pptoProgramado\\.mes2").val() - $("#pptoComprometido\\.mes2").val()- $("#pptoEjercido\\.mes2").val());
			$("#pptoDisponibleMes3").val($("#pptoProgramado\\.mes3").val() - $("#pptoComprometido\\.mes3").val()- $("#pptoEjercido\\.mes3").val());
			$("#pptoDisponibleMes4").val($("#pptoProgramado\\.mes4").val() - $("#pptoComprometido\\.mes4").val()- $("#pptoEjercido\\.mes4").val());
			$("#pptoDisponibleMes5").val($("#pptoProgramado\\.mes5").val() - $("#pptoComprometido\\.mes5").val()- $("#pptoEjercido\\.mes5").val());
			$("#pptoDisponibleMes6").val($("#pptoProgramado\\.mes6").val() - $("#pptoComprometido\\.mes6").val()- $("#pptoEjercido\\.mes6").val());
			$("#pptoDisponibleMes7").val($("#pptoProgramado\\.mes7").val() - $("#pptoComprometido\\.mes7").val()- $("#pptoEjercido\\.mes7").val());
			$("#pptoDisponibleMes8").val($("#pptoProgramado\\.mes8").val() - $("#pptoComprometido\\.mes8").val()- $("#pptoEjercido\\.mes8").val());
			$("#pptoDisponibleMes9").val($("#pptoProgramado\\.mes9").val() - $("#pptoComprometido\\.mes9").val()- $("#pptoEjercido\\.mes9").val());
			$("#pptoDisponibleMes10").val($("#pptoProgramado\\.mes10").val() - $("#pptoComprometido\\.mes10").val()- $("#pptoEjercido\\.mes10").val());
			$("#pptoDisponibleMes11").val($("#pptoProgramado\\.mes11").val() - $("#pptoComprometido\\.mes11").val()- $("#pptoEjercido\\.mes11").val());
			$("#pptoDisponibleMes12").val($("#pptoProgramado\\.mes12").val() - $("#pptoComprometido\\.mes12").val()- $("#pptoEjercido\\.mes12").val());
			
			sumaPptoDisponible();
		}
		function sumaPptoProgramado(){
			var total = 0.0;
			
			total += parseFloat($("#pptoProgramado\\.mes1").val());
			total += parseFloat($("#pptoProgramado\\.mes2").val());
			total += parseFloat($("#pptoProgramado\\.mes3").val());
			total += parseFloat($("#pptoProgramado\\.mes4").val());
			total += parseFloat($("#pptoProgramado\\.mes5").val());
			total += parseFloat($("#pptoProgramado\\.mes6").val());
			total += parseFloat($("#pptoProgramado\\.mes7").val());
			total += parseFloat($("#pptoProgramado\\.mes8").val());
			total += parseFloat($("#pptoProgramado\\.mes9").val());
			total += parseFloat($("#pptoProgramado\\.mes10").val());
			total += parseFloat($("#pptoProgramado\\.mes11").val());
			total += parseFloat($("#pptoProgramado\\.mes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoProgramadoTotal").val(total);
		}
		
		function sumaPptoComprometido(){
			var total = 0.0;
			
			total += parseFloat($("#pptoComprometido\\.mes1").val());
			total += parseFloat($("#pptoComprometido\\.mes2").val());
			total += parseFloat($("#pptoComprometido\\.mes3").val());
			total += parseFloat($("#pptoComprometido\\.mes4").val());
			total += parseFloat($("#pptoComprometido\\.mes5").val());
			total += parseFloat($("#pptoComprometido\\.mes6").val());
			total += parseFloat($("#pptoComprometido\\.mes7").val());
			total += parseFloat($("#pptoComprometido\\.mes8").val());
			total += parseFloat($("#pptoComprometido\\.mes9").val());
			total += parseFloat($("#pptoComprometido\\.mes10").val());
			total += parseFloat($("#pptoComprometido\\.mes11").val());
			total += parseFloat($("#pptoComprometido\\.mes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoComprometidoTotal").val(total);
		}
		
		function sumaPptoEjercido(){
			var total = 0.0;
			
			total += parseFloat($("#pptoEjercido\\.mes1").val());
			total += parseFloat($("#pptoEjercido\\.mes2").val());
			total += parseFloat($("#pptoEjercido\\.mes3").val());
			total += parseFloat($("#pptoEjercido\\.mes4").val());
			total += parseFloat($("#pptoEjercido\\.mes5").val());
			total += parseFloat($("#pptoEjercido\\.mes6").val());
			total += parseFloat($("#pptoEjercido\\.mes7").val());
			total += parseFloat($("#pptoEjercido\\.mes8").val());
			total += parseFloat($("#pptoEjercido\\.mes9").val());
			total += parseFloat($("#pptoEjercido\\.mes10").val());
			total += parseFloat($("#pptoEjercido\\.mes11").val());
			total += parseFloat($("#pptoEjercido\\.mes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoEjercidoTotal").val(total);
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
		
		
	</tiles:putAttribute>
		
	<tiles:putAttribute name="ready"> 
	$('#presupuesto_op').addClass("active ");
	$('#presupuesto').addClass("collapse in");
	
	$('#partidas_op').addClass("active");
	
	
	
	
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
	
	var empresa = $("#empresa");		
	$.getJSON("getNombreNivel", {
		idEmpresa : empresa.val()	
	}, function(nn) {				
		$("#nivel1Label").text(nn.nivel1);	
		$("#nivel2Label").text(nn.nivel2);	
		$("#nivel3Label").text(nn.nivel3);	
		$("#nivel4Label").text(nn.nivel4);
		if(nn.nivel5 == ""){
			$("#nivel5").hide();
		}else{
			$("#nivel5Label").text(nn.nivel5);
		}	
		
		if(nn.nivel6 == ""){
			$("#nivel6").hide();
			$("#nivel6Label").text("");
		}else{
			$("#nivel6Label").text(nn.nivel6);
		}
		if(nn.nivel7 == ""){
			$("#nivel7").hide();
			$("#nivel7Label").text("");
		}else{
			$("#nivel7Label").text(nn.nivel7);
		}
		if(nn.nivel8 == ""){
			$("#nivel8").hide();
			$("#nivel8Label").text("");
		}else{
			$("#nivel8Label").text(nn.nivel8);
		}
		if(nn.nivel9 == ""){
			$("#nivel9").hide();
			$("#nivel9Label").text("");
		}else{
			$("#nivel9Label").text(nn.nivel9);
		}
		if(nn.nivel10 == ""){
			$("#nivel10").hide();
			$("#nivel10Label").text("");
		}else{
			$("#nivel10Label").text(nn.nivel10);
		}	
		
		
			
		$("#nivel7Label").text(nn.nivel7);	
		$("#nivel8Label").text(nn.nivel8);	
		$("#nivel9Label").text(nn.nivel9);	
		$("#nivel10Label").text(nn.nivel10);	
							
	});
		

	
	$("#distribuir").click(function(){
		var total = $("#pptoProgramadoTotal");
		if(total.val() != "" && total.val() > 0){
			var dist = total.val()/12;
			dist =  Math.floor(dist * 100) / 100;
			
			$("#pptoProgramado\\.mes1").val(dist);
			$("#pptoProgramado\\.mes2").val(dist);
			$("#pptoProgramado\\.mes3").val(dist);
			$("#pptoProgramado\\.mes4").val(dist);
			$("#pptoProgramado\\.mes5").val(dist);
			$("#pptoProgramado\\.mes6").val(dist);
			$("#pptoProgramado\\.mes7").val(dist);
			$("#pptoProgramado\\.mes8").val(dist);
			$("#pptoProgramado\\.mes9").val(dist);
			$("#pptoProgramado\\.mes10").val(dist);
			$("#pptoProgramado\\.mes11").val(dist);
			$("#pptoProgramado\\.mes12").val(dist);
			
			presupuestoDisponible();
		
		}
		
		//alert("Distribuir");
	});


	$(".pptoProg").change(function(){
		sumaPptoProgramado();
		presupuestoDisponible();	
	});
	
	$(".pptoComp").change(function(){
		sumaPptoComprometido();
		presupuestoDisponible();	
	});
	$(".pptoEjer").change(function(){
		sumaPptoEjercido();
		presupuestoDisponible();
	});
	
	
	</tiles:putAttribute>
	
	
	
	
	
</tiles:insertDefinition>