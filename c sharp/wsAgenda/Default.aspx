<%@ Page Language="C#" AutoEventWireup="true"  CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Agenda</title>
    <link href="estilos.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <div class="titulo">Validaci&oacute;n de usuarios</div>
    <div style="text-align:center;">
    <% %>
    <form id="form1" runat="server">
    <input type="hidden" id="hddValidado" value="0">
    <table class="formulario">
        <tr>
            <td rowspan=3 style="background:#FFFFFF;"><img src="imagenes/icon_usuario.png" border=0 /></td>
            <td class="derecha">loging</td>
            <td class="izquierda"><input type="text" id="txtLoging" runat="server" size="20"></td>
        </tr>
        <tr>
            <td class="derecha">clave</td>
            <td class="izquierda"><input type="password" id="txtClave" runat="server" size="20"></td>
        </tr>
        <tr>
            <td colspan=2 class="centro"><input type="submit" id="btnAceptar" value="Aceptar" runat="server" onserverclick="btnAceptar_ServerClick"></td>
        </tr>
        <tr>
            <td colspan=3 class="centro"><label id="lblMensage" runat="server"></label></td>
        </tr>
    
    </table>
    </form>
    </div>
</body>
</html>
