from flask import Flask
from base import *
from base_conjuntos import *

app = Flask(__name__)


@app.route('/')
def inicio():
    return "hola"

@app.route('/operar/<operador>/<int:valor_1>/<int:valor_2>')
def calcular(operador, valor_1, valor_2):
    if operador == 'suma':
        valor = sumar(valor_1, valor_2)
    elif operador == 'resta':
        valor = restar(valor_1, valor_2)
    elif operador == 'multiplicacion':
        valor = multiplicar(valor_1, valor_2)
    elif operador == 'potencia':
        valor = elevar(valor_1, valor_2)
    elif operador == 'division':
        valor = dividir(valor_1, valor_2)
    else:
        valor = inicio()

    return str(valor)

@app.route('/recursividad/<operador>/<lista>')
def calcular_rec(operador, lista):
    #l = [int(x) for x in lista.split(',')]
    l = pasar_enteros(lista.split(','))
    if operador == 'suma':
        valor = sumar_recursivo(l)
    else:
        valor = inicio()

    return str(valor)
    


if __name__ == '__main__':
    app.run(debug=True)