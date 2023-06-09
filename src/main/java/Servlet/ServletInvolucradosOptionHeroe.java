package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import JavaBeans.JB_Heroes;
import JavaBeans.JB_Agentes;
import JavaBeans.JB_Ataque;
import Datos.DAO_Heroes;
import Datos.DAO_Agentes;
import Datos.DAO_Ataques;

@WebServlet("/ServletInvolucradosOptionHeroe")

public class ServletInvolucradosOptionHeroe extends HttpServlet{
	
	
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
			
			
			//Para ataques
			DAO_Ataques atadao = new DAO_Ataques();
			List<JB_Ataque> lista3 = atadao.seleccionar();
			
			if (lista3.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de heroes we");
	        }
			
			rq.setAttribute("ataques",lista3);
			
			//Dirige a Involucrados
			rq.getRequestDispatcher("/Editables/Agrega_Involucrados.jsp").forward(rq, rp);
			}

}