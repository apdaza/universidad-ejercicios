using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using clAgenda;

public partial class _Default : System.Web.UI.Page 
{
    Usuario usu;
    UsuarioData usuData;
    protected void Page_Load(object sender, EventArgs e)
    {
        usu = new Usuario();
        usu.Id = 0;
        usuData = new UsuarioData();
    }
    protected void btnAceptar_ServerClick(object sender, EventArgs e)
    {
        usu = usuData.getUsuarioByLogin(txtLoging.Value, txtClave.Value);
        lblMensage.InnerText = usuData.Msn;
        if (usu.Id > 0)
        {
            Response.Redirect("Inicio.aspx?id=" + usu.Id);
        }
        
    }
}
