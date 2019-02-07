/*
 * DBConexion.java
 * 
 * Created on 7/04/2008, 10:01:58 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udistrital.pryagenda.datos;


import java.sql.*;
/**
 *
 * @author alejo
 */
public class DBConexion {
    static String bd = "agenda";
    static String login = "root";
    static String password = "apdaza777";
    static String url = "jdbc:mysql://localhost/"+bd;
    
    Connection conexion = null;
    
    public DBConexion() {
        try{
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(url,login,password);

                if (conexion!=null){
                        System.out.println("Conexión a base de datos "+bd+" OK");
                }
        }catch(SQLException e){
                System.out.println(e);
        }catch(ClassNotFoundException e){
                System.out.println(e);
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }

    public void desconectar(){
        conexion = null;
    }

}
