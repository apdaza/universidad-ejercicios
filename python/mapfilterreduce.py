from random import *

#iterando sobre una lista
items = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
cuadrados = list(map(lambda x: x**2, items))
print cuadrados
print "-----------------------------------"
#iterando varias listas
a = [1,2,3,4]
b = [17,12,11,10]
c = [-1,-4,5,9]
print map(lambda x,y:x+y, a,b)
print map(lambda x,y,z:x+y+z, a,b,c)
print map(lambda x,y,z:x+y-z, a,b,c)
print "-----------------------------------"
#iterando sobre funciones
def producto(x):
    return (x*x)
def suma(x):
    return (x+x)
funcs = [producto, suma]
for i in items:
    value = list(map(lambda x: x(i), funcs))
    print(value)

#filtros
lista_numeros = range(-5, 5)
print filter(lambda x: x < 0, lista_numeros)
print filter(lambda x: x % 2, [0,1,1,2,3,5,8,13,21,34,55])
print filter(lambda x: x % 2 == 0, [0,1,1,2,3,5,8,13,21,34,55])

#reducciones
print reduce(lambda x, y: x * y, [1, 2, 3, 4])
print reduce(lambda x,y: x+y, [47,11,42,13])
print reduce(lambda a,b: a if (a > b) else b, [47,11,42,102,13])
print reduce(lambda x, y: x+y, range(1,101))

#el menor cuadrado de los cuadrados de los pares de una lista
print reduce(lambda x, y: x if x < y else y, (map(lambda x: x**2, (filter(lambda x: x % 2 == 0, sample(range(100),10))))))
