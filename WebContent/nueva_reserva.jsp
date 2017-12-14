<%@page import="entity.TipoElemento"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/meta.jsp" %>
<title>Nueva Reserva</title>
<script>
$(function() {
    $( "fechaInicio" ).datepicker({ maxDate: '+0d' });

});
</script>
</head>
<body>
<%@ include file="/nav.jsp" %>
<!-- Page Content -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
	<h2 class="mt-4 mb-3">Nueva <small>Reserva</small></h2>
    <hr>
</div>

<div class="container">   
	<div class="row">
	 <div class="col-lg-8">
			<div class="panel panel-default">
	        <div class="panel-heading">Reservar Tipo de Elemento</div>
           		 <div class="panel-body">
                  <div class="row">
                  <form class="form-persona" name="nuevaReserva" action="NuevaReserva" method="post">
                        <div class="col-lg-12">
                        <%if(request.getAttribute("aviso")!=null){%>
    						<div class="alert alert-info">
        						<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
          
                               <%=request.getAttribute("aviso") %>
       						 </div> 
    						<%}%>
                        	<div class="form-group">
                        		<label>Tipo de elemento</label>
                        		 <select id="idTipo" name="idTipo" class="form-control">
  									<%	
  									ArrayList<TipoElemento> tipoe = (ArrayList<TipoElemento>)request.getAttribute("tipos");
           							for(TipoElemento t : tipoe){
           							%>
           							<option id="idTipo" name="idTipo" value="<%=t.getIdT()%>"><%=t.getDescripcion()%></option>
           								<%} %>
						</select>
                        	</div>
                        </div>
                    	<div class="col-lg-4">
                   			<div class="form-group">
                   		 		<label>Fecha</label>
                   				<input class="form-control" type="date"  name="fechaInicio" id="fechaInicio" value="" required="" >
                  			</div>
                  		</div>
                  		<div class="col-lg-4">
                  			<div class="form-group">
                   		 		<label>Hora Inicio</label>
                   				
                  				<select id="horaInicio" name="horaInicio" class="form-control">
                  				<%for(int i = 0; i<24;i++){%>
                  				<option id="horaInicio" name="horaInicio" value="<%=i%>"><%=i%>:00:00</option>	
                  				<%}%>
                  				
                  				</select>
                  			</div>
                  		</div>
                  		<div class="col-lg-4">
                  			<div class="form-group">
                   		 		<label>Cantidad de Horas</label>
                   				<select id="cantHoras" name="cantHoras" class="form-control">
                  				<%for(int i = 1; i<25;i++){%>
                  				<option id="cantHoras" name="cantHoras" value="<%=i%>"><%=i%> Horas</option>	
                  				<%}%>
                  				
                  				</select>
                   				
                   			</div>
                  		</div>
                  		<div class="col-lg-12">
                  		<button class="btn btn-info btn-block" type="submit" >Siguiente</button>
                  		</div>
                  		</form>
                        </div>
                    <br>
                   </div>
                 </div>
               </div>
             </div>
</div>
 
<%@include file="/foot.jsp"%>
</body>
</html>