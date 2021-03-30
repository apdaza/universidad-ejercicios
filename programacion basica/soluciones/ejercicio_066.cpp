#include <iostream>

using namespace std;

int main(){
	int o[3][3]={{5,6,13},{14,2,4},{21,7,6}};
	int c[3][3];
	cout << "matriz original" << endl;
	for(int i=0;i<3;i++){
		for(int y=0;y<3;y++){
			cout << o[i][y] << "\t";
		}
		cout << endl;
	}
	cout << "matriz multiplicada por 2" << endl;	
	for(int i=0;i<3;i++){
		for(int y=0;y<3;y++){
			c[i][y]=o[i][y]*2;
			cout << c[i][y] << "\t";
		}
		cout << endl;
	}
	return 0;
}
