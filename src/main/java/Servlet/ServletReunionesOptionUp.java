package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_reuniones;
import Datos.DAO_Reuniones;

import JavaBeans.JB_Lider;
import Datos.DAO_Lider;

@WebServlet("/ServletReunionesOptionUp")

public class ServletReunionesOptionUp extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			
			//Para reuniones
		
			DAO_Reuniones reudao = new DAO_Reuniones();
			List<JB_reuniones> reunion = reudao.seleccionar();
			if (reunion.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de reunion we");
	        }
			
			
			rq.setAttribute("reuniones", reunion);
			
			//Para heroes
			
			DAO_Lider herdao = new DAO_Lider();
			List<JB_Lider> hero = herdao.seleccionar();
			if (hero.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de lider we");
	        }
			
			
			rq.setAttribute("heroes", hero);
			
			//Dirige a agregar reuniones
			rq.getRequestDispatcher("/Editables/Actualizar_Reunion.jsp").forward(rq, rp);
			}

}