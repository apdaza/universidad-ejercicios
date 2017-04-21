import sys
import pygame
import util
from pygame.locals import *
from random import *
from wall import *
from heroe import *
from villano import *
from tablero import *
from constructores import *
import copy

SCREEN_WIDTH = 800
SCREEN_HEIGHT = 600
ICON_SIZE = 32

def ordenar(lista):
    for x in range(0,len(lista)):
        for y in range(0,len(lista)):
            if int(lista[x]) > int(lista[y]):
                temp = lista[x]
                lista[x] = lista[y]
                lista[y] = temp


def game():
    pygame.init()

    screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
    pygame.display.set_caption("Pursuit")
    background_image = util.cargar_imagen('imagenes/fondo.jpg')
    inicio_image = util.cargar_imagen('imagenes/inicio.jpg')
    acerca_image = util.cargar_imagen('imagenes/acerca.jpg')
    pygame.mouse.set_visible(False)

    tablero = Tablero()
    tablero.reiniciar((SCREEN_WIDTH, SCREEN_HEIGHT))
    director = Director()
    director.setBuilder(ConstructorHumanos())

    heroe = director.getHeroe()
    heroe.ubicar(tablero.pos_heroe)

    walls = []
    villanos = []
    """for i in tablero.lista:
        walls.append(Wall(i))


    for i in tablero.enemigos:
        copia_villano = copy.copy(villano)
        villanos.append(copia_villano)
"""
    ejecutando = True
    jugando = False
    while ejecutando:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                ejecutando = False
                sys.exit()
        teclas = pygame.key.get_pressed()
        if teclas[K_SPACE]:
            heroe.ubicar(tablero.pos_heroe)
            jugando = True
            heroe.vida = 100
            heroe.puntos = 0
            tablero.reiniciar((SCREEN_WIDTH, SCREEN_HEIGHT))
            walls = []
            villanos = []
            for i in tablero.lista:
                walls.append(Wall(i))

            villano = Villano((0,0))
            for i in tablero.enemigos:
                villano_copia = villano.copiar(i)
                villanos.append(villano_copia)

        if jugando:
            heroe.walls = walls
            heroe.enemigos = villanos
            screen.blit(background_image, (0, 0))

            fuente = pygame.font.Font(None, 30)
            texto_puntos = fuente.render("Puntos: " + str(heroe.puntos), 1, (250, 250, 250))
            texto_vida = fuente.render("Vida: " + str(heroe.vida), 1, (250, 250, 250))
            heroe.update()
            for n in walls:
                screen.blit(n.image, n.rect)
            heroe.draw(screen)
            for n in villanos:
                n.walls = walls
                n.partners = villanos
                n.update()
                screen.blit(n.image, n.rect)

            if heroe.vida <= 0:
                puntos = open('puntaje.txt', 'r')
                pts = [x[:-1] for x in puntos.readlines()]
                puntos.close()
                pts.append(heroe.puntos)
                jugando = False
                puntos = open('puntaje.txt', 'w')
                for x in pts:
                    puntos.write(str(x)+'\n')
                puntos.close()


            screen.blit(texto_vida, (20, 10))
            screen.blit(texto_puntos, (200, 10))
        else:
            if teclas[K_a]:
                screen.blit(acerca_image, (0, 0))
            else:
                screen.blit(inicio_image, (0, 0))
                puntos = open('puntaje.txt', 'r')
                pts = [x[:-1] for x in puntos.readlines()]
                puntos.close()
                ordenar(pts)
                linea = 400
                fuente = pygame.font.Font(None, 30)
                texto_puntos = fuente.render("Mejores puntajes: ", 1, (50, 50, 50))
                screen.blit(texto_puntos, (550, linea))
                fuente = pygame.font.Font(None, 20)
                for x in pts[:5]:
                    if int(x) == heroe.puntos:
                        color = (5, 5, 250)
                    else:
                        color = (250, 5, 5)
                    texto_puntos = fuente.render(str(x), 1, color)
                    screen.blit(texto_puntos, (750, linea))
                    linea += 25
        pygame.display.update()
        pygame.time.delay(10)


if __name__ == '__main__':
    game()
