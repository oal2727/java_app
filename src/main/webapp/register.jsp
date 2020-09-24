<%-- 
    Document   : register
    Created on : 19/09/2020, 11:42:54 AM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
           <jsp:include page="navbar.jsp"></jsp:include>
         <%
            if(null!=request.getAttribute("errorMessage"))
            {
               %>
               <div class="alert alert-danger" role="alert">
               <% out.println(request.getAttribute("errorMessage")); %>
            </div>
         <%   }
        %>
           <div class="col-md-5 m-auto">
                <div class="card">
               <div class="card-header">
                    register
               </div>
               <div class="card-body">
                  <form action="registeruser" method="post">
                         <div class="form-group">
                             <input type="text" name="nombre" class="form-control" placeholder="Nombre here" required/>
                         </div>
                         <div class="form-group">
                             <input type="text" name="apellido"  class="form-control" placeholder="Apellido here" required/>
                         </div>
                       <div class="form-group">
                             <input type="text" name="user" class="form-control" placeholder="User here" required/>
                         </div>
                        <div class="form-group">
                             <input type="password" name="password1" class="form-control" placeholder="Password here" required/>
                         </div>
                       <div class="form-group">
                             <input type="password" name="password2" class="form-control" placeholder="Repeat Password here" required/>
                         </div>
                         <button class="btn btn-primary" type="submit">Register</button>
                     </form>
               </div>
           </div>
           </div>
    </body>
</html>
