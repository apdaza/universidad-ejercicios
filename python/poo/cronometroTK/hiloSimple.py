from threading import Thread
from Cronometro import *
from time import *

class MiHilo(Thread):
   def run(self):
	   while True:
		   mostrarTiempo(c)

def mostrarTiempo(crono):
	while crono.parado == False:
		crono.avanzar()
		print (crono.getTiempo())
		

c = Cronometro()
c.cambiarEstado()

# Arranque del hilo
hilo = MiHilo()
hilo.start()
