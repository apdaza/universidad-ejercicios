#include <iostream>
#include <fstream>

using namespace std;

int main(){
	system("clear");
	int i = 32;
	
	fstream archivo("ascii.txt",ios::out);
	
	if(!archivo){
		cout << "no se puede crear el archivo ascii.txt"<<endl;
	}else{
		while(i<128){ 
			archivo << i << " = " << char(i) << "\t\t";
			i++;
			if(i%8==0)archivo << "\n";
		}
		archivo.close();
	}
	return 0;
}
