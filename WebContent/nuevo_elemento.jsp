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
	        <div class="panel-heading">Nuevo Elemento</div>
           		 <div class="panel-body">
                  <div class="row">
                  <form class="form-persona" name="nuevoElemento" action="NuevoElemento" method="post">
                        <div class="col-lg-12">
                        <%if(request.getAttribute("aviso")!=null){%>
    						<div class="alert alert-info">
        						<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
          
                               <%=request.getAttribute("aviso") %>
       						 </div> 
    						<%}%>
                        	<div class="form-group">
                        		<label>Tipo de elemento</label>
                        		 <select id="idTipo" name="idTipo" class="form-control">
  									<%	
  									ArrayList<TipoElemento> tipoe = (ArrayList<TipoElemento>)request.getAttribute("tipos");
           							for(TipoElemento t : tipoe){
           							%>
           							<option id="idTipo" name="idTipo" value="<%=t.getIdT()%>"><%=t.getDescripcion()%></option>
           								<%} %>
						</select>
                        	</div>
                        </div>
                    	<div class="col-lg-6">
                   			<div class="form-group">
                   		 		<label>Nombre</label>
                   				<input class="form-control" type="text"  name="nom_elem" id="nom_elem" value="" required="" >
                  			</div>
                  		</div>
                  		<div class="col-lg-6">
                  			<div class="form-group">
                   		 		<label>Descripción</label>
                   				<input class="form-control" type="text"  name="desc" id="desc" value="" required="">
                  			</div>
                  		</div>
                  		<div class="col-lg-12">
                  		<button class="btn btn-success btn-block" type="submit" >Nuevo</button>
                  		</div>
                  		</form>
                        </div>
                    <br>
                   </div>
                 </div>
               </div>
             </div>
</div>
 
<%@include file="/foot.jsp"%>
</body>
</html>