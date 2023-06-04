package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Integrantes;
import JavaBeans.JB_Integrantes;

@WebServlet("/ServletIntegrantesDelete")

public class ServletIntegrantesDelete {
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
		int id_h = Integer.parseInt(rq.getParameter(("id_h")));
		JB_Integrantes inte = new JB_Integrantes(id_h);
		DAO_Integrantes intedao = new DAO_Integrantes();
		intedao.borrar(inte);
		rp.sendRedirect("");

	}
}
