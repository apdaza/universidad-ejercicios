
var jugando;

$(document).ready(inicio);
$(document).keydown(capturaTeclado);

function inicio(){
	jugando = true;
	miCanvas = $("#mi_canvas")[0];
	contexto = miCanvas.getContext("2d");
	buffer = document.createElement("canvas");
	heroe = new Heroe();
	puntos = [new Punto(), new Punto(), new Punto()];
    $('#viento')[0].play();
	enemigos = [new Enemigo(), new Enemigo(),
		  new Enemigo(), new Enemigo(),
		  new Enemigo(), new Enemigo()];
    
    muros = [new Muro(), new Muro(),
             new Muro(), new Muro(),
             new Muro()];
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
	if(event.which==38 || event.which==87)
		heroe.actualizar('arriba');
	if(event.which==40 || event.which==83)
		heroe.actualizar('abajo');
	if(event.which==39 || event.which==68)
		heroe.actualizar('derecha');
	if(event.which==37 || event.which==65)
		heroe.actualizar('izquierda');
	
}

function run(){ 
	buffer.width = miCanvas.width;
	buffer.height = miCanvas.height;
	contextoBuffer = buffer.getContext("2d");
		 
	if(jugando){  
		contextoBuffer.clearRect(0,0,buffer.width,buffer.height);

		heroe.dibujar(contextoBuffer);

		for(i=0;i<puntos.length;i++){
			puntos[i].dibujar(contextoBuffer);
			
			if(heroe.colision(puntos[i].x,puntos[i].y)){
				puntos[i].actualizar();
				heroe.puntos++;
			}
		}
        
        for(i=0;i<muros.length;i++){
			muros[i].dibujar(contextoBuffer);
			if(muros[i].colision(heroe.x,heroe.y)){
				heroe.reubicar();
            }
            for(e=0;e<enemigos.length;e++){
                if(muros[i].colision(enemigos[e].x,enemigos[e].y)){
                    enemigos[e].reubicar();
                }
            }
            for(e=0;e<puntos.length;e++){
                if(muros[i].colision(puntos[e].x,puntos[e].y)){
                    puntos[e].actualizar();
                }
            }
		}
        
		for(i=0;i<enemigos.length;i++){
			enemigos[i].dibujar(contextoBuffer);
			enemigos[i].actualizar(heroe,enemigos);
			if(heroe.colision(enemigos[i].x,enemigos[i].y)){
				heroe.vida--;
				enemigos[i].reubicar();
			}
		}
	
		if(heroe.vida <= 0)
			jugando = false;
		
		contexto.clearRect(0,0,miCanvas.width,miCanvas.height);
		contexto.drawImage(buffer, 0, 0);
		setTimeout("run()",20);
		
	}else{
		contextoBuffer.clearRect(0,0,buffer.width,buffer.height);
		contextoBuffer.fillStyle = "#ffffff";
		heroe.sprite = 3;
		heroe.vida = 0;
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


