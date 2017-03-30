using System;
using System.Collections.Generic;
using System.Text;
using MySQLDriverCS;

namespace appUsuarios.AppData
{
    class MySqlConectar
    {
        public MySQLConnection cnn;
        
        //contructor de la clase: estable la conexion con el servidor mysql
        public MySqlConectar()
        {
            try
            {
                cnn = new MySQLConnection(new MySQLConnectionString("localhost", "prueba", "root", "").AsString);
            }
            catch (MySQLException e)
            {
                System.Console.WriteLine("Fallo de conectar");
                System.Console.WriteLine(e.Message.ToString());
            }
        }

        public MySQLConnection getCnn()
        {
            return cnn;
        }
    }

    
}
