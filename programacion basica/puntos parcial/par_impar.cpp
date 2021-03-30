/*
*segundo punto del parcial:
*programa que lee un numero e indica si es par o impar
*tiempo 5 a 10 minutos.
*valor 1 pt.
*/
#include <iostream>

using namespace std;

int main(){
	int n;
	cout << "ingrese el numero a evaluar :" << endl;
	cin >> n;
	if(n%2==0){
		cout << n << " es par" << endl;
	}else{
		cout << n << " es impar" << endl;
	}
}
