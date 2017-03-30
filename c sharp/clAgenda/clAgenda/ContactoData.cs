using System;
using System.Collections.Generic;
using System.Text;
using MySql.Data.MySqlClient;

namespace clAgenda
{
    public class ContactoData
    {
        private ConexionMySql conMySql;
        private string msn;

        public ContactoData()
        {
            conMySql = new ConexionMySql();
        }

        public void insertar(Contacto a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("insert into contactos values(?p1,?p2,?p3,?p4,?p5,?p6,?p7,?p8,?p9)", conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.PrimerNombre);
                cmd.Parameters.AddWithValue("?p2", a.SegundoNombre);
                cmd.Parameters.AddWithValue("?p3", a.PrimerApellido);
                cmd.Parameters.AddWithValue("?p4", a.SegundoApellido);
                cmd.Parameters.AddWithValue("?p5", a.Direccion);
                cmd.Parameters.AddWithValue("?p6", a.Telefono);
                cmd.Parameters.AddWithValue("?p7", a.Celular);
                cmd.Parameters.AddWithValue("?p8", a.Mail);
                cmd.Parameters.AddWithValue("?p9", a.UsuarioAsignado.Id);

                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al insertar en contacto ("+ex.Message+")";
            }
        }

        public void actualizar(Contacto a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("update contactos set cnt_primer_nombre=?p2, "+
                                                                        " cnt_segundo_nombre=?p3, " +
                                                                        " cnt_primer_apellido=?p4, " +
                                                                        " cnt_segundo_apellido=?p5, " +
                                                                        " cnt_direccion=?p6, " +
                                                                        " cnt_telefono=?p7, " +
                                                                        " cnt_celular=?p8, " +
                                                                        " cnt_mail=?p9, " +
                                                                        " usu_id=?p10 " +
                                                                        " where cnt_id = ?p1", conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Id);
                cmd.Parameters.AddWithValue("?p2", a.PrimerNombre);
                cmd.Parameters.AddWithValue("?p3", a.SegundoNombre);
                cmd.Parameters.AddWithValue("?p4", a.PrimerApellido);
                cmd.Parameters.AddWithValue("?p5", a.SegundoApellido);
                cmd.Parameters.AddWithValue("?p6", a.Direccion);
                cmd.Parameters.AddWithValue("?p7", a.Telefono);
                cmd.Parameters.AddWithValue("?p8", a.Celular);
                cmd.Parameters.AddWithValue("?p9", a.Mail);
                cmd.Parameters.AddWithValue("?p10", a.UsuarioAsignado.Id);
                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al actualizar en contacto (" + ex.Message + ")";
            }
        }

        public void borrar(Contacto a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("delete from contactos where cnt_id = ?p1", conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Id);
                
                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al borrar en contacto (" + ex.Message + ")";
            }
        }


        public List<Contacto> consultar()
        {
            List<Contacto> contactos = new List<Contacto>();
            try
            {
                MySqlCommand cmd = new MySqlCommand("select cnt_id, cnt_primer_nombre, "+
                                                          " cnt_segundo_nombre, cnt_primer_apellido, " +
                                                          " cnt_segundo_apellido, cnt_direccion, " +
                                                          " cnt_telefono, cnt_celular, " +
                                                          " cnt_mail, usu_id " +
                                                          " from contactos", conMySql.Conexion);
                cmd.Prepare();
                MySqlDataReader myReader = cmd.ExecuteReader();
                if (myReader.HasRows)
                {
                    while (myReader.Read())
                    {
                        Contacto a = new Contacto();
                        a.Id = Int16.Parse(myReader["cnt_id"].ToString());
                        a.PrimerNombre = myReader["cnt_primer_nombre"].ToString();
                        a.SegundoNombre = myReader["cnt_segundo_nombre"].ToString();
                        a.PrimerApellido = myReader["cnt_primer_apellido"].ToString();
                        a.SegundoApellido = myReader["cnt_segundo_apellido"].ToString();
                        a.Direccion = myReader["cnt_direccion"].ToString();
                        a.Telefono = myReader["cnt_telefono"].ToString();
                        a.Celular = myReader["cnt_celular"].ToString();
                        a.Mail = myReader["cnt_mail"].ToString();
                        UsuarioData ud = new UsuarioData();
                        Usuario x = ud.getUsuarioById(Int16.Parse(myReader["usu_id"].ToString()));
                        a.UsuarioAsignado = x;
                        contactos.Add(a);
                    }
                    msn = "consultar contactos exitosa";
                }
                else
                {
                    msn = "No hay registros en contactos";
                }
            }
            catch (MySqlException ex)
            {
                msn = "error al consultar contactos(" + ex.Message + ")";
            }
            return contactos;
        }

        public List<Contacto> consultarByUserId(int id)
        {
            List<Contacto> contactos = new List<Contacto>();
            try
            {
                MySqlCommand cmd = new MySqlCommand("select cnt_id, cnt_primer_nombre, " +
                                                          " cnt_segundo_nombre, cnt_primer_apellido, " +
                                                          " cnt_segundo_apellido, cnt_direccion, " +
                                                          " cnt_telefono, cnt_celular, " +
                                                          " cnt_mail, usu_id " +
                                                          " from contactos " +
                                                          " where usu_id = ?p1 ", conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", id);
                cmd.Prepare();
                MySqlDataReader myReader = cmd.ExecuteReader();
                if (myReader.HasRows)
                {
                    while (myReader.Read())
                    {
                        Contacto a = new Contacto();
                        a.Id = Int16.Parse(myReader["cnt_id"].ToString());
                        a.PrimerNombre = myReader["cnt_primer_nombre"].ToString();
                        a.SegundoNombre = myReader["cnt_segundo_nombre"].ToString();
                        a.PrimerApellido = myReader["cnt_primer_apellido"].ToString();
                        a.SegundoApellido = myReader["cnt_segundo_apellido"].ToString();
                        a.Direccion = myReader["cnt_direccion"].ToString();
                        a.Telefono = myReader["cnt_telefono"].ToString();
                        a.Celular = myReader["cnt_celular"].ToString();
                        a.Mail = myReader["cnt_mail"].ToString();
                        UsuarioData ud = new UsuarioData();
                        Usuario x = ud.getUsuarioById(Int16.Parse(myReader["usu_id"].ToString()));
                        a.UsuarioAsignado = x;
                        contactos.Add(a);
                    }
                    msn = "consultar contactos exitosa";
                }
                else
                {
                    msn = "No hay registros en contactos";
                }
            }
            catch (MySqlException ex)
            {
                msn = "error al consultar contactos(" + ex.Message + ")";
            }
            return contactos;
        }

        public string Msn
        {
            get { return msn; }
        }
    }
}
