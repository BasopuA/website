/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.ac.tut.model.AssetwiseDatabase;

/**
 *
 * @author Alex
 */
public class LoginServlet extends HttpServlet {

     
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        AssetwiseDatabase db = new AssetwiseDatabase();
        
        if(db.emailExist(email))
        {
            response.sendRedirect("resetPassword.jsp");
        }
        else
        {
            request.setAttribute("errorMessage", "Email not found. Please try again");
            request.getRequestDispatcher("forgotPassword.jsp");
        }
            
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        String Password = request.getParameter("email");
        
        //business logic
        AssetwiseDatabase db = new AssetwiseDatabase();
        
        if(db.passwordVerify(email, Password))
        {
            response.sendRedirect("welcome.jsp");
        }
        else
        {
            request.setAttribute("errorMessage", "Invalid email or password. Please try again");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

   
}
