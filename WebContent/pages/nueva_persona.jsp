<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="entity.Persona"%>
<%@page import="entity.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../config/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../config/bootstrap/css/bootstrap2.css" rel="stylesheet" media="screen">
<link href="../config/css/modern-business.css" rel="stylesheet" media="screen">
<title>Sistema de Reservas</title>
</head>
<body>
<%@include file="/pages/nav.jsp"%>
<!-- Page Content -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
	<h2 class="mt-4 mb-3">Gestion <small>de Personas </small></h2>
    <hr>
</div>

<div class="container">   
	<div class="row">
       <div class="col-lg-12">
			<div class="panel panel-default">
	        <div class="panel-heading">Busqueda Persona</div>
           		 <div class="panel-body">
                    <div class="row">
                    <form class="form-persona" name="dni" action="/ReservasWeb/Gestiona/buscar_dni" method="get">
                        	 <div class="col-lg-12">
                        	 	<label>Ingrese DNI</label>
        	           		 	<div class="input-group">
                       		 		<input class="form-control input-sm" type="number"  name="dni" id="dni" autofocus>
                           			<span class="input-group-btn">
                           			<button type="submit" class="btn btn-info btn-sm">Buscar</button>  </a>	
                           			</span>
                          		 </div>
                          	 </div>
                     </form> 
                     
                     <br>   
                     </div>
               <% if (request.getAttribute("nuevaper")==null) { %>      
               <div class="row">
              
                	<div class="col-lg-6">
                		<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number"  name="dni" id="dni" disabled="" >
                          	
                        </div>
                        <div class="form-group">
                          <label>Nombre</label>
                          	<input class="form-control" type="text" name="nombre" id="nombre" disabled="" >
                        </div>
                        <div class="form-group">
                          <label>Apellido</label>
                          	<input class="form-control" type="text" name="apellido" id="apellido" disabled="" >
                        </div>
                        <div class="form-group">
                          	<label>Estado</label>
                            	<div class="checkbox">
                                   <label>
                                     <input type="checkbox" value="admin">Habilitado
                                   </label>
                                </div>
                                </div>
                    </div>
                    <div class="col-lg-6">
                		<div class="form-group">
                          <label>Usuario</label>
                          	<input class="form-control" type="text" name="usuario" id="usuario" >
                        </div>
                        <div class="form-group">
                          <label>Contraseña</label>
                          	<input class="form-control" type="password" name="pass" id="pass" >
                        </div>
                        <div class="form-group">
                        <label>Categoria</label>
                          <select class="form-control">
  						<%	ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
           					for(Categoria c : categorias){
           				%>
           				<option><%=c.getDescripcion() %></option>
           				<%} %>
						</select>
					</div>
		

					<div class="form-group">
					<br>
						<button class="btn btn-success btn-block" disabled >Guardar</button>
					</div>
                       
                    </div>
                    </div>
                </div>
               <%}else{ %>
               <div class="row">
               
                	<div class="col-lg-6">
                		<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number"  name="dni" id="dni" disabled="" value="<%=session.getAttribute("nuvaper")%>">
                          	
                        </div>
                        <div class="form-group">
                          <label>Nombre</label>
                          	<input class="form-control" type="text" name="nombre" id="nombre" value="%>">
                        </div>
                        <div class="form-group">
                          <label>Apellido</label>
                          	<input class="form-control" type="text" name="apellido" id="apellido" value="" >
                        </div>
                        <div class="form-group">
                          	<label>Estado</label>
                            	<div class="checkbox">
                                   <label>
                                     <input type="checkbox" value="admin"  checked>Habilitado
                                   </label>
                                </div>
                                </div>
                    </div>
                    <div class="col-lg-6">
                		<div class="form-group">
                          <label>Usuario</label>
                          	<input class="form-control" type="text" name="usuario" id="usuario" value="" >
                        </div>
                        <div class="form-group">
                          <label>Contraseña</label>
                          	<input class="form-control" type="password" name="pass" id="pass" value="">
                        </div>
                        <div class="form-group">
                        <label>Categoria</label>
                          <select class="form-control">
  						<%	ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
           					for(Categoria c : categorias){
           				%>
           				<option value="<%=c.getDescripcion() %>" <%if(((Persona)session.getAttribute("perdni")).getCategoria().getDescripcion().equals(c.getDescripcion()) ){%>selected<% } %>><%=c.getDescripcion() %></option>
           				<%} %>
						</select>
					</div>
		

					<div class="form-group">
					<br>
						<button class="btn btn-warning btn-block" >Modificar</button>
					</div>
                       
                    </div>
                    </div>
                </div>
               
               <%} %>
                </div>    	
			</div>
			
		</div><!-- DiV 6 -->
		

    			
	</div>
</div>

<br>
<!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Java UTNFRRO &copy; Alessandri - Bojanich</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="../config/jquery/jquery.min.js"></script>
    <script src="../config/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>