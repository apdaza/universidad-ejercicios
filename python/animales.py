class Animal():
    def alimentar(self):
        pass

    def dormir(self):
        print "durmiendo"

class Gato(Animal):
    def alimentar(self):
        print "quiero catchaw"

class Perro(Animal):
    def alimentar(self):
        print "quiero dogchaw"

animal = Perro()
animal.alimentar()
animal.dormir()

animal = Gato()
animal.alimentar()
animal.dormir()
