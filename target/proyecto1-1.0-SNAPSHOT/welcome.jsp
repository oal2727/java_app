<%-- 
    Document   : welcome
    Created on : 19/09/2020, 11:15:50 AM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <jsp:include page="navbar.jsp"></jsp:include>
    <body>
        <% 
            if(session.getAttribute("usuario") == null){
                response.sendRedirect("login.jsp");
            }
        %>
        <h1 class="text-primary text-center">Welcome <%  out.println(session.getAttribute("usuario")); %></h1>
    </body>
</html>
