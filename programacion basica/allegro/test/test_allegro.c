//gcc test_allegro.c -o test_allegro.o `allegro-config --libs`
#include <stdio.h>
#include <stdlib.h>
#include <allegro.h>

int iniciar(){
	allegro_init();
	install_keyboard(); /* nos permitira utilizar el teclado */
	set_color_depth(16);
	if (set_gfx_mode(GFX_AUTODETECT,640,480,0,0)<0){
		printf("error al iniciar modo grafico\n");
		allegro_exit();
		exit(-1);
	}
}

void terminar(){
	allegro_exit();
}

void realizar_juego()
{
	BITMAP *nave;
	PALETTE *paleta;
	BITMAP *buffer;
	int x, y, x_anterior, y_anterior;
	nave=load_bitmap("imagenes/tux.pcx",paleta);
	//set_palette(paleta);
	if (nave==NULL) terminar();
	buffer=create_bitmap(nave->w,nave->h);
	clear(buffer);
	if (buffer==NULL) terminar();
	x=SCREEN_W/2;
	y=SCREEN_H/2;
	int cont_u=0, cont_d=0, cont_l=0, cont_r=0;
	while (!key[KEY_ESC]){
		if (key[KEY_UP]&&cont_u<=10){
			y--;
			cont_u++;
			cont_d=0; 
			cont_l=0; 
			cont_r=0;
		}
		if (key[KEY_DOWN]&&cont_d<=10){
			y++;
			cont_u=0;
			cont_d++; 
			cont_l=0; 
			cont_r=0;
		}
		if (key[KEY_LEFT]&&cont_l<=10){
			x--;
			cont_u=0;
			cont_d=0; 
			cont_l++; 
			cont_r=0;
		}
		if (key[KEY_RIGHT]&&cont_r<=10){
			x++;
			cont_u=0;
			cont_d=0; 
			cont_l=0; 
			cont_r++;
		}
		if (x<0) x=x_anterior;
		if (x>SCREEN_W-nave->w) 
			x=x_anterior;
		if (y<0) 
			y=y_anterior;
		if (y>SCREEN_H-nave->h) 
			y=y_anterior;
		if ((x_anterior!=x) || (y_anterior!=y)){
			blit(buffer,screen, 0, 0, x_anterior,y_anterior,buffer->w,buffer->h);
			blit(screen,buffer,x,y,0,0,buffer->w,buffer->h);
			draw_sprite(screen, nave, x, y);
		}
		x_anterior=x;
		y_anterior=y;
	}
	
	readkey();
	destroy_bitmap(nave);
}
int main(){
	iniciar();
	realizar_juego();
	terminar();
	return 0;
}
