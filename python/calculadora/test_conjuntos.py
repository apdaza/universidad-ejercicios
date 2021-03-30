from base_conjuntos import *

def test_suma_conjuntos():
    l = [1,2,3,4,5]
    assert 15 == sumar(l)

def test_suma_conjuntos_rec():
    l = [1,2,3,4,5]
    assert 15 == sumar_recursivo(l)