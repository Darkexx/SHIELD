package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Agentes;
import JavaBeans.JB_Agentes;

@WebServlet("/ServletAgentesDelete")

public class ServletAgentesDelete extends HttpServlet{
	
	private static final long serialVersionUID = 3142298690820546658L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		int id_agent = Integer.parseInt(rq.getParameter("id_agent"));
		JB_Agentes agent = new JB_Agentes(id_agent);
		DAO_Agentes agentdao = new DAO_Agentes();
		agentdao.borrar(agent);
		
		rp.sendRedirect("");

	}
}
