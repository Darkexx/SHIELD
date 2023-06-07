package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_Agentes;
import Datos.DAO_Agentes;

@WebServlet("/ServletAgentesOptionUpdate")

public class ServletAgentesOptionUpdate extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			
			//Para agentes
		
			DAO_Agentes agendao = new DAO_Agentes();
			List<JB_Agentes> agentes = agendao.seleccionar();
			if (agentes.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de involucrados we");
	        }
			
			
			rq.setAttribute("agentes", agentes);
			
			//Dirige a Involucrados
			rq.getRequestDispatcher("/Editables/Actualizar_Agente.jsp").forward(rq, rp);
			}

}