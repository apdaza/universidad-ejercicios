/*
 * DBConexion.java
 * 
 * Created on 7/04/2008, 10:01:58 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;


import java.sql.*;
/**
 *
 * @author alejo
 */
public class DBConexion {
    static String bd = "agenda";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    static String mensaje = "";
    
    Connection conexion = null;
    
    public DBConexion() {
        try{
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(url,login,password);

                if (conexion!=null){
                        System.out.println("Conexión a base de datos "+bd+" OK");
                }
        }catch(SQLException e){
                mensaje = e.getMessage();
        }catch(ClassNotFoundException e){
                mensaje = e.getMessage();
        }
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        DBConexion.mensaje = mensaje;
    }
        
    public Connection getConexion(){
        return conexion;
    }

    public void desconectar(){
        conexion = null;
    }

}
