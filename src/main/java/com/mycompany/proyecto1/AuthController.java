/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;

import Services.ServiceUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;              
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author josel
 */
@WebServlet(name="loginuser",urlPatterns={"/loginuser"})
public class AuthController extends HttpServlet{
    ServiceUser service = new ServiceUser();
    Usuario user;
     public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
             HttpSession session = req.getSession();
            String usuario = req.getParameter("user");
            String password = req.getParameter("password");
                user = service.checkUser(usuario);
                if(user == null){
                    req.setAttribute("errorMessage", "Usuario incorrecto" );
                    RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                    rd.forward(req, res);  
                }else{
                    boolean pass = service.desencriptionPassword(password, user.password);
                    if(pass){
                      session.setAttribute("usuario",user.usuario);
                      res.sendRedirect("welcome.jsp");
                    }else{
                         req.setAttribute("errorMessage", "Contraseña incorrecto");
                       RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                       rd.forward(req, res);
                    }
                }
    }
      public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
           HttpSession session = req.getSession();
           session.removeAttribute("usuario");
             res.sendRedirect("login.jsp");
         }
     
}
