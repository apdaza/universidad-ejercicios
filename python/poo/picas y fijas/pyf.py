from random import *


class Numero():
    def __init__(self):
        self.lista = []
        self.picas = 0
        self.fijas = 0

    def buscarRepetido(self, a):
        for i in self.lista:
            if i == a:
                return True
        self.lista.append(a)
        return False

    def mostrarNumero(self):
        numero = 0
        for i in self.lista:
            numero = numero * 10 + i
        return numero

    def mostrarPicasFijas(self):
        return "picas = " + str(self.picas) + " fijas " + str(self.fijas)

    def compararNumeros(self, numero):
        self.picas = 0
        self.fijas = 0
        for u in range(0, 3):
            for a in range(0, 3):
                if self.lista[a] == numero.lista[u]:
                    if a == u:
                        self.fijas = self.fijas + 1
                    else:
                        self.picas = self.picas + 1


class NumeroAleatorio(Numero):

    def generarNumero(self):
        cont = 0
        while cont < 3:
            verificacion = True
            while verificacion:
                x = randint(0, 9)
                verificacion = self.buscarRepetido(x)
            cont = cont + 1


class NumeroUsuario(Numero):

    def capturarNumero(self, numero):
        self.lista = []
        while numero > 0:
            self.lista = [numero % 10] + self.lista
            numero = numero / 10


def main():
    numeroMaquina = NumeroAleatorio()
    numeroUsuario = NumeroUsuario()

    numeroMaquina.generarNumero()

    intentos = 0
    while numeroMaquina.fijas < 3 and intentos < 10:
        numero = input("ingrese un numero de 3 digitos: ")
        numeroUsuario.capturarNumero(numero)
        numeroMaquina.compararNumeros(numeroUsuario)
        print(numeroMaquina.mostrarPicasFijas())
        intentos = intentos + 1

    if numeroMaquina.fijas == 3:
        print("Usted gano en " + str(intentos) + " intentos")
    else:
        print("no pudo adivinar luego de " + str(intentos) + " intentos")
        print("el numero es: " + str(numeroMaquina.mostrarNumero()))

if __name__ == '__main__':
    main()