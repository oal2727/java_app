<%-- 
    Document   : navbar
    Created on : 10/09/2020, 02:28:05 PM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Config" %>

<!DOCTYPE html>
<html>
    <head>
        <title>App Java</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><% 
     Config setup = new Config();
     out.println(setup.NAME);
    %></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Login</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Register</a>
      </li>
     
    </ul>
  </div>
</nav>
    </body>
</html>
