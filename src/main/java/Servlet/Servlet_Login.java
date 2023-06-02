package Servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import JavaBeans.JB_Users;
import Datos.DAO_Users;
import Datos.DAO_Lider;


@WebServlet("/Servlet_Login")

public class Servlet_Login extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          DAO_Users usurdao = new DAO_Users();
          String user = request.getParameter("EntUsu");
          String password = request.getParameter("EntPass").trim();

          JB_Users usur = usurdao.busca(user);

        if (usur!=null) {
            if (usur.getPass().equals(password)) {

                 //request.setAttribute("usuario",usuario);

                if (usur.getRoll().equals("Lider_Shield")) {
                    //Si el rol es de Lider_Heroes reedirige al jsp correspondiente
                    RequestDispatcher dispatcher = request.getRequestDispatcher("indexLidShield.jsp");
                    dispatcher.forward(request, response);
                }
                else if (usur.getRoll().equals("Lider_Heroes")) {
                    //Si se trata de un Lider_Heroes obtenemos su nombre 
                	
                	int idint = Integer.parseInt(usur.getId_us());
                	
                    DAO_Lider lidao = new DAO_Lider();
                    String nomlid = lidao.retnom(idint);

                    request.setAttribute("nomlider",nomlid);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("indexLidHer.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                	
                	System.out.println("no existe roll");//JSP mensaje de inexistencia de roll
                } 

            }
            else {
            	System.out.println("Contraseña incorrecta");//JSP mensaje de error contraseña
            }

        }
        else {
        	System.out.println("no existe usuario");//JSP mensaje de error usuario
        }



    }

}