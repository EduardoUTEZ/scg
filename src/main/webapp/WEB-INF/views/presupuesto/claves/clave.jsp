<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="title">
		<fmt:message key="presupuesto" />
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">

			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">code</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">Partidas Presupuestales</h4>
						<div class="toolbar">
                            <a href='<c:url value="add"/>' class="btn btn-success"> <i
								class="fa fa-plus"></i> <span class="hidden-480"> Nueva Partida </span>
							</a>
							
							<a href='<c:url value="cargaMasiva"/>' class="btn "> 
							<i class="fa fa-plus"> </i> <span class="hidden-480"> Carga Masiva </span>
							</a>
							
                        </div>
                        <hr>
                        <div class="toolbar">
                        	
                        	
                        	<label class="control-label"><fmt:message key="presupuesto.clave.anio" /></label>
                        	<form:form action="buscaPresupuesto" method="POST" modelAttribute="busquedaPresupuesto">
                        	<div class="row">
							
							<div class="col-md-4">
                        	<form:select path="anio"
								class="selectpicker"  data-style="select-with-transition"
								multiple="false" title="Selecciona el Año" data-size="7">
								<form:options items="${anios}"/>
							</form:select>
							</div>
							</div>
							
							</form:form>
                        </div>
                        
						<table id="tableClaves"
							class="table table-striped table-no-bordered table-hover">
							<thead>
								<tr>
									<th><fmt:message key="presupuesto.clave.descripcion" /></th>
									<th><fmt:message key="presupuesto.clave.cuentaContable" /></th>
									<th><fmt:message key="presupuesto.clave.cuenta" /></th>
									<th><fmt:message key="presupuesto.clave.empresa" /></th>
									<th><fmt:message key="catalogos.acciones" /></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="clave" items="${claves}">
									<tr>
										<td><a href="edit?id=${clave.id}">${clave.descripcion}</a>
										</td>
										<td>${clave.cuentaContable}</td>
										<td>${clave.cuenta}</td>
										<td>${clave.empresa}</td>
										<td><a href="delete?id=${clave.id}" onclick=""><i
												class="fa fa-trash-o"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						
						
						
					</div>
				</div>
			</div>

		</div>
	</tiles:putAttribute>


	<tiles:putAttribute name="ready"> 
	$('#presupuesto_op').addClass("active ");
	$('#presupuesto').addClass("collapse in");
	
	$('#partidas_op').addClass("active");
	$('#tableClaves').DataTable({
	 "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        }
	
	});
   </tiles:putAttribute>

</tiles:insertDefinition>