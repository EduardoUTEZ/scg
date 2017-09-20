<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="defaultTemplate">
<fmt:message key="catalogo.proveedor" var="entity"/> 

	<tiles:putAttribute name="title">
	<fmt:message key="catalogos" />
	</tiles:putAttribute>

	<tiles:putAttribute name="body">		
		<div class="row">	
		
		<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">transform</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">
						<c:if test="${empty usuario.id}"><fmt:message key="labels.forms.newform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						<c:if test="${not empty usuario.id}"><fmt:message key="labels.forms.editform.title"><fmt:param value="${entity}"/></fmt:message></c:if>
						</h4>
						<small><fmt:message key="labels.forms.hint.requiredfields"/></small>
						
						
						<form:form id="add" action="save" method="POST" modelAttribute="proveedor" usuario="form" >
						
						<div class="form-body">
							<!-- Mensaje de error, validación backend -->
							<spring:hasBindErrors name="proveedor">							
							<div class="alert alert-danger" style="display: block;"><button class="close" data-close="alert"></button><fmt:message key="error.form.globalmessage"/></div>
							</spring:hasBindErrors>
							
							<div class="row">
							<spring:bind path="proveedor.tipoProveedor">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.tipoProveedor"/> *</label>									
									<form:select path="tipoProveedor" required="true" multiple="false" class="select2-container form-control select2me">
									<form:option value="NONE">Seleccione...</form:option>
									<form:option value="Moral">Moral</form:option>
									<form:option value="Física">Física</form:option>
								</form:select>															
								<form:errors path="tipoProveedor" class="help-block"></form:errors>			
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="proveedor.estado">
								<div class="col-md-4">
								<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
								<label class="control-label"><fmt:message key="catalogo.proveedor.estado"/> *</label>
								<form:select path="estado" required="true"  class="select2-container form-control select2me">
								<form:option value="NONE">Seleccione...</form:option>
									<form:option value="1">Activo</form:option>
									<form:option value="0">Inactivo</form:option>
								</form:select>															
								<form:errors path="estado" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	
							
							<spring:bind path="proveedor.rfc">
								<div class="col-md-4">
								<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
								<label class="control-label"><fmt:message key="catalogo.proveedor.rfc"/> *</label>
																					
								<form:input path="rfc" maxlength="15" required="true" type="text" class="form-control input"   readonly="${empty usuario.id?'false':'true'}"/>					
									<form:errors path="rfc" class="help-block"></form:errors>											
								</div>
								</div>
							</spring:bind>	
						</div>
						
						<div class="row">
							<spring:bind path="proveedor.razonSocial">
								<div class="col-md-12">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.razonSocial"/> *</label>									
									<form:input path="razonSocial" maxlength="50" required="true" type="text" class="form-control input"   readonly="${empty usuario.id?'false':'true'}"/>					
									<form:errors path="razonSocial" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
						</div>
						<div class="row">
							<spring:bind path="proveedor.nombre">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.razonSocial"/> *</label>									
									<form:input path="nombre" maxlength="50" required="true" type="text" class="form-control input"   readonly="${empty usuario.id?'false':'true'}"/>					
									<form:errors path="nombre" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							<spring:bind path="proveedor.primerApellido">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.primerApellido"/></label>									
									<form:input path="primerApellido" maxlength="50" required="true" type="text" class="form-control input"   readonly="${empty usuario.id?'false':'true'}"/>					
									<form:errors path="primerApellido" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="proveedor.segundoApellido">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.segundoApellido"/></label>									
									<form:input path="segundoApellido" maxlength="50" required="true" type="text" class="form-control input"   readonly="${empty usuario.id?'false':'true'}"/>					
									<form:errors path="segundoApellido" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							</div>
							
							<div class="row">
							<spring:bind path="proveedor.dirCalle">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.calle"/> *</label>									
									<form:input path="dirCalle" maxlength="100" required="true" type="text" class="form-control input upper" />					
									<form:errors path="dirCalle" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
								<spring:bind path="proveedor.dirNoExt">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.numExterior"/> *</label>									
									<form:input path="dirNoExt" maxlength="20" required="true" type="text" class="form-control input upper" />					
									<form:errors path="dirNoExt" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="proveedor.dirNoInt">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.numInterior"/> </label>									
									<form:input path="dirNoInt" maxlength="20" type="text" class="form-control input upper" />					
									<form:errors path="dirNoInt" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							
							</div>
							
							
							<div class="row">
							<spring:bind path="proveedor.dirCol">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.colonia"/> *</label>									
									<form:input path="dirCol" maxlength="100" required="true" type="text" class="form-control input upper" />					
									<form:errors path="dirCol" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
								<spring:bind path="proveedor.dirMunDel">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.muniDel"/> *</label>									
									<form:input path="dirMunDel" maxlength="100" required="true" type="text" class="form-control input upper" />					
									<form:errors path="dirMunDel" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="proveedor.dirEstado">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.estadoER"/> *</label>									
									<form:input path="dirEstado" maxlength="50" required="true" type="text" class="form-control input upper" />					
									<form:errors path="dirEstado" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							
							</div>
							
								<div class="row">
							<spring:bind path="proveedor.dirPais">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.pais"/> *</label>									
									<form:input path="dirPais" maxlength="50" required="true" type="text" class="form-control input upper" />					
									<form:errors path="dirPais" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
								<spring:bind path="proveedor.dirCP">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.CP"/> *</label>									
									<form:input path="dirCP" maxlength="5" required="true" type="text" class="form-control input upper" />					
									<form:errors path="dirCP" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="proveedor.telefono">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.telefono"/> *</label>									
									<form:input path="telefono" maxlength="10" required="true" type="text" class="form-control input upper" />					
									<form:errors path="telefono" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
							
							
							</div>
							
							
								<div class="row">
							<spring:bind path="proveedor.contrato">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.contrato"/> *</label>									
									<form:select path="tipoProveedor" required="true" multiple="false" class="select2-container form-control select2me">
									<form:option value="NONE">Seleccione...</form:option>
									<form:option value="Si">Si</form:option>
									<form:option value="No">No</form:option>
									<form:option value="No Aplica">No Aplica</form:option>
								</form:select>
								<form:errors path="contrato" class="help-block"></form:errors>			
									</div>
								</div>
							</spring:bind>
							
								<spring:bind path="proveedor.retenciones">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.retenciones"/> *</label>									
									<form:select path="retenciones" required="true" multiple="false" class="select2-container form-control select2me">
									<form:option value="NONE">Seleccione...</form:option>
									<form:option value="Si">Si</form:option>
									<form:option value="No">No</form:option>
								</form:select>
								<form:errors path="retenciones" class="help-block"></form:errors>			
									</div>
								</div>
							</spring:bind>
							
							<spring:bind path="proveedor.empresaGrupo">
								<div class="col-md-4">
								<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
								<label class="control-label"><fmt:message key="catalogo.proveedor.empresaGrupo"/> *</label>
								<form:select path="empresaGrupo" required="true" multiple="false" class="select2-container form-control select2me">
									<form:option value="NONE">Seleccione...</form:option>
									<form:options itemValue="id" itemLabel="nombre" items="${grupos}"/>
								</form:select>															
								<form:errors path="empresaGrupo" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>	
							</div>
							
							
							
							<div class="row">
							<spring:bind path="proveedor.banco">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.banco"/>*</label>									
									<form:input path="banco" maxlength="50" required="true" type="text" class="form-control input upper" />					
									<form:errors path="banco" class="help-block"></form:errors>		
									</div>
								</div>
							</spring:bind>
								<spring:bind path="proveedor.cuentaBanco">
								<div class="col-md-4">
									<div class="form-group label-floating ${status.error ? 'has-error' : ''}">						
									<label class="control-label"><fmt:message key="catalogo.proveedor.cuentaBanco"/>*</label>									
									<form:input path="cuentaBanco" maxlength="12" required="true" type="text" class="form-control input upper" />					
									<form:errors path="cuentaBanco" class="help-block"></form:errors>		
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
							<a id="cancelar" href="<c:url value="/proveedores/"/>" type="button" class="btn btn-default"><fmt:message key="labels.buttons.cancel"/></a>
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
	$('#roles_op2').addClass("active");
	
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