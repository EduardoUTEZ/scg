a<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="defaultTemplate">
<fmt:message key="catalogos.asegurados" var="entity"/> 

	<tiles:putAttribute name="title">
	<c:if test="${empty asegurado.id}">
		<fmt:message key="labels.forms.newform.title"><fmt:param value="${entity}"/></fmt:message>
	</c:if>
	<c:if test="${not empty asegurado.id}">
		<fmt:message key="labels.forms.editform.title"><fmt:param value="${entity}"/></fmt:message>
	</c:if>
	</tiles:putAttribute>
	
	<!-- Menu de navegación -->
	<tiles:putAttribute name="nav">
	<li><a href='<c:url value="/asegurados/"/>'>${entity}</a> <i class="fa fa-angle-right"></i></li>	
	</tiles:putAttribute>
	
	
	<tiles:putAttribute name="body">		
		<div class="row">	
		<div class="col-md-10 col-md-offset-1">
																															
			<div class="portlet box green-haze">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-edit"></i> 
						<c:if test="${empty asegurado.id}"><fmt:message key="labels.forms.newform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						<c:if test="${not empty asegurado.id}"><fmt:message key="labels.forms.editform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						<small><fmt:message key="labels.forms.hint.requiredfields"/></small>
					</div>
					<div class="tools">
						<a href="" class="collapse"></a>
					</div>
				</div>
				
				<div class="portlet-body form">						
					<!-- <form asegurado="form"> -->
					<form:form id="add" action="save" method="POST" modelAttribute="asegurado" asegurado="form" >
						
						<div class="form-body">
							<!-- Mensaje de error, validación backend -->
							<spring:hasBindErrors name="asegurado">							
							<div class="alert alert-danger" style="display: block;"><button class="close" data-close="alert"></button><fmt:message key="error.form.globalmessage"/></div>
							</spring:hasBindErrors>
							
							
							<h3>Póliza: ${asegurado.folioPoliza} </h3>
							
							<h4 class="form-section">Datos del Asegurado </h4>
							<div class="row">
							
							<spring:bind path="asegurado.primerApellido">
								<div class="col-md-4">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.primerApellido"/> *</label>									
									<form:input path="primerApellido" maxlength="50" required="true" type="text" class="form-control input upper" placeholder=""/>					
									<form:errors path="primerApellido" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="asegurado.segundoApellido">
								<div class="col-md-4">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.segundoApellido"/> *</label>									
									<form:input path="segundoApellido" maxlength="50" type="text" class="form-control input upper" placeholder=""/>					
									<form:errors path="segundoApellido" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="asegurado.nombre">
								<div class="col-md-4">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.nombre"/> *</label>									
									<form:input path="nombre" maxlength="50" required="true" type="text" class="form-control input upper" placeholder=""/>					
									<form:errors path="nombre" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							</div>
							<div class="row">
							
							<spring:bind path="asegurado.fechaNacimiento">
								<div class="col-md-4">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.fechaNacimiento"/> *</label>									
									<form:input path="fechaNacimiento" maxlength="10" required="true" type="text" 
									onkeyup="mascara(this,'/',patron,true)" onblur="getEdadAseg(this);"
									 class="form-control input upper" placeholder="dd/mm/aaaa"/>					
									<form:errors path="fechaNacimiento" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="asegurado.edad">
								<div class="col-md-4">
									<div class="form-group ${status.error ? 'has-error' : ''}">						
									<label><fmt:message key="catalogos.asegurados.edad"/></label>									
									<form:input path="edad" maxlength="3"  type="text" class="form-control input upper" placeholder="" readonly="true"/>					
									<form:errors path="edad" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="asegurado.sexo">
								<div class="col-md-4">
								<div class="form-group ${status.error ? 'has-error' : ''}">
								<label><fmt:message key="catalogos.asegurados.sexo"/> *</label>
								<form:select path="sexo" required="true" multiple="false" class="select2-container form-control select2me" placeholder="Selecciona">
									<form:option value=""/>
									<form:options items="${sexos}"/>
								</form:select>															
								<form:errors path="sexo" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	
							
						</div>
						<div class="row">
							<spring:bind path="asegurado.estadoCivil">
								<div class="col-md-4">
								<div class="form-group ${status.error ? 'has-error' : ''}">
								<label><fmt:message key="catalogos.asegurados.estadoCivil"/> *</label>
								<form:select path="estadoCivil" required="true" multiple="false" class="select2-container form-control select2me" placeholder="Selecciona">
									<form:option value=""/>
									<form:options items="${estadosCivil}"/>
								</form:select>															
								<form:errors path="estadoCivil" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	

						</div>
							
							
							
							
							<h4 class="form-section">Datos de Beneficiarios </h4>
							<div class="row ">
								<div class="col-md-2">
									<div class="form-group">
										<label>Nombre *</label>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Primer Apellido *</label>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Segundo Apellido</label>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Parentesco *</label>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Porcentaje *</label>
									</div>
								</div>
							</div>
				
							<c:forEach items="${asegurado.beneficiarios}" var="beneficiario" varStatus="status">
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">					
									<input name="beneficiarios[${status.index}].nombre" id="bnombre${status.index}" value="${beneficiario.nombre}" class="form-control input upper" size="25" maxlength="20">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">					
									<input name="beneficiarios[${status.index}].primerApellido" id="bapellidoPaterno${status.index}" value="${beneficiario.primerApellido}" class="form-control input upper" size="25" maxlength="20">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">					
									<input name="beneficiarios[${status.index}].segundoApellido" id="bapellidoMaterno${status.index}" value="${beneficiario.segundoApellido}" class="form-control input upper" size="25" maxlength="20">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">					
									<select  name="beneficiarios[${status.index}].parentesco" id="bparentesco${status.index}" class="select2-container form-control select2me" placeholder="Selecciona">
									<option></option>
									<c:forEach items="${parentescos}" var="parentesco"><option <c:if test="${parentesco == beneficiario.parentesco}">selected</c:if> ><c:out value="${parentesco}"/></option> </c:forEach>	
									</select>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">					
									<input name="beneficiarios[${status.index}].porcentaje" id="bporcentaje${status.index}" value="${beneficiario.porcentaje}" class="form-control input upper" size="4" maxlength="3">
									</div>
								</div>
							</div>
							</c:forEach>
							

							
													
						</div>
						<div class="form-actions">
							<button type="submit" class="btn green"><fmt:message key="labels.buttons.save"/></button>									
							<a href="<c:url value="/principal"/>" type="button" class="btn default"><fmt:message key="labels.buttons.cancel"/></a>
						</div>
						
						<form:hidden path="id"/>
						<form:hidden path="rfc"/>
						<form:hidden path="folioPoliza"/>
						<form:hidden path="certificado"/>
						<form:hidden path="estatus"/>
						<form:hidden path="fechaRegistro"/>
						<form:hidden path="usuarioRegistra"/>
						<form:hidden path="fechaInicioVigencia"/>
						<form:hidden path="fechaFinVigencia"/>
						
					</form:form>
				</div>
			</div>			

		</div>
	</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="scripts">
	<script src="<c:url value='/assets/global/plugins/bootstrap-select/bootstrap-select.min.js'/>"></script>
	<script src="<c:url value='/assets/global/plugins/select2/select2.min.js'/>"></script>
	<script src="<c:url value='/assets/global/plugins/jquery-multi-select/js/jquery.multi-select.js'/>"></script>
	<script src="<c:url value='/assets/scg/asegurado.js'/>"></script>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="ready"> 
	$('#asegurados').addClass("start active open")
	</tiles:putAttribute>
	
</tiles:insertDefinition>