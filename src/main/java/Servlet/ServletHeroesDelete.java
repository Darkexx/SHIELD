package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import JavaBeans.JB_Heroes;
import Datos.DAO_Heroes;

@WebServlet("/ServletHeroesDelete")

public class ServletHeroesDelete extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
			int id_h = Integer.parseInt(rq.getParameter(("id_h")));
			JB_Heroes her = new JB_Heroes(id_h);
			DAO_Heroes herdao = new DAO_Heroes();
			herdao.borrar(her);
			rp.sendRedirect("");
	
	}
}