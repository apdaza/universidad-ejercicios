/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alejandro.daza.clientes.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alejo
 */
public class DBConexion {
    static String bd = "clientes";
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
    
    public ResultSet ejecutarConsulta(PreparedStatement pstm){
        ResultSet res = null;
        try{
            res = pstm.executeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
    
    public void ejecutarActualizacion(PreparedStatement pstm){
        try{
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}

