<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<tiles:insertDefinition name="defaultTemplate">
	
	<tiles:putAttribute name="title">
		<fmt:message key="catalogos" />
	</tiles:putAttribute>
	
	<tiles:putAttribute name="body">
		<div class="row">

			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">people</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">Proveedores</h4>
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
					
						<table id="tableProveedor"
							class="table table-striped table-no-bordered table-hover">
							<thead>
								<tr>
									<th><fmt:message key="proveedor.rfc" /></th>
									<th><fmt:message key="proveedor.razonSocial" /></th>
									<th>Banco</th>
									<th>Cuenta</th>
									<th><fmt:message key="proveedor.tipo" /></th>
									<th><fmt:message key="proveedor.tel" /></th>
									<th><fmt:message key="proveedor.contrato" /></th>
									<th><fmt:message key="proveedor.estado" /></th>
									<th><fmt:message key="proveedor.acciones" /></th>
									
								</tr>
							</thead>
							<tbody>
                            <c:forEach var="proveedor" items="${proveedores}"> 
                                 <tr> 
                                    <td><a href="edit?id=${proveedor.id}">${proveedor.rfc}</a> </td> 
                                    	<td>${proveedor.razonSocial}</td>
                                    	<td>${proveedor.banco}</td>
                                    	<td>${proveedor.cuentaBanco}</td>
										<td>${proveedor.tipoProveedor}</td>
										<td>${proveedor.telefono}</td>
										<td>${proveedor.contrato}</td>
										<c:if test="${proveedor.estado==0}">
										<td>Inactivo</td>
										</c:if>
										<c:if test="${proveedor.estado==1}">
										<td>Activo</td>
										</c:if>
										
                                    <td><a href="delete?id=${proveedor.id}" onclick=""><i class="fa fa-trash-o"></i></a></td>
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
	$('#catalogos_op').addClass("active ");
	$('#catalogos').addClass("collapse in");
	$('#roles_op2').addClass("active");
	$('#tableProveedor').DataTable( {
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        }
    } );
   </tiles:putAttribute>

</tiles:insertDefinition>