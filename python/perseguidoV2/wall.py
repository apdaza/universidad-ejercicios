from pygame.sprite import Sprite
from pygame import *
import util
from random import *


class Wall(Sprite):
    def __init__(self, pos):
        Sprite.__init__(self)
        self.image = util.cargar_imagen('imagenes/wall.jpg')
        self.rect = self.image.get_rect()
        self.pos = pos
        self.rect.move_ip(self.pos)



