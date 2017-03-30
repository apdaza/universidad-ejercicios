class ArbolN():
    def __init__(self, valor, hijos=[]):
        self.valor = valor
        self.hijos = hijos

arbol = ArbolN(2, [ArbolN (4, [ArbolN(12), ArbolN(24), ArbolN(40)]),
                   ArbolN (8, [ArbolN(16), ArbolN(32)]),
                   ArbolN (5, [ArbolN(25), ArbolN(50), ArbolN(100)])])

def buscar(arbol, valor):
    if arbol.valor == valor:
        return True
    else:
        if arbol.hijos == []:
            return False
        else:
            return buscar(arbol.hijos[0], valor) or buscar2(arbol.hijos[1:], valor)

def buscar2(lista, valor):
    if lista == []:
        return False
    else:
        return buscar(lista[0], valor) or buscar2(lista[1:], valor)
