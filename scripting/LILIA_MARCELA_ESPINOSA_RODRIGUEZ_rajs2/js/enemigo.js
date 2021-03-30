function Enemigo(){
	this.img = [$("#pezI")[0],$("#pezD")[0]];	
	this.x = aleatorio(0,620);
	this.y = aleatorio(100,330);
	this.velocidad = 0;
	this.sprite = 0;
	while(this.velocidad == 0)
		this.velocidad=aleatorio(1,3);
			
	this.dibujar = function(ctx){
		var img = this.img[this.sprite];
		ctx.drawImage(img,this.x,this.y);
	}
	
	this.actualizar = function(heroe,amigos){
		if (heroe.x < this.x){
			this.x -= this.velocidad;
			this.sprite = 0;
		}
		if (heroe.x > this.x){
			this.x += this.velocidad;
			this.sprite = 1;
		}
		if (heroe.y < this.y)
			this.y -= this.velocidad;
		if (heroe.y > this.y)
			this.y += this.velocidad;
		this.x = (640 + this.x)%640;
		this.y = (480 + this.y)%480;
	}
	this.reubicar = function(){
		this.x = aleatorio(0,620);
		this.y = aleatorio(0,460);
	}

	this.colision = function(x,y){
		var distancia=Math.sqrt( Math.pow( (x-this.x), 2)+Math.pow( (y-this.y),2));
		if(distancia>this.img.width)
		   return false;
		else
		   return true;	
	}
}
