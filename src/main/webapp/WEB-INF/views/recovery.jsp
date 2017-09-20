<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="es">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title><fmt:message key="messages.title" /> | Seguros Thona</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="Seguros Thona Web App" name="description"/>
<meta content="Seguros Thona" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/simple-line-icons/simple-line-icons.min.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/uniform/css/uniform.default.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css'/>" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->

<link href="<c:url value='/assets/admin/pages/css/login-soft.css'/>" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME STYLES -->
<link href="<c:url value='/assets/global/css/components-rounded.css'/>" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/global/css/plugins.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/admin/layout/css/layout.css'/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value='/assets/admin/layout/css/custom.css'/>" rel="stylesheet" type="text/css"/>


<!-- END THEME STYLES -->
<link rel="shortcut icon" href="<c:url value='/assets/admin/layout/img/favicon.ico'></c:url>"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
<!-- BEGIN LOGO -->
<div class="logo">

	<a href="<c:url value="init"></c:url>">
	<img src="<c:url value='/assets/admin/layout/img/logo-big.png'/>" />
	</a>
</div>
<!-- END LOGO -->
<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
<div class="menu-toggler sidebar-toggler">
</div>
<!-- END SIDEBAR TOGGLER BUTTON -->
<!-- BEGIN LOGIN -->
<div class="content">
	
	<!-- Info -->

<h3>Información de recuperación</h3>
<p>
	 ${mensaje}
</p>

<div class="form-actions">
	<a href="<c:url value='/'/>" type="button" class="btn default">
	<i class="m-icon-swapleft"></i> Atrás </a>
</div>


	
</div>
<!-- END LOGIN -->
<!-- BEGIN COPYRIGHT -->
<div class="copyright">
	 Seguros Thona
</div>
<script src="<c:url value='/assets/global/plugins/jquery.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery-migrate.min.js'/>" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<c:url value='/assets/global/plugins/jquery-ui/jquery-ui.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery.blockui.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/jquery.cokie.min.js'/>" type="text/javascript"></script>

<script src="<c:url value='/assets/global/plugins/uniform/jquery.uniform.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js'/>" type="text/javascript"></script>

<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<c:url value='/assets/global/plugins/jquery-validation/js/jquery.validate.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/global/plugins/backstretch/jquery.backstretch.min.js'/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/assets/global/plugins/select2/select2.min.js'/>"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<c:url value='/assets/global/scripts/metronic.js'/>" type="text/javascript"></script>
<script src="<c:url value='/assets/admin/layout/scripts/layout.js'/>" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {     
	Metronic.init({context : "<c:url value='/assets/'/>"});
Layout.init(); // init current layout
  
       // init background slide images
       $.backstretch([
       	
       	
       	"<c:url value='/assets/admin/pages/media/bg/ag05.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag06.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag22.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag23.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag24.jpg'/>",
		"<c:url value='/assets/admin/pages/media/bg/ag26.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag14.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag15.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag16.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag17.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag34.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag35.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag32.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag07.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag25.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag08.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag09.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag01.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag02.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag03.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag04.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag10.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag11.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag12.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag13.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag14.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag15.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag16.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag17.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag18.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag19.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag20.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag21.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag22.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag23.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag24.jpg'/>",
		"<c:url value='/assets/admin/pages/media/bg/ag26.jpg'/>",
		"<c:url value='/assets/admin/pages/media/bg/ag27.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag28.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag29.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag30.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag31.jpg'/>",
       	"<c:url value='/assets/admin/pages/media/bg/ag33.jpg'/>",


       	
        ], {
          fade: 1000,
          duration: 5000
    }
    );
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>