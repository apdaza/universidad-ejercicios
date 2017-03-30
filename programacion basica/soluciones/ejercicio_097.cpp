#include <iostream>

using namespace std;
const int TAM = 5;
struct alumno{
	char nombre[30];
	float parcial[3];
	float final;
};
alumno alumnos[TAM];
void leer_nombre(alumno *a);
void leer_parciales(alumno *a);
void calcular_final(alumno *a);
int main(){
	system("clear");
	for(int i=0;i<TAM;i++){
		leer_nombre(&alumnos[i]);
	}
	for(int i=0;i<TAM;i++){
		cout << "para el alumno " << alumnos[i].nombre << endl;
		leer_parciales(&alumnos[i]);
		calcular_final(&alumnos[i]);
	}
	for(int i=0;i<TAM;i++){
		if(alumnos[i].final>=3.5){
			cout << alumnos[i].nombre << " apto " << alumnos[i].final << endl;
		}else{
			cout << alumnos[i].nombre << " no apto " <<  alumnos[i].final << endl;
		}
	}
	return 0;
}
void leer_nombre(alumno *a){
	cout << "ingrese el nombre del alumno ";
	cin.getline((*a).nombre,30);
}
void leer_parciales(alumno *a){
	for(int i=0;i<3;i++){
		cout << "ingrese la nota del parcial " << i+1 << " :\t";
		cin >> (*a).parcial[i];
	}
}
void calcular_final(alumno *a){
	(*a).final=0;
	for(int i=0;i<3;i++){
		(*a).final+=(*a).parcial[i];	
	}
	(*a).final/=3;	
}
