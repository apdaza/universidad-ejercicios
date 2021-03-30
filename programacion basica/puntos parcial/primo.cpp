/*
*tercer punto del parcial:
*programa que lee un numero e indica si es primo o no
*tiempo 10 a 15 minutos.
*valor 1,5 pt.
*/
#include <iostream>

using namespace std;

int main(){
	int n,div;
	div = 0;
	cout << "ingrese el numero a evaluar :" << endl;
	cin >> n;
	for(int i=1;i<=n;i++){
		if(n%i==0){
			div++;
		}
	}
	if(div==2){
		cout << n << " es primo " << endl;
	}else{
		cout << n << " no esprimo " << endl;
	}
}
