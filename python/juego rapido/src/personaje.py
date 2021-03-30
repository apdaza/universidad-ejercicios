import pygame
from pygame.sprite import Sprite
from pygame import *
from random import *
from util import *

class Personaje(Sprite):
    """Clase que define el comportamiento de los villanos del juego"""
    def __init__(self,coord,vel):
        """constructor de la clase"""
        Sprite.__init__(self)
        self.image = cargar_imagen('../imagenes/tux.png')
        self.rect = self.image.get_rect()
        self.rect.move_ip(coord[0], coord[1])
        self.dir = "l"
        self.velocidad=vel
                
    def update(self):
        """actualiza la posicion del villano"""
        if self.dir == "l":
            self.rect.x += self.velocidad
            self.rect.y += self.velocidad//2
        elif self.dir == "r":
            self.rect.x -= self.velocidad
            self.rect.y += self.velocidad//2
        elif self.dir == "u":
            self.rect.x += self.velocidad
            self.rect.y -= self.velocidad//2
        elif self.dir == "d":
            self.rect.x -= self.velocidad
            self.rect.y -= self.velocidad//2
        if self.rect.x<=0:
            if self.dir=="r":
                self.dir="l"
            else:
                self.dir="u"
        if self.rect.x>=768:
            if self.dir=="l":
                self.dir="r"
            else:
                self.dir="d"
        if self.rect.y<=0:
            if self.dir=="u":
                self.dir="l"
            else:
                self.dir="r"
        if self.rect.y>=568:
            if self.dir=="l":
                self.dir="u"
            else:
                self.dir="d"
