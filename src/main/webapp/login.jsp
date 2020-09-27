<%-- 
    Document   : login
    Created on : 19/09/2020, 11:14:17 AM
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        
    </head>
    <body>
           <jsp:include page="navbar.jsp"></jsp:include>
           

           <div id="error_login"></div>
             <div class="col-md-5 m-auto">
                <div class="card">
               <div class="card-header">
                    Login here
               </div>
               <div class="card-body">
                   <form id="login_form">
                       <div class="form-group">
                           <input type="text" id="user" class="form-control"  placeholder="Usuario here " />
                       </div>
                       <div class="form-group">
                           <input type="password" id="password" class="form-control" placeholder="Password here " />
                       </div>
                       <button class="btn btn-primary" type="submit">Log In</button>
                   </form>
               </div>
           </div>
           </div>
        <script src="script/script2.js"></script>
    </body>
</html>
