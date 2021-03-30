function Objeto(x,y,n){
	this.img = $("#Object"+n)[0];
	this.x = x;
  this.y = y-this.img.height;
  //console.log(this.img.height);

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
