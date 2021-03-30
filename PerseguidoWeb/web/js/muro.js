function Muro(){
	this.img = [$("#vortex1")[0],$("#vortex2")[0]];
    this.sprite = 0;	
	this.x = aleatorio(0,620);
    this.y = aleatorio(0,460);
			
	this.dibujar = function(ctx){
		var img = this.img[this.sprite];
		ctx.drawImage(img,this.x,this.y);
        if(this.sprite==0)
            this.sprite = 1;
        else
            this.sprite = 0;
	}
    
    this.colision = function(x,y){
		var distancia=Math.sqrt( Math.pow( (x-this.x), 2)+Math.pow( (y-this.y),2));
		if(distancia>this.img[0].width)
		   return false;
		else
		   return true;	
	}
	
}
