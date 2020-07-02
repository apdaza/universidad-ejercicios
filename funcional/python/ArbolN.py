class NodoN:
	def __init__(self, val, hijos = []):
		self.valor = val
		self.hijos = hijos
	
def buscar(arbol, valor):
	if arbol == None:
		return False
	elif arbol.valor == valor:
		return True
	else:
		return buscar_en_hijos(arbol.hijos, valor)

def buscar_en_hijos(lista, valor):
	if lista == []:
		return False
	else:
		return buscar(lista[0], valor) or buscar_en_hijos(lista[1:], valor)

def ver_arbol(arbol):
	if arbol == None:
		return []
	else:
		return [arbol.valor] + ver_hijos(arbol.hijos)

def ver_hijos(lista):
	if lista==[]:
		return []
	else:
		return [ver_arbol(lista[0])] + ver_hijos(lista[1:])

def insertar(arbol, valor):
	if arbol == None:
		return NodoN(valor)
	if arbol.valor == valor[:-1]:
		return NodoN(arbol.valor, arbol.hijos+[NodoN(valor)])
	return insertar_hijos(arbol.hijos,valor)

def insertar_hijos(lista, valor):
	if lista == []:
		return None
	return insertar(lista[0], valor); insertar_hijos(lista[1:], valor)
	

arbol = NodoN('1',[NodoN('12',[NodoN('121'),
							NodoN('122')]),
				  NodoN('15',[NodoN('151')]),
				  NodoN('10'),
				  NodoN('13',[NodoN('131'),NodoN('132'),NodoN('133')])])

#print(buscar(arbol, '20'))
#print(buscar(arbol, '130'))
print(ver_arbol(arbol))
print(ver_arbol((insertar(arbol, '1211'))))
