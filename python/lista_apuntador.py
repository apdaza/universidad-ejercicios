class Alumno:
	nombre = ""
	apellido = ""
	codigo = ""
	notas = []
	siguiente = None
	
	def promedio(self):
		p=0
		cont = 0
		for n in self.notas:
			p+=n
			cont+=1
		p/=cont
		return p
	
a = Alumno()
a.nombre = "Juan"
a.apellido = "Diaz"
a.codigo = "123"
a.notas = [2.5,3.0,4.0]

a.siguiente = Alumno()
a.siguiente.nombre = "Ana"
a.siguiente.apellido = "Perez"
a.siguiente.codigo = "456"
a.siguiente.notas = [5.0,3.0,4.0]

inicio = a
while inicio:
	print "Nombre:",inicio.nombre
	print "Apellido:",inicio.apellido
	print "Promedio: %.1f" % (inicio.promedio())
	print ""
	inicio = inicio.siguiente
	
	
