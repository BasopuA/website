<%-- 
    Document   : resetPassword
    Created on : Feb 7, 2025, 11:10:09 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                display: flex;
                justify-content: center;
                height: 100vh;
                margin: 0;
            }
            .reset-password-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                width: 300px;
                text-align: center;
            }
            .reset-password-container h2 {
                margin-bottom: 20px;
                color: #333;
            }
            .reset-password-container input[type="password"] {
                width: 100px;
                padding: 10px;
                margin-bottom: 15px;
                border: 4px;
                border-radius: 4px;
                font-size: 16px;
            }
            .reset-password-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        .reset-password-container input[type="submit"]:hover {
            background-color: #218838;
        }
        .error-message {
            color: red;
            margin-bottom: 15px;
        }
        </style>
    </head>
    <body>
        <div class="reset-password-container">
            <h2>Rest Your Password</h2>
            <%-- Display error message if any --%>
            <% if(request.getAttribute("errorMessage")!=null){%>
            <div class="error-message">
                <%= request.getAttribute("errorMessage")%>
            </div>
            <%}%>
            <form action="ResetPasswordServlet" method="POST">
                <input type="password" name="newPassword" placeholder="Enter new password" required><br>
                <input type="password" name="confirmPasswor" placeholder="confirm new password" required><br>
                <input type="submit" value="Reset Password" >
            </form>
        </div>
    </body>
</html>
