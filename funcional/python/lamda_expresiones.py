
cuadrado = lambda x: x * x
print(cuadrado(3))

def incrementador(n):
    return lambda x: x + n

f = incrementador(2)
g = incrementador(3)

print(f(25), g(25))

print(list(map (lambda x: x + 3, [2,3,4,5])))

print(list(map (g, [2,3,4,5])))

print(list(filter ((lambda x: x % 5 == 0),range(1,100))))
