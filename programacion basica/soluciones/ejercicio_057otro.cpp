#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main(){
	int o[10];
	int max, min, cerca, promedio, acum = 0;
	srand(time(0));
	for(int i=0;i<10;i++){
		o[i]=(rand()%100);
		acum = acum + o[i];
	}
	promedio = acum / 10;
	max = o[0];
	min = o[0];
	cerca = o[0];
	for(int i=0;i<10;i++){
		if(o[i] > max){
			max = o[i];
		}
		if(o[i] < min){
			min = o[i];
		}
		if(abs(promedio - o[i])<abs(promedio - cerca)){
			cerca = o[i];
		}
	}
	cout << " el menor es : " << min << endl;
	cout << " el mayor es : " << max << endl;
	cout << " el mas cercano a "<< promedio << " es : " << cerca << endl;
	return 0;
}
