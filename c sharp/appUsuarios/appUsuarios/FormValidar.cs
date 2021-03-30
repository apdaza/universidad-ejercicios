using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using appUsuarios.AppData;
namespace appUsuarios
{
    public partial class FormValidar : Form
    {
        public FormValidar()
        {
            InitializeComponent();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            DBUsuarios dbUser = new DBUsuarios();
            int cont = dbUser.validarUsuario(txtUsuario.Text, txtClave.Text);
            System.Console.WriteLine("encontrados " + cont);
            if (cont > 0)
            {
                FormEstudiantes frmEst = new FormEstudiantes();
                frmEst.Show();
            }
            else
            {
               
            }
        }

    }
}