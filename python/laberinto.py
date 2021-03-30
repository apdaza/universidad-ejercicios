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

def buscar_camino(matriz, pos, revisadas):
    if matriz[pos[0]][pos[1]] == 2:
        print 'found at %d,%d' % (pos[0], pos[1])
        return True
    elif matriz[pos[0]][pos[1]] == 1:
        print 'wall at %d,%d' % (pos[0], pos[1])
        return False
    elif matriz[pos[0]][pos[1]] == 3:
        print 'visited at %d,%d' % (pos[0], pos[1])
        return False
    print 'visiting %d,%d' % (pos[0], pos[1])
    # mark as visited
    matriz[pos[0]][pos[1]] = 3
    # explore neighbors clockwise starting by the one on the right
    if ((pos[0] < len(matriz)-1 and buscar_camino(matriz,(pos[0]+1, pos[1]),revisadas))
        or (pos[1] > 0 and buscar_camino(matriz,(pos[0], pos[1]-1),revisadas))
        or (pos[0] > 0 and buscar_camino(matriz,(pos[0]-1, pos[1]),revisadas))
        or (pos[1] < len(matriz)-1 and matriz(pos[0], pos[1]+1))):
        return True
    return False
    """if matriz[pos[0]][pos[1]] != "1":
        print pos
    if matriz[pos[0]][pos[1]] == "Y":
        print "encontrado"
    else:
        if matriz[pos[0]-1][pos[1]] != "1" and (pos[0]-1,pos[1]) not in revisadas:
            return buscar_camino(matriz,(pos[0]-1,pos[1]),revisadas + [(pos[0]-1,pos[1])])
        if matriz[pos[0]+1][pos[1]] != "1" and (pos[0]+1,pos[1]) not in revisadas:
            return buscar_camino(matriz,(pos[0]+1,pos[1]),revisadas + [(pos[0]+1,pos[1])])
        if matriz[pos[0]][pos[1]-1] != "1" and (pos[0],pos[1]-1) not in revisadas:
            return buscar_camino(matriz,(pos[0],pos[1]-1),revisadas + [(pos[0],pos[1]-1)])
        if matriz[pos[0]][pos[1]+1] != "1" and (pos[0],pos[1]+1) not in revisadas:
            return buscar_camino(matriz,(pos[0],pos[1]+1),revisadas + [(pos[0],pos[1]+1)])
"""


"""arbol = Arbol('X', (1,1), [Arbol ('0', (1,2), [Arbol('0', (1,3)), Arbol('0',(1,2))]),
                            Arbol ('0', (2,1), [Arbol('Y',(3,1))])
                           ]
              )
"""

lista = [list(linea[:-1]) for linea in open("laberinto.txt").readlines()]

print buscar_inicio(lista)

#mostrar_arbol(arbol)
buscar_camino(lista, buscar_inicio(lista), [])
