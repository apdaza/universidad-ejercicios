#include <iostream>
#include <cstdlib>
#include <ctime>
int main(int argc, char** argv)
{
	srand(time(0));
	for(int x=0;x<10;x++)
		std::cout<<rand()%20<<std::endl;
	return 0;
}
