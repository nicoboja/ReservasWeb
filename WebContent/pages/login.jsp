<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="config/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">


<script type="text/javascript" >
function carga() {
	document.getElementById("inputUser").focus();
	
}
</script>

<title>Reservas | Iniciar Sesion</title>
</head>

<body onload="carga();">

<div class="container">

    <div class="row" id="center">
   	 	<div class="col-md-12 col-md-offset-12">
    		<h1 align="center">Sistema de Reserva</h1>
    		<p align="center" >JAVA UTN FRRO</p>
    	</div>
    </div>
<div class="container">
	<div class="col-md-8 col-md-offset-12" id="center">
<%if(session.getAttribute("errorlogin")!=null){%>
          dasd 
            
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
</div> <!-- /container -->
		
	
</div>

</body>
</html>