package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_STARK;
import JavaBeans.JB_Heroes;
import Datos.DAO_STARK;
import Datos.DAO_Heroes;

@WebServlet("/ServletArmamentoOptAg")

public class ServletArmamentoOptAg extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			
			//Para agente de Stark
		
			DAO_STARK starkdao = new DAO_STARK();
			List<JB_STARK> stark = starkdao.seleccionar();
			if (stark.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de stark we");
	        }
			
			rq.setAttribute("colab", stark);
			
			
			//Para Heroes
			
			
			DAO_Heroes herdao = new  DAO_Heroes();
			List<JB_Heroes> her = herdao.seleccionar();
			if (her.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de heroes we");
	        }
			
			rq.setAttribute("heroes", her);
			
			
			//Dirige a Agrega_Armamento
			rq.getRequestDispatcher("/Editables/Agrega_Armamento.jsp").forward(rq, rp);
			}

}