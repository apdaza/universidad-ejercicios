using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Collections.Generic;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using clAgenda;

public partial class Inicio : System.Web.UI.Page
{
    Usuario usu;
    UsuarioData usuData;
    Contacto con;
    ContactoData conData;
    List<Contacto> contactos; 
    protected void Page_Load(object sender, EventArgs e)
    {
        usu = new Usuario();
        usuData = new UsuarioData();
        conData = new ContactoData();
        usu = usuData.getUsuarioById(Int16.Parse(Request.QueryString["id"]));
        if (usu.Id == 0)
            Response.Redirect("Default.aspx");
        else
        {
            lblUsuario.InnerText = usu.Apellido + " " + usu.Nombre;
            hdfId.Value = Request.QueryString["id"];
            contactos = conData.consultarByUserId(Int16.Parse(Request.QueryString["id"]));
            Contacto[] cons = contactos.ToArray();
            Response.Write("<table border=1>");
            Response.Write("<tr>");
            Response.Write("<th>Primer Apellido</th>");
            Response.Write("<th>Primer Nombre</th>");
            Response.Write("<th>Direccion</th>");
            Response.Write("<th>Telefono</th>");
            Response.Write("<th>Mail</th>");
            Response.Write("<th colspan=2>Acciones</th>");
            Response.Write("</tr>");
            for (int x = 0; x < contactos.Count; x++)
            {
                Response.Write("<tr>");
                Response.Write("<td>" + cons[x].PrimerApellido + "</td>");
                Response.Write("<td>" + cons[x].PrimerNombre + "</td>");
                Response.Write("<td>" + cons[x].Direccion + "</td>");
                Response.Write("<td>" + cons[x].Telefono + "</td>");
                Response.Write("<td>" + cons[x].Mail + "</td>");
                Response.Write("<td><a href='Editar.aspx?id=" + cons[x].Id + "'>Editar</a></td>");
                Response.Write("<td><a href='Borrar.aspx?id=" + cons[x].Id + "'>Borrar</a></td>");
                Response.Write("</tr>");
            }
            Response.Write("<tr>");
            Response.Write("<td colspan=8><a href='Agregar.aspx'>Agregar</a></td>");
            Response.Write("</tr>");
            Response.Write("<table>");
        }
      
    }
    protected void Button1_ServerClick(object sender, EventArgs e)
    {
        
    }
}
