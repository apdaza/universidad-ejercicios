def filtrar_por_cabeza(lista):
    if lista == []:
        return []
    if len(lista) == 1:
        return lista
    if lista[-1] % lista[0] == 0:
        return filtrar_por_cabeza(lista[:-1]) + [lista[-1]]
    return filtrar_por_cabeza(lista[:-1])

print filtrar_por_cabeza([25] + range(200))
