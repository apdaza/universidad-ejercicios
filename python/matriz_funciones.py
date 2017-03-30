import random, os, sys
def doblar(n):
	return n*2

def doble_matriz(matriz):
	for x in range(0,len(matriz)):
		for y in range(0,len(matriz[x])):
			matriz[x][y]=doblar(matriz[x][y])

def imprimir_matriz(matriz):
	for x in matriz:
		for y in x:
			print(str(y)+"\t",end=" ")
		print("")

def llenado_aleatorio(filas,columnas,tope=10):
	x=0
	matriz=[]
	while x<filas:
		y=0
		lista=[]
		while y<columnas:
			lista.append(int(random.random()*tope))
			y+=1
		matriz.append(lista)
		x+=1
	return matriz

os.system("clear")
m = llenado_aleatorio(5,3,100)
imprimir_matriz(m)
print("")		
input("presione enter para verla al doble")
os.system("clear")
doble_matriz(m)	

imprimir_matriz(m)
