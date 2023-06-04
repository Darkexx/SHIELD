<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="JavaBeans.JB_Integrantes" %>
<!DOCTYPE html>

<html>

	<head>
		<title> Integrantes de grupos (Editable) </title>
	</head>

<body>
<h2>Integrantes de equipos</h2>

	<jsp:useBean id="Integrantes" class="JavaBeans.JB_Integrantes" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Grupo</th>
			<th>Nombre integrante</th>
			<th>Identificacion</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Integrantes> lista = (List<JB_Integrantes>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Integrantes integ : lista){
    %>

	<tr>
		<td><%out.print(integ.getNombre());%></td>
		<td><%out.print(integ.getNombre2());%></td>
		<td><%out.print(integ.getIdInt());%></td>
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
    
    <form action="Editables/Agrega_EquipoInteg.jsp" method="get">
		<input type="submit" value="Agregar Integrante">
	</form>
	
	<form action="Editables/Actualizar_EquipoInteg.jsp" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="ServletIntegrantesDelete" method="get">
	
		<input id="id_int" type="text" name="id_i">
		<input type="submit" value="Eliminar Integrante">
		
	</form>

</body>
</html>
