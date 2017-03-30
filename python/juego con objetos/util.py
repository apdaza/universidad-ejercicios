import pygame

def cargar_imagen(nombre, optimizar=False):
    imagen = pygame.image.load(nombre)

    if optimizar:
        return imagen.convert()
    else:
        return imagen.convert_alpha()

def cargar_sonido(nombre):
    return pygame.mixer.Sound(nombre)
