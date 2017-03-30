using System;
using System.Collections.Generic;
using System.Text;
using MySql.Data.MySqlClient;

namespace clAlumno
{
    
    class MysqlConexion
    {
        private MySqlConnection conexion;
        private string servidor;
        private string basedatos;
        private string usuario;
        private string clave;
        private string mensage;

        public MysqlConexion()
        {
            inicializar();
        }

        public void inicializar()
        {
            string connectionString;

            servidor = "localhost";
            basedatos = "dbalumnos";
            usuario = "root";
            clave = "";
            
            connectionString = "SERVER=" + servidor + ";" + "DATABASE=" + basedatos + ";" + "UID=" + usuario + ";" + "PASSWORD=" + clave + ";";

            
            try
            {
                conexion = new MySqlConnection(connectionString);
                conexion.Open();
            }
            catch (MySqlException ex)
            {
                mensage = "error al conectar a la base de datos (" + ex.Message + ")";
            }
        }

        public MySqlConnection Conexion
        {
            get { return conexion; }
        }

        public string Mensage
        {
            get { return mensage; }
            set { mensage = value; }
        }

        public void closeConexion()
        {
            conexion.Close();
        }


    }
}
