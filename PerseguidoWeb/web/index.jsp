<%-- 
    Document   : index
    Created on : 25-abr-2017, 17:13:43
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="description" content="El perseguido">
        <meta name="keywords" content="canvas colisiones jquery ajax">
        <meta name="author" content="Alejandro Daza">
        <title>El Perseguido</title>
        <link href="estilos/default.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="estilos/default.css" media="screen">
        <script src="js/jquery-1.11.0.min.js" language="JavaScript1.2"></script>
        <script src="js/utiles.js" language="JavaScript1.2"></script>
        <script src="js/heroe.js" language="JavaScript1.2"></script>
        <script src="js/enemigo.js" language="JavaScript1.2"></script>
        <script src="js/punto.js" language="JavaScript1.2"></script>
        <script src="js/muro.js" language="JavaScript1.2"></script>
        <script src="js/script.js" language="JavaScript1.2"></script>
    </head>
    <body>
        <section>
            <canvas id="mi_canvas" width="640" height="480">
                Tu navegador no es compatible
            </canvas>			
        </section>
        <section>
            <div id="popup" style="display: none;">
                <div class="content-popup">
                    <div class="close"><a href="#" id="close"><img src="imagenes/close.png"/></a></div>
                    <div>
                        <h2>Teclas de juego</h2>
                        <img src="imagenes/teclado.png"/>
                        <h2>Creditos</h2>
                        <p>Alejandro Daza</p>
                        <p>Universidad Distrital</p>
                        <p>Scripting</p>
                    </div>
                </div>
            </div>
            
            <h1>EL PERSEGUIDO</h1>
            <hr>
            <figure>
                <img id="F1" src="<%= session.getAttribute("F1")%>"/> <figcaption>El Heroe</figcaption>
            </figure>
            <figure>
                <img id="pezI" src="imagenes/pezI.png"/> <figcaption>El Enemigo</figcaption>
            </figure>
            <figure>
                <img id="punto" src="imagenes/punto.png"/> <figcaption>Los Puntos</figcaption>
            </figure>
            <hr>
            <div id="somediv"></div>
            <button id="instrucciones">Ver Instrucciones</button><br>
            <button id="iniciar">Iniciar</button>
            <blockquote>huye mientras puedas!!!</blockquote>
        </section>
        <audio id="viento">
            <source src="sonidos/viento.ogg" type="audio/ogg">
            <source src="sonidos/viento.mp3" type="audio/mpeg">
            Tu navegador no es compatible
        </audio>


        <img id="B1" src="<%= session.getAttribute("B1")%>"/>
        <img id="B2" src="<%= session.getAttribute("B2")%>"/>
        <img id="B3" src="<%= session.getAttribute("B3")%>"/>
        <img id="F2" src="<%= session.getAttribute("F1")%>"/>
        <img id="F3" src="<%= session.getAttribute("F2")%>"/>
        <img id="D1" src="<%= session.getAttribute("D1")%>"/>
        <img id="D2" src="<%= session.getAttribute("D2")%>"/>
        <img id="D3" src="<%= session.getAttribute("D3")%>"/>
        <img id="I1" src="<%= session.getAttribute("I1")%>"/>
        <img id="I2" src="<%= session.getAttribute("I2")%>"/>
        <img id="I3" src="<%= session.getAttribute("I3")%>"/>

        <img id="pezD" src="imagenes/pezD.png"/>
        <img id="vortex1" src="imagenes/vortex1.png"/>



    </body>
</html>
