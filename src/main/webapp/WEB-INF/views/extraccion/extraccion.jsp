<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="styles">
		<link href="<c:url value='/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css'/>" rel="stylesheet" type="text/css"/>
		<link href="<c:url value='/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css'/>" rel="stylesheet" type="text/css"/>
		<link href="<c:url value='/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css'/>" rel="stylesheet" type="text/css"/>		
	</tiles:putAttribute>
	<tiles:putAttribute name="title">Extracción de Información</tiles:putAttribute>
	<tiles:putAttribute name="body">
	<%@include file="../secciones/messages.jsp" %>
	<div class="row">	
		<div class="col-md-10 col-md-offset-1">
																															
			<div class="portlet box green-haze">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-edit"></i> 
						
						<small>Utiliza los siguientes campos de filtrado para obtener una búsqueda más exacta.</small>
					</div>
					<div class="tools">
						<a href="" class="collapse"></a>
					</div>
				</div>
				
				<div class="portlet-body form">						
					<!-- <form busquedaAseg="form"> -->
					<form:form id="busquedaAsegEx" action="busquedaAsegEx" method="POST" modelAttribute="busquedaAseg"  >						
					
						
						<div class="form-body">
							<!-- Mensaje de error, validación backend -->
							<spring:hasBindErrors name="busquedaAseg">							
							<div class="alert alert-danger" style="display: block;"><button class="close" data-close="alert"></button><fmt:message key="error.form.globalmessage"/></div>
							</spring:hasBindErrors>
							
							
							<div class="form-actions">
							<div class="row">
							
							
							<spring:bind path="busquedaAseg.folioPoliza">
								<div class="col-md-2">
								<div class="form-group ${status.error ? 'has-error' : ''}">
								<label><fmt:message key="catalogos.asegurados.folioPoliza"/></label>
								<form:select path="folioPoliza" required="true" multiple="false" class="select2-container form-control select2me">
									<form:options items="${polizas}"/>
								</form:select>															
								<form:errors path="folioPoliza" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	
							
							<spring:bind path="busquedaAseg.certificado">
								<div class="col-md-2">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.certificado"/></label>									
									<form:input path="certificado" maxlength="10" type="text" class="form-control input upper" placeholder=""/>					
									<form:errors path="certificado" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="busquedaAseg.nombre">
								<div class="col-md-2">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.nombre"/></label>									
									<form:input path="nombre" maxlength="20"  type="text" class="form-control input upper" placeholder=""/>					
									<form:errors path="nombre" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="busquedaAseg.primerApellido">
								<div class="col-md-2">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.primerApellido"/></label>									
									<form:input path="primerApellido" maxlength="20"  type="text" class="form-control input upper" placeholder=""/>					
									<form:errors path="primerApellido" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
														
							
							<spring:bind path="busquedaAseg.estatus">
								<div class="col-md-2">
								<div class="form-group ${status.error ? 'has-error' : ''}">
								<label><fmt:message key="catalogos.asegurados.estatus"/></label>
								<form:select path="estatus"  multiple="false" class="select2-container form-control select2me">
									<form:options itemValue="id" itemLabel="nombre" items="${estados}"/>
								</form:select>															
								<form:errors path="estatus" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>
							
							<div class="col-md-2">
							<div class="form-group">	
							<label>Acciones</label>		
							<button type="submit" class="btn green form-control"><fmt:message key="labels.buttons.search"/></button>
							</div>	
							</div>	
							
						</div>									
						</div>						
					</form:form>
					
					
					<form:form id="extraeAseg" action="extraeAseg" method="GET" target="_blank" onsubmit="return valida();">	
					
					<c:if test="${not empty asegurados}">
					<div class="form-actions">
					<button type="submit" class="btn green">Extraer documentos</button>	
					</div>
					</c:if>
					
					
					
					<!-- Tabla de resultados de búsqeuda -->
				 
					<table id="tableAsegs"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th><input type="checkbox"  id="todos"></th>
									<th><fmt:message key="catalogos.asegurados.folioPoliza" /></th>
									<th><fmt:message key="catalogos.asegurados.certificado" /></th>
									<th><fmt:message key="catalogos.asegurados.nombre" /></th>
									<th><fmt:message key="catalogos.asegurados.primerApellido" /></th>
									<th><fmt:message key="catalogos.asegurados.fechaRegistro" /></th>
									<th><fmt:message key="catalogos.asegurados.estatus" /></th>
									
								</tr>
							</thead>
							<tbody>
                            <c:forEach var="aseg" items="${asegurados}"> 
                                 <tr>
                                 	<td><input type="checkbox" name="asegurados" value="${aseg.id}"></td> 
                                 	<td>${aseg.folioPoliza} </td> 
                                    <td><a href="asegurados/consulta?id=${aseg.id}"> <fmt:formatNumber type="number" pattern="0000000000" value="${aseg.certificado}"/></a> </td> 
                                    <td>${aseg.nombre} </td> 
                                    <td>${aseg.primerApellido} </td> 
                                    <td>${aseg.fechaRegistro} </td> 
                                    <td>${aseg.estatus.nombre} </td> 
                                    
                                 </tr> 
                             </c:forEach> 
							</tbody>

						</table>
						
						</form:form>
			
					<!-- Fin -->
				</div>
			</div>			

		</div>
	</div>
	
	
	
		
	</tiles:putAttribute>	
	
	<tiles:putAttribute name="scripts">
	<script src="<c:url value='/assets/global/plugins/bootstrap-select/bootstrap-select.min.js'/>"></script>
	<script src="<c:url value='/assets/global/plugins/select2/select2.min.js'/>"></script>
	<script src="<c:url value='/assets/global/plugins/jquery-multi-select/js/jquery.multi-select.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/global/plugins/datatables/media/js/jquery.dataTables.js'/>"></script>
		<script
			src="<c:url value='/assets/global/scripts/custom_table_managed.js'/>"
			type="text/javascript"></script>

		<script type="text/javascript"
			src="<c:url value='/assets/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/admin/pages/scripts/argostable.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/global/scripts/jquery.spring-friendly.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/admin/pages/scripts/ui-idletimeout.js'/>"></script>
	
	
	
	<script>
	function valida(){
		if($('input[name="asegurados"]:checked').length == 0){
			bootbox.alert("Favor de seleccionar por lo menos 1 documento para extraer");
			return false;
		}else{
			return true;
		}
	}
	</script>
	</tiles:putAttribute>
	
	
	<tiles:putAttribute name="ready">
	$('#asegurados').addClass("start active open");
	$('#tableAsegs').DataTable({
		searching: false
	});
	$('#todos').change(function() {
	    var checkboxes = $('[name="asegurados"]');
	    if($(this).is(':checked')) {
	        checkboxes.prop('checked', true);
	    } else {
	        checkboxes.prop('checked', false);
	    }
	    $.uniform.update();
	});
	

	</tiles:putAttribute>
	
</tiles:insertDefinition>