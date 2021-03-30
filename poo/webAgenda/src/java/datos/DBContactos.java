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

public class DBContactos {
    DBConexion cn;
    
    public DBContactos() {
        cn = new DBConexion();
    }
    
    /*public Contacto getContactoById(int id){
        Contacto c = new Contacto();
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, " +
                                                                                " con_nombre, " +
                                                                                " con_apellido, " +
                                                                                " con_telefono_domicilio, " +
                                                                                " con_telefono_oficina," +
                                                                                " con_celular, " +
                                                                                " con_correo, " +
                                                                                " con_direccion_residencia," +
                                                                                " con_direccion_trabajo " +
                                                                        " FROM contactos " + 
                                                                        " WHERE con_id = ? ");
            pstm.setInt(1, id);
            
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                c.setId(res.getInt("con_id"));
                c.setNombre(res.getString("con_nombre"));
                c.setApellido(res.getString("con_apellido"));
                c.setTelefonoDomicilio(res.getString("con_telefono_domicilio"));
                c.setTelefonoOficina(res.getString("con_telefono_oficina"));
                c.setCelular(res.getString("con_celular"));
                c.setCorreo(res.getString("con_correo"));
                c.setDireccionResidencia(res.getString("con_direccion_residencia"));
                c.setDireccionTrabajo(res.getString("con_direccion_trabajo"));
            }
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return c;
    }
    */
    /** trae todos los registros de la tabla contactos */
     public ResultSet getContactos() throws SQLException{
        //List<Contacto> data = null;
        
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, " +
                                                                            " con_nombre, " +
                                                                            " con_apellido, " +
                                                                            " con_telefono_domicilio, " +
                                                                            " con_telefono_oficina," +
                                                                            " con_celular, " +
                                                                            " con_correo, " +
                                                                            " con_direccion_residencia," +
                                                                            " con_direccion_trabajo " +
                                                                    " FROM contactos " + 
                                                                    " ORDER BY con_nombre, con_apellido ");


        ResultSet res = pstm.executeQuery();
        return res;
        /*int i = 0;
        while(res.next()){
            Contacto c = new Contacto();
            c.setId(res.getInt("con_id"));
            c.setNombre(res.getString("con_nombre"));
            c.setApellido(res.getString("con_apellido"));
            c.setTelefonoDomicilio(res.getString("con_telefono_domicilio"));
            c.setTelefonoOficina(res.getString("con_telefono_oficina"));
            c.setCelular(res.getString("con_celular"));
            c.setCorreo(res.getString("con_correo"));
            c.setDireccionResidencia(res.getString("con_direccion_residencia"));
            c.setDireccionTrabajo(res.getString("con_direccion_trabajo"));
            data.add(c);                

        }
        res.close();
         
         */

        //return data;
    }
    /* 
    public int insertarContacto(Contacto c){
        int cont_usuario = -1;
        int resultado = 0;//no hubo errores de validacion
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("select count(1) as cont " +
                                                      " from contactos " +
                                                      " where con_correo = ? ");
            pstm.setString(1, c.getCorreo());
           

            ResultSet res = pstm.executeQuery();
            res.next();
            cont_usuario = res.getInt("cont");
            res.close();
            
            
            if(cont_usuario==0){
                pstm = cn.getConexion().prepareStatement("insert into contactos (con_nombre, " +
                                                                               " con_apellido," +
                                                                               " con_telefono_domicilio," +
                                                                               " con_telefono_oficina," +
                                                                               " con_celular," +
                                                                               " con_correo," +
                                                                               " con_direccion_residencia," +
                                                                               " con_direccion_trabajo) " +
                                                                    " values(?,?,?,?,?,?,?,?)");
                pstm.setString(1, c.getNombre());
                pstm.setString(2, c.getApellido());
                pstm.setString(3, c.getTelefonoDomicilio());
                pstm.setString(4, c.getTelefonoOficina());
                pstm.setString(5, c.getCelular());
                pstm.setString(6, c.getCorreo());
                pstm.setString(7, c.getDireccionResidencia());
                pstm.setString(8, c.getDireccionTrabajo());
                
                pstm.executeUpdate();
                    
                pstm = cn.getConexion().prepareStatement("select last_insert_id()");
                res = pstm.executeQuery();
                res.next();
                resultado = res.getInt(1);
                res.close();
            }else{
                resultado = -2;//el login ya existe
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int actualizarContacto(Contacto c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("update contactos set con_nombre = ?, " +
                                                                               " con_apellido = ?," +
                                                                               " con_telefono_domicilio = ?," +
                                                                               " con_telefono_oficina = ?," +
                                                                               " con_celular = ?," +
                                                                               " con_correo = ?," +
                                                                               " con_direccion_residencia = ?," +
                                                                               " con_direccion_trabajo = ? " +
                                                                        " where con_id = ?");
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getApellido());
            pstm.setString(3, c.getTelefonoDomicilio());
            pstm.setString(4, c.getTelefonoOficina());
            pstm.setString(5, c.getCelular());
            pstm.setString(6, c.getCorreo());
            pstm.setString(7, c.getDireccionResidencia());
            pstm.setString(8, c.getDireccionTrabajo());
            pstm.setInt(9, c.getId());

            resultado = pstm.executeUpdate();
                    
                
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarContacto(Contacto c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from contactos " +
                                                                        " where con_id = ?");
            
            pstm.setInt(1, c.getId());

            resultado = pstm.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }
    */
    public String getMensaje(){
        return cn.getMensaje();
    }

}
