#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

int main(){
	int o[10];
	float c[10];
	srand(time(0));
	for(int i=0;i<10;i++){
		o[i]=50+(rand()%51);
	}
	for(int i=0;i<10;i++){
		c[i]=o[i]*0.5;
	}
	for(int i=0;i<10;i++){
		cout << o[i] << "\t" << c[i] << endl;
	}
	return 0;
}
