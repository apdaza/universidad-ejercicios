def suma(lista):
	if lista == []:
		return 0
	else:
		return lista[0] + suma(lista[1:])

def minimo(lista):
	if len(lista)==1:
		return lista[0]
	elif lista[0] < lista[1]:
		return minimo([lista[0]]+lista[2:])
	else:
		return minimo(lista[1:])
		
print(minimo([3,4,5,2,4]))		

def menores(lista):
	if lista == []:
		return []
	else:
		return [minimo(lista[0])] + menores(lista[1:])
		
print(menores([[5,6,7,8,9],[2,3,1,4,5],[11,22,33,44,55,7]]))



lista=[[5,6,7,8,9],[2,3,1,4,5],[11,22,33,44,55,7]]

print (lista[1][2:])




