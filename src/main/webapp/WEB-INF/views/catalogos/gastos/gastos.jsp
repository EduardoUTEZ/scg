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
						<h4 class="card-title">Solicitudes de Gastos</h4>
							<div class="toolbar">
                            <a  id="agregarG" class="btn brn-success"> <i
								class="fa fa-plus"></i> <span class="hidden-480"> Nuevo </span>
							</a>
							
							 <a href="print" class="btn brn-success"> <i
								class="fa fa-print"></i> <span class="hidden-480">Imprimir</span>
							</a>
							
							 <a href="download" class="btn brn-success"> <i
								class="fa fa-download"></i> <span class="hidden-480">Exportar</span>
							</a>
							
							 <a href="#" class="btn brn-success"> <i
								class="fa fa-pushpin"></i> <span class="hidden-480">Bitácora</span>
							</a>
                        </div>
						<hr>


						<table id="tableSolicitudesGastos"
							class="table table-striped table-no-bordered table-hover">
							<thead>
								<tr>
									<th>Seleccionar</th>
									<th>No.Solicitud</th>
									<th>Empresa</th>
									<th>Fecha</th>
									<th>Estado</th>
									<th>Tipo</th>
									<th>Solicitante</th>
									<th>Descripción</th>
									<th>Importe</th>
									<th>Acción</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="r" items="${gastos}">
									<tr>

										<td>*</td>
										<td><a href="edit?id=${r.id}">${r.id}</a></td>
										<td>${r.empresa.nombre}</td>
										<td>${r.estadoFechaHora}</td>
										<td>${r.estatus}</td>
										<td>${r.tipo}</td>
										<td>${r.usuario.nombre}</td>
										<td>${r.descripcion}</td>
										<td>${r.importe}</td>
										<td><a href="delete?id=${r.id}" onclick=""><i
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
	
	$('#agregarG').click(function(){
      
      swal({
			title : '¿Que tipo de Solicitud de Gasto deseas crear?',
			text : '',
			html:'Normal <input type="radio" name="tipo" value="Normal" id="opcionA"/> Programada <input type="radio" name="tipo" value="Programada" id="opcionB"/> ',
			type : 'warning',
			showCancelButton : true,
			confirmButtonText : 'Entrar',
			cancelButtonText : 'Cancelar',
			confirmButtonClass : "btn btn-success",
			cancelButtonClass : "btn btn-danger",
			buttonsStyling : false
		}).then(function() {
			//window.location.href = linkURL;
			if ($('input:radio[name=tipo]:checked').val()== 'Normal'){
				
			window.location.href ="add";
				
			}else if ($('input:radio[name=tipo]:checked').val()== 'Programada') {
				
			alert ("Pantalla en construcción");	
				
			}
		}, function(dismiss) {
			// dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
			if (dismiss === 'cancel') {
				//Acciones despues de cancelar.
				alert($('input:radio[name=tipo]:checked').val())
			}
		});
	
	});
	
	
	$('#tableSolicitudesGastos').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        }
    });
   </tiles:putAttribute>

</tiles:insertDefinition>