using System;
using System.Collections.Generic;
using System.Text;
using MySql.Data.MySqlClient;

namespace clAlumno
{
    public class AlumnoData
    {
        private MysqlConexion msc;
        private string msn;

        public AlumnoData()
        {
            msc = new MysqlConexion();
        }

        public void insertar(Alumno a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("insert into alumno values(?p1,?p2,?p3)", msc.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Codigo);
                cmd.Parameters.AddWithValue("?p2", a.Nombre);
                cmd.Parameters.AddWithValue("?p3", a.Apellido);

                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al insertar en alumno ("+ex.Message+")";
            }
        }

        public void actualizar(Alumno a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("update alumno set nombre =?p2, apellido = ?p3 where codigo = ?p1", msc.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Codigo);
                cmd.Parameters.AddWithValue("?p2", a.Nombre);
                cmd.Parameters.AddWithValue("?p3", a.Apellido);

                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al actualizar en alumno (" + ex.Message + ")";
            }
        }

        public void borrar(Alumno a)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("delete from alumno where codigo = ?p1", msc.Conexion);
                cmd.Parameters.AddWithValue("?p1", a.Codigo);
                
                cmd.Prepare();

                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                msn = "error al borrar en alumno (" + ex.Message + ")";
            }
        }


        public List<Alumno> consultar()
        {
            List<Alumno> alumnos = new List<Alumno>();
            try
            {
                MySqlCommand cmd = new MySqlCommand("select codigo, nombre, apellido from alumno", msc.Conexion);
                cmd.Prepare();
                MySqlDataReader myReader = cmd.ExecuteReader();
                if (myReader.HasRows)
                {
                    while (myReader.Read())
                    {
                        Alumno a = new Alumno();
                        a.Codigo = myReader["codigo"].ToString();
                        a.Nombre = myReader["nombre"].ToString();
                        a.Apellido = myReader["apellido"].ToString();
                        alumnos.Add(a);
                    }
                    msn = "consulta alumno exitosa";
                }
                else
                {
                    msn = "No hay registros en alumno";
                }
            }
            catch (MySqlException ex)
            {
                msn = "error al consultar alumno(" + ex.Message + ")";
            }
            return alumnos;
        }

        public string Msn
        {
            get { return msn; }
        }
    }
}
