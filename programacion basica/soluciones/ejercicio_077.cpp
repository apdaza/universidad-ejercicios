#include <iostream>

using namespace std;

int main(){
	char cad[30];
	int cont=0;
	for(int i=0;i<30;i++){
		cad[i]='\0';
	}
	cout << "Ingrese una cadena de texto:";
	cin.getline(cad,30);
	for(int i=0;i<30;i++){
		if(isupper(cad[i])){
			cont++;
		}
	}
	cout << "la cadena : " << cad << " tiene " << cont << " mayúsculas " <<endl;
	return 0;
}
