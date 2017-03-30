/*
*primer punto del parcial:
*programa que lee dos numeros y retorna la suma
*tiempo 5 a 10 minutos.
*valor 1 pt.
*/
#include <iostream>

using namespace std;

int main(){
	int s1,s2,suma;	
	cout << "ingrese el primer sumando :" << endl;
	cin >> s1;
	cout << "ingrese el segundo sumando :" << endl;
	cin >> s2;
	suma = s1 + s2;
	cout << s1 << " + " << s2 << " = " << suma << endl;
}
