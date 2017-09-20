<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="title">
		Cambio de Contrase�a
	</tiles:putAttribute>

	<!-- Menu de navegaci�n -->



	<tiles:putAttribute name="body">
	<%@include file="../secciones/messages.jsp" %>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">

				<div class="portlet box green-haze">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-edit"></i>
							Cambio de contrase�a.
							<small><fmt:message
									key="labels.forms.hint.requiredfields" /></small>
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>

					<div class="portlet-body form">
						<!-- <form rol="form"> -->
						<form:form id="cambiar" action="cambiar" method="POST"
							modelAttribute="cambioClave" rol="form">

							<div class="form-body">
								<!-- Mensaje de error, validaci�n backend -->
								<spring:hasBindErrors name="cambioClave">
									<div class="alert alert-danger" style="display: block;">
										<button class="close" data-close="alert"></button>
										<fmt:message key="error.form.globalmessage" />
									</div>
								</spring:hasBindErrors>

								<spring:bind path="cambioClave.claveAccesoActual">
									<div class="form-group ${status.error ? 'has-error' : ''}">

										<label><fmt:message key="cambioClave.claveAccesoActual" /></label>
										<form:input path="claveAccesoActual" maxlength="50" required="true"
											type="password" class="form-control input upper"
											placeholder="actual" />
										<form:errors path="claveAccesoActual" class="help-block"></form:errors>
									</div>
								</spring:bind>
								<spring:bind path="cambioClave.claveAccesoNueva">
									<div class="form-group ${status.error ? 'has-error' : ''}">

										<label><fmt:message key="cambioClave.claveAccesoNueva" /></label>
										<form:input path="claveAccesoNueva" maxlength="50" required="true"
											type="password" class="form-control input upper"
											placeholder="nueva" />
										<form:errors path="claveAccesoNueva" class="help-block"></form:errors>
									</div>
								</spring:bind>
								<spring:bind path="cambioClave.claveAccesoNueva2">
									<div class="form-group ${status.error ? 'has-error' : ''}">

										<label><fmt:message key="cambioClave.claveAccesoNueva2" /></label>
										<form:input path="claveAccesoNueva2" maxlength="50" required="true"
											type="password" class="form-control input upper"
											placeholder="confirmaci�n" />
										<form:errors path="claveAccesoNueva2" class="help-block"></form:errors>
									</div>
								</spring:bind>

								

							<form:hidden path="idUsuario" />
							<div class="form-actions">
							<button type="submit" class="btn green"><fmt:message key="labels.buttons.save"/></button>									
							<a href="<c:url value="/principal"/>" type="button" class="btn default"><fmt:message key="labels.buttons.cancel"/></a>
						</div>
							
						</form:form>
					</div>
				</div>

			</div>
		</div>
	</tiles:putAttribute>
<tiles:putAttribute name="ready"> 
	$('#cambiar').submit(function(event){
		var n = $("#claveAccesoNueva");
		var n2 = $("#claveAccesoNueva2");
		
		if (n.val() != n2.val()){
			bootbox.alert("La contrase�a no coincide con la confirmaci�n.<br> Favor de capturarla correctamente.");
			n.val("");
			n2.val("");
			return false;	
		}
		
		
	});
	</tiles:putAttribute>
	

</tiles:insertDefinition>