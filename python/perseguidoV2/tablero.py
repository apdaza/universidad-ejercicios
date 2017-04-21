from pygame.sprite import Sprite
from pygame import *
from random import *


class Tablero(Sprite):
    def reiniciar(self, tam):
        self.lista = [(x * 32, y) for x in range(0, tam[0] / 32) for y in [0, tam[1] - 32]]
        self.lista += [(x, y * 32) for x in [0, tam[0] - 32] for y in range(0, tam[1] / 32)]
        i = 0
        cant = randint(20, 40)
        while i < cant:
            tupla = (randint(0, tam[0] / 32) * 32, randint(0, tam[1] / 32) * 32)
            if tupla not in self.lista or tupla == (32, 32):
                self.lista.append(tupla)
                i += 1
        i = 0
        self.enemigos = []
        cant = randint(5, 15)
        while i <= cant:
            tupla = (randint(0, tam[0] / 32) * 32, randint(0, tam[1] / 32) * 32)
            if tupla not in self.lista and tupla not in self.enemigos:
                self.enemigos.append(tupla)
                i += 1
        self.pos_heroe = (0, 0)
        while self.pos_heroe in self.lista:
            self.pos_heroe = (randint(0, tam[0] / 32) * 32, randint(0, tam[1] / 32) * 32)
            print self.pos_heroe

