using System;
using System.Collections.Generic;
using System.Text;

namespace clAlumno
{
    public class Alumno
    {
        private string codigo;
        private string nombre;
        private string apellido;

        public string Codigo
        {
            set { codigo = value; }
            get { return codigo; }
        }
        public string Nombre
        {
            set { nombre = value; }
            get { return nombre; }
        }
        public string Apellido
        {
            set { apellido = value; }
            get { return apellido; }
        }
    }
}
