<%-- 
    Document   : index
    Created on : 10/12/2011, 06:25:32 PM
    Author     : alejandro
--%>

<%@page import="java.util.List"%>
<%@page import="logica.Contacto"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet contactos = (ResultSet)session.getAttribute("contactos"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda web</title>
        <script src='validar.jsp' language='JavaScript1.2'></script>
        <link href='diseno.css' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <h1>Contactos</h1>
        <table>
            <tr>
                <th>codigo</th><th>nombre</th><th>apellido</th><th>correo</th><th>acciones</th>
            </tr>
                <% while (contactos.next()){ %>
                    <tr>
                        <td><%= contactos.getString("con_id") %></td>
                        <td><%= contactos.getString("con_nombre") %></td>
                        <td><%= contactos.getString("con_apellido") %></td>
                        <td><%= contactos.getString("con_correo") %></td>
                        <td class="links">
                            <a href="CargarContacto?op=edit&item=<%= contactos.getString("con_id") %>">Editar</a>
                            <a href="CargarContacto?op=delete&item=<%= contactos.getString("con_id") %>">Borrar</a>
                        </td>
                    </tr>
                <% }%>
                <tr>
                    <td colspan="5" class="links"><a href="insertar_contacto.jsp">Agregar</a></td>
            </tr>
        </table>
    </body>
</html>
