#include <iostream>
#include <math.h>

using namespace std;

int main(){
	double a,b,c,r;
	cout << "Ingrese el valor de a: ";
	cin >> a;
	cout << "Ingrese el valor de b: ";
	cin >> b;
	cout << "Ingrese el valor de c: ";
	cin >> c;
	r=-b+(sqrt((pow(b,2)+2-a)/(2*a)));
	cout << "el resultado de la expresión es " << r << endl;
	return 0;
}
