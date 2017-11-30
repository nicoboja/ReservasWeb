<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Reservas</title>
<script>
<% if (request.getAttribute("uss")==null) { request.getSession().setAttribute("error", null);%> 
    window.location.href = "/ReservasWeb/login.jsp"
<%}else{%>
	window.location.href = "/ReservasWeb/home.jsp"
<%}%>
</script>
</head>
<body>
	IR <a href="/home.jsp">INICIO</a>
</body>
</html>