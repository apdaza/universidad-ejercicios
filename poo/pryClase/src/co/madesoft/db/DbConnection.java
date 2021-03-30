package co.madesoft.db;

import java.sql.*;
/**
 * Clase que permite conectar con la base de datos
 * @author alejo
 */
public class DbConnection {
    static String bd = "clase";
    static String login = "root";
    static String password = "apdaza777";
    static String url = "jdbc:mysql://localhost/"+bd;

    Connection conn = null;
    
    /** Constructor de DbConnection */
    public DbConnection() {
        try{
        		//obtenemos el driver de para mysql
                Class.forName("com.mysql.jdbc.Driver");
                //obtenemos la conexión
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
    /**Permite retornar la conexión*/
    public Connection getConnection(){
        return conn;
    }

    public void desconectar(){
        conn = null;
    }
    
}
