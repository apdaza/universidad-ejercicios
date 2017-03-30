from mod_ordenamiento import *
from random import *
m = []
for n in range(10):
	m.append(randint(0,100))
copia = m[0:]
print m
insercion(copia)
print copia
#hacer_pivote(m)

