class UnidadDeTiempo:
	def __init__(self):
		valor = 0
		tope = 59

	def borrar(self):
		self.valor = 0

	def avanzar(self):
		if self.valor < self.tope:
			self.valor = self.valor+1
		else:
			self.valor = 0;

	def resetear(self):
		self.valor = 0

	def getValor(self):
		return self.valor
