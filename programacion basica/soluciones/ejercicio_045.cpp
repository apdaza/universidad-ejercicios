#include <iostream>

using namespace std;

int main(){
	int acum=0;
	int n;
	for(int x=0;x<5;x++){
		cout << "ingrese el numero " << x+1 << " de 5 ";
		cin >> n;
		acum+=n;
	}
	cout << "la media de los 5 numeros es " << acum/5 << endl;
	return 0;
}
