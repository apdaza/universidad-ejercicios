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
	

arbol = NodoN(10,[NodoN(20,[NodoN(40),
							NodoN(44)]),
				  NodoN(50,[NodoN(150)]),
				  NodoN(100),
				  NodoN(1000,[NodoN(2000),NodoN(3000),NodoN(5000)])])

print buscar(arbol, 20)
print buscar(arbol, 3000)
