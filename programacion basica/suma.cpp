#include <iostream>

using namespace std;

const int TOPE = 100;

int main(){
	int d,cont;
	cont = 0;
	d=1;
	cout << "ingrese numeros mayores que cero"<<endl;
	while(d>0){
		cin >> d;
		cont++;
	}
	cout << "se ingresaron " << cont << " numeros mayores que cero " << endl;
	return 0;
}
