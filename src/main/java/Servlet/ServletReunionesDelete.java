package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Reuniones;
import JavaBeans.JB_reuniones;

@WebServlet("/ServletReunionesDelete")

public class ServletReunionesDelete extends HttpServlet{
	
	private static final long serialVersionUID = 3142298690820546658L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		String tema = rq.getParameter("tema");
		
		JB_reuniones reunion = new JB_reuniones(tema);
		DAO_Reuniones reuniondao = new DAO_Reuniones();
		reuniondao.borrar(reunion);
		
		rp.sendRedirect("");

	}
}
