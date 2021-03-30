from pytest import *
from base import *


def test_suma():
    assert 15 == sumar(10, 5)

def test_resta():
    assert 5 == restar(10, 5)

def test_multiplicacion():
    assert 15 == multiplicar(5, 3)

def test_division():
    assert 3 == dividir(10, 3)

def test_potencia():
    assert 125 == elevar(5, 3)