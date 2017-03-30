#include <iostream>

using namespace std;

bool verificar_numero(char c);

int main(){
	char car;
	
	cout << "Ingrese un caracter : ";
	cin >> car;
	if(verificar_numero(car)){
		cout << car << " es un número" << endl;
	}else{
		cout << car << " no es un número" << endl;
	}
	return 0;
}

bool verificar_numero(char c){
	bool resp;
	switch(c){
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			resp = true;
			break;
		default:
			resp = false;
			break;
	}
	return resp;
}

