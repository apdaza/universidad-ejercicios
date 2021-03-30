#include <iostream>
#include <cstdio>
#include <ctime>
#include <ncurses.h>

using namespace std;

const int TAM = 5;
void iniciar_arreglo(int b[],int f);
void mostrar_arreglo(int b[],int f);
void capturar_arreglo(int b[],int f);
bool jugar(int a[],int b[],int f);
void pintar_menu();

int main(){
	initscr();
	
	start_color();
   init_pair(1,COLOR_WHITE,COLOR_BLACK);
	init_pair(2,COLOR_RED,COLOR_BLACK);
	init_pair(3,COLOR_BLUE,COLOR_BLACK);
	init_pair(4,COLOR_YELLOW,COLOR_BLACK);
   attron(COLOR_PAIR(1));
	refresh();

	int aleatorio[TAM],usuario[TAM],digitos;
	char d,op;
	bool exito;
	op='s';

	while(op!='n'){
		iniciar_arreglo(aleatorio,TAM);
		pintar_menu();
		cin >> d;
		switch(d){
			case '3':
				digitos = 3;
				exito=jugar(aleatorio,usuario,digitos);
				move(10,0);
				if(exito){
					printw("felicitaciones");
				}else{
					printw("de malas");
				}
				refresh();
				mostrar_arreglo(aleatorio,digitos);
				break;
			case '4':
				digitos = 4;
				exito=jugar(aleatorio,usuario,digitos);
				mostrar_arreglo(aleatorio,digitos);
				break;
			case '5':
				digitos = 5;
				exito=jugar(aleatorio,usuario,digitos);
				mostrar_arreglo(aleatorio,digitos);
				break;
			case 'x':
				op='n';
				break;
		}

		if(op!='n'){
			move(15,0);
			printw("Desea continuar (s/n) : ");
			refresh();
			cin >> op;
		}
	}while(op!='n');
	
	attroff(COLOR_PAIR(1));
	endwin();
	return 0;
}

void iniciar_arreglo(int b[],int f){
	int num,i;
	bool enc;
	i=0;
	srand(time(0));
	while(i<f){
		num=rand()%10;
		enc = false;
		for(int j=0;j<i;j++){
			if(num==b[j]){
				enc = true;
			}
		}
		if(enc==false){
			b[i]=num;
			cout << num;
			i++;
		}
	}
}

void capturar_arreglo(int b[],int f){
	int num,i;
	bool enc;
	i=0;
	while(i<f){
		erase();
		move(0,0);
		printw("ingrese el digito %d",i+1);
		move(1,0);
		refresh();
		cin >> num;
		enc = false;
		for(int j=0;j<i;j++){
			if(num==b[j]){
				enc = true;
			}
		}
		if(enc==false){
			b[i]=num;
			i++;
		}else{
			move(2,0);
			printw("el numero ya existe");
		}
		refresh();
	}
}

void mostrar_arreglo(int b[],int f){
	erase();
	for(int i=0;i<f;i++){
		move(0,(i*5));
		printw("[%d]",b[i]);
	}
	refresh();
}

bool jugar(int a[],int b[],int f){
	int picas=0;
	int fijas=0;
	int intentos = 0;
	char c;
	
	while(fijas<f && intentos<TAM){
		picas = 0;
		fijas = 0;
		capturar_arreglo(b,f);
		for(int x=0;x<f;x++){
			for(int y=0;y<f;y++){
				if(a[x]==b[y]){
					if(x==y){
						fijas++;
					}else{
						picas++;
					}
				}
			}
		}
		move(3,0);
		printw("picas = %d fijas = %d",picas,fijas);
		move(4,0);
		printw("intento = %d",intentos);
		intentos++;
		refresh();
		cin >> c;
	}


	if (fijas==f){
		return true;
	}else{
		return false;
	}
}


void pintar_menu(){
	erase();
	move(3,10);
	printw("Elija con cuantos digitos desea jugar ");
	move(4,15);
	printw("<3> tres digitos ");
	move(5,15);
	printw("<4> cuatro digitos ");
	move(6,15);
	printw("<5> cinco digitos ");
	move(7,15);
	printw("<x> para salir ");
	move(8,15);
	refresh();
}



