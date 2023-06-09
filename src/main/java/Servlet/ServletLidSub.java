package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;

import Datos.Conexion;
import JavaBeans.JB_Lideres_Subdivision;
import Datos.DAO_Lideres_Subdv;

@WebServlet("/ServletLidSub")

public class ServletLidSub extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			DAO_Lideres_Subdv lisubdao = new DAO_Lideres_Subdv();
			List<JB_Lideres_Subdivision> lista = lisubdao.consuLid();
			
			if (lista.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos de lidsub we");
	        }
			
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Editables/Editable_LidSub.jsp").forward(rq, rp);
			
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		
			//String id_at = rq.getParameter("id_at");
			//int id_h = Integer.parseInt(rq.getParameter("id_h"));
			//int id_agent = Integer.parseInt(rq.getParameter("id_agent"));
			//String fecha = rq.getParameter("fecha");
			
			//JB_Involucrados inv = new JB_Involucrados(id_at,id_h,id_agent,fecha);
			//DAO_Involucrados invdao = new DAO_Involucrados();
			
			//invdao.agregar(inv);
			
			rp.sendRedirect("");
		
	}

}
