<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
setTimeout(function() {
    $('.alert').fadeOut('fast');
}, 10000);

</script>

<c:if test="${ not empty errmsg}">
	<br><br>
	<div class="alert alert-warning">${errmsg}</div>
	<br><br>
</c:if>
<c:if test="${ not empty infomsg}">
	<br><br>
	<div class="alert alert-info">${infomsg}</div>
	<br><br>
</c:if>
<c:if test="${ not empty succmsg}">
	<br><br>
	<div class="alert alert-success">${succmsg}</div>
	<br><br>
</c:if>	

<div class="alert alert-warning" id="warnmsg" style="display:none;"></div>