<%@page import="entity.Persona"%>
<%@page import="entity.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="config/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="config/css/modern-business.css" rel="stylesheet" media="screen">

<title>Sistema de Reservas</title>
</head>
<body>

<%@include file="/pages/nav.jsp"%>

<!-- Page Content -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
      <h2 class="mt-4 mb-3">Usuario:   
        <small><%=((Persona)session.getAttribute("persona")).getUss()%> </small>
      </h2>
    <hr>
	<div class="row">
        <div class="col-lg-8 mb-8">
          <div class="card h-100">
            <h4 class="card-header">Reservas Pendientes</h4>
            <div class="card-body">
             	<table class="table table-hover">
            		<thead>
            			<tr>
            				 <th>#</th>
            				 <th>Fecha</th> 
            				 <th>Hora</th> 
            				 <th>Elemento</th> 
            				 <th>Estado</th>
            			</tr>
            		</thead> 
            		<tbody> 
            			<tr> 
            				<th scope="row">1</th> 
            				<td><%=((Reserva)session.getAttribute("respend"))%></td> 
            				<td>Otto</td> 
            				<td>@mdo</td>
            				<td>bbb</td> 
            				</tr> 
            			<tr>
            				<th scope="row">2</th> 
            				<td>Jacob</td> 
            				<td>Thornton</td>
            				<td>@fat</td> 
            				<td></td>
            			</tr> 
            		 </tbody> 
            		</table>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-success btn-block">Modificar Reservas</a>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">Datos Personales</h4>
            <div class="card-body">
            	<ul>
  					<li>Nombre: <%=((Persona)session.getAttribute("persona")).getNombre()%></li>
  					<li>Apellido: <%=((Persona)session.getAttribute("persona")).getApellido()%></li>
  					<li>Categoria: <%=((Persona)session.getAttribute("persona")).getCategoria().getDescripcion()%></li>
  					<li>DNI: <%=((Persona)session.getAttribute("persona")).getDni()%></li>
  				</ul> 
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-warning btn-block ">Modificar</a>
            </div>
          </div>
        </div>
     </div>
  </div>


<br>
<br>
<%@include file="/pages/foot.jsp"%>