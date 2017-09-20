<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="defaultTemplate">
<fmt:message key="catalogos.usuarios" var="entity"/> 

	<tiles:putAttribute name="title">
	<fmt:message key="catalogos" />
	</tiles:putAttribute>

	<tiles:putAttribute name="body">		
		<div class="row">	
		
		<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">person</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">
						<c:if test="${empty usuario.id}"><fmt:message key="labels.forms.newform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						<c:if test="${not empty usuario.id}"><fmt:message key="labels.forms.editform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						</h4>
						<small><fmt:message key="labels.forms.hint.requiredfields"/></small>
						
						
						<form:form id="add" action="save" method="POST" modelAttribute="usuario" usuario="form" >
						
						<div class="form-body">
							<!-- Mensaje de error, validación backend -->
							<spring:hasBindErrors name="usuario">							
							<div class="alert alert-danger" style="display: block;"><button class="close" data-close="alert"></button><fmt:message key="error.form.globalmessage"/></div>
							</spring:hasBindErrors>
							
							<div class="row">
							<spring:bind path="usuario.nombre">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogos.usuarios.nombre"/> *</label>									
									<form:input path="nombre" maxlength="50" required="true" type="text" class="form-control input upper"/>					
									<form:errors path="nombre" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="usuario.estado">
								<div class="col-md-4">
								<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
								<label class="control-label"><fmt:message key="catalogos.usuarios.estado"/> *</label>
								<form:select path="estado" required="true" multiple="false" class="select2-container form-control select2me">
									<form:options items="${estados}"/>
								</form:select>															
								<form:errors path="estado" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	
							
							<spring:bind path="usuario.rol">
								<div class="col-md-4">
								<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
								<label class="control-label"><fmt:message key="catalogos.usuarios.rol"/> *</label>
								<form:select path="rol" required="true" multiple="false" class="select2-container form-control select2me">
									<form:options itemValue="id" itemLabel="nombre" items="${roles}"/>
								</form:select>															
								<form:errors path="rol" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	
							
							
							
						</div>
						<div class="row">
							
							<spring:bind path="usuario.nombreAcceso">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogos.usuarios.nombreAcceso"/> *</label>									
									<form:input path="nombreAcceso" maxlength="20" required="true" type="text" class="form-control input"   readonly="${empty usuario.id?'false':'true'}"/>					
									<form:errors path="nombreAcceso" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="usuario.claveAcceso">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogos.usuarios.claveAcceso"/> *</label>									
									<form:input path="claveAcceso" maxlength="40" required="true" type="password" class="form-control input" />					
									<form:errors path="claveAcceso" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="usuario.claveAcceso2">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogos.usuarios.claveAcceso2"/> *</label>									
									<form:input path="claveAcceso2" maxlength="40" required="true" type="password" equalTo="#claveAcceso" class="form-control input" />					
									<form:errors path="claveAcceso2" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>

							</div>
							
							<div class="row">
							<spring:bind path="usuario.correoElectronico">
								<div class="col-md-6">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogos.usuarios.correoElectronico"/> *</label>									
									<form:input path="correoElectronico" maxlength="80" required="true" type="email" class="form-control input upper" />					
									<form:errors path="correoElectronico" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							</div>
							
							
							<h4 class="form-section">Datos Informativos </h4>
							<div class="row">
								
								<div class="col-md-3">
									<div class="form-group">
									<label ><fmt:message key="catalogos.general.fechaAlta"/>: </label>									
									<div ><fmt:formatDate value="${usuario.fechaAlta}" pattern="yyyy/MM/dd HH:mm:ss"/> </div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
									<label><fmt:message key="catalogos.general.usuarioAlta"/>: </label>									
									<div><c:out value="${usuario.usuarioAlta}"/></div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
									<label><fmt:message key="catalogos.general.fechaModifica"/>: </label>									
									<div ><fmt:formatDate value="${usuario.fechaModifica}" pattern="yyyy/MM/dd HH:mm:ss"/> </div>
									</div>
								</div>
								
								<div class="col-md-3">
									<div class="form-group">
									<label><fmt:message key="catalogos.general.usuarioModifica"/>: </label>									
									<div><c:out value="${usuario.usuarioModifica}"/></div>
									</div>
								</div>				
							</div>
							
													
						</div>
						<div class="form-actions">
							<button type="submit" class="btn btn-success"><fmt:message key="labels.buttons.save"/></button>									
							<a id="cancelar" href="<c:url value="/usuarios/"/>" type="button" class="btn btn-default"><fmt:message key="labels.buttons.cancel"/></a>
						</div>
						
						<form:hidden path="id"/>
					</form:form>
						
						
						
						
						
                   	</div>
               	</div>
        </div>
		
		
		
	</div>
	</tiles:putAttribute>
		
	<tiles:putAttribute name="ready"> 
	
	$('#catalogos_op').addClass("active ");
	$('#catalogos').addClass("collapse in");
	$('#usuarios_op').addClass("active");
	
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