#include <iostream>
#include <fstream>

using namespace std;

int main(){
	system("clear");
	char c;
	
	fstream archivo("ascii.txt",ios::in);
	
	if(!archivo){
		cout << "no se puede abrir el archivo ascii.txt"<<endl;
	}else{
		archivo >> c;
		while(!archivo.eof()){ 
			cout << c;
			archivo >> c;
		}
		archivo.close();
	}
	return 0;
}
