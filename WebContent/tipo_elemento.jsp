<%@page import="entity.TipoElemento"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/meta.jsp" %>
<title>Tipo Elemento</title>
</head>
<body>
<%@ include file="/nav.jsp" %>
<!-- Page Content -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
	<h2 class="mt-4 mb-3">Gestion <small>de Elementos </small></h2>
    <hr>
</div>

<div class="container">   
	<div class="row">
	 <div class="col-lg-6">
			<div class="panel panel-default">
	        <div class="panel-heading">Tipo de elemento</div>
           		 <div class="panel-body">
                  <div class="row">
                   <!--Form-->
                  
                        <div class="col-lg-12">
                        <%if(request.getAttribute("aviso")!=null){%>
    						<div class="alert alert-info">
        					<button type="button" class="close" data-dismiss="info" aria-hidden="true"></button>
          
                               <%=request.getAttribute("aviso")%>
       						 </div> 
    					<%}%>
    					 <form class="form-persona" name="idTipo" action="TipoElementos" method="get">
    					<div class="col-lg-6">
    						<div class="form-group">
                        		<label>Tipo de elemento</label>
                        		 <select id="idTipo" name="idTipo" class="form-control" >
  								  									<%	
  									ArrayList<entity.TipoElemento> tipoe = (ArrayList<entity.TipoElemento>)request.getAttribute("tipos");
           							for(entity.TipoElemento t : tipoe){
           							%>
           							<option id="idTipo" name="idTipo" value="<%=t.getIdT()%>" <% if(request.getAttribute("nuevo")!=null){ %>disabled<%} %>><%=t.getDescripcion()%></option>
           								<%} %>
  									
								</select>
							</div>
						</div>
						<div class="col-lg-3">
						<br>
						<button type="submit" class="btn btn-info btn-sm">Seleccionar</button>	
						</div>
						</form>
						
						<div class="col-lg-1">
						<br>
						 <form class="form-persona" name="idTipo" action="TipoElementos" method="get">
						<input class="form-control input-sm" type="text"  name="idTipo" id="idTipo" value="Nuevo" hidden>
						<button type="submit" class="btn btn-success btn-sm">Nuevo</button>	
						</form>
						</div>
						</div>
                         
                      
                      
                        </div>
                    <br>
                    <%if( request.getAttribute("te")==null && request.getAttribute("nuevo")==null){ %>	
                        <div class="col-lg-6">
                        	<div class="form-group">
                        		<label>Id Tipo Elemento</label>
                        		<input class="form-control input-sm" type="number"  name="i" id="i" disabled>
                        	</div>
                        </div>
                    	<div class="col-lg-6">
                   			<div class="form-group">
                   		 		<label>Descripción</label>
                   				<input class="form-control" type="text"  name="descripcion" id="descripcion" disabled>
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Maximo Pendiente</label>
                   				<input class="form-control" type="number"  name="max" id="max" disabled>
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Dias Previos</label>
                   				<input class="form-control" type="number"  name="dias" id="dias" disabled >
                  			</div>
                  		</div>
                  		<button class="btn btn-success btn-block" type="submit"  disabled>Guardar</button>
                  	<%} %>	
                  	
                  	<%if(request.getAttribute("modifica")!=null){ %>	
                    	
                    	<form class="form-persona" name="idTipo" action="TipoElementos" method="post">
                        <div class="col-lg-6">
                        	<div class="form-group">
                        		<label>Id Tipo Elemento</label>
                        		<input class="form-control input-sm" type="number"  name="i" id="i" disabled value="<%=((TipoElemento)request.getAttribute("tipo")).getIdT()%>">
                        		<input class="form-control input-sm" type="number"  name="idTform" id="idTform" hidden value="<%=((TipoElemento)request.getAttribute("tipo")).getIdT() %>">
                        	</div>
                        </div>
                    	<div class="col-lg-6">
                   			<div class="form-group">
                   		 		<label>Descripción</label>
                   				<input class="form-control" type="text"  name="descripcion" id="descripcion" value="<%=((TipoElemento)request.getAttribute("tipo")).getDescripcion()%>" >
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Maximo Pendiente</label>
                   				<input class="form-control" type="number"  name="max" id="max" value="<%=((TipoElemento)request.getAttribute("tipo")).getDiasMaxAnt()%>">
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Dias Previos</label>
                   				<input class="form-control" type="number"  name="dias" id="dias" value="<%=((TipoElemento)request.getAttribute("tipo")).getDiasMaxAnt()%>" >
                  			</div>
                  		</div>
                  		<button class="btn btn-warning btn-block" type="submit" >Modificar</button>
                  		</form>
                  		<%} %>
                  		
                  		<%if(request.getAttribute("nuevo")!=null){ %>	
                    	<form class="form-persona" name="idTipo" action="TipoElementos" method="post">
                        <div class="col-lg-6">
                        	<div class="form-group">
                        		<label>Id Tipo Elemento</label>
                        		<input class="form-control input-sm" type="number"  name="i" id="i" disabled " >
                        		</div>
                        </div>
                    	<div class="col-lg-6">
                   			<div class="form-group">
                   		 		<label>Descripción</label>
                   				<input class="form-control" type="text"  name="descripcion" id="descripcion" value="" >
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Maximo Pendiente</label>
                   				<input class="form-control" type="number"  name="max" id="max" value="">
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Dias Previos</label>
                   				<input class="form-control" type="number"  name="dias" id="dias" value="" >
                  			</div>
                  		</div>
                  		<button class="btn btn-success btn-block" type="submit" >Nuevo</button>
                  		</form>
                  		<%} %>
                  		
                  	</div> 
                  </div> 
                 </div>
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