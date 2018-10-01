/*
 * DbUser.java
 *
 * Created on 2 de diciembre de 2006, 12:36
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
public class DbUser {
    DbConnection cn;
	
    /** Creates a new instance of DbUser */
    public DbUser() {
        cn = new DbConnection();
    }
    
    public boolean valUsuario(String u, String c){
	boolean r=false;
	try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("select count(1) as cont " +
                                        				" from usuario " +
                                                                        " where usuario = ? " +
                                                                        " and clave = md5(?)");
            pstm.setString(1, u);
            pstm.setString(2, c);

            ResultSet res = pstm.executeQuery();
            res.next();
            int cont = res.getInt("cont");
            res.close();
            
            
            if(cont>=1){r = true;}else{r = false;}
        }catch(SQLException e){
            System.out.println(e);
        }
        return r;
    }
    /** obtiene el id del usuario */
    public int getIdUsuario(String u, String c){
        int id = -1;
        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("select id " +
                                                                        " from usuario " +
                                                                        " where usuario = ? " +
                                                                        " and clave = md5(?)");
            pstm.setString(1, u);
            pstm.setString(2, c);

            ResultSet res = pstm.executeQuery();
            res.next();
            id = res.getInt("id");
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return id;
    }
    /**obtiene las opciones del menu asociadas al usuario */
    public Object[][] getMenuUsuario(int id){
        int registros = 0;

        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("SELECT count(1) as cont" +
                                            " FROM opciones o,rol_usuario ru, rol_opciones ro" +
                                            " WHERE o.id=ro.id_opcion" +
                                            " and ru.id_rol = ro.id_rol" +
                                            " and ru.id_usuario = ?");
            pstm.setInt(1, id);

            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close();			
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        Object [][] data = new Object[registros][5];
        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("SELECT o.nombre as nombre," +
                                                                        " o.nivel as nivel," +
                                                                        " o.id_padre as padre," +
                                                                        " o.id as id_menu," +
                                                                        " o.task as task " +
                                                                        " FROM opciones o,rol_usuario ru, rol_opciones ro" +
                                                                        " WHERE o.id=ro.id_opcion" +
                                                                        " and ru.id_rol = ro.id_rol" +
                                                                        " and ru.id_usuario = ?" + 
                                                                        " ORDER BY o.id_padre, o.orden");
            pstm.setInt(1, id);

            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String nombre = res.getString("nombre");
                String nivel = res.getString("nivel");
                String padre = res.getString("padre");
                String id_menu = res.getString("id_menu");
                String task = res.getString("task");

                data[i][0] = nombre;
                data[i][1] = nivel;
                data[i][2] = padre;
                data[i][3] = id_menu;
                data[i][4] = task;

                i++;
            }
            res.close();	
            
            
        }catch(SQLException e){
         System.out.println(e);
        }
        return data;
    }
    /** trae todos los usuarios para su administracion */
     public Object[][] getUsuarios(){
        int registros = 0;

        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("SELECT count(1) as cont" +
            " FROM usuario ");
            

            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        Object [][] data = new Object[registros][5];
        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("SELECT id, " +
                                                                        " usuario, " +
                                                                        " nombres, " +
                                                                        " apellidos," +
                                                                        " estado " +
                                                                        " FROM usuario " + 
                                                                        " ORDER BY usuario ");
            

            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String id = res.getString("id");
                String usuario = res.getString("usuario");
                String nombres = res.getString("nombres");
                String apellidos = res.getString("apellidos");
                String estado = res.getString("estado");
                

                data[i][0] = id;
                data[i][1] = usuario;
                data[i][2] = nombres;
                data[i][3] = apellidos;
                data[i][4] = estado;
                

                i++;
            }
            res.close();	
            
            
        }catch(SQLException e){
         System.out.println(e);
        }
        return data;
    }
     
    /** actualiza un usuario */
    public int updateUsuario(int id, String u, String c, String n, String a, String s, int r ){
        int cont_id = -1;
        int cont_usuario = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("select count(1) as cont " +
                                                                        " from usuario " +
                                                                        " where id = ? ");
            pstm.setInt(1, id);
           

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_id = res.getInt("cont");
            res.close();
            
            
            
            pstm = cn.getConeccion().prepareStatement("select count(1) as cont " +
                                                      " from usuario " +
                                                      " where usuario = ? " +
                                                      " and id <> ?");
            pstm.setString(1, u);
            pstm.setInt(2, id);

            res = pstm.executeQuery();
            res.next();
            cont_usuario = res.getInt("cont");
            res.close();
            System.out.println("cont_usuario = "+cont_usuario);
            if(cont_id==1){
                if(cont_usuario==0){
                    if(u.length()>0 && c.length()>0 && n.length()>0 && a.length()>0 && s.length()==1){
                        pstm = cn.getConeccion().prepareStatement("update usuario set usuario = ?, " +
                                                        " clave = md5(?), " +
                                                        " nombres = ?, " +
                                                        " apellidos = ?, " +
                                                        " estado = ? " +
                                                        " where id = ? ");
                        pstm.setString(1, u);
                        pstm.setString(2, c);
                        pstm.setString(3, n);
                        pstm.setString(4, a);
                        pstm.setString(5, s);
                        pstm.setInt(6, id);
                        
                        pstm.executeUpdate();
                        
                        pstm = cn.getConeccion().prepareStatement("delete from rol_usuario " +
                                " where id_usuario = ? and id_rol <> 0 ");
                        pstm.setInt(1, id);
                        pstm.executeUpdate();
                        
                        pstm = cn.getConeccion().prepareStatement("insert into rol_usuario " +
                                " (id_rol,id_usuario) " +
                                " values(?,?)");
                        pstm.setInt(1, r);
                        pstm.setInt(2, id);
                        pstm.executeUpdate();
                        
                    }else{
                        resultado = 3;//valores de los campos no validos
                    }
                }else{
                    resultado = 2;//el login ya existe
                }
            }else{
                resultado = 1;//el id de usuario no existe
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    /** inserta un usuario */
    public int insertUsuario(String u, String c, String n, String a, String s, int r ){
        int cont_usuario = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("select count(1) as cont " +
                                                      " from usuario " +
                                                      " where usuario = ? ");
            pstm.setString(1, u);
           

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_usuario = res.getInt("cont");
            res.close();
            
            
            if(cont_usuario==0){
                if(u.length()>0 && c.length()>0 && n.length()>0 && a.length()>0 && s.length()==1){
                    pstm = cn.getConeccion().prepareStatement("insert into usuario " +
                            " (usuario,clave,nombres,apellidos,estado) " +
                            " values(?,md5(?),?,?,?)");
                    pstm.setString(1, u);
                    pstm.setString(2, c);
                    pstm.setString(3, n);
                    pstm.setString(4, a);
                    pstm.setString(5, s);
                    

                    pstm.executeUpdate();
                    
                    pstm = cn.getConeccion().prepareStatement("select id " +
                                                       " from usuario " +
                                                       " where usuario = ? " +
                                                       " and clave = md5(?)");
                    pstm.setString(1, u);
                    pstm.setString(2, c);

                    res = pstm.executeQuery();
                    res.next();
                    resultado = res.getInt("id");
                    res.close();
                    
                    pstm = cn.getConeccion().prepareStatement("insert into rol_usuario " +
                                " (id_rol,id_usuario) " +
                                " values(?,?)");
                    pstm.setInt(1, r);
                    pstm.setInt(2, resultado);
                    pstm.executeUpdate();
                    
                    pstm = cn.getConeccion().prepareStatement("insert into rol_usuario " +
                                " (id_rol,id_usuario) " +
                                " values(0,?)");
                    pstm.setInt(1, resultado);
                    pstm.executeUpdate();
                    
                }else{
                    resultado = -3;//valores de los campos no validos
                }
            }else{
                resultado = -2;//el login ya existe
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    /** inserta un usuario */
    public int deleteUsuario(int id){
        int cont_usuario = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            Statement stm = cn.getConeccion().createStatement();
            PreparedStatement pstm = cn.getConeccion().prepareStatement("select count(1) as cont " +
                                                      " from usuario " +
                                                      " where id = ? ");
            pstm.setInt(1, id);
           

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_usuario = res.getInt("cont");
            res.close();
            
            
            if(cont_usuario==1){
                
                pstm = cn.getConeccion().prepareStatement("delete from usuario " +
                        " where id = ? ");
                pstm.setInt(1, id);
               
                pstm.executeUpdate();
                
                pstm = cn.getConeccion().prepareStatement("delete from rol_usuario " +
                                " where id_usuario = ? ");
                        pstm.setInt(1, id);
                        pstm.executeUpdate();
                
            }else{
                resultado = -2;//el id no existe
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
}
