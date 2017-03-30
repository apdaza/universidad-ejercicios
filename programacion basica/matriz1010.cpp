#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;
int main ()
{
    srand(time(0));
    int v1[9][9];
    int v2[9];
    int v3[9];
    int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0,acum1=0,acum2=0,acum3=0,cont1=0,mayor,menor,aux;
    cout<<"\n\n           P R O G R A M A     M A T R I S     C U A D R A D A\n\n\n";
    cout<<"\n\n   La siguiente matris  esta  llenada  con valores  aleatorios  entre 1 y 99\n\n\n\n";
    for(a=0;a<=9;a++)
    {
    	cout<<"                 ";
        for(b=0;b<=9;b++)
        {
        	v1[a][b]= rand ()%99;
                aux=v1[a][b];
                if(aux>0)
                {
                   mayor=aux;
                }
                acum2=v1[a][b]+acum2;
                acum1=v1[a][b]+d;
                if(v1[a][b]<=9)
                {
                   cout<<v1[a][b]<<"   ";
                }
                else
                {
                   cout<<v1[a][b]<<"  ";
                }
                d=acum1;
                f=acum2;                  
       }
       v2[a]=acum2;
       acum2=0;
       f=0;
       g=0;
       cout<<"\n";
    }
    for(i=0;i<=9;i++)
    {
    	for(g=0;g<=9;g++)
        {
             v3[i]=v1[g][i]+cont1;
             cont1=v3[i];
        }
        cont1=0;
        v1[g][i]=0;
    }
                                                             
    for(e=0;e<=9;e++)
    {
        cout<<"\n    La sumatoria de la fila   # "<<e+1<<" ="<<v2[e];
    }
    cout<<"\n\n\n";
    for(h=0;h<=9;h++)
    {
         cout<<"\n    La  sumatoria de la columna # "<<h+1<<" ="<<v3[h];
    } 
    cout<<"\n\n           El promedio de los valores en la matris  es: "<<acum1/100;
   
}
                                            
                                                                                                                          
