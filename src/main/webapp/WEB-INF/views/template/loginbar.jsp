<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url value='/assets/admin/layout/img/avatar.png' var="colab_pic"/>
<img alt="pic" class="img-circle" 
src="${colab_pic}">

<span class="username username-hide-on-mobile">
Bienvenid@ <sec:authentication property="principal.username"/>
 </span>
<i class="fa fa-angle-down"></i>
</a>
<ul class="dropdown-menu dropdown-menu-default">
	<li>
	<a href="<c:url value="/cambioClave/"></c:url>">
		<i class="icon-lock"></i> Cambiar Contraseña</a>
		
		<a href="<c:url value="/j_spring_security_logout"></c:url>">
		<i class="icon-key"></i> Cerrar sesi&oacute;n </a>
	</li>
</ul>
