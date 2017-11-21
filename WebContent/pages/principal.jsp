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

<%@include file="../jspf/nav.jsp"%>

<br>
<br>
 <div class="container">

      <form class="form-signin" name="signin" action="login" method="post">
        <h2 class="form-signin-heading">Acceder al Sistema</h2>
        <label for="inputUser" class="sr-only">Usuario</label>
        <input name="user" id="inputUser" class="form-control" placeholder="Usuario" required="" autofocus="" type="">
        <label for="inputPass" class="sr-only">Constraseña</label>
        <input name="pass" id="inputPass" class="form-control" placeholder="Contraseña" required="" type="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
      </form>

    </div> <!-- /container -->

<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="../jspf/foot.jsp"%>