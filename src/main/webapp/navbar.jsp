<%-- 
    Document   : navbar
    Created on : 10/09/2020, 02:28:05 PM
    Author     : josel
tags : https://www.tutorialspoint.com/jsp/jstl_core_if_tag.htm
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>App Java</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
      <script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
    
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp">System Task</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <!-- dropdown user -->
        <% 
          if(session.getAttribute("usuario") == null){
              %>
             <li class="nav-item active">
                <a class="nav-link" id="login" href="login.jsp">Login</a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="register.jsp">Register</a>
              </li>
     <%
          }else{
       %>
          <li class="nav-item active">
                <a class="nav-link" href="task.jsp">Task</a>
              </li>
        <li class="nav-item dropdown" style="margin-right:50px;">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <% out.println(session.getAttribute("usuario")); %>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
             <a class="dropdown-item" id="logout_user">Logout</a>
           <!-- <form action="loginuser" method="get"> 
          <button class="dropdown-item" type="submit">Logout</button>
          </form> -->
        </div>
      </li>
      
      <% } %>
    </ul>
  </div>
</nav>
    <script src="script/script2.jsss"></script>
    </body>
</html>
