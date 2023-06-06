package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_Involucrados;
import Datos.DAO_Involucrados;

@WebServlet("/ServletInvolucradosOptionUpdate")

public class ServletInvolucradosOptionUpdate extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			
		
			//Para heroes
			DAO_Heroes herdao = new DAO_Heroes();
			List<JB_Heroes> lista = herdao.seleccionar();
			
			if (lista.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de heroes we");
	        }
			
			rq.setAttribute("heroes",lista);
			
			//Para agentes
			DAO_Agentes agedao = new DAO_Agentes();
			List<JB_Agentes> lista2 = agedao.seleccionar();
			
			if (lista2.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de agentes we");
	        }
			rq.setAttribute("agentes", lista2);
			
			
			//Dirige a Involucrados
			rq.getRequestDispatcher("/Editables/Agrega_Involucrados.jsp").forward(rq, rp);
			}

}