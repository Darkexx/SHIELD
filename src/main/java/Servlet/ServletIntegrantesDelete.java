package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Integrantes;
import JavaBeans.JB_Integrantes;

@WebServlet("/ServletIntegrantesDelete")

public class ServletIntegrantesDelete extends HttpServlet{
	
	private static final long serialVersionUID = 3142298690820546658L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
		int id_i = Integer.parseInt(rq.getParameter(("id_i")));
		JB_Integrantes inte = new JB_Integrantes(id_i);
		DAO_Integrantes intedao = new DAO_Integrantes();
		intedao.borrar(inte);
		rp.sendRedirect("");

	}
}
