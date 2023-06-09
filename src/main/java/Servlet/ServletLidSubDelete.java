package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import JavaBeans.JB_Lideres_Subdivision;
import Datos.DAO_Lideres_Subdv;

@WebServlet("/ServletLidSubDelete")

public class ServletLidSubDelete extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
			//int id_h = Integer.parseInt(rq.getParameter(("id_h")));
			String id_ls = rq.getParameter("id_ls");
		
			JB_Lideres_Subdivision sublid = new JB_Lideres_Subdivision(id_ls);
			DAO_Lideres_Subdv subdao = new DAO_Lideres_Subdv();
			subdao.borrar(sublid);
			rp.sendRedirect("");
	
	}
}