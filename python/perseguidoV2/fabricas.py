from productos import *

class FabricaAbstracta():
    def crear_izquierda(self): pass
    def crear_derecha(self): pass
    def crear_arriba(self): pass
    def crear_abajo(self): pass

class FabricaSpritesHumano(FabricaAbstracta):
    def crear_izquierda(self):
        izquierda = IzquierdaHumano()
        return izquierda.get_sprites()

    def crear_derecha(self):
        derecha = DerechaHumano()
        return derecha.get_sprites()

    def crear_arriba(self):
        arriba = ArribaHumano()
        return arriba.get_sprites()

    def crear_abajo(self):
        abajo = AbajoHumano()
        return abajo.get_sprites()

class FabricaSpritesZombi(FabricaAbstracta):
    def crear_izquierda(self):
        izquierda = IzquierdaZombi()
        return izquierda.get_sprites()

    def crear_derecha(self):
        derecha = DerechaZombi()
        return derecha.get_sprites()

    def crear_arriba(self):
        arriba = ArribaZombi()
        return arriba.get_sprites()

    def crear_abajo(self):
        abajo = AbajoZombi()
        return abajo.get_sprites()

class FabricaSpritesEsqueleto(FabricaAbstracta):
    def crear_izquierda(self):
        izquierda = IzquierdaEsqueleto()
        return izquierda.get_sprites()

    def crear_derecha(self):
        derecha = DerechaEsqueleto()
        return derecha.get_sprites()

    def crear_arriba(self):
        arriba = ArribaEsqueleto()
        return arriba.get_sprites()

    def crear_abajo(self):
        abajo = AbajoEsqueleto()
        return abajo.get_sprites()
