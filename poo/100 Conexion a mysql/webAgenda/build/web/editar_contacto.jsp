<%-- 
    Document   : editar_contacto
    Created on : 12-dic-2011, 10:27:33
    Author     : Alejo
--%>

<%@page import="logica.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Contacto</title>
        <script src='validar.jsp' language='JavaScript1.2'></script>
        <link href='diseno.css' rel='stylesheet' type='text/css'>
    </head>
    <body>
         <form id="frmActualizarContacto" action="ActualizarContacto" method="POST">
             <input type="hidden" id="txtId" name="txtId" value="<%= ((Contacto)session.getAttribute("contacto")).getId() %>">
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" id="txtNombre" name="txtNombre" value="<%= ((Contacto)session.getAttribute("contacto")).getNombre() %>"></td>
            </tr>
            <tr>
                <td>Apellido</td>
                <td><input type="text" id="txtApellido" name="txtApellido" value="<%= ((Contacto)session.getAttribute("contacto")).getApellido() %>"></td>
            </tr>
            <tr>
                <td>Teléfono domicilio</td>
                <td><input type="text" id="txtTelefonoDomicilio" name="txtTelefonoDomicilio" value="<%= ((Contacto)session.getAttribute("contacto")).getTelefonoDomicilio() %>"></td>
            </tr>
            <tr>
                <td>Teléfono oficina</td>
                <td><input type="text" id="txtTelefonoOficina" name="txtTelefonoOficina" value="<%= ((Contacto)session.getAttribute("contacto")).getTelefonoOficina() %>"></td>
            </tr>
            <tr>
                <td>Celular</td>
                <td><input type="text" id="txtCelular" name="txtCelular" value="<%= ((Contacto)session.getAttribute("contacto")).getCelular() %>"></td>
            </tr>
            <tr>
                <td>Correo</td>
                <td><input type="text" id="txtCorreo" name="txtCorreo" value="<%= ((Contacto)session.getAttribute("contacto")).getCorreo() %>"></td>
            </tr> 
            <tr>
                <td>Dirección domicilio</td>
                <td><input type="text" id="txtDireccionDomicilio" name="txtDireccionDomicilio" value="<%= ((Contacto)session.getAttribute("contacto")).getDireccionResidencia() %>"></td>
            </tr>
            <tr>
                <td>Dirección oficina</td>
                <td><input type="text" id="txtDireccionOficina" name="txtDireccionOficina" value="<%= ((Contacto)session.getAttribute("contacto")).getDireccionTrabajo() %>"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="Aceptar" onclick="submit();"></td>
            </tr>
            
        </table>
        </form>
    </body>
</html>
