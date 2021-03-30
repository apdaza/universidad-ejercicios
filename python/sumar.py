from functools import reduce

def sumar(elementos):
    acum = 0
    for e in elementos:
        acum += e
    return acum

def sumar2(elementos):
    acum = 0
    while len(elementos) > 0:
        acum += elementos[0]
        elementos.pop(0)
    return acum

def sumar3(elementos):
    return reduce((lambda x, y: x + y), elementos) 

def procedure_sum(elementos):
    print(reduce((lambda x, y: x + y), elementos)) 

print(procedure_sum([1,2,3,4,5,6]))
