import pygame
from pygame.sprite import Sprite
from pygame import *


class Heroe(Sprite):
    instance = None

    def __new__(cls, *args, **kargs):
        if cls.instance is None:
            cls.instance = object.__new__(cls, *args, **kargs)
        return cls.instance

    def __init__(self):
        Sprite.__init__(self)
        self.sentido = 0
        self.cont = 0
        self.velocidad = 10
        self.vida = 100
        self.puntos = 0
        self.walls = []
        self.enemigos = []

    def ubicar(self, pos):
        self.rect.x = pos[0]
        self.rect.y = pos[1]

    def set_sprites(self, sprites):
        self.imagenes = sprites
        self.image = self.imagenes[self.sentido][0]
        self.rect = self.image.get_rect()
        self.rect.move_ip(32, 32)

    def set_mensajes(self, mensajes):
        self.msgs = mensajes
        self.msg = self.msgs[0]

    def getPos(self):
        return (self.rect.x, self.rect.y)

    def update(self):
        teclas = pygame.key.get_pressed()
        oldx = self.rect.left
        oldy = self.rect.top
        if teclas[K_LEFT]:
            self.rect.left -= self.velocidad
            self.sentido = 1
        elif teclas[K_RIGHT]:
            self.rect.left += self.velocidad
            self.sentido = 0
        if teclas[K_UP]:
            self.rect.top -= self.velocidad
            self.sentido = 3
        elif teclas[K_DOWN]:
            self.rect.top += self.velocidad
            self.sentido = 2
        if teclas[K_LEFT] or teclas[K_RIGHT] or teclas[K_UP] or teclas[K_DOWN]:
            self.image = self.imagenes[self.sentido][self.cont]
            self.cont += 1
            self.cont %= 3
            self.puntos += 1
            self.msg = self.msgs[0]

        for n in self.walls:
            if self.rect.colliderect(n.rect):
                self.msg = self.msgs[2]
                self.rect.x = oldx
                self.rect.y = oldy

        for n in self.enemigos:
            if self.rect.colliderect(n.rect):
                self.msg = self.msgs[1]
                self.vida -= 1

    def draw(self, screen):
        fuente = pygame.font.Font(None, 20)
        texto_heroe = fuente.render(str(self.msg), 1, (20, 20, 50))
        screen.blit(self.image, self.rect)
        screen.blit(texto_heroe, (self.rect.x - 20, self.rect.y - 15))
