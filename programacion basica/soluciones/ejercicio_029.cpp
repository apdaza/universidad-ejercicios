#include <iostream>

using namespace std;

int main(){
	char c;
	cout << "Ingrese un caracter ";
	cin >> c;
	switch(c){
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			cout << "el caracter es una vocal" << endl;
			break;
		default:
			cout << "el caracter no es una vocal" << endl;
			break;
	}
	
	return 0;
}
