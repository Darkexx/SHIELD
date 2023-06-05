package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import JavaBeans.JB_Lider;
import Datos.DAO_Lider;

@WebServlet("/ServletLiderUpdate")

public class ServletLiderUpdate extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
		
		String nombre = rq.getParameter("nombre");
		String equipo_arm = rq.getParameter("equipo_arm");
		int id_l = Integer.parseInt(rq.getParameter("id_l"));
		
		
		JB_Lider lid = new JB_Lider("nombre","equipo_arm",id_l);
		DAO_Lider lidao = new DAO_Lider();
		
		
		lid.setNombre(nombre);
		lid.setEquipoArm(equipo_arm);
		lid.setIdL(id_l);
		
		lidao.modificar(lid);
		
		//herdao.modificar(her);
		rp.sendRedirect("");
		
	}
}