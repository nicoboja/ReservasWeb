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
        <div class="col-lg-6 mb-6">
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

    	<div class="col-lg-6">
    	<div class="col-lg-12">
			<div class="panel panel-default">
	        <div class="panel-heading">Busqueda Persona</div>
           		 <div class="panel-body">
                    <div class="row">
                    <form class="form-persona" name="dni" action="/ReservasWeb/persona" method="post">
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
               <div class="row">
                	<div class="col-lg-6">
                	<%if(session.getAttribute("perform")!=null){
                		Persona p = new Persona();
                		p = ((Persona)session.getAttribute("perform"));
                	%>	
                	<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number"  name="dni" id="dni" disabled="" 
                          	value="">
                	<% }else{ %>
                	
                	
                	
                	
                	
                		<div class="form-group">
                          <label>DNI</label>
                          	<input class="form-control" type="number"  name="dni" id="dni" disabled="" 
                          	>
                          	
                        </div>
                        <div class="form-group">
                          <label>Nombre</label>
                          	<input class="form-control" type="text" name="nombre" id="nombre">
                        </div>
                        <div class="form-group">
                          <label>Apellido</label>
                          	<input class="form-control" type="text" name="apellido" id="apellido" >
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
  						
						</select>
					</div>
			<%}%>		

		<div class="form-group">
					<br>
					<button class="btn btn-success btn-block" >Guardar</button>
					</div>
                       
                    </div>
                    </div>
                </div>
                </div>    	
			</div>
			
		</div><!-- DiV 6 -->
		
	</div>
</div>

<br>
<%@include file="../pages/foot.jsp"%>