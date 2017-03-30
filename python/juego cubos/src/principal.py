# To change this template, choose Tools | Templates
# and open the template in the editor.

__author__="alejo"
__date__ ="$11/03/2011 10:07:34 PM$"


import sys, pygame
from pygame.locals import *
from logica import *

SCREEN_WIDTH = 800
SCREEN_HEIGHT = 600

def load_image(name):
	""" carga una imagen controlando la existencia de la misma """
	try:
		image = pygame.image.load(name)
	except (pygame.error, message):
		print ('No se puede cargar la imagen: ', name)
		raise (SystemExit, message)

	image = image.convert_alpha()
	return image, image.get_rect()

def main():
	x=100
	y=100
	pygame.init()
	screen = pygame.display.set_mode((SCREEN_WIDTH,SCREEN_HEIGHT))
	pygame.display.set_caption( "Jueguito de Cubos" )

        tablero = Tablero(10,10,50,(255,255,255))
        tablero.agregarCaras()
        cubo = Cubo(100,100,50,(0,0,0))
        cubo.agregarCaras()
	while True:
		background_image, background_rect = load_image( "imagenes/fondo.jpg" )
		screen.blit(background_image, (0,0))
		
	
		
		for event in pygame.event.get():
                    
                    if event.type == pygame.QUIT:
                            sys.exit()
                    if event.type == pygame.KEYDOWN:
                        #print(event.key,"==",K_UP)
                        if event.key==K_UP:
                            #print("arriba")
                            cubo.mover("arriba")
                        if event.key==K_DOWN:
                            #print("abajo")
                            cubo.mover("abajo")
                        if event.key==K_LEFT:
                            #print("izquierda")
                            cubo.mover("izquierda")
                        if event.key==K_RIGHT:
                            #print("derecha")
                            cubo.mover("derecha")

		tablero.dibujar(screen)
                cubo.dibujar(screen)
                pygame.display.update()
		pygame.time.delay(10)

if __name__ == "__main__":
    main()
