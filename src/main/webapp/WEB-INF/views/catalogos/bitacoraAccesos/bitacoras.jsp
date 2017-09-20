<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
						<i class="material-icons">list</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">Bitacora de Accesos</h4>
						<div class="toolbar">
                            <form:form id="buscar" action="buscar" method="POST" modelAttribute="busquedaBitacora">
                            <div class="form-group">
                            	<div class="col-md-2">
							    <label class="label-control">Fecha Inicial</label>
							    <form:input path="f1" class="form-control datetimepicker" required="true" data-date-format="DD/MM/YYYY"/>
								</div>
								
								<div class="col-md-2">
							    <label class="label-control">Fecha Final</label>
							    <form:input path="f2" class="form-control datetimepicker" required="true" data-date-format="DD/MM/YYYY"/>
								</div>
							</div>
                            
                            
                            <button  class="btn btn-success"> <i
								class="fa fa-search"></i> <span class="hidden-480"> Buscar </span>
							</button>
							</form:form>
                        </div>
                        <h4>Resultados de la búsqueda</h4><hr>
						<table id="tableBitacoras"
							class="table table-striped table-no-bordered table-hover">
							<thead>
								<tr>
									<th><fmt:message key="catalogos.bitacoras.nombreAcceso" /></th>
									<th><fmt:message key="catalogos.bitacoras.fechaAcceso" /></th>
									

								</tr>
							</thead>
							<tbody>
								<c:forEach var="bitacora" items="${bitacoras}">
									<tr>
										<td>${bitacora.nombreAcceso}</td>
										<td>${bitacora.fechaAcceso}</td>
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
	$('#bitacoras_op').addClass("active");
	
	$('#tableBitacoras').DataTable({
     "pagingType": "full_numbers",
     "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "Todas"]],
     responsive: true,
     language: {
       search: "_INPUT_",
       searchPlaceholder: "Buscar",
       "url":"<c:url value='/assets/js/SpanishDT.json'/>"
   	}
 	});
 	
 	$('.datetimepicker').datetimepicker({
    icons: {
        time: "fa fa-clock-o",
        date: "fa fa-calendar",
        up: "fa fa-chevron-up",
        down: "fa fa-chevron-down",
        previous: 'fa fa-chevron-left',
        next: 'fa fa-chevron-right',
        today: 'fa fa-screenshot',
        clear: 'fa fa-trash',
        close: 'fa fa-remove', 
        useCurrent: true
    }
});
 	
   </tiles:putAttribute>

</tiles:insertDefinition>