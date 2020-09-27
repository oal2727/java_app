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
           <div id="error_register"></div>
           <div class="col-md-5 m-auto">
                <div class="card">
               <div class="card-header">
                    register
               </div>
               <div class="card-body">
                  <form id="register_form">
                         <div class="form-group">
                             <input type="text" id="nombre" class="form-control" placeholder="Nombre here" required/>
                         </div>
                         <div class="form-group">
                             <input type="text" id="apellido"  class="form-control" placeholder="Apellido here" required/>
                         </div>
                       <div class="form-group">
                             <input type="text" id="usuario" class="form-control" placeholder="User here" required/>
                         </div>
                        <div class="form-group">
                             <input type="password" id="password1" class="form-control" placeholder="Password here" required/>
                         </div>
                       <div class="form-group">
                             <input type="password" id="password2" class="form-control" placeholder="Repeat Password here" required/>
                         </div>
                         <button class="btn btn-primary" type="submit">Register</button>
                     </form>
               </div>
           </div>
           </div>
    </body>
</html>
