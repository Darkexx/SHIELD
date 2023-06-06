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
			
			
			//Para involucrados
		
			DAO_Involucrados invodao = new DAO_Involucrados();
			List<JB_Involucrados> involucrados = invodao.seleccionar();
			if (involucrados.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de involucrados we");
	        }
			
			
			rq.setAttribute("involucrados", involucrados);
			
			//Para heroes
			//DAO_Heroes herdao = new DAO_Heroes();
			//List<JB_Heroes> lista = herdao.seleccionar();
			
			//if (lista.isEmpty()) {
	        //	System.out.println("void como el void");
	        //}
	        //else {
	        	//System.out.println("Aqui hay datos de heroes we");
	        //}
			
			//rq.setAttribute("heroes",lista);
			
			
			
			
			//Dirige a Involucrados
			rq.getRequestDispatcher("/Editables/Actualizar_Involucrados.jsp").forward(rq, rp);
			}

}