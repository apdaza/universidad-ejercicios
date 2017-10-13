class Saludador():
    def __init__(self,msg):
        self.mensaje = msg

    def saludar(self, nombre):
        print self.mensaje + nombre


class Saludador2(Saludador):
    def despedir(self):
        print "adios"

class Saludador3():
    def __init__(self, msg):
        self.mensaje = msg

    def despedir(self):
        print self.mensaje + "desde el padre 2"

class SaludadorHijo(Saludador3, Saludador2):
    pass

#saludador = Saludador("hola ")
#saludador.saludar("alejo")

#saludador2 = Saludador2("buenas ")
#saludador2.saludar("miguel")
#saludador2.despedir()

saludador_hijo = SaludadorHijo("hasta la vista ")
saludador_hijo.saludar("alejo")
saludador_hijo.despedir()

