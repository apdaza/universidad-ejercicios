function Heroe(){
	this.x = 310;
	this.y = 15;
	this.img = [[$("#D1")[0],$("#D2")[0],$("#D3")[0]],
                    [$("#I1")[0],$("#I2")[0],$("#I3")[0]],
		    [$("#F1")[0],$("#F2")[0],$("#F3")[0]],
		    [$("#B1")[0],$("#B2")[0],$("#B3")[0]]];
	this.sprite = 2;
	this.vida = 100;
	this.puntos = 0;
	this.contador = 0;
	this.moviendo = false;
	this.sentido = ['derecha','izquierda','abajo','arriba'];

	
	this.dibujar = function(ctx){
		var img = this.img[this.sprite][this.contador];
		if(this.moviendo){
			this.contador += 1;
			this.contador = this.contador % 3;
		}
		var x = this.x;
		var y = this.y;
		ctx.drawImage(img, x, y);
		ctx.save();
		ctx.fillStyle = "#ffffff";
		ctx.font = "12px sans-serif";
		ctx.fillStyle = "#ff0000";
        ctx.fillRect(x,y-10,50,10);
        ctx.fillStyle = "#ffffff";
        ctx.fillRect(x,y-10,this.vida/2,10);
        ctx.fillStyle = "#000000";
		ctx.fillText("vida: "+ this.vida, x, y-1);
        ctx.fillStyle = "#ffffff";
        ctx.fillText("puntos: "+ this.puntos, x, y + 35);
		ctx.fillText("corriendo a: "+ this.sentido[this.sprite], x, y+45);
        ctx.restore();
		this.moviendo = false;
	}
	
	this.actualizar = function(accion){
		if(accion=="arriba"){
			this.y -= 10;
			this.sprite = 3;
		}
		if(accion=="abajo"){
			this.y += 10;
			this.sprite = 2;
		}
		if(accion=="izquierda"){
			this.x -= 10;
			this.sprite = 1;
		}
		if(accion=="derecha"){
			this.x += 10;
			this.sprite = 0;
		}
		this.moviendo = true;
		this.x = (640 + this.x)%640;
		this.y = (480 + this.y)%480;
		
	}
	
	this.colision = function(x,y){
		var distancia=Math.sqrt( Math.pow( (x-this.x), 2)+Math.pow( (y-this.y),2));
		if(distancia>this.img[this.sprite][0].width)
		   return false;
		else
		   return true;	
	}
    
    this.reubicar = function(){
		this.x = aleatorio(0,620);
		this.y = aleatorio(0,460);
	}
}
