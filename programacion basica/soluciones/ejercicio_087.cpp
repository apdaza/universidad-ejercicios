#include <iostream>

using namespace std;

int incremento(int n);

int main(){
	int num;
	
	cout << "Ingrese un numero : ";
	cin >> num;
	num = incremento(num);
	cout << num << endl;
	return 0;
}

int incremento(int n){
	return ++n;
}

