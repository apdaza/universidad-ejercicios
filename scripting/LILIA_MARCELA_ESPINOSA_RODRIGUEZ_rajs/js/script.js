
var jugando;

$(document).ready(inicio);
$(document).keydown(capturaTeclado);

function inicio(){
	jugando = true;
	miCanvas = $("#mi_canvas")[0];
	contexto = miCanvas.getContext("2d");
	buffer = document.createElement("canvas");
	mamut = new Mamut();
	chinchillas = [new Chinchilla(), new Chinchilla(),
				   new Chinchilla(), new Chinchilla(),
				   new Chinchilla(), new Chinchilla(),
				   new Chinchilla(), new Chinchilla(),
				   new Chinchilla(), new Chinchilla()];
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
		mamut.actualizar('arriba');
	if(event.which==40 || event.which==83)
		mamut.actualizar('abajo');
	if(event.which==39 || event.which==68)
		mamut.actualizar('derecha');
	if(event.which==37 || event.which==65)
		mamut.actualizar('izquierda');
	
}

function run(){ 
	buffer.width = miCanvas.width;
	buffer.height = miCanvas.height;
	contextoBuffer = buffer.getContext("2d");
		 
	if(jugando){  
		contextoBuffer.clearRect(0,0,buffer.width,buffer.height);

		mamut.dibujar(contextoBuffer);
		for(i=0;i<chinchillas.length;i++){
			chinchillas[i].dibujar(contextoBuffer);
			chinchillas[i].actualizar();
			if(mamut.colision(chinchillas[i].x,chinchillas[i].y)){
				mamut.sprite = 2;
				mamut.vida--;
				$('#pierde')[0].play();
			}
		}
		
		if(mamut.vida <= 0)
			jugando = false;
		
		contexto.clearRect(0,0,miCanvas.width,miCanvas.height);
		contexto.drawImage(buffer, 0, 0);
		setTimeout("run()",20);
		
	}else{
		contextoBuffer.clearRect(0,0,buffer.width,buffer.height);
		contextoBuffer.fillStyle = "#ffffff";
		mamut.sprite = 3;
		mamut.vida = 0;
		mamut.dibujar(contextoBuffer);
		contextoBuffer.font = "50px sans-serif";
		contextoBuffer.fillText("GAMEOVER", 300, 440);
		contextoBuffer.fillStyle = "#ff0000";
		contextoBuffer.font = "15px sans-serif";
		contextoBuffer.fillText("try again", 550, 460);
		contexto.clearRect(0,0,miCanvas.width,miCanvas.height);
		contexto.drawImage(buffer, 0, 0);
	}
	
}


