using System;
using System.Collections.Generic;
using System.Text;

namespace clAgenda
{
    public class Contacto
    {
        private int id;
        private string primerNombre;
        private string segundoNombre;
        private string primerApellido;
        private string segundoApellido;
        private string direccion;
        private string telefono;
        private string celular;
        private string mail;
        private Usuario usuarioAsignado;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }
        
        public string PrimerNombre
        {
            get { return primerNombre; }
            set { primerNombre = value; }
        }

        public string PrimerApellido
        {
            get { return primerApellido; }
            set { primerApellido = value; }
        }

        public string SegundoNombre
        {
            get { return segundoNombre; }
            set { segundoNombre = value; }
        }

        public string SegundoApellido
        {
            get { return segundoApellido; }
            set { segundoApellido = value; }
        }

        public string Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }

        public string Telefono
        {
            get { return telefono; }
            set { telefono = value; }
        }

        public string Celular
        {
            get { return celular; }
            set { celular = value; }
        }

        public string Mail
        {
            get { return mail; }
            set { mail = value; }
        }

        public Usuario UsuarioAsignado
        {
            get { return usuarioAsignado; }
            set { usuarioAsignado = value; }
        }
        
    }
}
