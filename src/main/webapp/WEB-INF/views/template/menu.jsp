<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="sidebar" data-active-color="red"
	data-background-color="black"
	data-image="<c:url value='/assets/img/sidebar-1.jpg'/>">
	<!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->
	<div class="logo">
		<a href="#" class="simple-text"> Control de Gastos </a>
	</div>
	<div class="logo logo-mini">
		<a href="http://www.creative-tim.com" class="simple-text"> SCG </a>
	</div>
	<div class="sidebar-wrapper">
		<!--  
                <div class="user">
                    <div class="photo">
                        <img src="<c:url value='/assets/img/faces/avatar.jpg'/>" />
                    </div>
                    <div class="info">
                        <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                            Tania Andrew
                            <b class="caret"></b>
                        </a>
                        <div class="collapse" id="collapseExample">
                            <ul class="nav">
                                <li>
                                    <a href="#">My Profile</a>
                                </li>
                                <li>
                                    <a href="#">Edit Profile</a>
                                </li>
                                <li>
                                    <a href="#">Settings</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                   
                </div>
                -->
		<ul class="nav">
			<li id="principal_op"><a href="<c:url value='/principal'/>">
					<i class="material-icons">dashboard</i>
					<p>Principal</p>
			</a></li>

			<li id="catalogos_op"><a data-toggle="collapse"
				href="#catalogos"> <i class="material-icons">apps</i>
					<p>
						Catálogos <b class="caret"></b>
					</p>
			</a>
				<div class="collapse" id="catalogos">
					<ul class="nav">
						<li id="bitacoras_op"><a
							href="<c:url value='/bitacoraAccesos/'/>">Bitácora de Acceso</a></li>
							<li id="roles_op2"><a href="<c:url value='/proveedores/'/>">Proveedores</a></li>
							 <li id="roles_op"><a href="<c:url value='/roles/'/>">Roles</a></li> 
						<li id="usuarios_op"><a href="<c:url value='/usuarios/'/>">Usuarios</a></li>
                       
					</ul>
				</div></li>

			<li id="presupuesto_op"><a data-toggle="collapse"
				href="#presupuesto"> <i class="material-icons">monetization_on</i>
					<p>
						Presupuesto <b class="caret"></b>
					</p>
			</a>
				<div class="collapse" id="presupuesto">
					<ul class="nav">
						<li id="partidas_op"><a href="<c:url value='/partidas/partidas'/>">Partidas Presupuestales</a></li>
						<li id="reasignacion_op"><a href="<c:url value='/partidas/reasignacion'/>">Reasignación Presupuestal</a></li>
					

					</ul>
				</div></li>



		</ul>
	</div>
</div>