package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_Subdivision;
import Datos.DAO_Subdivision;

@WebServlet("/ServletLidSubOptAg")

public class ServletLidSubOptAg extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			
			//Para subdivisiones
		
			DAO_Subdivision subdao = new DAO_Subdivision();
			List<JB_Subdivision> sub = subdao.seleccionar();
		
			if (sub.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de stark we");
	        }
			
			rq.setAttribute("subs", sub);

			rq.getRequestDispatcher("/Editables/Agrega_LidSub.jsp").forward(rq, rp);
			}

}