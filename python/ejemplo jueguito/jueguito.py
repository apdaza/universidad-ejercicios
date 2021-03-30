import sys, pygame
from pygame.locals import *

SCREEN_WIDTH = 640
SCREEN_HEIGHT = 480
ICON_SIZE = 32

def load_matriz(file):
	""" Carga el archivo del laberinto en la lista """
	inp = open(file,"r")
	lista = []
	for linea in inp.readlines():
		lista.append(linea.split())
	return lista
	
def verificar_matriz(lista):
	""" verifica si aun esta el heroe en juego en la matriz """
	no_encontrado = True
	for n in range(len(lista)):
		for m in range(len(lista[n])):
			if lista[n][m]=="X":
				no_encontrado = False
	return no_encontrado

def finalizar_matriz(lista):
	""" limpia la lista que tiene la matriz del juego """
	for n in range(len(lista)):
		for m in range(len(lista[n])):
			lista[n][m]="0"
			
				
def mover_heroe(lista,movimiento):
	""" mueve el heroe en la matriz """
	posx,posy = -1,-1
	for n in range(len(lista)):
		for m in range(len(lista[n])):
			if lista[n][m] == "X":
				posx=n
				posy=m
				break
	if posx > -1:
		if movimiento == "u":
			if lista[posx][posy-1]=="W":
				finalizar_matriz(lista)
			elif posy-1 >= 0 and lista[posx][posy-1]!="1":
				lista[posx][posy]= "0"
				lista[posx][posy-1]="X"
		elif movimiento == "d":
			if lista[posx][posy+1]=="W":
				finalizar_matriz(lista)
			elif posy+1 < len(lista[posx])-1 and lista[posx][posy+1]!="1":
				lista[posx][posy]= "0"
				lista[posx][posy+1]="X"
		elif movimiento == "r":
			if lista[posx+1][posy]=="W":
				finalizar_matriz(lista)
			elif posx+1 < len(lista)-1 and lista[posx+1][posy]!="1":
				lista[posx][posy]= "0"
				lista[posx+1][posy]="X"
		elif movimiento == "l":
			if lista[posx-1][posy]=="W":
				finalizar_matriz(lista)
			elif posx-1 >= 0 and lista[posx-1][posy]!="1":
				lista[posx][posy]= "0"
				lista[posx-1][posy]="X"

def load_image(name):
	""" carga una imagen controlando la existencia de la misma """
	try: 
		image = pygame.image.load(name)
	except pygame.error, message:
		print 'No se puede cargar la imagen: ', name
		raise SystemExit, message

	image = image.convert_alpha()
	return image, image.get_rect()

def main():
	pygame.init()
	screen = pygame.display.set_mode((SCREEN_WIDTH,SCREEN_HEIGHT))
	pygame.display.set_caption( "Jueguito Python" )
	lista = load_matriz("archivos/matriz.txt")
	while True:
		background_image, background_rect = load_image( "imagenes/fondo.jpg" )
		ganaste_image, ganaste_rect = load_image("imagenes/ganaste.jpg")
		wall_image, wall_rect = load_image("imagenes/wall2.jpg")
		tux_image, tux_rect = load_image("imagenes/tux.png")
		pygame.mouse.set_visible( False )
		screen.blit(background_image, (0,0))
		for n in range(len(lista)):
			for m in range(len(lista[n])):
				if lista[n][m] == "1":
					screen.blit(wall_image, (n*ICON_SIZE,m*ICON_SIZE))
				if lista[n][m] == "X":
					screen.blit(tux_image, (n*ICON_SIZE,m*ICON_SIZE))
		
		if verificar_matriz(lista):
			screen.blit(ganaste_image, (0,SCREEN_HEIGHT/3))
		
		for event in pygame.event.get():
			if event.type == pygame.QUIT:
				sys.exit()
			if event.type == pygame.KEYDOWN:
				if event.key==K_UP:
					mover_heroe(lista,"u")
				if event.key==K_DOWN:
					mover_heroe(lista,"d")
				if event.key==K_LEFT:
					mover_heroe(lista,"l")
				if event.key==K_RIGHT:
					mover_heroe(lista,"r")
		pygame.display.update()
		pygame.time.delay(10)
		
if __name__ == '__main__': main()
