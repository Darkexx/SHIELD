<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>



<h2>Bienvenido Lider de Heroes</h2>
<p> Usuario = <% out.print(request.getAttribute("nomlider")); %> </p>

	<form action="ServletIntegrantes" method="get">
		<input type="submit" value="Integrantes de cada equipo">
	</form>
	
</body>
</html>
