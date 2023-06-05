<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Lider" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Lideres de Heroes </title>
	</head>


<body>
<h2>Bienvenido a SHIELD</h2>

	
	
	<jsp:useBean id="Heroes" class="JavaBeans.JB_Heroes" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>ID_Lider</th>
			<th>Nombre</th>
			<th>Armamento</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Lider> lista = (List<JB_Lider>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Lider lider : lista){
    %>

	<tr>
		<td><%out.print(lider.getIdL());%></td>
		<td><%out.print(lider.getNombre());%></td>
		<td><%out.print(lider.getEquipoArm());%></td>
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
    
    <form action="Editables/Agrega_Lider.jsp" method="get">
		<input type="submit" value="Agregar Lider">
	</form>
	
	<form action="Editables/Actualizar_Lider.jsp" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="ServletLiderDelete" method="get">
	
		<input id="id" type="text" name="id_l">
		<input type="submit" value="Eliminar Lider">
		
	</form>
</body>
</html>