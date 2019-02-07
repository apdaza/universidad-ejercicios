<%-- 
    Document   : insertar_contacto
    Created on : 12-dic-2011, 9:34:56
    Author     : Alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Contacto</title>
        <script src='validar.jsp' language='JavaScript1.2'></script>
        <link href='diseno.css' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <form id="frmInsertarContacto" action="InsertarContacto" method="POST">
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" id="txtNombre" name="txtNombre"></td>
            </tr>
            <tr>
                <td>Apellido</td>
                <td><input type="text" id="txtApellido" name="txtApellido"></td>
            </tr>
            <tr>
                <td>Teléfono domicilio</td>
                <td><input type="text" id="txtTelefonoDomicilio" name="txtTelefonoDomicilio"></td>
            </tr>
            <tr>
                <td>Teléfono oficina</td>
                <td><input type="text" id="txtTelefonoOficina" name="txtTelefonoOficina"></td>
            </tr>
            <tr>
                <td>Celular</td>
                <td><input type="text" id="txtCelular" name="txtCelular"></td>
            </tr>
            <tr>
                <td>Correo</td>
                <td><input type="text" id="txtCorreo" name="txtCorreo"></td>
            </tr> 
            <tr>
                <td>Dirección domicilio</td>
                <td><input type="text" id="txtDireccionDomicilio" name="txtDireccionDomicilio"></td>
            </tr>
            <tr>
                <td>Dirección oficina</td>
                <td><input type="text" id="txtDireccionOficina" name="txtDireccionOficina"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="Aceptar" onclick="submit();"></td>
            </tr>
            
        </table>
        </form>
    </body>
</html>
