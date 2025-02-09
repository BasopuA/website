package za.ac.tut.web;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.ac.tut.model.AssetwiseDatabase;
import za.ac.tut.model.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Alex
 */
public class UserDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        

        // Create a User object
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
       user.setPassword(hashedPassword);

        // Add user to the database
        AssetwiseDatabase database = new AssetwiseDatabase();
        try {
            database.addUser(user);

            // Set user details for feedback
            String details = user.displayTheDetails(name, surname, email);
            request.setAttribute("details", details);

            // Redirect to success page
            response.sendRedirect("Success.jsp");
            return; // Stop further execution
        } catch (Exception e) {
            e.printStackTrace();

            // Redirect to error page
            response.sendRedirect("Error.jsp");
            return; // Stop further execution
        }
    }
}