<%@page import="entity.TipoElemento"%>
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
                        <%if(session.getAttribute("aviso")!=null){%>
    						<div class="alert alert-info">
        					<button type="button" class="close" data-dismiss="info" aria-hidden="true"></button>
          
                               <%=session.getAttribute("aviso")%>
       						 </div> 
    					<%}%>
                          <form class="form-persona" name="idTipo" action="Elemento" method="get">
                        	 	<label>Buscar ID</label>
        	           		    <div class="input-group">
                       		 		<input class="form-control input-sm" type="number"  name="idTipo" id="iTipo" autofocus>
                           			<span class="input-group-btn">
                           			  <button type="submit" class="btn btn-info btn-sm">Buscar</button>	
                           			</span>
                          </form>
                        </div>
                    <br>
                    <%if( session.getAttribute("tipo")==null && session.getAttribute("nuevo")==null){ %>	
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
                  	
                  	<%if(session.getAttribute("tipo")!=null && session.getAttribute("nuevo")==null){ %>	
                    	<form class="form-persona" name="idTipo" action="Elemento" method="post">
                        <div class="col-lg-6">
                        	<div class="form-group">
                        		<label>Id Tipo Elemento</label>
                        		<input class="form-control input-sm" type="number"  name="i" id="i" disabled value="<%=((TipoElemento)session.getAttribute("tipo")).getIdT()%>">
                        		<input class="form-control input-sm" type="number"  name="idTform" id="idTform" hidden value="<%=((TipoElemento)session.getAttribute("tipo")).getIdT() %>">
                        	</div>
                        </div>
                    	<div class="col-lg-6">
                   			<div class="form-group">
                   		 		<label>Descripción</label>
                   				<input class="form-control" type="text"  name="descripcion" id="descripcion" value="<%=((TipoElemento)session.getAttribute("tipo")).getDescripcion()%>" >
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Maximo Pendiente</label>
                   				<input class="form-control" type="number"  name="max" id="max" value="<%=((TipoElemento)session.getAttribute("tipo")).getDiasMaxAnt()%>">
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Dias Previos</label>
                   				<input class="form-control" type="number"  name="dias" id="dias" value="<%=((TipoElemento)session.getAttribute("tipo")).getDiasMaxAnt()%>" >
                  			</div>
                  		</div>
                  		<button class="btn btn-warning btn-block" type="submit" >Modificar</button>
                  		</form>
                  		<%} %>
                  		
                  		<%if(session.getAttribute("tipo")==null && session.getAttribute("nuevo")!=null){ %>	
                    	<form class="form-persona" name="idTipo" action="Elemento" method="post">
                        <div class="col-lg-6">
                        	<div class="form-group">
                        		<label>Id Tipo Elemento</label>
                        		<input class="form-control input-sm" type="number"  name="i" id="i" disabled " >
                        		<input class="form-control input-sm" type="number"  name="idTform" id="idTform" hidden value="<%=session.getAttribute("nuevo")%>">
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
                  		<button class="btn btn-sussess btn-block" type="submit" >Nuevo</button>
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