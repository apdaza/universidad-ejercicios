function Piso(x,y){
	this.img = $("#piso")[0];
  this.sprite = 0;
	this.x = x;
  this.y = y;

	this.dibujar = function(ctx){
		var img = this.img;
		ctx.drawImage(img,this.x,this.y);
	}

}
