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
	 <div class="col-lg-10">
			<div class="panel panel-default">
	        <div class="panel-heading">Modifica Tipo de elemento</div>
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
    					 
    					<div class="col-lg-12">
    						<div class="form-group">
                        		
                        		
                        		<table class="table table-hover ">
            						<thead>
            							<tr>
            							 <th>Tipo Elemento</th>
            							  
            							 <th>Maximo Pendiente</th>
            							 <th>Dias Previos</th>  
            							 <th></th>
            							</tr>
            						</thead> 
            					<tbody>  
  									<%	
  									ArrayList<TipoElemento> tipoe = (ArrayList<TipoElemento>)request.getAttribute("tipos");
           							for(TipoElemento t : tipoe){
           							%>
           							<form class="form-persona" name="idTipo" action="ModificaTipoElemento" method="post">
           							<input class="form-control" type="text" name="id" id="id" value="<%=t.getIdT()%>" hidden>
           							<tr> 
            							<td><input class="form-control" type="text" name="desc" id="desc" value="<%=t.getDescripcion()%>"></td>
            							<td><input class="form-control" type="text" name="cant" id="cant" value="<%=t.getCantMax()%>"></td> 
            							<td><input class="form-control" type="text" name="dias" id="dias" value="<%=t.getDiasMaxAnt()%>"></td> 
            							<td><button type="submit" class="btn btn-outline btn-warning btn-xs">Modificar</button></td>
            						</tr>
           							</form>
           							<%} %>
							
							</tbody>
							</table>
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