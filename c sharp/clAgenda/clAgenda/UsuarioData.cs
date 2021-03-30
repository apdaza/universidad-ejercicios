using System;
using System.Collections.Generic;
using System.Text;
using MySql.Data.MySqlClient;

namespace clAgenda
{
    public class UsuarioData
    {
        private ConexionMySql conMySql;
        private string msn;

        public UsuarioData()
        {
            conMySql = new ConexionMySql();
        }

        public void insertar(Usuario a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("insert into usuarios values(?p1,?p2,?p3,?p4,?p5)", conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Id);
                cmd.Parameters.AddWithValue("?p2", a.Login);
                cmd.Parameters.AddWithValue("?p3", a.Clave);
                cmd.Parameters.AddWithValue("?p4", a.Nombre);
                cmd.Parameters.AddWithValue("?p5", a.Apellido);

                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al insertar en usuario ("+ex.Message+")";
            }
        }

        public void actualizar(Usuario a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("update usuarios set usu_login=?p2, usu_clave=md5(?p3), usu_nombre =?p4, usu_apellido = ?p5 where usu_id = ?p1", conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Id);
                cmd.Parameters.AddWithValue("?p2", a.Login);
                cmd.Parameters.AddWithValue("?p3", a.Clave);
                cmd.Parameters.AddWithValue("?p4", a.Nombre);
                cmd.Parameters.AddWithValue("?p5", a.Apellido);

                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al actualizar en usuario (" + ex.Message + ")";
            }
        }

        public void borrar(Usuario a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("delete from usuarios where usu_id = ?p1", conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Id);
                
                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al borrar en usuario (" + ex.Message + ")";
            }
        }


        public List<Usuario> consultar()
        {
            List<Usuario> usuarios = new List<Usuario>();
            try
            {
                MySqlCommand cmd = new MySqlCommand("select usu_id, usu_login, usu_nombre, usu_apellido from usuarios", conMySql.Conexion);
                cmd.Prepare();
                MySqlDataReader myReader = cmd.ExecuteReader();
                if (myReader.HasRows)
                {
                    while (myReader.Read())
                    {
                        Usuario a = new Usuario();
                        a.Id = Int16.Parse(myReader["usu_id"].ToString());
                        a.Login = myReader["usu_login"].ToString();
                        a.Nombre = myReader["usu_nombre"].ToString();
                        a.Apellido = myReader["usu_apellido"].ToString();
                        usuarios.Add(a);
                    }
                    msn = "consultar usuarios exitosa";
                }
                else
                {
                    msn = "No hay registros en usuario";
                }
            }
            catch (MySqlException ex)
            {
                msn = "error al consultar usuario(" + ex.Message + ")";
            }
            return usuarios;
        }

        public Usuario getUsuarioByLogin(string login, string clave)
        {
            Usuario usuario = new Usuario();
            try
            {
                MySqlCommand cmd = new MySqlCommand("select usu_id, usu_login, usu_nombre, usu_apellido " +
                                                    "from usuarios " +
                                                    "where usu_login = ?p1 and usu_clave = md5(?p2)"
                                                    , conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", login);
                cmd.Parameters.AddWithValue("?p2", clave);
                cmd.Prepare();
               
                MySqlDataReader myReader = cmd.ExecuteReader();
                if (myReader.HasRows)
                {
                    myReader.Read();
                    
                    usuario.Id = Int16.Parse(myReader["usu_id"].ToString());
                    usuario.Login = myReader["usu_login"].ToString();
                    usuario.Nombre = myReader["usu_nombre"].ToString();
                    usuario.Apellido = myReader["usu_apellido"].ToString();
                    
                    msn = "consulta usuarios exitosa";
                }
                else
                {
                    msn = "No hay registros coincidentes en usuario";
                }
            }
            catch (MySqlException ex)
            {
                msn = "error al getUsuarioByLogin(" + ex.Message + ")";
            }
            return usuario;
        }

        public Usuario getUsuarioById(Int16 id)
        {
            Usuario usuario = new Usuario();
            try
            {
                MySqlCommand cmd = new MySqlCommand("select usu_id, usu_login, usu_nombre, usu_apellido " +
                                                    "from usuarios " +
                                                    "where usu_id = ?p1"
                                                    , conMySql.Conexion);
                cmd.Parameters.AddWithValue("?p1", id);
                cmd.Prepare();

                MySqlDataReader myReader = cmd.ExecuteReader();
                if (myReader.HasRows)
                {
                    myReader.Read();

                    usuario.Id = Int16.Parse(myReader["usu_id"].ToString());
                    usuario.Login = myReader["usu_login"].ToString();
                    usuario.Nombre = myReader["usu_nombre"].ToString();
                    usuario.Apellido = myReader["usu_apellido"].ToString();

                    msn = "consulta usuarios exitosa";
                }
                else
                {
                    msn = "No hay registros coincidentes en usuario";
                }
            }
            catch (MySqlException ex)
            {
                msn = "error al getUsuarioById(" + ex.Message + ")";
            }
            return usuario;
        }


        public string Msn
        {
            get { return msn; }
        }
    }
}
