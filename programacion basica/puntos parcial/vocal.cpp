/*
*cuarto punto del parcial:
*programa que lee un caracter e indica si es vocal o no
*tiempo 10 a 15 minutos.
*valor 1,5 pt.
*/
#include <iostream>

using namespace std;

int main(){
	char n;
	cout << "ingrese el caracter a evaluar :" << endl;
	cin >> n;
	switch(n){
		case 'a':
		case 'e':
		case '1':
		case 'o':
		case 'u':
			cout << "Ud. ingreso la vocal " << n << endl;
			break;
		default:
			cout << "Ud. ingreso el caracter " << n << " que no es una vocal " << endl;
			break;
	}
}
