<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>
<h2>Bienvenido a SHIELD</h2>

	
	<form action="Servlet_Login" method = "post">
	
	<label for="user"> Nombre de usuario </label>
	<input id="user" type="text" name="EntUsu">
	
	<br>
	<br>
	
	<label for="pass"> Contraseña </label>
	<input id="pass" type="text" name="EntPass">
	
	<input type="submit" value="Ingresar">
	
	</form>
	
	
</body>
</html>
