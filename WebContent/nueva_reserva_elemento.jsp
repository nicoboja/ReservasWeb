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
                   		 		<p><label>Fecha de Reserva:</label> 2017-12-12</p>
                   		 		<p><label>Hora de Inicio: </label> 2017-12-12</p>
                   		 		<p><label>Cantidad de Horas: </label> 2017-12-12</p>
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
                        		<select id="idElemento" name="idElemento" multiple class="form-control">
                        		 	<option>1</option>
								 	 <option>2</option>
									  <option>3</option>
								 	 <option>4</option>
									  <option>5</option>
  								</select>
                        	</div>
                        </div>
                       
                    	
                  	
                  		<div class="col-lg-12">
                  		<button class="btn btn-info btn-block" type="submit" >Siguiente</button>
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