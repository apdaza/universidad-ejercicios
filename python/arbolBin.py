class Nodo():
    def __init__(self,val,izq=None,der=None):
        self.valor = val
        self.izquierda = izq
        self.derecha = der

def inorden(arbol):
    if arbol == None:
        return []
    else:
        return inorden(arbol.izquierda)+[arbol.valor]+inorden(arbol.derecha)

def preorden(arbol):
    if arbol == None:
        return []
    else:
        return [arbol.valor]+preorden(arbol.izquierda)+preorden(arbol.derecha)

def postorden(arbol):
    if arbol == None:
        return []
    else:
        return postorden(arbol.izquierda)+postorden(arbol.derecha)+[arbol.valor]

def evaluar(arbol):
    if arbol.valor == '+':
        return evaluar(arbol.izquierda) + evaluar(arbol.derecha)
    elif arbol.valor == '-':
        return evaluar(arbol.izquierda) - evaluar(arbol.derecha)
    elif arbol.valor == '*':
        return evaluar(arbol.izquierda) * evaluar(arbol.derecha)
    elif arbol.valor == '/':
        return evaluar(arbol.izquierda) / evaluar(arbol.derecha)
    else:
        return int(arbol.valor)

def suma(arbol):
    if arbol == None:
        return 0
    else:
        return suma(arbol.izquierda)+suma(arbol.derecha)+arbol.valor        

def insertar(arbol, valor):
    if arbol == None:
        return Nodo(valor)
    else:
        if valor >= arbol.valor:
            return Nodo(arbol.valor, arbol.izquierda, insertar(arbol.derecha, valor))
        else:
            return Nodo(arbol.valor, insertar(arbol.izquierda, valor), arbol.derecha)

def insertarLista(arbol, lista):
    if lista==[]:
        return arbol
    else:
        if arbol == None:
            return insertarLista(Nodo(lista[0]), lista[1:])
        else:
            return insertarLista(insertar(arbol, lista[0]), lista[1:])

def imprimeArbolSangrado(arbol, nivel=0):
    if arbol == None:
        return
    else:
        imprimeArbolSangrado(arbol.izquierda, nivel+1)
        print ' '*nivel + str(arbol.valor)
        imprimeArbolSangrado(arbol.derecha, nivel+1)

def buscarEnArbol(valor, arbol):
    if arbol == None:
        return False
    elif arbol.valor == valor:
        return True
    elif valor < arbol.valor:
        return buscarEnArbol(valor, arbol.izquierda)
    else:
        return buscarEnArbol(valor, arbol.derecha)

def contarElementos(arbol):
    if arbol == None:
        return 0
    else:
        return 1 + contarElementos(arbol.derecha) + contarElementos(arbol.izquierda)

        
a = Nodo(15, Nodo(10, Nodo(4)), Nodo(25))
b = Nodo('+', Nodo('-', Nodo('14'),Nodo('4')), Nodo('25'))

print inorden(a)
print preorden(a)
print postorden(a)
print suma(a)
print inorden(insertar(a,67))
print inorden(insertarLista(a,[23,2,17,20]))

imprimeArbolSangrado(a,0)

print inorden(b)
print preorden(b)
print postorden(b)

print evaluar(b)

print buscarEnArbol(10, a)
print buscarEnArbol(110, a)

print contarElementos(a)
