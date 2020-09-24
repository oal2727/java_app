/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josel
 */
public class Conexion {
     Connection conexion=null;
    public Connection getConexion(){
        String type="postgresql";
        //?useSSL=false => mysql
         try {  
        String host="localhost";
        String user="postgres";
        String password="postgres";
        String port="5432";
        String database="php2";
        String url = "jdbc:"+type+"://"+host+":"+port+"/"+database;
            //siempre definir bien el url y añadir el class for name ...
             Class.forName("org.postgresql.Driver");
             conexion = DriverManager.getConnection(url,user,password);
             if(conexion != null){
                 System.out.println("conexion establecida");
                 return conexion;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
}

//CREATE TABLE usuario (
//   id serial PRIMARY KEY,
//   nombre VARCHAR (30) NOT NULL,
//   apellido VARCHAR (30) NOT NULL,
//   usuario VARCHAR (30) NOT NULL,
//   password VARCHAR (150) NOT NULL
//)