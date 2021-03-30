
var jugando;
var preguntando;
var pregunta;

$(document).ready(inicio);
$(document).keydown(capturaTeclado);

function inicio(){
	jugando = true;
  preguntando = false;
	miCanvas = $("#mi_canvas")[0];
	contexto = miCanvas.getContext("2d");
	buffer = document.createElement("canvas");
  img_fondo = $("#fondo")[0]
	heroe = new Heroe();
	puntos = [new Punto(500),new Punto(1000),new Punto(1500),new Punto(2000),new Punto(2500)];

	enemigos = [new Enemigo(200), new Enemigo(700), new Enemigo(1200), new Enemigo(1700),
		  new Enemigo(2200), new Enemigo(2800)];

  pisos = [new Piso(0,350), new Piso(128,350),
             new Piso(256,350), new Piso(384,350),
             new Piso(512,350), new Piso(640,350)];

  huesos = [new Hueso(0,350,1), new Hueso(384,350,3), new Hueso(768,350,2), new Hueso(1052,350,4)];

  objetos = [new Objeto(200,350,3), new Objeto(400,350,2), new Objeto(600,350,4),
             new Objeto(800,350,6),new Objeto(1000,350,7),new Objeto(1200,350,5)];


  preguntas = [["El Amazonas tiene 264.945 habitantes","v"],
               ["Amazonas es una región de Colombia","v"],
               ["Una de sus comidas típicas es el juane de gallina","v"],
               ["Es la región mas grande de Colombia","v"],
               ["Su capital es Leticia","v"],
               ["Esa región NO le pertenece a áfrica","v"],
               ["Tiene mas de 1 comida típica","v"],
               ["Tiene 7 ríos que se clasifican como los mas importantes","v"],
               ["Estuvo en la guerra colombo - peruana","v"],
               ["En el país que se ubica es uno de los países que mas riquesas tiene","v"],
               ["Esa región NO es de Colombia","f"],
               ["Todos tienen el mismo color favorito en esa región","f"],
               ["Esa región no existe","f"],
               ["En esa región no hay agua","f"],
               ["En esta región no hay nada","f"],
               ["No tiene comidas típicas","f"],
               ["Es una región es inhóspita","f"],
               ["Tu vives solo en esta región","f"],
               ["Esta región te vuelve un caracol","f"],
               ["Esta región es prohibida","f"]];



	run();

	$('#instrucciones').click(function(){
        $('#popup').fadeIn('slow');
        $('.popup-overlay').fadeIn('slow');
        $('.popup-overlay').height($(window).height());
        return false;
    });

    $('#close').click(function(){
        $('#popup').fadeOut('slow');
        $('.popup-overlay').fadeOut('slow');
        return false;
    });

    $("#iniciar").click(function(){
		if(jugando==false)
			inicio();
	});
}

function capturaTeclado(event){
  console.log(event.which, preguntando);
  accion = "";
	$('#zombie')[0].play();
	if(event.which==39 || event.which==68){
		accion="derecha";
  }
	if(event.which==37 || event.which==65){
		accion="izquierda";
  }
  if(preguntando){
    if(event.which==86){
			$('#cripta')[0].pause();
			$('#cripta')[0].currentTime = 0;
      if(preguntas[pregunta][1]=="v"){
        heroe.puntos+=10;
      }else{
        heroe.vida-=20;
      }
      preguntando=false;
      heroe.x+=20;
      setTimeout("run()",20);
    }
    if(event.which==70){
			$('#cripta')[0].pause();
			$('#cripta')[0].currentTime = 0;
      if(preguntas[pregunta][1]=="f"){
        heroe.puntos+=10;
      }else{
        heroe.vida-=20;
      }
      preguntando=false;
      for(i=0;i<puntos.length;i++){
        puntos[i].x-=20;
      }
      setTimeout("run()",20);
    }
  }
  heroe.actualizar(accion);
  for(i=0;i<huesos.length;i++){
    huesos[i].actualizar(accion);
  }
  for(i=0;i<objetos.length;i++){
    objetos[i].actualizar(accion);
  }
  for(i=0;i<puntos.length;i++){
    puntos[i].actualizar(accion);
  }
	for(i=0;i<enemigos.length;i++){
    enemigos[i].actualizar(accion);
  }
}

function run(){
	buffer.width = miCanvas.width;
	buffer.height = miCanvas.height;
	contextoBuffer = buffer.getContext("2d");

	if(jugando){
		contextoBuffer.clearRect(0,0,buffer.width,buffer.height);
    for(i=0;i<objetos.length;i++){
			objetos[i].dibujar(contextoBuffer);
		}
    contextoBuffer.drawImage(img_fondo,0,0);
		for(i=0;i<enemigos.length;i++){
	    enemigos[i].dibujar(contextoBuffer);
			enemigos[i].mover();
	  }

		for(i=0;i<pisos.length;i++){
			pisos[i].dibujar(contextoBuffer);
		}

		for(i=0;i<huesos.length;i++){
			huesos[i].dibujar(contextoBuffer);
		}
    heroe.dibujar(contextoBuffer);
		for(i=0;i<puntos.length;i++){
			puntos[i].dibujar(contextoBuffer);

			if(heroe.colision(puntos[i].x,puntos[i].y)){
				$('#cripta')[0].play();
        pregunta = aleatorio(0,preguntas.length-1);
        console.log(preguntas[pregunta][0]);
        preguntando=true;
    		contextoBuffer.fillStyle = "#ffffff";
    		contextoBuffer.font = "20px sans-serif";
    		contextoBuffer.fillText(preguntas[pregunta][0]+"?", 20, 20);
        contextoBuffer.fillStyle = "#00ff00";
        contextoBuffer.fillText("(v) verdadero", 20, 45);
        contextoBuffer.fillStyle = "#ff0000";
        contextoBuffer.fillText("(f) falso", 20, 70);
			}
		}
		for(i=0;i<enemigos.length;i++){
			if(enemigos[i].colision(heroe.x,heroe.y)){
				heroe.vida-=1;
			}
		}



		if(heroe.vida <= 0){
			jugando = false;
		}


		contexto.clearRect(0,0,miCanvas.width,miCanvas.height);
		contexto.drawImage(buffer, 0, 0);
    if(!preguntando){
  		setTimeout("run()",20);
    }

	}else {

		contextoBuffer.clearRect(0,0,buffer.width,buffer.height);
		contextoBuffer.fillStyle = "#ffffff";
		heroe.sprite = 3;
		heroe.vida = 0;
    heroe.contador = 0;
    for(i=0;i<objetos.length;i++){
			objetos[i].dibujar(contextoBuffer);
		}
    contextoBuffer.drawImage(img_fondo,0,0);
		for(i=0;i<pisos.length;i++){
			pisos[i].dibujar(contextoBuffer);
		}
		for(i=0;i<huesos.length;i++){
			huesos[i].dibujar(contextoBuffer);
		}
		heroe.dibujar(contextoBuffer);
		contextoBuffer.font = "50px sans-serif";
		contextoBuffer.fillText("FIN DEL JUEGO", 200, 440);
		contextoBuffer.fillStyle = "#ff0000";
		contextoBuffer.font = "15px sans-serif";
		contextoBuffer.fillText("intenta de nuevo", 450, 460);
		contexto.clearRect(0,0,miCanvas.width,miCanvas.height);
		contexto.drawImage(buffer, 0, 0);
	}

}
