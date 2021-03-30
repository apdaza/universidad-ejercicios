#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#       sin título.py
#       
#       Copyright 2011 Alejandro Daza <alejo@dhcppc5>
#       
#       This program is free software; you can redistribute it and/or modify
#       it under the terms of the GNU General Public License as published by
#       the Free Software Foundation; either version 2 of the License, or
#       (at your option) any later version.
#       
#       This program is distributed in the hope that it will be useful,
#       but WITHOUT ANY WARRANTY; without even the implied warranty of
#       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#       GNU General Public License for more details.
#       
#       You should have received a copy of the GNU General Public License
#       along with this program; if not, write to the Free Software
#       Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#       MA 02110-1301, USA.
import sys, pygame
from pygame.locals import *

class Componente:
	x = 0
	y = 0
	tam = 0
	
	def __init__(self, x, y, t):
		self.x = x
		self.y = y
		self.tam = t
		
	def dibujar(self):
		raise NotImplementedError( "Should have implemented this" )
			
class Cara(Componente):
	tipo = 0
	puntosX = []
	puntosY = []
	
	def dibujar(self, screen):
		pygame.screen.draw
		
		
	
