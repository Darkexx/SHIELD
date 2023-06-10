<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
	</head>


<body>
	
	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">
	
	
	
	<header class="site clearfix">
      <div class="col one">
      	<br>
      	
        <img src="logo.png" alt="591 Systems" width="900" height="729" id="logo-v" />
      </div>
      <div class="col two">
        <h4>Bienvenido a SHIELD<br /> <b>S</b>trategic <b>H</b>omeland <b>I</b>ntervention, <b>E</b>nforcement and <b>L</b>ogistic <b>D</b>ivision</h4>
        <p>----------------------------------------</p>
        <p>SHIELD v 1.0.23</p>
        <p>(c)2023 SHIELD</p>
      </div>
    </header>
	
	
	
	
	
	
<h2>Bienvenido a SHIELD</h2>

	
	<form action="Servlet_Login" method = "post">
	
	<label for="user"> Nombre de usuario>> </label>
	<input id="user" type="text" name="EntUsu">
	
	<br>
	<br>
	
	<label for="pass"> Contraseña>> </label>
	<input id="pass" type="text" name="EntPass">
	
	<br>
	<br>
	
	<input type="submit" value="Ingresar">
	
	</form>
	
	</div>
	</div>
</body>
</html>
