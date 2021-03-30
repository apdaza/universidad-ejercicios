#include <iostream>

using namespace std;

int main(){
	char r;
	int x=0;
	do{
		x++
		cout << endl << " desea continuar (s/n) ";
		cin >> r;
	}while(r!='n');
	cout << "la pregunta se hizo " << x << " veces " << endl;
	return 0;
}
