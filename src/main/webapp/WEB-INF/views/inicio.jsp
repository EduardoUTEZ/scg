<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="styles">
		<link
			href="<c:url value='/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css'/>"
			rel="stylesheet" type="text/css" />
		<link
			href="<c:url value='/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css'/>"
			rel="stylesheet" type="text/css" />
		<link
			href="<c:url value='/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css'/>"
			rel="stylesheet" type="text/css" />
	</tiles:putAttribute>
	<tiles:putAttribute name="title">Principal</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<%@include file="secciones/messages.jsp"%>
	
	Contenido de la página Principal.
	<div class="toolbar">
			<a href="<c:url value='/reasignacion/'/>" class="btn brn-success"> <i class="fa"></i>
				<span class="hidden-480">Solicitud de Reasignación Presupuestal</span>
			</a>
			
			<a href="<c:url value='/gastos/'/>"  class="btn brn-success"> <i class="fa"></i>
				<span class="hidden-480">Solicitud de Gastos</span>
			</a>
		</div>

	</tiles:putAttribute>



</tiles:insertDefinition>