<%@page import="entity.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../jspf/meta.jsp"%>

<title>Sistema de Reservas</title>
</head>
<body>

<%@include file="/jspf/nav.jsp"%>

<br>
<br>

<h1>Bienvenido <%=((Persona)session.getAttribute("persona")).getNombre()%></h1>

<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="/jspf/foot.jsp"%>