#dada una lista de enteros retornar el menor elemento de la lista
print min([3,6,8,1,10])

#dada una lista indicar si esta ordenada
def ordenada(lista):
	if lista == []:
		return True
	elif len(lista)==1:
		return True
	else:
		return lista[0] < lista[1] and ordenada(lista[1:])

print ordenada([1,2,3,4,5,3])

#dada una lista de listas retornar una lista con el mayor elemento de cada sublista
print [max(x) for x in [[1,2,3],[5,4,3],[3,6,4]]]

#dada una lista de listas retornar el promedio de los elementos 
#de las sublistas que contengan un multiplo de 5
print [sum(x)/len(x) for x in [[1,2,3,20],[5,4,3],[3,6,4]] if len([y for y in x if y % 5 == 0]) > 0]

#dadas dos listas genere una lista de listas en la que se relacione cada elemento de la primera
#con los elementos de la segunda que sean multiplos de dicho elemento
print [[x,y] for x in [2,6,8] for y in [21,14,11,36] if y % x == 0]

#dada una lista de numeros retornar una lista de listas en la que cada numero 
#se combierta en una sublista de digitos
print [list(str(x)) for x in [123,456,789]]