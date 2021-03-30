/*
 * DBContactos.java
 * 
 * Created on 7/04/2008, 10:26:02 PM
 */
package datos;

import java.sql.*;
import logica.Contacto;
import logica.Registro;

public abstract class DBTabla {

    DBConexion cn;
    
    public DBTabla() {
        cn = new DBConexion();
    }

    /**
     * trae un registro de la tabla
     */
    public abstract ResultSet getRegistroById(int id) throws SQLException;

    /**
     * trae todos los registros de la tabla
     */
    public abstract ResultSet getRegistros() throws SQLException;

    /**
     * inserta un registro en la tabla
     */
    public abstract void insertarRegistro(Registro c);

    /**
     * actualiza un registro en la tabla
     */
    public abstract void actualizarRegistro(Registro c);

    /**
     * borra un registro en la tabla
     */
    public abstract void borrarRegistro(Registro c);

    /**
     * retorna un mensaje de gestion
     */
    public String getMensaje() {
        return cn.getMensaje();
    }
}
