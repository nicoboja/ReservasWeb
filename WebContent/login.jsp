<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="/meta.jsp" %>

<script type="text/javascript" >
function carga() {
	document.getElementById("inputUser").focus();
	
}
</script>

<title>Ingrese al Sistema</title>
</head>
<body onload="carga();">

</body>
<div class="container">
	<div class="row" id="center">
	<div id="center" >
    		<h1 align="center">Sistema de Reserva</h1>
    		<p align="center" >JAVA UTN FRRO</p>
    	</div>
    </div>
    <div id="center">
    <%if(request.getAttribute("error")!=null){%>
    	<div class="alert alert-danger">
        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
          <%=request.getAttribute("error") %>
        </div> 
    <%}%>
    	<form class="form-signin" name="signin" action="/ReservasWeb/inicio" method="post">
       		<h4 class="form-signin-heading">Acceder al Sistema</h2>
        	<label for="inputUser" class="sr-only">Usuario</label>
        	<input name="user" id="inputUser" class="form-control" placeholder="Usuario" required="" autofocus="" type="">
        	<label for="inputPass" class="sr-only">Constraseña</label>
        	<input name="pass" id="inputPass" class="form-control" placeholder="Contraseña" required="" type="Password">
        	<button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
    	</form>
    </div>
</div>
    
    
</html>