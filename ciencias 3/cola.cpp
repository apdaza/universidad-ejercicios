#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
struct agenda
{
    char nombre[50];
    char telefono[25];
    char mail[50];
};
 
struct nodo
{
    struct agenda dato;
    struct nodo *proximo;
};
 
struct nodo *nuevonodo();
int colavacia(struct nodo *);
struct nodo *creacola(struct nodo *, struct agenda);
void mostrar(struct nodo *);
 
int main()
{
    struct nodo *pri=NULL, *ult=NULL;
    struct agenda x;
    printf("Ingrese nombre: ");
    gets(x.nombre);
    while(strcmpi(x.nombre,"fin"))
    {
        printf("Ingrese telefono: ");
        gets(x.telefono);
        printf("Ingrese mail: ");
        gets(x.mail);
        ult=creacola(ult,x);
        if(pri==NULL) pri=ult; // Si es la 1º pasada pongo en pri el valor del primer nodo
        printf("Ingrese nombre: ");
        gets(x.nombre);
    }
    if(colavacia(pri)==1) {
      printf("No se ingresaron registros");
      //getch();
    }
    else mostrar(pri);
}
 
struct nodo *nuevonodo()
{
    struct nodo *p;
    p=(struct nodo *)malloc(sizeof(struct nodo));
    if(p==NULL)
    {
        printf("Memoria RAM Llena");
        //getch();
        exit(0);
    }
    return p;
}
 
struct nodo *creacola(struct nodo *ult, struct agenda x)
{
    struct nodo *p;
    p=nuevonodo();
    (*p).dato=x;
    (*p).proximo=NULL;
    if(ult!=NULL) (*ult).proximo=p; // Si hay nodo anterior en prox pongo la direccion del nodo actual
    return p;
}
 
int colavacia(struct nodo *pri)
{
    if(pri==NULL) return 1;
    else return 0;
}
 
void mostrar(struct nodo *pri)
{
    struct nodo *aux;
    while(pri!=NULL)
    {
        printf("Nombre: %s - Telefono: %s - Mail: %s \n",pri->dato.nombre,pri->dato.telefono,pri->dato.mail);
        aux=pri;
        pri=(*pri).proximo;
        free(aux);
    }
    //getch();
}
