<%-- 
    Document   : index
    Created on : 29/04/2011, 06:51:28 AM
    Author     : alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" language="javascript">
            function actualiza_display(v){
                document.getElementsByName("display")[0].value=document.getElementsByName("display")[0].value+v;
                if(document.getElementsByName("display")[0].value=="null"){
                    document.getElementsByName("display")[0].value="";
                }
            }
        </script>
    </head>
    <body onLoad="actualiza_display('')">
        <h1>Calculadora web</h1>
        <form name="frmCalculadora" action="Procesador" method="post">
            <table>
                <tr>
                    <td colspan="5">
                        <input type="text" name="display" size="20" maxlength="20" value="<%=String.valueOf(session.getAttribute("resultado") ) %>">
                    </td>
                </tr>
                <tr>
                    <td><input type="button" value="7" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="8" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="9" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="/" onclick="actualiza_display(' '+this.value+' ')"></td>
                </tr>
                <tr>
                    <td><input type="button" value="4" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="5" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="6" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="*" onclick="actualiza_display(' '+this.value+' ')"></td>
                </tr>
                <tr>
                    <td><input type="button" value="1" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="2" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="3" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="-" onclick="actualiza_display(' '+this.value+' ')"></td>
                </tr>
                <tr>
                    <td><input type="button" value="0" onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="." onclick="actualiza_display(this.value)"></td>
                    <td><input type="button" value="=" onclick="submit()"></td>
                    <td><input type="button" value="+" onclick="actualiza_display(' '+this.value+' ')"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
