package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import JavaBeans.JB_Lider;
import Datos.DAO_Lider;

@WebServlet("/ServletLiderDelete")

public class ServletLiderDelete extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
			int id_l = Integer.parseInt(rq.getParameter(("id_l")));
			JB_Lider lid = new JB_Lider(id_l);
			DAO_Lider lidao = new DAO_Lider();
			
			lidao.borrar(lid);
			
			rp.sendRedirect("");
			
			//JB_Heroes her = new JB_Heroes(id_h);
			//DAO_Heroes herdao = new DAO_Heroes();
			//herdao.borrar(her);
			//rp.sendRedirect("");
	
	}
}