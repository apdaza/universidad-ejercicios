#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
 
struct productos
{
    int codigo;
    char nombre[50];
    int existencia;
    float precio;
};
 
struct nodo
{
    struct productos dato;
    struct nodo *proximo;
};
 
/* Declaracion de funciones */
void archivo(FILE *fp);
struct nodo *nuevonodo();
struct nodo *creapila(struct nodo *pri, struct productos x);
void muestra(struct nodo *pri, FILE *fp);
/* Fin de Declaracion */
 
void main()
{
    struct productos x;
    struct nodo *pri=NULL;
    FILE *fp;
    char opcion; float auxiliar=0;
    if((fp=fopen("C:\\Datos.txt","wb"))==NULL)
    {
        getch();
    }
    fseek(fp,0,2);
    do
    {
        fflush(stdin);
        printf("Ingrese el Codigo de Producto ");
        scanf("%d",&x.codigo);
        fflush(stdin);
        printf("Ingrese Nombre de Producto ");
        gets(x.nombre);
        fflush(stdin);
        printf("Ingrese la Existencia ");
        scanf("%d",&x.existencia);
        fflush(stdin);
        printf("Ingrese el Precio ");
        scanf("%f",&auxiliar); x.precio=auxiliar;
        pri=creapila(pri,x);
        fflush(stdin);
        printf("Desea Ingresar otro Registro? (S/N) ");
        scanf("%c",&opcion); opcion=toupper(opcion);
    } while(opcion=='S');
    muestra(pri,fp);
    fflush(stdin);
    printf("El contenido de la Pila se ha Guardado. Desea Visualizarlo? (S/N)");
    scanf("%c",&opcion); opcion=toupper(opcion);
    if(opcion=='S') archivo(fp);
    getch();
    fclose(fp);
}
 
struct nodo *creapila(struct nodo *pri, struct productos x)
{
    struct nodo *p;
    p=nuevonodo();
    (*p).dato=x;
    (*p).proximo=pri;
    return p;
}
 
struct nodo *nuevonodo()
{
    struct nodo *p;
    p=(struct nodo *)malloc(sizeof(struct nodo));
    if(p==NULL)
    {
        printf("Memoria RAM Llena");
        getch();
        exit(0);
    }
    return p;
}
 
void muestra(struct nodo *pri, FILE *fp)
{
    clrscr();
    struct nodo *aux;
    while(pri!=NULL)
    {
        printf("Codigo: %d \n",(*pri).dato.codigo);
        printf("Nombre: %s \n",(*pri).dato.nombre);
        printf("Existencia: %d \n",(*pri).dato.existencia);
        printf("Precio: %0.2f \n\n",(*pri).dato.precio);
        fwrite(&pri->dato,sizeof(struct productos),1,fp);
        aux=pri;
        pri=(*pri).proximo;
        free(aux);
    }
}
 
void archivo(FILE *fp)
{
    struct productos x;
    clrscr();
    printf("Datos del Archivo:\n\n");
    fread(&x,sizeof(struct productos),1,fp);
    while(!feof(fp))
    {
        printf("Codigo: %d \n",x.codigo);
        printf("Nombre: %s \n",x.nombre);
        printf("Existencia: %d \n",x.existencia);
        printf("Precio: %0.2f \n\n",x.precio);
        fread(&x,sizeof(struct productos),1,fp);
    }
    printf("Fin de Archivo");
}
