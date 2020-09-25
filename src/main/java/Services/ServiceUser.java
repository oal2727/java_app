/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DatabaseConfig.Conexion;
import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author josel
 */
public class ServiceUser extends Conexion{
    //we need close connection
    private String sql;
    //we need best practices sql 
     public String EncryptionPassword(String password){
          String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
         return bcryptHashString;
     }
     public boolean desencriptionPassword(String password,String hashingpassword){
         BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashingpassword);
        return result.verified;
     }
    
    
    public int RegisterUser(Usuario user){
           try{
                sql = "SELECT * FROM usuario where usuario=?";
               PreparedStatement query1 = this.getConexion().prepareStatement(sql);
               query1.setString(1,user.usuario);
               ResultSet output = query1.executeQuery();
               if(output.next()){
                   System.out.println("usuario ya existente");
                   return -1;
               }else{
                   System.out.println("prosigue");
                   sql = "INSERT INTO usuario(nombre,apellido,usuario,password) values(?,?,?,?)";
                    PreparedStatement query2 = this.getConexion().prepareStatement(sql);
                    query2.setString(1,user.nombre);
                    query2.setString(2,user.apellido);
                    query2.setString(3,user.usuario);
                    query2.setString(4,user.password);
                    int x = query2.executeUpdate();
                   return x;
               }
           }catch(SQLException e){
                System.out.println("Problema registrar" + e);
           }
           return 0;
    }
//    public int LoginUser(String usuario,String password){
//        try{
//              sql ="SELECT * FROM usuario where user=? and password=?";
//              PreparedStatement query = this.getConexion().prepareStatement(sql);
//              query.setString(1,usuario);
//              query.setString(2,password);
//              ResultSet res = query.executeQuery();
//              return (res.absolute(1)) ? 1 : 0;
//        }catch(SQLException e){
//             System.out.println("Error " + e);
//        }
//        return 0;
//    }
    public Usuario checkUser(String usuario){
        Usuario user;
        try{
            sql ="SELECT * FROM usuario where usuario=?";
            PreparedStatement query = this.getConexion().prepareStatement(sql);
            query.setString(1, usuario);
            ResultSet res = query.executeQuery();
            if(res.next()){
                 user = new Usuario(res.getString("nombre"),res.getString("apellido"),
                         res.getString("usuario"),res.getString("password"));
                 return user;
            }else{
                return null;
            }
        }catch(SQLException e){
             System.out.println("Error " + e);
        }
        return null;
    }
 
}
