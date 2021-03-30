#include <iostream>
using namespace std;

int potencia_recursiva(int, int);

int main() {
	int base, exponente;
	cout << "ingrese la base : " << endl;
	cin >> base;
	cout << "ingrese el exponente : " << endl;
	cin >> exponente;
	cout << base << " elevado a " << exponente << " es : " << potencia_recursiva(base, exponente) << endl;
	return 0;
}

int potencia_recursiva(int base, int exponente){
	if(exponente > 1){
		return base * potencia_recursiva(base, exponente-1);
	}else{
		return base;
	}
}
