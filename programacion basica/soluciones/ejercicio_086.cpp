#include <iostream>

using namespace std;

int main(){
	char cad[30];
	char cop[30];
	int cont=-1;
	bool pal = true;
	for(int i=0;i<30;i++){
		cad[i]='\0';
		cop[i]='\0';
	}
	cout << "Ingrese una cadena de texto:";
	cin.getline(cad,30);
	for(int i=0;i<30;i++){
		if(cad[i]!='\0' && cad[i]!=' '){
			cont++;
			cop[cont]=cad[i];
		}
	}
	for(int i=0;i<cont;i++){
		if(cop[i]!=cop[cont-i]){
			pal = false;
		}
	}
	if(pal){
		cout << "la cadena : " << cad << " es un palíndromo " << endl;
	}else{
		cout << "la cadena : " << cad << " no es un palíndromo " << endl;
	}
	return 0;
}
