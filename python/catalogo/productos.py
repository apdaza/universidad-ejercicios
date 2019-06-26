import util

class Abajo():
    def get_sprites(self): pass

class AbajoHumano(Abajo):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/F1.png'),
                util.cargar_imagen('imagenes/F2.png'),
                util.cargar_imagen('imagenes/F3.png')]

class AbajoZombi(Abajo):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/ZF1.png'),
                util.cargar_imagen('imagenes/ZF2.png'),
                util.cargar_imagen('imagenes/ZF3.png')]

class AbajoEsqueleto(Abajo):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/SF1.png'),
                util.cargar_imagen('imagenes/SF2.png'),
                util.cargar_imagen('imagenes/SF3.png')]

class Arriba():
    def get_sprites(self): pass

class ArribaHumano(Arriba):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/B1.png'),
                util.cargar_imagen('imagenes/B2.png'),
                util.cargar_imagen('imagenes/B3.png')]

class ArribaZombi(Arriba):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/ZB1.png'),
                util.cargar_imagen('imagenes/ZB2.png'),
                util.cargar_imagen('imagenes/ZB3.png')]

class ArribaEsqueleto(Arriba):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/SB1.png'),
                util.cargar_imagen('imagenes/SB2.png'),
                util.cargar_imagen('imagenes/SB3.png')]

class Derecha():
    def get_sprites(self): pass

class DerechaHumano(Derecha):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/D1.png'),
                util.cargar_imagen('imagenes/D2.png'),
                util.cargar_imagen('imagenes/D3.png')]

class DerechaZombi(Derecha):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/ZD1.png'),
                util.cargar_imagen('imagenes/ZD2.png'),
                util.cargar_imagen('imagenes/ZD3.png')]

class DerechaEsqueleto(Derecha):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/SD1.png'),
                util.cargar_imagen('imagenes/SD2.png'),
                util.cargar_imagen('imagenes/SD3.png')]


class Izquierda():
    def get_sprites(self): pass

class IzquierdaHumano(Izquierda):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/I1.png'),
                util.cargar_imagen('imagenes/I2.png'),
                util.cargar_imagen('imagenes/I3.png')]

class IzquierdaZombi(Izquierda):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/ZI1.png'),
                util.cargar_imagen('imagenes/ZI2.png'),
                util.cargar_imagen('imagenes/ZI3.png')]

class IzquierdaEsqueleto(Izquierda):
    def get_sprites(self):
        return [util.cargar_imagen('imagenes/SI1.png'),
                util.cargar_imagen('imagenes/SI2.png'),
                util.cargar_imagen('imagenes/SI3.png')]
