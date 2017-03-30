class Arbol():
    def __init__(self, valor, pos, hijos=[]):
        self.valor = valor
        self.posicion = pos
        self.hijos = hijos

def buscar_valor(arbol, valor):
    if arbol.valor == valor:
        return True
    else:
        if arbol.hijos == []:
            return False
        else:
            return buscar_valor(arbol.hijos[0], valor) or buscar_valor_hijos(arbol.hijos[1:], valor)

def buscar_valor_hijos(lista, valor):
    if lista == []:
        return False
    else:
        return buscar_valor(lista[0], valor) or buscar_valor_hijos(lista[1:], valor)
        
def buscar_inicio(matriz):
	for f in range(len(matriz)):
		for c in range(len(matriz[f])):
			if matriz[f][c] == "X":
				return (f, c)
				
def mostrar_arbol(arbol):
	if arbol == None:
		pass 
	else:
		print arbol.valor + " | (" + str(arbol.posicion[0]) + "," + str(arbol.posicion[1]) + ")"
		mostrar_arbol_hijos(arbol.hijos)

def mostrar_arbol_hijos(lista):
	if lista == []:
		pass
	else:
		mostrar_arbol(lista[0])
		mostrar_arbol_hijos(lista[1:])


arbol = Arbol('X', (1,1), [Arbol ('0', (1,2), [Arbol('0', (1,3)), Arbol('0',(1,2))]),
                            Arbol ('0', (2,1), [Arbol('Y',(3,1))])
                           ]
              )		


lista = [list(linea[:-1]) for linea in open("laberinto.txt").readlines()]

print buscar_inicio(lista)

mostrar_arbol(arbol)
