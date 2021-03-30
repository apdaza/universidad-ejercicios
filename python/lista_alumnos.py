class Alumno:
	nombre = ""
	apellido = ""
	codigo = ""
	notas = []
	siguiente = None
	
	def promedio(self):
		acum=0
		for n in self.notas:
			acum+=n
		return acum/len(self.notas)
	
a=Alumno()
inicio = a
opcion = ""

while True:	
	a.nombre = raw_input("ingrese el nombre ")
	a.apellido = raw_input("ingrese el apellido ")
	a.codigo = raw_input("ingrese el codigo ")
	notas = raw_input("ingrese el notas ").split()
	for n in notas:
		a.notas.append(float(n))
	
	opcion = raw_input("Desea continuar s/n")
	if opcion != "N" and opcion != "n":
		a.siguiente = Alumno()
		a = a.siguiente
	else:
		break
		
while inicio:
	print "Nombre:",inicio.nombre
	print "Apellido:",inicio.apellido
	print "Promedio: %.1f" % (inicio.promedio())
	print ""
	inicio = inicio.siguiente
	

