<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Tip_Ataque" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Info Extraterrestre </title>
		
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Info Amenaza Extraterrestre:</h2>

		<div class="overlay"></div>
		<div class="scanline"></div>
		<div class="wrapper">
  		<div class="content clearfix">

	<jsp:useBean id="t_at" class="JavaBeans.JB_Tip_Ataque" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Identificacion Ataque</th>
			<th>Tipo</th>
			<th>Region Afectada</th>
			<th>Especie Alien</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Tip_Ataque> lista = (List<JB_Tip_Ataque>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Tip_Ataque t_ataque : lista){
    %>

	<tr>
			<td><%out.print(t_ataque.getIdAt());%></td>
			<td><%out.print(t_ataque.getNomTipo());%></td>
			<td><%out.print(t_ataque.getRegAfect());%></td>
			<td><%out.print(t_ataque.getAlien());%></td>
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
	
	</div>
	</div>
	
</body>
</html>