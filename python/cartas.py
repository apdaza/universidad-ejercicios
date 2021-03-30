# -*- coding: utf-8 -*-
from random import *

def baraja():
    return sample([(x, y) for x in [str(n) for n in range(2, 11)] + ['J', 'Q', 'K', 'A'] for y in ["picas", "corazones", "treboles", "picas"]],52)

def jugar(mazo,jugador,casa):
    print "-------------------------------------"
    print mazo
    #print casa
    #print jugador
    print "-------------------------------------"
    if mazo != []:
        return jugar(mazo[2:], jugador + [mazo[0]], casa + [mazo[1]])

jugar(baraja(), [], [])
