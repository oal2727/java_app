/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function() {
    console.log("initialzie js");
    //falta de recarga caliente
    $( "#login_form" ).submit(function( event ) {
       alert( "Handler for .submit() called." );
       event.preventDefault();
     });

    
});