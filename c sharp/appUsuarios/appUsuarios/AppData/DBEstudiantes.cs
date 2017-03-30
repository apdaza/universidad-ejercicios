using System;
using System.Collections.Generic;
using System.Text;
using MySQLDriverCS;

namespace appUsuarios.AppData
{
    class DBEstudiantes:MySqlConectar
    {
        public int contarEstudiantes()
        {
            int cont = 0;
            String CadenaSql = "select count(1) from estudiante ";
            try
            {
                MySQLDataReader ds;
                MySQLCommand query;
                cnn.Open();
                query = new MySQLCommand(CadenaSql, cnn);
                ds = query.ExecuteReaderEx();

                ds.Read();
                cont = int.Parse(ds.GetValue(0).ToString());

            }
            catch (MySQLException e)
            {
                System.Console.WriteLine(e.Message.ToString());
            }
            finally
            {
                cnn.Close();
            }
            return cont;
        }
        
        public String[,] getEstudiantes()
        {
            String CadenaSqlCont = "select count(1) from estudiante ";
            String CadenaSql = "select codigo, nombre, apellido, correo from estudiante ";
            String[,] estudiantes = null;
            try
            {
                MySQLDataReader ds;
                MySQLCommand query;
                cnn.Open();
                query = new MySQLCommand(CadenaSqlCont, cnn);
                ds = query.ExecuteReaderEx();
                ds.Read();
                int cont = ds.GetInt16(0);
                query = new MySQLCommand(CadenaSql, cnn);
                ds = query.ExecuteReaderEx();
                estudiantes = new String[cont, 4];
                int i=0;
                while(ds.Read())
                {
                    estudiantes[i,0]= ds.GetValue(0).ToString();
                    estudiantes[i,1]= ds.GetValue(1).ToString();
                    estudiantes[i,2]= ds.GetValue(2).ToString();
                    estudiantes[i,3]= ds.GetValue(3).ToString();
                    i++;
                }

            }
            catch (MySQLException e)
            {
                System.Console.WriteLine(e.Message.ToString());
            }
            finally
            {
                cnn.Close();
            }
            return estudiantes;
        }
    }
}
