function Enemigo(){
	this.img = [$("#pezI")[0],$("#pezD")[0]];	
	this.x = aleatorio(0,620);
	this.y = aleatorio(100,330);
	this.velocidad_x = 0;
        this.velocidad_y = 0;
	this.sprite = 0;
	
			
	this.dibujar = function(ctx){
		var img = this.img[this.sprite];
		ctx.drawImage(img,this.x,this.y);
	}


	this.colision = function(x,y){
		var distancia=Math.sqrt( Math.pow( (x-this.x), 2)+Math.pow( (y-this.y),2));
		if(distancia>this.img.width)
		   return false;
		else
		   return true;	
	}
}
