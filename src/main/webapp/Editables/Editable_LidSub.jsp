<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Lideres_Subdivision" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Lideres de Subdivision </title>
	</head>


<body>
<h2>Lideres de subdivisiones</h2>

	
	
	<jsp:useBean id="armamento" class="JavaBeans.JB_Lideres_Subdivision" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Identificacion del lider</th>
			<th>Nombre</th>
			<th>Rango</th>
			<th>Subdivision</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Lideres_Subdivision> lista = (List<JB_Lideres_Subdivision>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Lideres_Subdivision lid : lista){
    %>

	<tr>
		<td><%out.print(lid.getIdLs());%></td>
		<td><%out.print(lid.getNombre());%></td>
		<td><%out.print(lid.getRango());%></td>
		<td><%out.print(lid.getIdSub());%></td>
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
    
    <form action="ServletLidSubOptAg" method="get">
		<input type="submit" value="Agregar Lider de Subdivision">
	</form>
	
	
	
	
	<form action="ServletLidSubOptUp" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	
	
	
	
	<form action="ServletLidSubDelete" method="get">

		<%
			@SuppressWarnings("unchecked")
			List<JB_Lideres_Subdivision> sub = (List<JB_Lideres_Subdivision>) request.getAttribute("lista");
		
		%>
		
		<label for="ag">Lider de subdivicion a eliminar</label>
		<select id="ag" name="id_ls">
		
			<% for(JB_Lideres_Subdivision Subs : sub){ %>	
		
				<option value = "<%= Subs.getIdLs() %>"> 
				
					<%= Subs.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<input type="submit" value="Eliminar Lider de Subdivision">
		
	</form>
	
</body>
</html>