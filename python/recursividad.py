def util(msg, f):
    print msg + str(f)
#01. Calcula el producto usando sumas recursivas
def producto(n, m):
    if m == 1:
        return n
    else:
        return n + producto(n, m - 1)
util(" 4 * 3 = ", producto(4, 3))

#02. Calcula la division usando restas recursivas
def division(n, m):
    if n < m:
        return 0
    else:
        return division(n - m, m) + 1
util(" 15 / 3 = ", division(15, 3))

#03. Calcula la potencia de forma recursiva
def potencia(b, e):
    if e == 1:
        return b
    else:
        return b * potencia(b, e - 1)
util(" 4 ** 3 = ", potencia(4, 3))

#04. Calcula factorial de forma recursiva
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)
util(" 4! = ", factorial(4))

#05. Calcula el termino n de la serie de fibonacci de forma recursiva
def fibo(b):
    if b in [1,2]:
        return 1
    else:
        return fibo(b - 1) + fibo(b - 2)
util(" 8 fibonacci = ", fibo(8))

#06. Suma los digitos de un numero de forma recursiva
def suma_digitos(n):
    if n < 10:
        return n
    else:
        return n % 10 + suma_digitos(int(n / 10))
util(" suma digitos 123 = ", suma_digitos(123))

#07. Calcula la longitud de un numero de forma recursiva
def longitud(n):
    if n < 10:
        return 1
    else:
        return 1 + longitud(int(n / 10))
util(" longitud 123 = ", longitud(123))

#08. Invierte un numero de forma recursiva
def invertir_digitos(n):
    if n < 10:
        return n
    else:
        return invertir_digitos(int(n / 10)) + (n % 10) * 10 ** longitud(int(n/10))
util(" invertir digitos 12345 = ", invertir_digitos(12345))

#09. Combierte un numero de base 10 a base 2 de forma recursiva
def bin_a_dec(n):
    if n < 10:
        return n
    else:
        return (n % 10) + bin_a_dec(int(n / 10)) * 2
util(" a decimal 10000 = ", bin_a_dec(10000))

#10. Combierte un numero de base 2 a base 10 de forma recursiva
def dec_a_bin(n):
    if n < 2:
        return n
    else:
        return (n % 2) + dec_a_bin(int(n / 2)) * 10
util(" a binario 1270 = ", dec_a_bin(1270))

#11. Cuenta los elementos de una lista
def cuenta_elementos(lista):
	if lista == []:
		return 0
	else:
		return 1 + cuenta_elementos(lista[1:])
util(" contar elementos [1,2,3,4,5] = ", cuenta_elementos([1,2,3,4,5]))

#12. Suma los elementos de una lista
def suma_elementos(lista):
	if lista == []:
		return 0
	else:
		return lista[0] + suma_elementos(lista[1:])
util(" sumar elementos [1,2,3,4,5] = ", suma_elementos([1,2,3,4,5]))

#12. Suma los elementos de las pocisiones pares de una lista
def suma_elementos_pares(lista):
	if lista == []:
		return 0
	else:
		return lista[0] + suma_elementos_pares(lista[2:])
util(" sumar elementos [1,2,3,4] = ", suma_elementos_pares([1,2,3,4]))

#13 quita los elementos de las posiciones pares de la lista
def quitar_pares(lista):
	if lista==[] or len(lista) == 1:
		return []
	else:
		return [lista[1]] + quitar_pares(lista[2:])
util(" quitar pares [1,2,3,4,5,6] = ", quitar_pares([1,2,3,4,5,6]))

#14 promedio de los elemntos de posiciones impares
def promedio_impares(lista):
	return suma_elementos(quitar_pares(lista))//cuenta_elementos(quitar_pares(lista))
util(" promedio impares [1,2,3,4,5,6] = ", promedio_impares([1,2,3,4,5,6]))

#14 elevar al cuadrado los elementos de una lista
#funcion cuadrado
def cuadrado(x):
	return x*x
#usando map
def map_cuadrados(lista):
	return map(cuadrado, lista)
#usando listas por comprension
def com_cuadrados(lista):
	return [x**2 for x in lista]
#recusividad
def recur_cuadrados(lista):
	if lista == []:
		return []
	else:
		return [lista[0]**2] + recur_cuadrados(lista[1:])
util(" map cuadrados [1,2,3,4,5,6] = ", map_cuadrados([1,2,3,4,5,6]))
util(" comprension cuadrados [1,2,3,4,5,6] = ", com_cuadrados([1,2,3,4,5,6]))
util(" recursividad cuadrados [1,2,3,4,5,6] = ", recur_cuadrados([1,2,3,4,5,6]))

#15 mayor de cada lista
def mayor(lista):
	if len(lista) == 1:
		return lista[0]
	else:
		if lista[0] > lista[1]:
			return mayor([lista[0]]+lista[2:])
		else:
			return mayor(lista[1:])

def mayores(lista):
	return [mayor(i) for i in lista]
util(" mayores [[1,2,3],[4,5,6],[8,7,4],[2,10,4,9]] = ", mayores([[1,2,3],[4,5,6],[8,7,4],[2,10,4,9]]))
