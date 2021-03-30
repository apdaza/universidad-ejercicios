from random import choice
import sys, pygame, random
from pygame.locals import *


class Componente:

    def __init__(self,x,y,t,color):
        self.x = x
        self.y = y
        self.tam = t
        self.color = color


class Cara(Componente):
    def establecerTipo(self, tipo):
        self.tipo = tipo
   
    def dibujar(self,screen):
        if self.tipo == "tapa":
            pygame.draw.polygon(screen, self.color, [(self.x,self.y),(self.x+self.tam,self.y),(self.x+self.tam*1.5,self.y-self.tam//2),(self.x+self.tam*0.5,self.y-self.tam//2)])
        elif self.tipo == "cara":
            pygame.draw.polygon(screen, self.color, [(self.x,self.y),(self.x+self.tam,self.y),(self.x+self.tam,self.y+self.tam),(self.x,self.y+self.tam)])
        elif self.tipo == "lateral":
            pygame.draw.polygon(screen, self.color, [(self.x,self.y),(self.x+self.tam*0.5,self.y-self.tam//2),(self.x+self.tam*0.5,self.y+self.tam//2),(self.x,self.y+self.tam)])

class Compuesto(Componente):
    componentes = []

    def agregarComponente(self,componente):
        self.componentes.append(componente)

class Tablero(Compuesto):
    def agregarCaras(self):
        for i in range(4):
            for j in range(4):
                cara = Cara(self.x*(i+self.tam),self.y*(j+self.tam),self.tam,(255,255,255))
                cara.establecerTipo("cara")
                self.agregarComponente(cara)

    def dibujar(self,screen):
        for c in self.componentes:
            c.dibujar(screen)

class Cubo(Compuesto):
    def agregarCaras(self):
        listaColores = [(255,0,0),(0,255,0),(0,0,255),(255,0,255),(255,255,0),(255,255,255)]
        cara = Cara(self.x,self.y,self.tam,random.choice(listaColores))
        cara.establecerTipo("cara")
        self.agregarComponente(cara)
        cara2 = Cara(self.x,self.y,self.tam,random.choice(listaColores))
        cara2.establecerTipo("tapa")
        self.agregarComponente(cara2)
        cara3 = Cara(self.x+self.tam,self.y,self.tam,random.choice(listaColores))
        cara3.establecerTipo("lateral")
        self.agregarComponente(cara3)

    def mover(self,direccion):
        if direccion=="arriba":
            for c in self.componentes:
                c.y-=c.tam
        if direccion=="abajo":
            for c in self.componentes:
                c.y+=c.tam
        if direccion=="derecha":
            for c in self.componentes:
                c.x+=c.tam
        if direccion=="izquierda":
            for c in self.componentes:
                c.x-=c.tam

    def dibujar(self,screen):
        for c in self.componentes:
            c.dibujar(screen)