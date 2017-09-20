<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<sec:authorize access="hasAnyRole('CAPTURA_ASEGURADOS', 'EXTRAE_INFORMACION')">
<li class="" id="asegurados">
	<a href="javascript:;">
	<i class="icon-folder"></i>
	<span class="title">Asegurados</span>
	<span class="selected"></span>
	<span class="arrow open"></span>
	</a>
	<ul class="sub-menu">
		<sec:authorize access="hasRole('CAPTURA_ASEGURADOS')">
		<li><a href="<c:url value='/asegurados/add'/>"><i class="icon-plus"></i> Agrega Asegurado</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('EXTRAE_INFORMACION')">
		<li><a href="<c:url value='/extraccion/'/>"><i class="icon-action-undo"></i> Extraer Asegurados</a></li>
		</sec:authorize>		
	</ul>
</li>
</sec:authorize>

