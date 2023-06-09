package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import JavaBeans.JB_Subdivision;
import JavaBeans.JB_Lideres_Subdivision;
import Datos.DAO_Subdivision;
import Datos.DAO_Lideres_Subdv;

@WebServlet("/ServletLidSubOptUp")

public class ServletLidSubOptUp extends HttpServlet{
	
	
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
			
			//Para lideres de subdivision
			
			DAO_Lideres_Subdv lidao =  new DAO_Lideres_Subdv();
			List<JB_Lideres_Subdivision> lid = lidao.seleccionar();
			
			if (lid.isEmpty()) {
	        	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de lideres we");
	        }
			
			rq.setAttribute("lideres", lid);

			rq.getRequestDispatcher("/Editables/Actualizar_LidSub.jsp").forward(rq, rp);
			}

}