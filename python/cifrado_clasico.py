#!/usr/bin/env python
# -*- coding: utf-8 -*-

def encontrar(caracter,alfabeto):
	if caracter not in alfabeto:
		return 0
	elif alfabeto == []:
		return 0
	elif caracter == alfabeto[0]:
		return 1
	else:
		return 1 + encontrar(caracter, alfabeto[1:])


def cifra_uno(mensaje,alfabeto):
	clave = 3
	corrido = alfabeto[clave:]+alfabeto[:clave]
	
	print alfabeto
	print corrido
	
	numeros = [encontrar(x,alfabeto) for x in list(mensaje)]
	lista = []
	for x in numeros:
		if x > 0:
			lista = lista + [corrido[x-1]]
		else:
			lista = lista + ['_']
	return lista
	
def cifra_dos(lista):
	clave = 3
	matriz = []
	cifrado = ""
	while len(lista) % clave != 0:
		lista.append('_')
	while lista != []:
		matriz.append(lista[:clave])
		lista = lista[clave:]
	
	resultado = [matriz[x][y] for y in range(clave) for x in range(len(matriz))]
	
	
	
	for x in resultado:
		cifrado += x
	
	return cifrado
		
def a_matriz(lista,clave):
	if lista == []:
		return []
	else: 
		return [lista[:clave]] + a_matriz(lista[clave:],clave) 

def decifra_uno(mensaje,alfabeto):
	clave = 3
	corrido = alfabeto[clave:]+alfabeto[:clave]
	
	numeros = [encontrar(x,corrido) for x in list(mensaje)]
	lista = []
	for x in numeros:
		if x > 0:
			lista = lista + [alfabeto[x-1]]
		else:
			lista = lista + ['_']
	return lista	

def main():
	alfabeto = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']	
	#mensaje = "LA MAYORIA DE LOS MALES LES VIENEN A LOS HOMBRES POR NO QUEDARSE TRANQUILOS EN CASA"
	#mensaje = "EL INSTINTO DICTA EL DEBER Y LA INTELIGENCIA DA PRETEXTOS PARA ELUDIRLO"
	#mensaje = "UN TEST PARA CIFRAR CON DIFERENTES ALGORITMOS"
	#mensaje = "UN PAJARO FUE EL CULPABLE DE TREMENDO ALBOROTO POR NO SABER CIFRAR SU CANTO"
	mensaje = "EL CIFRADO CLASICO ES UN BUEN EJERCICIO ACADEMICO PERO NO ES BUENA IDEA USARLO COMO MECANISMO DE SEGURIDAD EN LA ACTUALIDAD"
	
	#Blaise Pascal (1623-1662) Científico, filósofo y escritor francés.
	
	primer_cifrado = cifra_uno(mensaje,alfabeto) 
	cifrado_final = cifra_dos(primer_cifrado)
	print mensaje
	print cifrado_final
	
	print "-------------------------------------------------"
	clave = len(cifrado_final)/3
	
	matriz2 = a_matriz(list(cifrado_final),clave)
	for x in matriz2:
		print x
	
	cifrado = ""
	resultado = [matriz2[x][y] for y in range(clave) for x in range(len(matriz2))]
	for x in resultado:
		cifrado += x
	
	
	decifrado_matriz = decifra_uno(cifrado,alfabeto)
	decifrado = ""
	for x in decifrado_matriz:
		decifrado += x
		
	#print decifrado
	return 0

if __name__ == '__main__':
	main()

