#include <iostream>

using namespace std;

int main(){
	int x=0,y=0;
	int m[33];
	do{
		if(x%3==0 && x!=100){
			m[y++]=x;
		}
	}while(x++<100);
	for(y=0;y<33;y++){
		cout << m[y] << endl;
	}
	return 0;
}
