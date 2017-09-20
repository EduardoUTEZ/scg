<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="defaultTemplate">
<fmt:message key="catalogos.roles" var="entity"/> 

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
					
					
					<form:form id="add" action="save" method="POST" modelAttribute="rol" rol="form" >
						
						<div class="form-body">
							<!-- Mensaje de error, validación backend -->
							<spring:hasBindErrors name="rol">							
							<div class="alert alert-danger" style="display: block;"><button class="close" data-close="alert"></button><fmt:message key="error.form.globalmessage"/></div>
							</spring:hasBindErrors>
							
							<spring:bind path="rol.nombre">
								<div class="form-group ${status.error ? 'has-error' : ''}">
							
									<label><fmt:message key="catalogos.roles.nombre"/> *</label>									
										<form:input path="nombre" maxlength="50" required="true" type="text" class="form-control input upper" placeholder="nombre"/>					
										<form:errors path="nombre" class="help-block"></form:errors>		
								</div>
							</spring:bind>
							
							<spring:bind path="rol.permisos">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label><fmt:message key="catalogos.roles.permisos"/> *</label>
										<form:select path="permisos" required="true" class="selectpicker" data-style="select-with-transition" multiple="true" title="Selecciona los permisos asociados" data-size="7">
											<form:options items="${permisos}"/>
										</form:select>															
										<form:errors path="permisos" class="help-block"></form:errors>										
								</div>
							</spring:bind>							
						</div>
						<div class="form-actions">
							<button type="submit" class="btn btn-success"><fmt:message key="labels.buttons.save"/></button>									
							<a id="cancelar" href="<c:url value="/roles/"/>" type="button" class="btn btn-default"><fmt:message key="labels.buttons.cancel"/></a>
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
	$('#roles_op').addClass("active");
	
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