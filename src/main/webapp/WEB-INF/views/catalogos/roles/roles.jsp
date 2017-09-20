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
						<h4 class="card-title">Roles</h4>
						<div class="toolbar">
                            <a href="add" class="btn brn-success"> <i
								class="fa fa-plus"></i> <span class="hidden-480"> Nuevo </span>
							</a>
                        </div>
					
						<table id="tableRoles"
							class="table table-striped table-no-bordered table-hover">
							<thead>
								<tr>
									<th><fmt:message key="catalogos.roles.nombre" /></th>
									<th><fmt:message key="catalogos.roles.permisos" /></th>
									<th><fmt:message key="catalogos.acciones" /></th>
									
								</tr>
							</thead>
							<tbody>
                            <c:forEach var="rol" items="${roles}"> 
                                 <tr> 
                                    <td><a href="edit?id=${rol.id}">${rol.nombre}</a> </td> 
                                    <td>${rol.permisos} </td> 
                                    <td><a href="delete?id=${rol.id}" onclick=""><i class="fa fa-trash-o"></i></a></td>
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
	$('#roles_op').addClass("active");
	$('#tableRoles').DataTable({
	
	 "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
        }
	
	});
   </tiles:putAttribute>

</tiles:insertDefinition>