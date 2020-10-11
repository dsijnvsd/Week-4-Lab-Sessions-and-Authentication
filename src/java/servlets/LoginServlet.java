/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author awarsyle
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            HttpSession session = request.getSession();
            String logout = request.getParameter("logout");
            if(logout!= null){
                session.invalidate();
                request.setAttribute("message", "You have successfully logged out");
                 getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);  
            }
            else if(session.getAttribute("username") != null){
                response.sendRedirect("home");
            
            }
            else{getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);  
    }}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
            String password = request.getParameter("password");
            AccountService as = new AccountService();
            User user = as.login(username, password);
            
            
             if (username != null && password != null && user != null) {                 
                      request.setAttribute("invalid", false);   
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            response.sendRedirect("home");
             }
             else{
                 request.setAttribute("invalid", true);  
                 getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
             }
//        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
