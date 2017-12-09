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
	        <div class="panel-heading">Nuevo Tipo de elemento</div>
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
    			
                         </div>
                    <br>
                    <form class="form-persona" name="nuevo" action="NuevoTipoElemento" method="post">
						<div class="col-lg-12">
                   			<div class="form-group">
                   		 		<label>Descripción</label>
                   				<input class="form-control" type="text"  name="descripcion" id="descripcion" >
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Maximo Pendiente</label>
                   				<input class="form-control" type="number"  name="max" id="max" >
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Dias Previos</label>
                   				<input class="form-control" type="number"  name="dias" id="dias"  >
                  			</div>
                  		</div>
                  		<button class="btn btn-success btn-block" type="submit"  >Guardar</button>
					</form>
                  	
                  	
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