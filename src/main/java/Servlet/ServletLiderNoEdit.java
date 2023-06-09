package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;

import Datos.Conexion;
import JavaBeans.JB_Lider;
import Datos.DAO_Lider;

@WebServlet("/ServletLiderNoEdit")

public class ServletLiderNoEdit extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
			
			DAO_Lider lidedao = new DAO_Lider();
			List<JB_Lider> lista = lidedao.seleccionar();
			
			if (lista.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos ");
	        }
			
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Consultas/NoEdit_LiderHer.jsp").forward(rq, rp);
			

	}
	

}