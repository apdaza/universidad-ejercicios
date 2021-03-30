import base as ba

def sumar(lista):
    acum = 0
    for e in lista:
        acum = ba.sumar(acum, e)

    return acum

def sumar_recursivo(lista):
    if lista == []:
        return 0
    return sumar_recursivo(lista[1:]) + lista[0]

def pasar_enteros(lista):
    enteros = []
    for e in lista:
        enteros.append(int(e))
    
    return enteros
