<%@page import="entity.Persona"%>
<%@page import="entity.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/meta.jsp" %>
<title>Listado de Personas</title>
</head>
<body>
<%@ include file="/nav.jsp" %>
<!-- Page Content -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
	<h2 class="mt-4 mb-3">Gestion <small>de Personas </small></h2>
    <hr>
</div>

<div class="container">   
	<div class="row">
        <div class="col-lg-12 mb-12">
          <div class="card h-100">
            <h4 class="card-header">Listado de Personas</h4>
            <div class="card-body">
             	<table class="table table-hover ">
            		<thead>
            			<tr>
            				 <th>DNI</th>
            				 <th>Usuario</th> 
            				 <th>Nombre</th> 
            				 <th>Apellido</th> 
            				 <th>Categoria</th>
            				 <th></th>
            			</tr>
            		</thead> 
            		<tbody> 
           		<% 
           		ArrayList<Persona> listaPer = (ArrayList<Persona>)request.getAttribute("listaper");
           		for(Persona p : listaPer){
           		%>
            			<tr> 
            				<th scope="row"><%=p.getDni()%></th> 
            				<td><%=p.getUss()%></td> 
            				<td><%=p.getNombre()%></td> 
            				<td ><%=p.getApellido()%></td>
            				<td><%=p.getCategoria().getDescripcion()%></td>
            				<td>
            				<button type="button" class="btn btn-outline btn-warning btn-xs">Modificar</button>
            				</td>
            			</tr> 
            			<%}%>
            		 </tbody> 
            		</table>
            </div>	
            </div>
            </div>	

    			
	</div>
</div>

<br>

<%@include file="/foot.jsp"%>
</body>
</html>