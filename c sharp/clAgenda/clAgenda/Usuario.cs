using System;
using System.Collections.Generic;
using System.Text;

namespace clAgenda
{
    public class Usuario
    {
        private int id;
        private string login;
        private string clave;
        private string nombre;
        private string apellido;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Login
        {
            get { return login; }
            set { login = value; }
        }

        public string Clave
        {
            get { return clave; }
            set { clave = value; }
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public string Apellido
        {
            get { return apellido; }
            set { apellido = value; }
        }
    }
}
