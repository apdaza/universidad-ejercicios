from Hora import *
from Minuto import *
from Segundo import *

class Cronometro:
	def __init__(self):
		self.h = Hora()
		self.m = Minuto()
		self.s = Segundo()
		self.parado = True;

	def avanzar(self):
		self.s.avanzar()
		if(self.s.getValor()==0):
			self.m.avanzar()
			if(self.m.getValor()==0):
				self.h.avanzar()

	def getTiempo(self):
		return str(self.h.getValor())+":"+str(self.m.getValor())+":"+str(self.s.getValor())

	def cambiarEstado(self):
		self.parado = not self.parado

	def borrar(self):
		self.h.borrar()
		self.m.borrar()
		self.s.borrar()
