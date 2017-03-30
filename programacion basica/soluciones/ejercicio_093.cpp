#include <iostream>
#include <math.h>

using namespace std;

void leer_punto(int *x,int *y);
float distancia(int x1,int y1,int x2,int y2);
int main(){
	int x1,y1,x2,y2;
	float dist;	
	cout << "coordenadas primer punto " << endl;
	leer_punto(&x1,&y1);
	cout << "coordenadas segundo punto " << endl;
	leer_punto(&x2,&y2);
	dist=distancia(x1,y1,x2,y2);
	
	cout << "la distancia entre los puntos ("<<x1<<","<<y1<<") y ("<<x2<<","<<y2<<") es "<<dist<<endl;
	return 0;
}

void leer_punto(int *x,int *y){
	cout << "\t ingrese el valor de x ";
	cin >> *x;
	cout << "\t ingrese el valor de y ";
	cin >> *y;
}

float distancia(int x1,int y1,int x2,int y2){
	float d;
	d=sqrt(pow(x1-x2,2)+pow(y1-y2,2));
	return d;
}

