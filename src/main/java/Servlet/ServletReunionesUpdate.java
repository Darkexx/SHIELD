package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Reuniones;
import JavaBeans.JB_reuniones;

@WebServlet("/ServletReunionesUpdate")

public class ServletReunionesUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		int id_l = Integer.parseInt(rq.getParameter("id_l"));
		String hora =  rq.getParameter("hora");
		String tema2 =  rq.getParameter("tema2");
		
		String tema = rq.getParameter("tema"); 
		
		JB_reuniones reunion = new JB_reuniones(id_l,hora,tema,tema2);
		DAO_Reuniones reuniondao = new DAO_Reuniones();
		
		reunion.setIdL(id_l);
		reunion.setHora(hora);
		reunion.setTema(tema);
		reunion.setTema2(tema2);
		
		reuniondao.modificar(reunion);

		rp.sendRedirect("");
		
	}
	
}