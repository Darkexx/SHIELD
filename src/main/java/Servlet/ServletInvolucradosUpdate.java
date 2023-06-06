package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Involucrados;
import JavaBeans.JB_Involucrados;

@WebServlet("/ServletInvolucradosUpdate")

public class ServletInvolucradosUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		int id_h = Integer.parseInt(rq.getParameter("id_h"));
		int id_agent = Integer.parseInt(rq.getParameter("id_agent"));
		String fecha = rq.getParameter("fecha");
		
		String id_at = rq.getParameter("id_at");
		
		JB_Involucrados invo = new JB_Involucrados(id_h,id_agent,"fecha","id_at");
		DAO_Involucrados invodao = new DAO_Involucrados();
		
		invo.setIdH(id_h);
		invo.setIdAgent(id_agent);
		invo.setFecha(fecha);
		invo.setIdAt(id_at);
		
		invodao.modificar(invo);
		//int id_h = Integer.parseInt(rq.getParameter(("id_h")));
		//String nombre = rq.getParameter("nombre");
		
		//ID con el que actualizara
		
		//int id_int = Integer.parseInt(rq.getParameter(("id_i")));
		
		//JB_Integrantes inte = new JB_Integrantes(id_h,"nombre",id_int);
		//DAO_Integrantes intedao = new DAO_Integrantes();
		
		//inte.setIdH(id_h);
		//inte.setNombre(nombre);
		//inte.setIdInt(id_int);
		
		
		//intedao.modificar(inte);
		rp.sendRedirect("");
		
	}
	
}
