package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Involucrados;
import JavaBeans.JB_Involucrados;

@WebServlet("/ServletInvolucradosDelete")

public class ServletInvolucradosDelete extends HttpServlet{
	
	private static final long serialVersionUID = 3142298690820546658L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
		//int id_i = Integer.parseInt(rq.getParameter(("id_i")));
		//JB_Integrantes inte = new JB_Integrantes(id_i);
		//DAO_Integrantes intedao = new DAO_Integrantes();
		
		String id_at = rq.getParameter("id_at");
		JB_Involucrados inv = new JB_Involucrados(id_at);
		DAO_Involucrados invdao = new DAO_Involucrados();
		
		invdao.borrar(inv);
		rp.sendRedirect("");

	}
}