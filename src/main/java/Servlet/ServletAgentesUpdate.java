package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Agentes;
import JavaBeans.JB_Agentes;

@WebServlet("/ServletAgentesUpdate")

public class ServletAgentesUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		String nombre = rq.getParameter("nombre");
		String especializacion = rq.getParameter("especializacion");
		String puesto = rq.getParameter("puesto");
		
		int id_agent = Integer.parseInt(rq.getParameter("id_agent"));
		
		JB_Agentes agent = new JB_Agentes("nombre","especializacion","puesto",id_agent);
		DAO_Agentes agentdao = new DAO_Agentes();
		
		agent.setNombre(nombre);
		agent.setEspecializacion(especializacion);
		agent.setPuesto(puesto);
		agent.setIdAgent(id_agent);
		
		agentdao.modificar(agent);
		
		rp.sendRedirect("");
		
	}
	
}