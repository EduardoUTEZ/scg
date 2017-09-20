<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="defaultTemplate">
	<fmt:message key="catalogos.asegurados" var="entity" />

	<tiles:putAttribute name="title">
		<fmt:message key="labels.forms.consulta.title">
			<fmt:param value="${entity}" />
		</fmt:message>
	</tiles:putAttribute>

	<!-- Menu de navegación -->
	<tiles:putAttribute name="nav">
		<li><a href='<c:url value="/"/>'>${entity}</a> <i
			class="fa fa-angle-right"></i></li>
	</tiles:putAttribute>


	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">

				<div class="portlet box green-haze">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-file-text-o"></i>
							<fmt:message key="labels.forms.consulta.title">
								<fmt:param value="${entity}" />
							</fmt:message>
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>

					<div class="portlet-body form">
						<!-- <form asegurado="form"> -->


						<div class="form-body">
						
	
							<h4>Detalle del Asegurado:</h4>
							<div class="row">
								<div class="col-md-4">
								</div>
								<div class="col-md-4">
								</div>
								<div class="col-md-4">
									
									<ul class="list-unstyled">								
									<li><strong><fmt:message key="catalogos.asegurados.folioPoliza" />: </strong><c:out value="${asegurado.folioPoliza}" /></li>
									<li><strong><fmt:message key="catalogos.asegurados.certificado" />: </strong><fmt:formatNumber pattern="0000000000" value="${asegurado.certificado}" /></li>
									<li><strong><fmt:message key="catalogos.asegurados.estatus" />: </strong><c:out value="${asegurado.estatus.nombre}" /></li>			
									</ul>

								</div>

							</div>

							
							<h4 class="form-section">Datos del Asegurado</h4>


							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label><fmt:message
												key="catalogos.asegurados.primerApellido" /></label>
										<div class="consulta">
											<c:out value="${asegurado.primerApellido}" />
										</div>
									</div>
								</div>



								<div class="col-md-4">
									<div class="form-group">
										<label><fmt:message
												key="catalogos.asegurados.segundoApellido" /></label>
										<div class="consulta">
											<c:out value="${asegurado.segundoApellido}" />
										</div>
									</div>
								</div>

								<div class="col-md-4">
									<div class="form-group">
										<label><fmt:message key="catalogos.asegurados.nombre" /></label>
										<div class="consulta">
											<c:out value="${asegurado.nombre}" />
										</div>
									</div>
								</div>
							</div>



							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label><fmt:message
												key="catalogos.asegurados.fechaNacimiento" /></label>
										<div class="consulta">
											<fmt:formatDate pattern="dd/MM/yyyy"
												value="${asegurado.fechaNacimiento}" />
										</div>
									</div>
								</div>



								<div class="col-md-4">
									<div class="form-group">
										<label><fmt:message key="catalogos.asegurados.edad" /></label>
										<div class="consulta">
											<c:out value="${asegurado.edad}" />
										</div>
									</div>
								</div>

								<div class="col-md-4">
									<div class="form-group">
										<label><fmt:message key="catalogos.asegurados.sexo" /></label>
										<div class="consulta">
											<c:if test="${asegurado.sexo == 1}">MASCULINO</c:if>
											<c:if test="${asegurado.sexo == 2}">FEMENINO</c:if>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label><fmt:message key="catalogos.asegurados.estadoCivil" /></label>
										<div class="consulta">
											<c:if test="${asegurado.estadoCivil == 1}">SOLTERO</c:if>
											<c:if test="${asegurado.estadoCivil == 2}">CASADO</c:if>
										</div>
									</div>
								</div>
							</div>
							
							<h4 class="form-section">Designación de Beneficiarios</h4>
							
							
							
							<table id="tableBenef"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
								
									<th><fmt:message key="catalogos.beneficiarios.nombre" /></th>
									<th><fmt:message key="catalogos.beneficiarios.primerApellido" /></th>
									<th><fmt:message key="catalogos.beneficiarios.segundoApellido" /></th>
									<th><fmt:message key="catalogos.beneficiarios.parentesco" /></th>
									<th><fmt:message key="catalogos.beneficiarios.porcentaje" /></th>	
									
								</tr>
							</thead>
							<tbody>
                            <c:forEach var="ben" items="${beneficiarios}"> 
                                 <tr>
                                 	<td><c:out value="${ben.nombre}"/></td>
                                 	<td><c:out value="${ben.primerApellido}"/></td>
                                 	<td><c:out value="${ben.segundoApellido}"/></td>
                                 	<td><c:out value="${ben.parentesco}"/></td>
                                 	<td><c:out value="${ben.porcentaje}"/></td>   
                                 </tr> 
                             </c:forEach> 
							</tbody>

						</table>
							



						</div>
						<div class="form-actions">
						
											
							<form:form id="imprimeInd" action="../imprimeInd" method="GET" target="_blank">								
							<input type="hidden" name="id" id="id" value="${asegurado.id}"/>
							<input type="hidden" name="tipo" id="tipo"/>
							</form:form>
							
							<sec:authorize access="hasRole('IMPRIME')">	
							<button onclick='$("#modalForm").modal("show");' class="btn blue"> Imprimir</button>
							</sec:authorize>
							
							<sec:authorize access="hasRole('EDITA_INFORMACION')">	
							<c:if test="${asegurado.estatus.id == 6 || asegurado.estatus.id==2}">	
							<a href="<c:url value="/asegurados/edit?id=${asegurado.id}"/>" type="button"
								class="btn green">Actualizar</a>	
							</c:if>
							</sec:authorize>
							
							<sec:authorize access="hasRole('CONFIRMA_REGISTRO')">
							<c:if test="${asegurado.estatus.id==2}">	
							<a href="<c:url value="/asegurados/aprueba?id=${asegurado.id}"/>" type="button"
								class="btn green">Aprobar</a>	
							</c:if>
							</sec:authorize>
							<sec:authorize access="hasRole('BORRA_ASEGURADO')">	
							<c:if test="${asegurado.estatus.id == 6}">
							<a href="<c:url value="/asegurados/borrar?id=${asegurado.id}"/>" type="button"
								class="btn red" >Borrar</a>
							</c:if>
							</sec:authorize>
							<a href="<c:url value="/principal"/>" type="button"
								class="btn default">Cerrar</a>
						</div>



					</div>
				</div>

			</div>
		</div>
		
		
<div class="modal fade" id="modalForm" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Impresión de Certificados y Consentimientos</h4>
      </div>
      <div class="modal-body">
        <p>Seleccione el tipo de documento que desea generar:</p>
        <p>
        <input type="checkbox" name="tipo1" id="tipo1" >Certificado<br>
        <input type="checkbox" name="tipo2" id="tipo2" >Consentimiento<br>
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn blue" onclick="imprime();">Imprimir</button>
        <button type="button" class="btn default" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
		
		
		
	</tiles:putAttribute>

	<tiles:putAttribute name="scripts">
		<script
			src="<c:url value='/assets/global/plugins/bootstrap-select/bootstrap-select.min.js'/>"></script>
		<script
			src="<c:url value='/assets/global/plugins/select2/select2.min.js'/>"></script>
		<script
			src="<c:url value='/assets/global/plugins/jquery-multi-select/js/jquery.multi-select.js'/>"></script>
		<script>
		function imprime(){
			var tipo1 = $("#tipo1").is(':checked');
			var tipo2 = $("#tipo2").is(':checked');
			var tipo = $("#tipo");
			
			if(!tipo1  && !tipo2){
				bootbox.alert("Favor de seleccionar por lo menos 1 documento a imprimir");
			}else{
				if(tipo1 && !tipo2)
					tipo.val("1");
				else if(!tipo1 && tipo2)
					tipo.val("2");
				else if(tipo1 && tipo2)
					tipo.val("3");
				
				$("#imprimeInd").submit();
				
			}
		}
		</script>
			
	</tiles:putAttribute>

	<tiles:putAttribute name="ready"> 
	$('#asegurados').addClass("start active open")
	
	$('#modalForm').on('hidden.bs.modal', function () {
  		 location.reload();
	});
	</tiles:putAttribute>

</tiles:insertDefinition>