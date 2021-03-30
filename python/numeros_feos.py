lista = [1]
indice = 0
while len(lista) < 1000:
	lista.append(lista[indice]*2)
	lista.append(lista[indice]*3)
	lista.append(lista[indice]*5)
	indice += 1
	lista = list(set(lista))
	lista.sort()
print lista
