/*
 * DbConnection.java
 *
 * Created on 2 de diciembre de 2006, 12:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package co.madesoft.db;

import java.sql.*;
/**
 *
 * @author alejo
 */
public class DbConnection {
    static String bd = "dbinventario";
    static String login = "root";
    static String password = "apdaza777";
    static String url = "jdbc:mysql://localhost/"+bd;

    Connection conn = null;
    
    /** Creates a new instance of DbConnection */
    public DbConnection() {
        try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url,login,password);

                if (conn!=null){
                        System.out.println("Conección a base de datos "+bd+" OK");
                }
        }catch(SQLException e){
                System.out.println(e);
        }catch(ClassNotFoundException e){
                System.out.println(e);
        }
    }
    
    public Connection getConeccion(){
        return conn;
    }

    public void desconectar(){
        conn = null;
    }
    
}
