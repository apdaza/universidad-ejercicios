#include <iostream>
#include <cstdlib>
#include <ctime>
#include <ncurses.h>

using namespace std;

const int TAM = 10;

void burbuja(int b[], int t);
void llenar_arreglo(int b[], int t);
void mostrar_arreglo(int b[], int t, int y);
void mostrar_arreglo_resaltado(int b[],int t,int y,int pa, int pb,int color);
void copiar_arreglo(int b[],int c[],int t);
void intercambio(int b[],int i, int j);
int busca_pos(int b[],int ini,int fin);
void pintar_menu();
void seleccion(int b[], int t);
void insercion(int b[], int t);
void quick(int b[],int ini,int sup);

int main(){
	initscr();
	
	start_color();
   init_pair(1,COLOR_WHITE,COLOR_BLACK);
	init_pair(2,COLOR_RED,COLOR_BLACK);
	init_pair(3,COLOR_BLUE,COLOR_BLACK);
	init_pair(4,COLOR_YELLOW,COLOR_BLACK);
    attron(COLOR_PAIR(1));
	refresh();
	int a[TAM],ra[TAM];
	char op,m;
	
	llenar_arreglo(a,TAM);
	
	do{
		op='s';
		copiar_arreglo(a,ra,TAM);
		pintar_menu();
		cin>>m;
		erase();
		
		switch(m){
			case 'b':
				mostrar_arreglo(a,TAM,5);
				burbuja(ra,TAM);
				mostrar_arreglo(ra,TAM,6);
				break;
			case 's':
				mostrar_arreglo(a,TAM,5);
				seleccion(ra,TAM);
				mostrar_arreglo(ra,TAM,6);
				break;
			case 'i':
				mostrar_arreglo(a,TAM,5);
				insercion(ra,TAM);
				mostrar_arreglo(ra,TAM,6);
				break;
			case 'q':
				mostrar_arreglo(a,TAM,5);
				quick(ra,0,TAM-1);
				mostrar_arreglo(ra,TAM,6);
				break;
			case 'r':
				llenar_arreglo(a,TAM);
				mostrar_arreglo(a,TAM,5);
				break;
			case 'x':
				op='n';
				break;
			default:
				printw("la opcion elegida no es valida\n");
				refresh();
				break;
		}
		
		if(op!='n'){
			printw("Desea continuar (s/n) : ");
			refresh();
			cin >> op;
		}
	}while(op!='n');
	attroff(COLOR_PAIR(1));
	endwin();
	return 0;
}

void llenar_arreglo(int b[],int t){
	int i;
	srand(time(0));
	for(i=0;i<t;i++){
		b[i]=rand()%100;
	}
}

void copiar_arreglo(int b[],int c[],int t){
	int i;
	for(i=0;i<t;i++){
		c[i] = b[i];
	}
}

void mostrar_arreglo(int b[],int t,int y){
	int i;
	for(i=0;i<t;i++){
		move(y,(i*5));
		if(b[i]>9){
			printw("[%d]",b[i]);
		}else{
			printw("[0%d]",b[i]);
		}
	}
	move(y+1,0);
	refresh();
}

void mostrar_arreglo_resaltado(int b[],int t,int y,int pa, int pb,int color){
	int i;
	for(i=0;i<t;i++){
		move(y,(i*5));
		if(i==pa||i==pb){
			attron(COLOR_PAIR(color));
		}else{
			attron(COLOR_PAIR(1));
		}
		if(b[i]>9){
			printw("[%d]",b[i]);
		}else{
			printw("[0%d]",b[i]);
		}
	}
	attron(COLOR_PAIR(1));
	move(y+1,0);
	refresh();
	
}

void intercambio(int b[],int i, int j){
	int temp;
	temp = b[i];
	b[i] = b[j];
	b[j] = temp;
	
}

void burbuja(int b[], int t){
	move(0,0);
	printw("El algoritmo de Burbuja\n compara elemento por elemento con el siguiente de la lista y los intercambia");
	int i,j;
	for(i=0;i<t-1;i++){
		for(j=i+1;j<t;j++){
			mostrar_arreglo_resaltado(b,t,20,i,j,2);
			if(b[i]>b[j]){
				mostrar_arreglo_resaltado(b,t,20,i,j,3);
				intercambio(b,i,j);
			}
			getchar();
		}
	}
}

void seleccion(int b[], int t){
	move(0,0);
	printw("El algoritmo de Selección\n selecciona el menor elemento de la lista y lo intercambia con el elemento de la poscición actual");
	int i,p;
	for(i=0;i<t;i++){
		p=busca_pos(b,i,t-1);
		mostrar_arreglo_resaltado(b,t,20,i,p,2);
		if(b[i]>b[p]){
			mostrar_arreglo_resaltado(b,t,20,i,p,3);
			intercambio(b,i,p);
		}
		getchar();
	}
}

void insercion(int b[], int t){
	move(0,0);
	printw("El algoritmo de Inserción\n busca el menor elemento de la lista y lo inserta en la posición actual\n desplazando los mayores que el hacia la derecha");
	int i,j,p,temp;
	for(i=0;i<t;i++){
		p=busca_pos(b,i,t-1);
		temp = b[p];
		mostrar_arreglo_resaltado(b,t,20,i,p,2);
		for(j=p;j>i;j--){
			//mostrar_arreglo_resaltado(b,t,20,j,j-1,3);
			intercambio(b,j,j-1);
		}
		b[i]=temp;
		getchar();
	}
}

void quick(int b[],int inf,int sup){
	move(0,0);
	printw("El algoritmo QuickSor\n -selecciona un pivote de la lista\n -ubica a su derecha todos los elementos mayores que este\n -ubica a su izquierda todos los menores\n -hace lo mismo recursivamente con las sublistas resultantes");
	int i,j,div;
	i=inf;
	j=sup-1;
	div=b[sup];
	while(i<=j){
		if(b[i]>div && b[j]<div){
			intercambio(b,i,j);
		}else{
			if(b[i]<=div){
				i++;
			}
			if(b[j]>=div){
				j--;
			}
		}
	}
	intercambio(b,i,sup);
	mostrar_arreglo_resaltado(b,TAM,20,i,i,2);
	getchar();
	if(inf<i-1) quick(b,inf,i-1);
	if(i+1<sup) quick(b,i+1,sup);
}

void pintar_menu(){
	erase();
	move(4,10);
	printw("Elija una opción de ordenamiento ");
	move(6,15);
	printw("<b> para burbuja ");
	move(7,15);
	printw("<s> para seleccion ");
	move(8,15);
	printw("<i> para insercion ");
	move(9,15);
	printw("<q> para quickSort ");    
	move(11,15);
	printw("<r> para generar un nuevo arreglo ");
	move(12,15);
	printw("<x> para salir ");
	refresh();
}

int busca_pos(int b[],int ini,int fin){
	int pos,menor;
	pos=ini;
	menor=b[ini];
	for(int x=ini;x<=fin;x++){
		if(menor>b[x]){
			menor=b[x];
			pos=x;
		}
	}
	return pos;
}


