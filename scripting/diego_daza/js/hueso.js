function Hueso(x,y,n){
	this.img = $("#Bone"+n)[0];
	this.x = x;
  this.y = y;

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
		this.x = (1500 + this.x)%1500;

	}

}
