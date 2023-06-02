<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Heroes" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>
<h2>Bienvenido a SHIELD</h2>

	
	
	<jsp:useBean id="Heroes" class="JavaBeans.JB_Heroes" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>ID_Grupo</th>
			<th>Nombre</th>
			<th>ID_Lider</th>
			<th>ID_Subdivision</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Heroes> lista = (List<JB_Heroes>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Heroes hero : lista){
    %>

	<tr>
		<td><%out.print(hero.getIdH());%></td>
		<td><%out.print(hero.getNombre());%></td>
		<td><%out.print(hero.getIdL());%></td>
		<td><%out.print(hero.getIdSub());%></td>
	</tr>

	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
    %>
    
    </table>
	
	
</body>
</html>
