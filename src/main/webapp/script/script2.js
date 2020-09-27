/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {
    //falta de recarga caliente
    //post login
    $( "#login_form" ).submit(function( event ) {
       event.preventDefault();
       console.log($('#user').val());
      const param={
           user : $('#user').val(),
           password : $('#password').val()
      };
      console.log(param);
      const dataerror = $('#error_login');
        $.ajax({
            data: param,
            type: "POST",
            url: "loginuser"
        }).done(function(data){
            window.location.href="welcome.jsp"
            console.log("hecho");
        }).fail(function(data){
             console.log("fail");
             showData(dataerror,data.responseText);
        });
    });
    //post register
    $('#register_form').submit(function(event){
        event.preventDefault();
        const param = {
            nombre : $('#nombre').val(),
            apellido: $('#apellido').val(),
            user: $('#usuario').val(),
            password1: $('#password1').val(),
            password2: $('#password2').val()
        }
        const dataerror = $('#error_register');
         $.ajax({
            data: param,
            type: "POST",
            url: "registeruser"
        }).done(function(data){ //status => 200
            window.location.href="login.jsp";
            console.log("hecho");
        }).fail(function(data){ // status => 400
             console.log("fail");
             showData(dataerror,data.responseText);
        });
    })
    //get logout data
    $('#logout_user').click(function(event){
        $.get("loginuser",function(e){
            window.location.href="login.jsp";
        })
    })
    
    
    function showData(showdata,data){
        showdata.html(`
             <div class="alert alert-danger" role="alert">
              ${data}
            </div>
        `)
    }


    
});