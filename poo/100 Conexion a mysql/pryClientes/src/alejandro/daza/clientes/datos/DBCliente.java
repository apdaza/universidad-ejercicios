/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alejandro.daza.clientes.datos;

import alejandro.daza.clientes.logica.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alejo
 */
public class DBCliente {
    DBConexion cn;
    
    public DBCliente() {
        cn = new DBConexion();
    }
    
    public Cliente[] getClientes(){
        Cliente[] cls = null;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT clt_id, clt_nombre,clt_apellido, " +
                                                                             " clt_telefono,clt_correo " +
                                                                        " FROM cliente " + 
                                                                        " ORDER BY clt_nombre, clt_apellido ");
            

            ResultSet res = cn.ejecutarConsulta(pstm);
            res.last();
            int tam = res.getRow();
            res.beforeFirst();
            int i = 0;
            cls = new Cliente[tam];
            while(res.next()){
                cls[i] = new Cliente();
                cls[i].setCedula(res.getString("clt_id"));
                cls[i].setNombre(res.getString("clt_nombre"));
                cls[i].setApellido(res.getString("clt_apellido"));
                cls[i].setTelefono(res.getString("clt_telefono"));
                cls[i].setCorreo(res.getString("clt_correo"));
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return cls;
    }
    
    public void insertarCliente(Cliente c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into cliente(clt_id,clt_nombre," +
                                                                                            "clt_apellido,clt_telefono," +
                                                                                            "clt_correo) " +
                                                                                    " values(?,?,?,?,?)");
            pstm.setString(1, c.getCedula());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getApellido());
            pstm.setString(4, c.getTelefono());
            pstm.setString(5, c.getCorreo());
            
            cn.ejecutarActualizacion(pstm);
        }catch(SQLException e){
           System.out.println(e); 
        }
    }
    
    public void actualizarCliente(Cliente c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("update cliente set clt_nombre = ?," +
                                                                                          " clt_apellido = ?," +
                                                                                          " clt_telefono = ?," +
                                                                                          " clt_correo = ? " +
                                                                                   " where clt_id = ?");
            
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getApellido());
            pstm.setString(3, c.getTelefono());
            pstm.setString(4, c.getCorreo());
            pstm.setString(5, c.getCedula());
            cn.ejecutarActualizacion(pstm);
        }catch(SQLException e){
           System.out.println(e); 
        }
    }
    
    public void borrarCliente(Cliente c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from cliente where clt_id = ?");
            pstm.setString(1, c.getCedula());
            cn.ejecutarActualizacion(pstm);
        }catch(SQLException e){
           System.out.println(e); 
        }
    }
    
}
