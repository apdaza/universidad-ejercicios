/*
 * DbRol.java
 *
 * Created on 7 de diciembre de 2006, 23:22
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
public class DbRol {
    DbConnection cn;
    /** Creates a new instance of DbRol */
    public DbRol() {
        cn = new DbConnection();
    }
    
    /** trae todos los usuarios para su administracion */
     public Object[][] getRoles(){
        int registros = 0;

        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("SELECT count(1) as cont" +
            " FROM rol ");
            

            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        Object [][] data = new Object[registros][2];
        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("SELECT id, " +
                                                                        " nombre " +
                                                                        " FROM rol " + 
                                                                        " ORDER BY nombre ");
            

            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String id = res.getString("id");
                String nombre = res.getString("nombre");
                
                data[i][0] = id;
                data[i][1] = nombre;
                
                i++;
            }
            res.close();	
            
            
        }catch(SQLException e){
         System.out.println(e);
        }
        return data;
    }
    
}
