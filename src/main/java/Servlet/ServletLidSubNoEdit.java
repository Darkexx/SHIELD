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

@WebServlet("/ServletLidSubNoEdit")

public class ServletLidSubNoEdit extends HttpServlet{
	
	
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
			rq.getRequestDispatcher("/Consultas/NoEdit_LidSub.jsp").forward(rq, rp);
			
	}

}
