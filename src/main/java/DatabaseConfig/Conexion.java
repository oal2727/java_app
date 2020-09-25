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
        String host="ec2-52-1-95-247.compute-1.amazonaws.com";
        String user="sfsrfvsuipuwdt";
        String password="490b15f6e2f1cc96a5cc6651deced2db54fb23c5b5475ac2ba987f5e884f2054";
        String port="5432";
        String database="d5a7pkoohr0nvd";
        String url = "jdbc:"+type+"://"+host+":"+port+"/"+database+"?sslmode=require";
            //siempre definir bien el url y añadir el class for name ...
             Class.forName("org.postgresql.Driver");
             conexion = DriverManager.getConnection(url,user,password);
             if(conexion != null){
                 System.out.println("conexion establecida");
                 return conexion;
             }
         } catch (SQLException  | ClassNotFoundException ex) {
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