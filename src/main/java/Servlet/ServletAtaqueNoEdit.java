package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;

import Datos.Conexion;
import JavaBeans.JB_Ataque;
import Datos.DAO_Ataques;

@WebServlet("/ServletAtaqueNoEdit")

public class ServletAtaqueNoEdit extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	//-----Get-----
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
			
			DAO_Ataques armdao = new DAO_Ataques();
			List<JB_Ataque> lista = armdao.seleccionar();
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Consultas/NoEdit_Ataque.jsp").forward(rq, rp);
			
			
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
			String id_at = rq.getParameter("id_at");
			String nombre = rq.getParameter("nombre");
			int muertes = Integer.parseInt(rq.getParameter("muertes"));
			int heridos = Integer.parseInt(rq.getParameter("heridos"));
			String pais = rq.getParameter("pais");
			
			JB_Ataque ata = new JB_Ataque(id_at,nombre,muertes,heridos,pais);
			DAO_Ataques atadao = new DAO_Ataques();
			atadao.agregar(ata);
			rp.sendRedirect("");
			
	}

}