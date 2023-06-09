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
		
			String id_ls = rq.getParameter("id_ls");
			String nombre = rq.getParameter("nombre");
			String rango = rq.getParameter("rango");
			String id_sub = rq.getParameter("id_sub");
		
			JB_Lideres_Subdivision lidsub = new JB_Lideres_Subdivision(id_ls,nombre,rango,id_sub);
			DAO_Lideres_Subdv lidsubdao = new DAO_Lideres_Subdv();
			
			lidsubdao.agregar(lidsub);
			
			rp.sendRedirect("");
		
	}

}
