package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_Ataque;
import Datos.DAO_Ataques;

@WebServlet("/ServletAtaqueOptionUpdate")

public class ServletAtaqueOptionUpdate extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			
			//Para ataques
		
			DAO_Ataques atadao = new DAO_Ataques();
			List<JB_Ataque> ataque = atadao.seleccionar();
			if (ataque.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de ataque we");
	        }
			
			
			rq.setAttribute("ataques", ataque);
			
			//Dirige a Involucrados
			rq.getRequestDispatcher("/Editables/Actualizar_Ataque.jsp").forward(rq, rp);
			}

}