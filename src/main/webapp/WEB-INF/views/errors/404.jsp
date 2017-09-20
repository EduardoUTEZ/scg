<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title><fmt:message key="messages.title" />  - Error 404</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/font-awesome/css/font-awesome.min.css' />" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/simple-line-icons/simple-line-icons.min.css' />" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/uniform/css/uniform.default.css' />" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css' />" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="<c:url value='/assets/admin/pages/css/error.css' />" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="<c:url value='/assets/global/css/components.css" id="style_components' />" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/css/plugins.css' />" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/admin/layout/css/layout.css' />" rel="stylesheet" type="text/css"/>
<link id="style_color" href="<c:url value='/assets/admin/layout/css/themes/argos.css' />" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/admin/layout/css/custom.css' />" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="<c:url value='/assets/admin/layout/img/favicon.ico'></c:url>"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-quick-sidebar-over-content ">

<!-- BEGIN PAGE CONTENT-->
	<div class="row">
		<div class="col-md-12 page-404">
			<div class="number">
				 404
			</div>
			<div class="details">
				<h3>Archivo no encontrado</h3>
				<p>
					 La dirección que intentó acceder no existe.<br/>
					<a class="btn green-meadow"  href="<c:url value='/' />">
					Regresar al inicio </a>
					
				</p>
<!-- 				<form action="#"> -->
<!-- 					<div class="input-group input-medium"> -->
<!-- 						<input type="text" class="form-control" placeholder="keyword..."> -->
<!-- 						<span class="input-group-btn"> -->
<!-- 						<button type="submit" class="btn blue"><i class="fa fa-search"></i></button> -->
<!-- 						</span> -->
<!-- 					</div> -->
<!-- 					/input-group -->
<!-- 				</form> -->
			</div>
		</div>
	</div>
<!-- END PAGE CONTENT-->

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="<c:url value='/assets/global/plugins/respond.min.js' />"></script>
<script src="<c:url value='/assets/global/plugins/excanvas.min.js' />"></script> 
<![endif]-->
<script src="<c:url value='/assets/global/plugins/jquery.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery-migrate.min.js' />" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<c:url value='/assets/global/plugins/jquery-ui/jquery-ui.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/bootstrap/js/bootstrap.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery.blockui.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery.cokie.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/uniform/jquery.uniform.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js' />" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="<c:url value='/assets/global/scripts/metronic.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/admin/layout/scripts/layout.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/admin/layout/scripts/quick-sidebar.js' />" type="text/javascript"></script>
<script src="<c:url value='/assets/admin/layout/scripts/demo.js' />" type="text/javascript"></script>
<script>
jQuery(document).ready(function() {    
	Metronic.init({context : "<c:url value='/assets/'/>"});
Layout.init(); // init current layout
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
