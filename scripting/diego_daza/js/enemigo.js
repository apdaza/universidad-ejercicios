function Enemigo(x){
	this.img = $("#Hand")[0];
	this.x = x;
	this.y = 350;
	this.velocidad = 0;
	this.sprite = 0;
	while(this.velocidad==0)
		this.velocidad=aleatorio(-2,2);

	this.dibujar = function(ctx){
		ctx.drawImage(this.img,this.x,this.y);
	}

	this.mover = function(){
		this.y -= this.velocidad;
		if((this.y + this.img.height) < 350 || this.y > 450)
			this.velocidad *= -1;
	}

	this.actualizar = function(accion){
		if(accion=="izquierda"){
			this.x += 10;
		} else if(accion=="derecha"){
			this.x -= 10;
		}
		this.x = (4000 + this.x)%4000;

	}

	this.colision = function(x,y){
		var distancia=Math.abs(x-this.x);
		if(distancia<10 && this.y < 350)
		   return true;
		else
		   return false;
	}
}
