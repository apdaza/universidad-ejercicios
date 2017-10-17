/*
 * DBContactos.java
 * 
 * Created on 7/04/2008, 10:26:02 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import java.sql.*;
import logica.*;

public class DBCitas {
    DBConexion cn;
    
    public DBCitas() {
        cn = new DBConexion();
    }
    /** trae una cita por su id*/
    public Cita getCitaById(int id){
        Cita data = new Cita();
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT cit_id, " +
                                                                                " con_id, " +
                                                                                " cit_lugar, " +
                                                                                " cit_fecha, " +
                                                                                " cit_hora," +
                                                                                " cit_asunto " +
                                                                        " FROM citas " + 
                                                                        " where cit_id = ? ");
            

            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            DBContactos dbc = new DBContactos();
            if(res.next()){
                data = new Cita();
                data.setId(res.getInt("cit_id"));
                //data.setContacto(dbc.getContactoById(res.getInt("con_id")));
                data.setLugar(res.getString("cit_lugar"));
                data.setFecha(res.getString("cit_fecha"));
                data.setHora(res.getString("cit_hora"));
                data.setAsunto(res.getString("cit_asunto"));
            }
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    /** trae todos los registros de la tabla contactos */
     public Cita[] getCitas(){
        int registros = 0;

        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont" +
            " FROM citas ");
            
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        Cita[] data = new Cita[registros];
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT cit_id, " +
                                                                                " con_id, " +
                                                                                " cit_lugar, " +
                                                                                " cit_fecha, " +
                                                                                " cit_hora," +
                                                                                " cit_asunto " +
                                                                        " FROM citas " + 
                                                                        " ORDER BY cit_fecha desc, cit_hora desc ");
            

            ResultSet res = pstm.executeQuery();
            int i = 0;
            DBContactos dbc = new DBContactos();
            while(res.next()){
                data[i] = new Cita();
                data[i].setId(res.getInt("cit_id"));
                //data[i].setContacto(dbc.getContactoById(res.getInt("con_id")));
                data[i].setLugar(res.getString("cit_lugar"));
                data[i].setFecha(res.getString("cit_fecha"));
                data[i].setHora(res.getString("cit_hora"));
                data[i].setAsunto(res.getString("cit_asunto"));
                i++;
            }
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
     
    public int insertarCita(Cita c){
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into citas (con_id," +
                                                                               " cit_lugar," +
                                                                               " cit_fecha," +
                                                                               " cit_hora," +
                                                                               " cit_asunto) " +
                                                                    " values(?,?,?,?,?)");
            pstm.setInt(1, c.getContacto().getId());
            pstm.setString(2, c.getLugar());
            pstm.setString(3, c.getFecha());
            pstm.setString(4, c.getHora());
            pstm.setString(5, c.getAsunto());
            pstm.executeUpdate();

            pstm = cn.getConexion().prepareStatement("select last_insert_id()");
            ResultSet res = pstm.executeQuery();
            res.next();
            resultado = res.getInt(1);
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int actualizarCita(Cita c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("update citas set con_id = ?, " +
                                                                               " cit_lugar = ?," +
                                                                               " cit_fecha = ?," +
                                                                               " cit_hora = ?," +
                                                                               " cit_asunto = ? " +
                                                                        " where cit_id = ?");
            pstm.setInt(1, c.getContacto().getId());
            pstm.setString(2, c.getLugar());
            pstm.setString(3, c.getFecha());
            pstm.setString(4, c.getHora());
            pstm.setString(5, c.getAsunto());
            pstm.setInt(6, c.getId());

            resultado = pstm.executeUpdate();
                    
                
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarCita(Cita c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from citas " +
                                                                        " where cit_id = ?");
            
            pstm.setInt(1, c.getId());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }

}
