<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="title">Principal</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">

			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">transform</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">Solicitudes de Reasignación Presupuestal</h4>
							<div class="toolbar">
                            <a href="add" class="btn brn-success"> <i
								class="fa fa-plus"></i> <span class="hidden-480"> Nuevo </span>
							</a>
							
							 <a href="print" class="btn brn-success"> <i
								class="fa fa-print"></i> <span class="hidden-480">Imprimir</span>
							</a>
							
							 <a href="download" class="btn brn-success"> <i
								class="fa fa-download"></i> <span class="hidden-480">Exportar</span>
							</a>
                        </div>
						<hr>


						<table id="tableSolicitudes"
							class="table table-striped table-no-bordered table-hover">
							<thead>
								<tr>
									<th>Seleccionar</th>
									<th>No.Solicitud</th>
									<th>Fecha</th>
									<th>Estado</th>
									<th>Solicitante</th>
									<th>Cuenta Origen</th>
									<th>Cuenta Destino</th>
									<th>Importe</th>
									<th>Acción</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="r" items="${solicitudes}">
									<tr>

										<td>*</td>
										<td><a href="edit?id=${r.id}">${r.id}</a></td>
										<td>${r.solicitud.fechaEvaluacion}</td>
										<td>${r.solicitud.estatus}</td>
										<td>${r.solicitud.usuarioAlta}</td>
										<td>${r.clavePresupuestariaOrigen.nivel1}-${r.clavePresupuestariaOrigen.nivel2}-${r.clavePresupuestariaOrigen.nivel3}-${r.clavePresupuestariaOrigen.nivel4}-${r.clavePresupuestariaOrigen.nivel5}</td>
										<td>${r.clavePresupuestariaDestino.nivel1}-${r.clavePresupuestariaDestino.nivel2}-${r.clavePresupuestariaDestino.nivel3}-${r.clavePresupuestariaDestino.nivel4}-${r.clavePresupuestariaDestino.nivel5}</td>
										<td>${r.importe}</td>
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
	
	
	
	
	$('#tableSolicitudes').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        }
    });
   </tiles:putAttribute>

</tiles:insertDefinition>