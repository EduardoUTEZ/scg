<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="styles">
		<link href="<c:url value='/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css'/>" rel="stylesheet" type="text/css"/>
		<link href="<c:url value='/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css'/>" rel="stylesheet" type="text/css"/>
		<link href="<c:url value='/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css'/>" rel="stylesheet" type="text/css"/>		
	</tiles:putAttribute>
	<tiles:putAttribute name="title">Información</tiles:putAttribute>
	<tiles:putAttribute name="body">
	<%@include file="secciones/messages.jsp" %>
	
	<c:forEach items="${mensaje.mensajeFijo}" var="msg">
		${msg}<br>
	</c:forEach>
	

	</tiles:putAttribute>	
	
	
	
</tiles:insertDefinition>