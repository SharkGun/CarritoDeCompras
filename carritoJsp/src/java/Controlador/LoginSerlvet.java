/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.clienteBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LpKido
 */
public class LoginSerlvet extends HttpServlet {
protected String myParm=null;
    protected String myContextParam=null;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.myParm=config.getInitParameter("AppTitle");
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        String StrUsuario=request.getParameter("txtusername");
        String StrPassword=request.getParameter("txtpassword");
        
        UsuarioBL bl=new UsuarioBL();
        if(bl.Login(StrUsuario, StrPassword)==true) {
            
            ArrayList<UsuarioBE> Lista = bl.getUsuarioAll();
            
            request.setAttribute("UsuarioList", Lista);
            
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/dashboard.jsp");
            dispatcher.forward(request, response);
            //response.sendRedirect("dashboard.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
        */
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        myContextParam=request.getSession().getServletContext().getInitParameter("AppName");
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String StrUsuario=request.getParameter("txtUsuario");
        String StrPassword=request.getParameter("txtPassword");
        
        clienteBD bl=new clienteBD();
        if(bl.Login(StrUsuario, StrPassword)==true) {
            //VARIABLES DE SESION
            
            HttpSession session=request.getSession();
            session.setAttribute("gUser", StrUsuario);
            session.setAttribute("gAppName", myContextParam);
            session.setAttribute("gAppTitle", myParm);
            response.sendRedirect("index.jsp"); //Redireccionamiento a UserServlet
            
        }else{
            request.setAttribute("error", "-1");
            request.getRequestDispatcher("logeo.jsp").forward(request,response);
            //response.sendRedirect("Welcome");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
