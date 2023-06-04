package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Integrantes;
import JavaBeans.JB_Integrantes;

@WebServlet("/ServletIntegrantesUpdate")

public class ServletIntegrantesUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		int id_h = Integer.parseInt(rq.getParameter(("id_h")));
		String nombre = rq.getParameter("nombre");
		//ID con el que actualizara
		int id_int = Integer.parseInt(rq.getParameter(("id_i")));
		
		JB_Integrantes inte = new JB_Integrantes(id_h,"nombre",id_int);
		DAO_Integrantes intedao = new DAO_Integrantes();
		
		inte.setIdH(id_h);
		inte.setNombre(nombre);
		inte.setIdInt(id_int);
		
		
		intedao.modificar(inte);
		rp.sendRedirect("");
		
	}
	
}
