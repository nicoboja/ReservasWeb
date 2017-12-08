<%@page import="entity.Elemento"%>
<%@page import="entity.TipoElemento"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/meta.jsp" %>
<title>Elemento | eliminar</title>
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
	 <div class="col-lg-10">
			<div class="panel panel-default">
	        <div class="panel-heading">Elimina Elemento</div>
           		 <div class="panel-body">
                  <div class="row">
                 
                        <div class="col-lg-12">
                        <%if(request.getAttribute("aviso")!=null){%>
    						<div class="alert alert-info">
        						<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
          
                               <%=request.getAttribute("aviso") %>
       						 </div> 
    						<%}%>
                        	
                        </div>
                 
                <%if(request.getAttribute("listaelem")!=null){ %> 
             	<table class="table table-hover ">
            		<thead>
            			<tr>
            				 <th>Tipo Elemento</th>
            				 <th>Nombre</th> 
            				 <th>Descripcion</th> 
            				 <th></th>
            			</tr>
            		</thead> 
            		<tbody> 
            		<%ArrayList<entity.Elemento> listaElem = (ArrayList<entity.Elemento>)request.getAttribute("listaelem");
           				for(Elemento e : listaElem){
           			%>
           			<form class="form-persona" name="modifica" action="ModificaElemento" method="post">
                  	<input class="form-control" type="text" name="idE" id="idE" value="<%=e.getId()%>" hidden>
                  	       	
                  	<tr> 
            			<th><%=e.getTipoElem().getDescripcion()%></th> 
            			<td><input class="form-control" type="text" name="nom" id="nombre" value="<%=e.getNombre()%>"></td> 
            			<td><input class="form-control" type="text" name="desc" id="desc" value="<%=e.getDescrip()%>"></td> 
            			<td><button type="submit" class="btn btn-outline btn-warning btn-xs">Modificar</button></td>
            		</tr>
            		</form>
            		<%} %>
            		</tbody>
            		</table>
            		
                  	<%} %>
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