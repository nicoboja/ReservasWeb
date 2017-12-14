<%@page import="entity.Persona"%>
<%@page import="entity.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/meta.jsp" %>



<title>Sistema de Reservas</title>
</head>
<body>
<%@include file="/nav.jsp"%>
<!-- Page Content -->
<div class="container">
<!-- Page Heading/Breadcrumbs -->
      <h2 class="mt-4 mb-3">Cancelar   
        <small>Reservas</small>
      </h2>
    <hr>
</div>
<div class="container">   
	<div class="row">
        <div class="col-lg-12 mb-12">
          <div class="panel panel-default">
	        <div class="panel-heading">Cancelar Reserva</div>
           		 <div class="panel-body">
                  <div class="row">
                  
                  <%if(request.getAttribute("aviso")!=null){%>
    						<div class="alert alert-info">
        						<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
          
                               <%=request.getAttribute("aviso") %>
       						 </div> 
    						<%}%>
             	<table class="table table-hover ">
            		<thead>
            			<tr>
            				 <th>ID</th>
            				 <th>Fecha</th> 
            				 <th>Hora</th> 
            				 <th>Elemento</th>
            				 <th>Descripcion</th> 
            				 <th>Estado</th>
            				 <th></th>
            			</tr>
            		</thead> 
         			<tbody> 

            		<% ArrayList<Reserva> listaRes = (ArrayList<Reserva>)request.getAttribute("listares");
            		for(Reserva r : listaRes){%>
            		<tr <%if(r.getEstado().equals("Cancelado")){%>
            				class="warning" 
            				<%}%>> 
            				<form class="form" name="cancelarReserva" action="CancelarReserva" method="post">
            				<input class="form-control" type="number"  name="idRes" id="idRes" value="<%=r.getId()%>" hidden>
            				
            				<th scope="row"><%=r.getId()%></th> 
            				<td><%=r.getFecha()%></td> 
            				<td><%=r.getHora()%></td> 
            				<td ><%=r.getElem().getNombre()%></td>
            				<td ><%=r.getElem().getDescrip()%></td>
            				<td><%=r.getEstado() %></td>
            				<td><%if(!r.getEstado().equals("Cancelado")){%>
            				<button type="submit" class="btn btn-outline btn-warning btn-xs">Cancelar</button>
            				</td>
            				</form>
            				<%}%>
            			</tr> 
					<%} %>
					</tbody> 
            		</table>
			</div>
          
          </div>
        </div>
 </div>
     </div>
  </div>



<%@include file="/foot.jsp"%>
</body>

</html>