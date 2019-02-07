/*
 * DBContactos.java
 * 
 * Created on 7/04/2008, 10:26:02 PM
 */
package datos;

import java.sql.*;
import logica.Contacto;
import logica.Registro;

public class DBContactos extends DBTabla{

    @Override
    public ResultSet getRegistroById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_nombre, "
                + " con_apellido, "
                + " con_telefono_domicilio, "
                + " con_telefono_oficina,"
                + " con_celular, "
                + " con_correo, "
                + " con_direccion_residencia,"
                + " con_direccion_trabajo "
                + " FROM contactos "
                + " WHERE con_id = ? ");
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();

        return res;
    }

    @Override
    public ResultSet getRegistros() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_nombre, "
                + " con_apellido, "
                + " con_telefono_domicilio, "
                + " con_telefono_oficina,"
                + " con_celular, "
                + " con_correo, "
                + " con_direccion_residencia,"
                + " con_direccion_trabajo "
                + " FROM contactos "
                + " ORDER BY con_nombre, con_apellido ");


        ResultSet res = pstm.executeQuery();
        return res;
    }

    @Override
    public void insertarRegistro(Registro x) {
        Contacto c = (Contacto)x;
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into contactos (con_nombre, "
                    + " con_apellido,"
                    + " con_telefono_domicilio,"
                    + " con_telefono_oficina,"
                    + " con_celular,"
                    + " con_correo,"
                    + " con_direccion_residencia,"
                    + " con_direccion_trabajo) "
                    + " values(?,?,?,?,?,?,?,?)");
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getApellido());
            pstm.setString(3, c.getTelefonoDomicilio());
            pstm.setString(4, c.getTelefonoOficina());
            pstm.setString(5, c.getCelular());
            pstm.setString(6, c.getCorreo());
            pstm.setString(7, c.getDireccionResidencia());
            pstm.setString(8, c.getDireccionTrabajo());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualizarRegistro(Registro x) {
        Contacto c = (Contacto)x;
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update contactos set con_nombre = ?, "
                    + " con_apellido = ?,"
                    + " con_telefono_domicilio = ?,"
                    + " con_telefono_oficina = ?,"
                    + " con_celular = ?,"
                    + " con_correo = ?,"
                    + " con_direccion_residencia = ?,"
                    + " con_direccion_trabajo = ? "
                    + " where con_id = ?");
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getApellido());
            pstm.setString(3, c.getTelefonoDomicilio());
            pstm.setString(4, c.getTelefonoOficina());
            pstm.setString(5, c.getCelular());
            pstm.setString(6, c.getCorreo());
            pstm.setString(7, c.getDireccionResidencia());
            pstm.setString(8, c.getDireccionTrabajo());
            pstm.setInt(9, c.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void borrarRegistro(Registro c) {
        Contacto xc = (Contacto)c;
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from contactos "
                    + " where con_id = ?");

            pstm.setInt(1, xc.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
