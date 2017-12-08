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
	        <div class="panel-heading">Modificar Elemento</div>
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
                          <form class="form-persona" name="idTipo" action="TipoElementos" method="get">
                        	 	<label>Buscar ID</label>
        	           		    <div class="input-group">
                       		 		<input class="form-control input-sm" type="number"  name="idTipo" id="iTipo" autofocus>
                           			<span class="input-group-btn">
                           			  <button type="submit" class="btn btn-info btn-sm">Buscar</button>	
                           			</span>
                           		</div>
                          </form>
                        </div>
                    <br>
                   </div>
                 </div>
               </div>
             </div>
            <div class="col-lg-6">
			<div class="panel panel-default">
	        <div class="panel-heading">Nuevo Elemento</div>
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
                          <form class="form-persona" name="idTipo" action="TipoElementos" method="get">
                        	 	<label>Buscar ID</label>
        	           		    <div class="input-group">
                       		 		<input class="form-control input-sm" type="number"  name="idTipo" id="iTipo" autofocus>
                           			<span class="input-group-btn">
                           			  <button type="submit" class="btn btn-info btn-sm">Buscar</button>	
                           			</span>
                           		</div>
                          </form>
                        </div>
                    <br>
                   </div>
                 </div>
               </div>
             </div>
             
             
             
             
          </div>
        </div>    

</body>
</html>