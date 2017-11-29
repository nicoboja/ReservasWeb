<%@page import="entity.Persona"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../pages/meta.jsp"%>
<title>Sistema de Reservas</title>
</head>
<body>
<%@include file="../pages/nav.jsp"%>
<!-- Page Content -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
	<h2 class="mt-4 mb-3">Gestion <small>de Personas </small></h2>
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
            				 <th>Estado</th>
            				 <th></th>
            			</tr>
            		</thead> 
            		<tbody> 
           		<% 
           		ArrayList<Persona> listaPer = (ArrayList<Persona>)request.getAttribute("listaper");
           		for(Persona p : listaPer){
           		%>
            			<tr> 
            				<th scope="row"><%=p.getId()%></th> 
            				<td><%=p.getDni()%></td> 
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

<br>
<%@include file="../pages/foot.jsp"%>