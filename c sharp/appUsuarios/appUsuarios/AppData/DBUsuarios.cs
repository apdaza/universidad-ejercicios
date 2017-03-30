using System;
using System.Collections.Generic;
using System.Text;
using MySQLDriverCS;

namespace appUsuarios.AppData
{
    class DBUsuarios:MySqlConectar
    {
        public int validarUsuario(string u, string c)
        {
            int cont = 0;
            String CadenaSql = "select count(1) as cont from usuario where usuario = '" + u + "' and clave = md5('" + c + "')";
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
            catch(MySQLException e)
            {
                System.Console.WriteLine(e.Message.ToString());
            }
            finally
            {
                cnn.Close();
            }
            return cont;
        }
    }

}
