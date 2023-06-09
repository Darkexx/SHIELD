package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Lideres_Subdv;
import JavaBeans.JB_Lideres_Subdivision;

@WebServlet("/ServletLidSubUpdate")

public class ServletLidSubUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		String nombre = rq.getParameter("nombre");
		String rango = rq.getParameter("rango");
		String id_sub = rq.getParameter("id_sub");
		
		String id_ls = rq.getParameter("id_ls");
		
		JB_Lideres_Subdivision lid = new JB_Lideres_Subdivision(nombre,rango,id_sub,id_ls);
		DAO_Lideres_Subdv lidao = new DAO_Lideres_Subdv();
		
		lid.setNombre(nombre);
		lid.setRango(rango);
		lid.setIdSub(id_sub);
		lid.setIdLs(id_ls);
		
		lidao.modificar(lid);

		rp.sendRedirect("");
		
	}
	
}