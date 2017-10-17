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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda web</title>
    </head>
    <body>
        <h1>Contactos</h1>
        
        <% ResultSet contactos = (ResultSet)session.getAttribute("contactos"); %>
        <% 
        while (contactos.next()){
        %>
        <%= contactos.getString("con_nombre") %><br>
                
        <%
        }
        %>
    </body>
</html>
