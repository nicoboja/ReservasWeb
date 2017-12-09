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
      <h2 class="mt-4 mb-3">INICIO  |   
        <small> Usuario: <%=((Persona)session.getAttribute("usuario")).getUss()%> </small>
      </h2>
    <hr>
</div>
<div class="container">   
	<div class="row">
        <div class="col-lg-8 mb-8">
          <div class="card h-100">
            <h4 class="card-header">Reservas Pendientes</h4>
            <div class="card-body">
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
            				<th scope="row"><%=r.getId()%></th> 
            				<td><%=r.getFecha()%></td> 
            				<td><%=r.getHora()%></td> 
            				<td ><%=r.getElem().getNombre()%></td>
            				<td ><%=r.getElem().getDescrip()%></td>
            				<td><%=r.getEstado() %></td>
            				<td><%if(!r.getEstado().equals("Cancelado")){%>
            			
            				<%}%></td>
            			</tr> 
					<%} %>
					</tbody> 
            		</table>
			</div>
          
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">Datos Personales</h4>
            <div class="card-body">
            	<ul>
  					<li>Nombre: <%=((Persona)session.getAttribute("usuario")).getNombre()%></li>
  					<li>Apellido: <%=((Persona)session.getAttribute("usuario")).getApellido()%></li>
  					<li>Categoria: <%=((Persona)session.getAttribute("usuario")).getCategoria().getDescripcion()%></li>
  					<li>DNI: <%=((Persona)session.getAttribute("usuario")).getDni()%></li>
  				</ul> 
            </div>
           
          </div>
        </div>
     </div>
  </div>



<%@include file="/foot.jsp"%>
</body>

</html>