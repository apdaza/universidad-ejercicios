from random import *
li =[]
try:
	cant=int(raw_input("cuantos elementos desea generar: "))
except:
	cant=0
x=0
while x<cant:
	aleatorio=randint(0,100)
	encontrado = False
	for n in li:
		if n == aleatorio:
			encontrado = True
	if not encontrado:
		li.append(aleatorio)
		x+=1
print li
