<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<sec:authorize access="hasAnyRole('GESTIONA_USUARIOS', 'GESTIONA_ROLES')">
<li class="" id="catalogos">
	<a href="javascript:;">
	<i class="icon-folder"></i>
	<span class="title">Catálogos</span>
	<span class="selected"></span>
	<span class="arrow open"></span>
	</a>
	<ul class="sub-menu">
	<sec:authorize access="hasRole('GESTIONA_USUARIOS')">
		<li><a href="<c:url value='/usuarios/'/>"><i class="icon-user"></i> Usuarios</a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('GESTIONA_ROLES')">
		<li><a href="<c:url value='/roles/'/>"><i class="icon-users"></i> Roles</a></li>
	</sec:authorize>		
	</ul>
</li>
</sec:authorize>

