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
    public partial class FormEstudiantes : Form
    {
        String[,] est = null;
        DBEstudiantes dbEst;
        public FormEstudiantes()
        {
            InitializeComponent();
            dbEst = new DBEstudiantes();
            est = dbEst.getEstudiantes();
            int cont = dbEst.contarEstudiantes();
            for (int i = 0; i < cont; i++)
            {
                cmbCodigo.Items.Add(est[i,0]);
            }
            
        }

        private void cmbCodigo_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmbCodigo.SelectedValue != "")
            {
                txtNombre.Text = est[cmbCodigo.SelectedIndex, 1].ToString();
                txtApellido.Text = est[cmbCodigo.SelectedIndex, 2].ToString();
                txtCorreo.Text = est[cmbCodigo.SelectedIndex, 3].ToString();
            }
        }

    }
}