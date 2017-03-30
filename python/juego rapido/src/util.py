import pygame

def cargar_imagen(nombre, optimizar=False):
    """carga una imagen que viene indicada por el parametro nombre"""
    imagen = pygame.image.load(nombre)
    if optimizar:
        return imagen.convert()
    else:
        return imagen.convert_alpha()