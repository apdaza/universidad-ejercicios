function Muro(){
	this.img = $("#vortex1")[0];
	this.x = aleatorio(0,620);
  this.y = aleatorio(0,460);

	this.dibujar = function(ctx){
		ctx.drawImage(this.img,this.x,this.y);
	}

    this.colision = function(x,y){
		var distancia=Math.sqrt( Math.pow( (x-this.x), 2)+Math.pow( (y-this.y),2));
		if(distancia>this.img.width)
		   return false;
		else
		   return true;
	}

}
