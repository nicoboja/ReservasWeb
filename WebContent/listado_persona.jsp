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
	 <div class="col-lg-6">
			<div class="panel panel-default">
	        <div class="panel-heading">Busqueda Persona</div>
           		 <div class="panel-body">
                  <div class="row">
                    <!--Form-->
                    <form class="form-persona" name="dni" action="Persona" method="get">
                        <div class="col-lg-6">
                        	 	<label>Ingrese DNI</label>
        	           		    <div class="input-group">
                       		 		<input class="form-control input-sm" type="number"  name="dni" id="dni" autofocus>
                           			<span class="input-group-btn">
                           			  <button type="submit" class="btn btn-info btn-sm">Buscar</button>	
                           			</span>
                          	</div>
                        </div>
                     </form>
                     <!--/Form-->
                <%if(session.getAttribute("existedni")!=null){%>
                <!-- EXISTE DNI -->
                <%@ include file="/existepersona.jsp" %>
                

                <!--  #### -->
                <%  } %>
                <%if(session.getAttribute("nuevodni")!=null){%>
                <!-- NUEVO DNI -->
                <%@ include file="/nuevapersona.jsp" %>

                <!--  #### -->
                <%  } %>
                <%if(session.getAttribute("existedni")==null&&session.getAttribute("nuevodni")==null){%>
                <!-- NUEVO DNI --> 

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
                    <div class="checkbox" disabled="">
                      <label><input type="checkbox" value="admin" disabled="">Habilitado</label>
                    </div>
                  </div>

                </div><!--/col6-->

                <div class="col-lg-6">
                	<div class="form-group">
                    <label>Usuario</label>
                    <input class="form-control" type="text" name="usuario" id="usuario" disabled="">
                  </div>

                  <div class="form-group">
                    <label>Contraseña</label>
                      <input class="form-control" type="password" name="pass" id="pass" disabled="">
                  </div>

                  <div class="form-group">
                    <label>Categoria</label>
                    <select class="form-control">

  						      <%	
                     ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
           				   for(Categoria c : categorias){
           			    	%>
           			  	<option disabled=""><%=c.getDescripcion() %></option>
           				 <%} %>
						         </select>
					       </div>
                 <div class="form-group">
					        <br>
						      <button class="btn btn-success btn-block" disabled >Guardar</button>
					       </div>
                       
                </div><!--Col 6-->
                <%  } %>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
         <div class="panel panel-default">
          <div class="panel-heading">Listado de Personas</div>
               <div class="panel-body">
                  <div class="row">
				
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
           		<form class="form-persona" name="dni" action="Persona" method="get">
           		<input class="form-control" type="number"  name="dni" id="dni" hidden value="<%=p.getDni()%>" >
            			<tr> 
            				<th scope="row"><%=p.getDni()%></th> 
            				<td><%=p.getUss()%></td> 
            				<td><%=p.getNombre()%></td> 
            				<td ><%=p.getApellido()%></td>
            				<td><%=p.getCategoria().getDescripcion()%></td>
            				<td>
            				<button type="submit" class="btn btn-outline btn-warning btn-xs">Modificar</button>
            				</td>
            			</tr>
            			</form>
            			<%}%>
            			
            		 </tbody> 
            		</table>
            </div>	
            </div>
            </div>	

    	</div>		
	</div>
</div>

<br>

<%@include file="/foot.jsp"%>
</body>
</html>