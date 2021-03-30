from pygame.sprite import Sprite
from pygame import *
import util
from heroe import *
from random import *
from fabricas import *

class Villano(Sprite):
    def __init__(self, pos):
        Sprite.__init__(self)
        fabrica = FabricaSpritesEsqueleto()

        self.imagenes = [fabrica.crear_derecha(),
                         fabrica.crear_izquierda(),
                         fabrica.crear_abajo(),
                         fabrica.crear_arriba()]
        self.image = self.imagenes[0][0]
        self.rect = self.image.get_rect()
        self.rect.move_ip(pos)
        self.velocidad = randint(1, 3)
        self.heroe = Heroe()
        self.walls = []
        self.partners = []
        self.sentido = 0
        self.cont = 0

    def copiar(self, pos):
        villano = Villano(pos)
        return villano

    def update(self):
        pos_heroe = self.heroe.getPos()
        oldx = self.rect.left
        oldy = self.rect.top
        if pos_heroe[0] < self.rect.x:
            self.rect.x -= self.velocidad
            self.sentido = 1
            for n in self.walls:
                if self.rect.colliderect(n.rect):
                    self.rect.x += self.velocidad
                    self.sentido = 0
        if pos_heroe[0] > self.rect.x:
            self.rect.x += self.velocidad
            self.sentido = 0
            for n in self.walls:
                if self.rect.colliderect(n.rect):
                    self.rect.x -= self.velocidad
                    self.sentido = 1
        if pos_heroe[1] < self.rect.y:
            self.rect.y -= self.velocidad
            for n in self.walls:
                if self.rect.colliderect(n.rect):
                    self.rect.y += self.velocidad
        if pos_heroe[1] > self.rect.y:
            self.rect.y += self.velocidad
            for n in self.walls:
                if self.rect.colliderect(n.rect):
                    self.rect.y -= self.velocidad

        self.image = self.imagenes[self.sentido][self.cont]
        self.cont += 1
        self.cont %= 3


        for n in self.walls:
            if self.rect.colliderect(n.rect):
                self.rect.x = oldx
                self.rect.y = oldy

        for n in self.partners:
            if self.rect.x != n.rect.x or self.rect.y != n.rect.y:
                if self.rect.colliderect(n.rect):
                    self.rect.x = oldx
                    self.rect.y = oldy
