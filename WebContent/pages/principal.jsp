<%@page import="entity.Persona"%>
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
      <h2 class="mt-4 mb-3">Inicio |
        <small><%=((Persona)session.getAttribute("persona")).getNombre()%> <%=((Persona)session.getAttribute("persona")).getApellido()%></small>
      </h2>
      
	<div class="row">
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">Reservas Pendientes</h4>
            <div class="card-body">
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Learn More</a>
            </div>
          </div>
        </div>
        <div class="col-lg-6 mb-6">
          <div class="card h-100">
            <h4 class="card-header">Historial de Reservas</h4>
            <div class="card-body">
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis ipsam eos, nam perspiciatis natus commodi similique totam consectetur praesentium molestiae atque exercitationem ut consequuntur, sed eveniet, magni nostrum sint fuga.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Learn More</a>
            </div>
          </div>
        </div>


<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="/pages/foot.jsp"%>