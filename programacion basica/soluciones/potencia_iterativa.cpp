#include <iostream>
using namespace std;

int potencia_iterativa(int, int);

int main() {
	int base, exponente;
	cout << "ingrese la base : " << endl;
	cin >> base;
	cout << "ingrese el exponente : " << endl;
	cin >> exponente;
	cout << base << " elevado a " << exponente << " es : " << potencia_iterativa(base, exponente) << endl;
	return 0;
}

int potencia_iterativa(int base, int exponente){
	int potencia = 1;
	for(int i = 0; i < exponente; i++){
		potencia = potencia * base;
	}
	return potencia;
}
