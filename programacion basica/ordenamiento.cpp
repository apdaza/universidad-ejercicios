#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

const int TAM = 10;

void llenar_arreglo(int b[], int t);
void mostrar_arreglo(int b[], int t, int y);
void mostrar_arreglo_resaltado(int b[],int t,int y,int pa, int pb,int color);
void copiar_arreglo(int b[],int c[],int t);
void intercambio(int b[],int i, int j);
int busca_pos(int b[],int ini,int fin);
void pintar_menu();
void burbuja(int b[], int t);
void seleccion(int b[], int t);
void insercion(int b[], int t);
void quick(int b[],int ini,int sup);

int main(){
	int a[TAM],ra[TAM];
	char op,m;
	
	llenar_arreglo(a,TAM);
	
	do{
		op='s';
		copiar_arreglo(a,ra,TAM);
		pintar_menu();
		cin>>m;
		system("clear");
		
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
				cout << "la opcion elegida no es valida\n";
				system("clear");
				break;
		}
		
		if(op!='n'){
			cout << "Desea continuar (s/n) : ";
			cin >> op;
		}
	}while(op!='n');
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
		if(b[i]>9){
			cout << "[" << b[i] << "]";
		}else{
			cout << "[0" << b[i] << "]";
		}
	}
	cout << endl;
}


void intercambio(int b[],int i, int j){
	int temp;
	temp = b[i];
	b[i] = b[j];
	b[j] = temp;
	
}

void burbuja(int b[], int t){
	int i,j;
	for(i=0;i<t-1;i++){
		for(j=i+1;j<t;j++){
			if(b[i]>b[j]){
				intercambio(b,i,j);
			}
		}
	}
}

void seleccion(int b[], int t){
	int i,p;
	for(i=0;i<t;i++){
		p=busca_pos(b,i,t-1);
		if(b[i]>b[p]){
			intercambio(b,i,p);
		}
	}
}

void insercion(int b[], int t){
	int i,j,p,temp;
	for(i=0;i<t;i++){
		p=busca_pos(b,i,t-1);
		temp = b[p];
		for(j=p;j>i;j--){
			intercambio(b,j,j-1);
		}
		b[i]=temp;
	}
}

void quick(int b[],int inf,int sup){
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
	cout << i << endl;
	intercambio(b,i,sup);
	if(inf<i-1) quick(b,inf,i-1);
	if(i+1<sup) quick(b,i+1,sup);
}

void pintar_menu(){
	system("clear");
	cout << "Elija una opción de ordenamiento " << endl;
	cout << "<b> para burbuja " << endl;
	cout << "<s> para seleccion " << endl;
	cout << "<i> para insercion " << endl;
	cout << "<q> para quickSort " << endl; 
	cout << "<r> para generar un nuevo arreglo " << endl;
	cout << "<x> para salir " << endl;
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


