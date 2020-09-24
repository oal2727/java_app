/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;

import DatabaseConfig.Conexion;
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
@WebServlet("/registeruser")
public class UserController extends HttpServlet {
    ServiceUser service = new ServiceUser();
    
     
    
     public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
            //String aid = req.getParameter("aid");
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String usuario = req.getParameter("user");
            String password1 = req.getParameter("password1");
             String password2 = req.getParameter("password2");
          
             System.out.println("post data");
           if(nombre.equals("") || apellido.equals("") || usuario.equals("") ||
                   password1.equals("") || password2.equals("")){
//                      System.out.println("completar campos");
                  req.setAttribute("errorMessage", "completar campos" );
                  RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
                   rd.forward(req, res); 
           }else{
                 if(password1.equals(password2)){
                  String password = service.EncryptionPassword(password1);
                  System.out.println(password);
                  Usuario user = new Usuario(nombre,apellido,usuario,password);
                  int check = service.RegisterUser(user);
                  if(check < 0){
                         req.setAttribute("errorMessage", "el usuario ya existe" );
                     RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
                      rd.forward(req, res);  
                  }
                  else if(0 < check){
                            res.sendRedirect("login.jsp");
                  }
                }else{
                     req.setAttribute("errorMessage", "las contraseñas no coinciden" );
                     RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
                      rd.forward(req, res);  

                }
           }
             
           
    }
    
    
}
