package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_reuniones;
import JavaBeans.JB_Lider;
import Datos.DAO_Reuniones;
import Datos.DAO_Lider;

@WebServlet("/ServletReunionesOptionRe")

public class ServletReunionesOptionRe extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			
			//Para reuniones
		
			DAO_Lider lidao = new DAO_Lider();
			List<JB_Lider> lider = lidao.seleccionar();
			if (lider.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de ataque we");
	        }
			
			
			rq.setAttribute("lideres", lider);
			
			//Dirige a agregar reuniones
			rq.getRequestDispatcher("/Editables/Agrega_Reunion.jsp").forward(rq, rp);
			}

}