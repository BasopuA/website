<%-- 
    Document   : feedback
    Created on : Feb 7, 2025, 2:21:47 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register feedback Page</title>
    </head>
    <body>
        <h1>Feedback!</h1>
        <%
           String details = (String)request.getAttribute("details");
        %>
        <p>
            <b><%=details%></b>
        </p>
        <p>
            please click <a href="index.html">here</a> to go to the mail page
        </p>
    </body>
</html>
