<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="JavaBeans.JB_reuniones" %>
<!DOCTYPE html>

<html>

	<head>
		<title> Juntas (Editable) </title>
	</head>

<body>
<h2>Juntas pendientes</h2>

	<jsp:useBean id="Integrantes" class="JavaBeans.JB_reuniones" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Lider</th>
			<th>Tema</th>
			<th>Hora</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_reuniones> lista = (List<JB_reuniones>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_reuniones integ : lista){
    %>

	<tr>
		<td><%out.print(integ.getLider());%></td>
		<td><%out.print(integ.getTema());%></td>
		<td><%out.print(integ.getHora());%></td>
	</tr>

	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
    %>
    
    </table>

	<br>
    <br>
    
    <form action="" method="get">
		<input type="submit" value="Agregar Integrante">
	</form>
	
	<form action="" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="" method="get">
	
		<input id="id_int" type="text" name="id_i">
		<input type="submit" value="Eliminar Integrante">
		
	</form>

</body>
</html>