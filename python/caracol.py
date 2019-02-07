def leer_matriz(archivo):
    return [linea[:-1].split(' ') for linea in open(archivo).readlines()]

def girar(matriz):
    return [[x[y]  for x in matriz] for y in range(-1,((len(matriz[0] )+1)*-1),-1)]


def caracol(lista,matriz):
    if len(matriz) <= 1:
        return lista + matriz[0]
    return caracol(lista+matriz[0],girar(matriz[1:])) 

print caracol([],leer_matriz("caracol.txt"))
