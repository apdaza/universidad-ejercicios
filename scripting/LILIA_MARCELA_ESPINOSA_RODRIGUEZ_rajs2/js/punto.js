function Punto(){
	this.img = $("#punto")[0];	
	this.x = aleatorio(0,620);
	this.y = aleatorio(0,460);
			
	this.dibujar = function(ctx){
		var img = this.img;
		ctx.drawImage(img,this.x,this.y);
	}
	
	this.actualizar = function(){
		this.x = aleatorio(0,620);
		this.y = aleatorio(0,460);
	}
}
