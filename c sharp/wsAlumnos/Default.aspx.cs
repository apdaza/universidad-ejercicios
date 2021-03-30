using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using clAlumno;

public partial class _Default : System.Web.UI.Page 
{
    Alumno alumno = new Alumno();
    //AlumnoData alumnoData = new AlumnoData();
    protected void Page_Load(object sender, EventArgs e)
    {
        
    }

    protected void alumnoData_Selecting(object sender, ObjectDataSourceSelectingEventArgs e)
    {
        Label1.Text = alumnoData.
    }
    protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}
