package Servlet;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import Datos.Conexion;//Archivo conexión
import JavaBeans.JB_Agentes;//JavaBean Agentes
import Datos.DAO_Agentes;//DAO Agentes
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

@WebServlet("/ServletAgentes")
public class ServletAgentes extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";

        if (opc.equals("list")) {
            DAO_Agentes clidao = new DAO_Agentes();
            List<JB_Agentes> lista = clidao.seleccionar();
            rq.setAttribute("lista",lista);
            rq.getRequestDispatcher("/Editables/Editable_AgentesSh.jsp").forward(rq, rp);
        }

        else if (opc.equals("mostrar")) {
            Conexion con = new Conexion();
            Connection c = con.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            int id_agent = Integer.parseInt(rq.getParameter(("id_agent")));
            try {
                String updateSql = "SELECT * FROM agentes WHERE id_agent = ? ";
                ps = c.prepareStatement(updateSql);
                ps.setInt(1, id_agent);
                rs = ps.executeQuery();
                JB_Agentes Agnt = new JB_Agentes();
                while (rs.next()) {

                	Agnt.setIdAgent(rs.getInt("id_agent"));
                	Agnt.setNombre(rs.getString("nombre"));
                	Agnt.setEspecializacion(rs.getString("especializacion"));
                	Agnt.setPuesto(rs.getString("puesto"));
                
                }
                	
                rq.setAttribute("agente", Agnt);

                rq.getRequestDispatcher("---Aqui va JSP---").forward(rq, rp);
               
            } catch (SQLException ex) {
                System.out.println("Error en SQL " + ex.getMessage());
            }
        }
      
        else if (opc.equals("eliminar")) {

            int id_agent = Integer.parseInt(rq.getParameter(("id_agent")));
            JB_Agentes agn = new JB_Agentes(id_agent);
            DAO_Agentes agndao = new DAO_Agentes();
            agndao.borrar(agn);
            rp.sendRedirect("ServletAgentes");
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        

    	   	int id_agent = Integer.parseInt(rq.getParameter("id_agent"));
    	   	String nombre = rq.getParameter("nombre");
    	   	String especializacion = rq.getParameter("especializacion");
    	   	String puesto = rq.getParameter("puesto");

            JB_Agentes agent = new JB_Agentes(id_agent, nombre, especializacion, puesto);
            DAO_Agentes agentdao = new DAO_Agentes();
            agentdao.agregar(agent);
            rp.sendRedirect("");
       
    }
}