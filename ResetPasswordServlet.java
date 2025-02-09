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
public class ResetPasswordServlet extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        
        if(newPassword.equals(confirmPassword))
        {
            AssetwiseDatabase db = new AssetwiseDatabase();
            boolean success = db.updatePassword(email, newPassword);
            
            if(success)
            {
                response.sendRedirect("login.jsp?message=Password reset successfully. Please login");
            }
            else
            {
                request.setAttribute("errorMessage", "Failed to reset passwor try again.");
                request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            }
        }
        else
            {
                request.setAttribute("errorMessage", "Failed to reset passwor try again.");
                request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            }
    }

    
}
