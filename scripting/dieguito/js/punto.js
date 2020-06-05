function Punto(x){
	this.images = [$("#TombStone1")[0],$("#TombStone2")[0]];
	a = aleatorio(0,1);
	this.img = this.images[a];
	this.x = x;
	this.y = 350 - this.img.height;

	this.dibujar = function(ctx){
		var img = this.img;
		ctx.drawImage(img,this.x,this.y);
	}

	this.actualizar = function(accion){
		if(accion=="izquierda"){
			this.x += 10;
		} else if(accion=="derecha"){
			this.x -= 10;
		}
		this.x = (3000 + this.x)%3000;
	}
}
