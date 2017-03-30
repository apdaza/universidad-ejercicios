import sys, pygame, util
from pygame.locals import *
from heroe import *
from villano import *

SCREEN_WIDTH = 640
SCREEN_HEIGHT = 480
ICON_SIZE = 32

def game():
      pygame.init()
      pygame.mixer.init()
      screen = pygame.display.set_mode( (SCREEN_WIDTH,SCREEN_HEIGHT) )
      pygame.display.set_caption( "El Gran Laberinto" )
      background_image = util.cargar_imagen('imagenes/fondo.jpg');
      pierde_vida = util.cargar_sonido('sonidos/pierde_vida.wav')
      pygame.mouse.set_visible( False )
      temporizador = pygame.time.Clock()
      heroe = Heroe()
      villano = [Villano((100,120),7),Villano((200,280),10),Villano((300,370),8)]
      while True:
		  heroe.update()
		  for n in villano:
			  n.update()
		  heroe.image = heroe.imagenes[0]
		  for n in villano:
			  if heroe.rect.colliderect(n.rect):
				  heroe.image = heroe.imagenes[1]
				  pierde_vida.play()
		  
		  for event in pygame.event.get():
			  if event.type == pygame.QUIT:
				  sys.exit()
		  screen.blit(background_image, (0,0))
		  screen.blit(heroe.image, heroe.rect)
		  for n in villano:
			  screen.blit(n.image, n.rect)
		  pygame.display.update()
		  pygame.time.delay(10)
		
      
if __name__ == '__main__':
      game()

