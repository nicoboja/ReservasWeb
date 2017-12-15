<%@page import="entity.Persona"%>
<%@page import="entity.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/meta.jsp" %>



<title>Sistema de Reservas</title>
</head>
<body>
<%@include file="/nav.jsp"%>
<!-- Page Content -->
<div class="container">
<!-- Page Heading/Breadcrumbs -->
      <h2 class="mt-4 mb-3">UPS!     
        <small> Algo mal sucedio..</small>
      </h2>
    <hr>
</div>
<div class="container">   
<div class="col-lg-12">
                        <%if(request.getAttribute("aviso")!=null){%>
    						<div class="alert alert-danger">
        						<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
          
                               <%=request.getAttribute("aviso") %>
       						 </div> 
    						<%}%>
    						</div>
</div>
<br>
<br>
<br>
<br><br>
<br><br>
<br>

<%@include file="/foot.jsp"%>
</body>

</html>