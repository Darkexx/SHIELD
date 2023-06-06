package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import JavaBeans.JB_Heroes;
import Datos.DAO_Heroes;

@WebServlet("/ServletInvolucradosOptionHeroe")

public class ServletInvolucradosOptionHeroe extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			DAO_Heroes herdao = new DAO_Heroes();
			List<JB_Heroes> lista = herdao.seleccionar();
			
			if (lista.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos we");
	        	System.out.println(lista);
	        }
			
			rq.setAttribute("heroes",lista);
			rq.getRequestDispatcher("/Editables/Agrega_Involucrados.jsp").forward(rq, rp);
	}

}