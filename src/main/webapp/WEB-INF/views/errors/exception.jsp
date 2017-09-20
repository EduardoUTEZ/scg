<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="styles" type="string">
    /**/
    </tiles:putAttribute>

	<tiles:putAttribute name="title">Error en servidor</tiles:putAttribute>
	<tiles:putAttribute name="body">

		<div class="ui-widget">
			<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
				<p>
					<span class="ui-icon ui-icon-alert"
						style="float: left; margin-right: .3em;"></span> <strong>Ha
						sucedido el siguiente error en el sistema:</strong>
				<div>${exception}</div>
				<div>
					<fieldset>
						<legend>
							<b>Detalle:</b>
						</legend>
						<c:forEach items="${exception.stackTrace}" var="element">
							<c:out value="${element}"></c:out>
						</c:forEach>
					</fieldset>
				</div>

				</p>
			</div>
		</div>

	</tiles:putAttribute>
	<tiles:putAttribute name="scripts">
        <script type="text/javascript" src="<c:url value='/assets/global/plugins/jquery-validation/js/jquery.validate.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/assets/global/plugins/jquery-validation/js/additional-methods.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/assets/admin/pages/scripts/argosform.js'/>"></script>
    </tiles:putAttribute>
    <tiles:putAttribute name="ready" type="string">
        /**/
    </tiles:putAttribute>
<%--     <tiles:putAttribute name="functions"></tiles:putAttribute> --%>
</tiles:insertDefinition>
