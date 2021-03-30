def sumar(valor_1, valor_2):
    return valor_1 + valor_2

def restar(valor_1, valor_2):
    return valor_1 - valor_2

def multiplicar(valor_1, valor_2):
    return valor_1 * valor_2

def dividir(valor_1, valor_2):
    return valor_1 // valor_2

def elevar(base, exponente):
    if exponente == 0:
        return 1
    return elevar(base, exponente - 1) * base