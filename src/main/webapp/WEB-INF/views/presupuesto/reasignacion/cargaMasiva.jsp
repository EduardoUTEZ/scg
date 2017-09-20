<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="defaultTemplate">
<fmt:message key="reasignacion" var="entity"/> 

	<tiles:putAttribute name="title">${entity}</tiles:putAttribute>

	<tiles:putAttribute name="body">		
		<div class="row">	
		
		<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-icon"
						data-background-color="green">
						<i class="material-icons">playlist_add</i>
					</div>
					<div class="card-content">
						<h4 class="card-title">
						Carga masiva de Presupuesto
						</h4>
						<small><fmt:message key="labels.forms.hint.requiredfields"/></small>
						
						
						<form:form id="ejecutaCargaMasiva" action="ejecutaCargaMasiva" method="POST" modelAttribute="archivo" enctype="multipart/form-data">
						
						<div class="form-body">
							<!-- Mensaje de error, validación backend -->
							<spring:hasBindErrors name="archivo">							
							<div class="alert alert-danger" style="display: block;"><button class="close" data-close="alert"></button><fmt:message key="error.form.globalmessage"/></div>
							</spring:hasBindErrors>
							
							<div class="row">
							<spring:bind path="archivo.archivo">
								<div class="col-md-4">
								<div class="form-group label-floating ${status.error ? 'has-error' : ''}">
									<label class="control-label">Archivo *</label>
										
										<div class="fileinput fileinput-new text-center" data-provides="fileinput">
										    <div class="fileinput-new thumbnail">
										        <img src="../assets/img/excel.jpg" alt="...">
										    </div>
										    <div class="fileinput-preview fileinput-exists thumbnail"></div>
										    <div>
										        <span class="btn btn-danger btn-round btn-file">
										            <span class="fileinput-new">Selecciona Archivo</span>
										            <span class="fileinput-exists">Cambiar</span>
										            <input type="file" name="archivo" accept="application/vnd.ms-excel" />
										        </span>
										        <a href="#pablo" class="btn btn-danger btn-round fileinput-exists" data-dismiss="fileinput"><i class="fa fa-times"></i> Remover</a>
										    </div>
										</div>

																															
										<form:errors path="archivo" class="help-block"></form:errors>										
								</div>
								</div>
							</spring:bind>
							
							</div>
							</div>	
							
							<div class="form-actions">
							<button type="submit" class="btn btn-success"><fmt:message key="labels.buttons.process"/></button>									
							<a id="cancelar" href="<c:url value="/partidas/"/>" type="button" class="btn btn-default"><fmt:message key="labels.buttons.cancel"/></a>
						</div>
							
							
					</form:form>
						
						
						
						
						
                   	</div>
               	</div>
        </div>
		
		
		
	</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="functions"> 
		function presupuestoDisponible(){
			$("#pptoDisponibleMes1").val($("#pptoProgramado\\.mes1").val() - $("#pptoComprometido\\.mes1").val()- $("#pptoEjercido\\.mes1").val());
			$("#pptoDisponibleMes2").val($("#pptoProgramado\\.mes2").val() - $("#pptoComprometido\\.mes2").val()- $("#pptoEjercido\\.mes2").val());
			$("#pptoDisponibleMes3").val($("#pptoProgramado\\.mes3").val() - $("#pptoComprometido\\.mes3").val()- $("#pptoEjercido\\.mes3").val());
			$("#pptoDisponibleMes4").val($("#pptoProgramado\\.mes4").val() - $("#pptoComprometido\\.mes4").val()- $("#pptoEjercido\\.mes4").val());
			$("#pptoDisponibleMes5").val($("#pptoProgramado\\.mes5").val() - $("#pptoComprometido\\.mes5").val()- $("#pptoEjercido\\.mes5").val());
			$("#pptoDisponibleMes6").val($("#pptoProgramado\\.mes6").val() - $("#pptoComprometido\\.mes6").val()- $("#pptoEjercido\\.mes6").val());
			$("#pptoDisponibleMes7").val($("#pptoProgramado\\.mes7").val() - $("#pptoComprometido\\.mes7").val()- $("#pptoEjercido\\.mes7").val());
			$("#pptoDisponibleMes8").val($("#pptoProgramado\\.mes8").val() - $("#pptoComprometido\\.mes8").val()- $("#pptoEjercido\\.mes8").val());
			$("#pptoDisponibleMes9").val($("#pptoProgramado\\.mes9").val() - $("#pptoComprometido\\.mes9").val()- $("#pptoEjercido\\.mes9").val());
			$("#pptoDisponibleMes10").val($("#pptoProgramado\\.mes10").val() - $("#pptoComprometido\\.mes10").val()- $("#pptoEjercido\\.mes10").val());
			$("#pptoDisponibleMes11").val($("#pptoProgramado\\.mes11").val() - $("#pptoComprometido\\.mes11").val()- $("#pptoEjercido\\.mes11").val());
			$("#pptoDisponibleMes12").val($("#pptoProgramado\\.mes12").val() - $("#pptoComprometido\\.mes12").val()- $("#pptoEjercido\\.mes12").val());
			
			sumaPptoDisponible();
		}
		function sumaPptoProgramado(){
			var total = 0.0;
			
			total += parseFloat($("#pptoProgramado\\.mes1").val());
			total += parseFloat($("#pptoProgramado\\.mes2").val());
			total += parseFloat($("#pptoProgramado\\.mes3").val());
			total += parseFloat($("#pptoProgramado\\.mes4").val());
			total += parseFloat($("#pptoProgramado\\.mes5").val());
			total += parseFloat($("#pptoProgramado\\.mes6").val());
			total += parseFloat($("#pptoProgramado\\.mes7").val());
			total += parseFloat($("#pptoProgramado\\.mes8").val());
			total += parseFloat($("#pptoProgramado\\.mes9").val());
			total += parseFloat($("#pptoProgramado\\.mes10").val());
			total += parseFloat($("#pptoProgramado\\.mes11").val());
			total += parseFloat($("#pptoProgramado\\.mes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoProgramadoTotal").val(total);
		}
		
		function sumaPptoComprometido(){
			var total = 0.0;
			
			total += parseFloat($("#pptoComprometido\\.mes1").val());
			total += parseFloat($("#pptoComprometido\\.mes2").val());
			total += parseFloat($("#pptoComprometido\\.mes3").val());
			total += parseFloat($("#pptoComprometido\\.mes4").val());
			total += parseFloat($("#pptoComprometido\\.mes5").val());
			total += parseFloat($("#pptoComprometido\\.mes6").val());
			total += parseFloat($("#pptoComprometido\\.mes7").val());
			total += parseFloat($("#pptoComprometido\\.mes8").val());
			total += parseFloat($("#pptoComprometido\\.mes9").val());
			total += parseFloat($("#pptoComprometido\\.mes10").val());
			total += parseFloat($("#pptoComprometido\\.mes11").val());
			total += parseFloat($("#pptoComprometido\\.mes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoComprometidoTotal").val(total);
		}
		
		function sumaPptoEjercido(){
			var total = 0.0;
			
			total += parseFloat($("#pptoEjercido\\.mes1").val());
			total += parseFloat($("#pptoEjercido\\.mes2").val());
			total += parseFloat($("#pptoEjercido\\.mes3").val());
			total += parseFloat($("#pptoEjercido\\.mes4").val());
			total += parseFloat($("#pptoEjercido\\.mes5").val());
			total += parseFloat($("#pptoEjercido\\.mes6").val());
			total += parseFloat($("#pptoEjercido\\.mes7").val());
			total += parseFloat($("#pptoEjercido\\.mes8").val());
			total += parseFloat($("#pptoEjercido\\.mes9").val());
			total += parseFloat($("#pptoEjercido\\.mes10").val());
			total += parseFloat($("#pptoEjercido\\.mes11").val());
			total += parseFloat($("#pptoEjercido\\.mes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoEjercidoTotal").val(total);
		}
		
		function sumaPptoDisponible(){
			var total = 0.0;
			
			total += parseFloat($("#pptoDisponibleMes1").val());
			total += parseFloat($("#pptoDisponibleMes2").val());
			total += parseFloat($("#pptoDisponibleMes3").val());
			total += parseFloat($("#pptoDisponibleMes4").val());
			total += parseFloat($("#pptoDisponibleMes5").val());
			total += parseFloat($("#pptoDisponibleMes6").val());
			total += parseFloat($("#pptoDisponibleMes7").val());
			total += parseFloat($("#pptoDisponibleMes8").val());
			total += parseFloat($("#pptoDisponibleMes9").val());
			total += parseFloat($("#pptoDisponibleMes10").val());
			total += parseFloat($("#pptoDisponibleMes11").val());
			total += parseFloat($("#pptoDisponibleMes12").val());
			total =  Math.floor(total * 100) / 100;
			
			$("#pptoDisponibleTotal").val(total);
		}
		
		
	</tiles:putAttribute>
		
	<tiles:putAttribute name="ready"> 
	$('#presupuesto_op').addClass("active ");
	$('#presupuesto').addClass("collapse in");
	
	$('#partidas_op').addClass("active");
	
	
	
	
	$('#add').validate({
		 lang: 'es',
       submitHandler: function(form) {
          guardar(form);
        }
	});
	
	$('#cancelar').click(function(e) {
      e.preventDefault(); // Prevent the href from redirecting directly
      var linkURL = $(this).attr("href");
      cancelar(linkURL);
    });
	
	var empresa = $("#empresa");
	empresa.change(function(event){			
			
		$.getJSON("getNombreNivel", {
			idEmpresa : empresa.val()	
		}, function(nn) {				
			$("#nivel1Label").text(nn.nivel1);	
			$("#nivel2Label").text(nn.nivel2);	
			$("#nivel3Label").text(nn.nivel3);	
			$("#nivel4Label").text(nn.nivel4);
			if(nn.nivel5 == ""){
				$("#nivel5").hide();
			}else{
				$("#nivel5Label").text(nn.nivel5);
			}	
			
			if(nn.nivel6 == ""){
				$("#nivel6").hide();
				$("#nivel6Label").text("");
			}else{
				$("#nivel6Label").text(nn.nivel6);
			}
			if(nn.nivel7 == ""){
				$("#nivel7").hide();
				$("#nivel7Label").text("");
			}else{
				$("#nivel7Label").text(nn.nivel7);
			}
			if(nn.nivel8 == ""){
				$("#nivel8").hide();
				$("#nivel8Label").text("");
			}else{
				$("#nivel8Label").text(nn.nivel8);
			}
			if(nn.nivel9 == ""){
				$("#nivel9").hide();
				$("#nivel9Label").text("");
			}else{
				$("#nivel9Label").text(nn.nivel9);
			}
			if(nn.nivel10 == ""){
				$("#nivel10").hide();
				$("#nivel10Label").text("");
			}else{
				$("#nivel10Label").text(nn.nivel10);
			}	
			
			
				
			$("#nivel7Label").text(nn.nivel7);	
			$("#nivel8Label").text(nn.nivel8);	
			$("#nivel9Label").text(nn.nivel9);	
			$("#nivel10Label").text(nn.nivel10);	
								
		});
		
	});
	
	$("#distribuir").click(function(){
		var total = $("#pptoProgramadoTotal");
		if(total.val() != "" && total.val() > 0){
			var dist = total.val()/12;
			dist =  Math.floor(dist * 100) / 100;
			
			$("#pptoProgramado\\.mes1").val(dist);
			$("#pptoProgramado\\.mes2").val(dist);
			$("#pptoProgramado\\.mes3").val(dist);
			$("#pptoProgramado\\.mes4").val(dist);
			$("#pptoProgramado\\.mes5").val(dist);
			$("#pptoProgramado\\.mes6").val(dist);
			$("#pptoProgramado\\.mes7").val(dist);
			$("#pptoProgramado\\.mes8").val(dist);
			$("#pptoProgramado\\.mes9").val(dist);
			$("#pptoProgramado\\.mes10").val(dist);
			$("#pptoProgramado\\.mes11").val(dist);
			$("#pptoProgramado\\.mes12").val(dist);
			
			presupuestoDisponible();
		
		}
		
		//alert("Distribuir");
	});


	$(".pptoProg").change(function(){
		sumaPptoProgramado();
		presupuestoDisponible();	
	});
	
	$(".pptoComp").change(function(){
		sumaPptoComprometido();
		presupuestoDisponible();	
	});
	$(".pptoEjer").change(function(){
		sumaPptoEjercido();
		presupuestoDisponible();
	});
	
	
	</tiles:putAttribute>
	
	
	
	
	
</tiles:insertDefinition>