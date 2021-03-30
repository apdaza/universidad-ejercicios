/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alejandro.daza.clientes.logica;

import alejandro.daza.clientes.datos.DBCliente;

/**
 *
 * @author alejo
 */
public class Cliente {
    String cedula;
    String nombre;
    String apellido;
    String telefono;
    String correo;

    public Cliente() {
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void crearCliente(){
        DBCliente dbc = new DBCliente();
        dbc.insertarCliente(this);
    }
    
    public void actualizarCliente(){
        DBCliente dbc = new DBCliente();
        dbc.actualizarCliente(this);
    }
    
    public void borrarCliente(){
        DBCliente dbc = new DBCliente();
        dbc.borrarCliente(this);
    }
    
    public Cliente[] getClientes(){
        DBCliente dbc = new DBCliente();
        Cliente[] c = dbc.getClientes();
        return c;
    }
    
    

}
