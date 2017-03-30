import sys, pygame
from pygame.locals import *
from util import *
from personaje import *


def main():
    pygame.init()
    screen = pygame.display.set_mode( (800,600) )
    pygame.display.set_caption( "La Plaga" )
    background_image = cargar_imagen('../imagenes/fondo.jpg');
    personajes = []
    
    personajes.append(Personaje((400,300),5))
    
    puntos=0
    
    while True:
        screen.blit(background_image, (0,0))
        
        fuente = pygame.font.Font(None,50)
        imagen_vida = fuente.render("Puntos: "+str(puntos),1,(100,100,255))
        screen.blit(imagen_vida,(600,560))
        for n in personajes:
            n.update() 
            screen.blit(n.image, n.rect)   
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                print(pygame.mouse.get_pos())
        pygame.display.update()
        pygame.time.delay(10)


if __name__ == '__main__':
    main()
