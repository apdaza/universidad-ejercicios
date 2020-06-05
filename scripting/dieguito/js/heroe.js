function Heroe(){
	this.x = 350;
	this.y = 350;
	this.img = [[$("#Walk1")[0],$("#Walk2")[0],$("#Walk3")[0],$("#Walk4")[0],$("#Walk5")[0],$("#Walk6")[0],$("#Walk7")[0],$("#Walk8")[0],$("#Walk9")[0],$("#Walk10")[0]],
	            [$("#Back1")[0],$("#Back2")[0],$("#Back3")[0],$("#Back4")[0],$("#Back5")[0],$("#Back6")[0],$("#Back7")[0],$("#Back8")[0],$("#Back9")[0],$("#Back10")[0]],
							[$("#Walk")[0],$("#Walk")[1],$("#Walk")[2],$("#Walk")[3],$("#Walk")[4],$("#Walk")[5],$("#Walk")[6],$("#Walk")[7],$("#Walk")[8],$("#Walk")[9]],
						  [$("#Dead")[0],$("#Dead")[0],$("#Dead")[0],$("#Dead")[0],$("#Dead")[0],$("#Dead")[0],$("#Dead")[0],$("#Dead")[0],$("#Dead")[0],$("#Dead")[0]]];
	this.sprite = 0;
	this.vida = 100;
	this.puntos = 0;
	this.contador = 0;
	this.moviendo = false;
	this.sentido = ['derecha','izquierda','abajo','arriba'];


	this.dibujar = function(ctx){
		var img = this.img[this.sprite][this.contador];
		if(this.moviendo){
			this.contador += 1;
			this.contador = this.contador % 8;
		}
		//console.log(img, this.sprite, this.contador);
		var x = this.x;
		var y = this.y-img.height;
		ctx.drawImage(img, x, y);
		ctx.save();
		ctx.fillStyle = "#ffffff";
		ctx.font = "20px sans-serif";
		ctx.fillStyle = "#ff0000";
    ctx.fillRect(x,y-20,100,20);
    ctx.fillStyle = "#ffffff";
    ctx.fillRect(x,y-20,this.vida,20);
    ctx.fillStyle = "#000000";
		ctx.fillText("vida: "+ this.vida, x, y-1);
    ctx.fillStyle = "#ffffff";
    ctx.fillText("puntos: "+ this.puntos, x, y + 20);

    ctx.restore();
		this.moviendo = false;
	}

	this.actualizar = function(accion){
		/*if(accion=="arriba"){
			this.y -= 10;
			this.sprite = 0;
		}
		if(accion=="abajo"){
			this.y += 10;
			this.sprite = 0;
		}*/
		if(accion=="izquierda"){
			//this.x -= 10;
			this.sprite = 1;
		}
		if(accion=="derecha"){
			//this.x += 10;
			this.sprite = 0;
		}
		this.moviendo = true;
		this.x = (740 + this.x)%740;
		this.y = (480 + this.y)%480;

	}

	this.colision = function(x,y){
		var distancia=Math.abs(x - this.x);
		if(distancia>10)
		   return false;
		else
		   return true;
	}

}
