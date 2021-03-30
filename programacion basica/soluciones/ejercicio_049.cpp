#include <iostream>

using namespace std;

int main(){
	char r;
	int x=1;
	int tope = 1000;
	int paso = 10;
	do{
		cout << x << "\t";
		if(x%paso==0 && x!=tope){
			cout << endl << " desea continuar (s/n) ";
			cin >> r;
		}
	}while(r!='n' && x++<tope);
	cout << endl;
	return 0;
}
