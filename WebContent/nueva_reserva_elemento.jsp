<%@page import="entity.Elemento"%>
<%@page import="entity.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/meta.jsp" %>
<title>Nueva Reserva</title>
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
	<div class="col-lg-6">
                   			<div class="form-group">
                   		 		<p><label>Fecha de Reserva:</label> <%=((Reserva)request.getAttribute("datosR")).getFecha() %></p>
                   		 		<p><label>Hora de Inicio: </label> <%=((Reserva)request.getAttribute("datosR")).getHora() %></p>
                   		 		<p><label>Cantidad de Horas: </label > <%=((Reserva)request.getAttribute("datosR")).getCantHoras() %></p>
							</div>
                  		</div>
	 <div class="col-lg-10">
			<div class="panel panel-default">
			
	        <div class="panel-heading">Elementos disponbles a Reservar</div>
           		 <div class="panel-body">
                  <div class="row">
                 
                        <div class="col-lg-12">
                        <%if(request.getAttribute("aviso")!=null){%>
    						<div class="alert alert-info">
        						<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
          						<%=request.getAttribute("aviso") %>
       						 </div> 
    					<%}%>
    					 <form class="form-persona" name="nuevaReserva" action="NuevaReserva" method="post">
                        	<div class="form-group">
                        		<input type="hidden" name="fechaR" id="fechaR" value="<%=((Reserva)request.getAttribute("datosR")).getFecha() %>">
                        		<input type="hidden" name="horaI" id="horaI" value="<%=((Reserva)request.getAttribute("datosR")).getHora() %>">
                        		<input type="hidden" name="cantH" id="cantH" value="<%=((Reserva)request.getAttribute("datosR")).getCantHoras() %>">
                        		<div class="col-lg-8">
                   				<div class="form-group">
                        		<label>Detalle </label>
                        		<input type="text" class="form-control" name="detalle" id="detalle" value="" placeholder="Ingrese un detalle de la reserva ">
                        		</div>
                        		</div>
                        		<div class="col-lg-11">
                   				<div class="form-group">
                        		<label>Seleccione un elemento disponible </label>
                        		<select id="idE" name="idE" multiple class="form-control">
                        		 	<%	
  									if(request.getAttribute("elementos")!=null){
  									ArrayList<Elemento> elem = (ArrayList<Elemento>)request.getAttribute("elementos");
           							for(Elemento e : elem){
           							%>
                        		 	<option id="idE" name="idE" value="<%=e.getId()%>"><%=e.getNombre()%></option>
           							<%}}%>
								 	 
  								</select>
                        	</div>
                        </div>
                        </div>
                        </div>
                       	<div class="col-lg-12">
                  		<button class="btn btn-success btn-block" type="submit" >Reservar</button>
                  		</form>
                  		</div>
                  		
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