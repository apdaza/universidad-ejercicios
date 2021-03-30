from random import shuffle

def baraja():
    return [(x,y) for x in ['A','2','3','4','5','6','7','8','9','J','Q','K'] for y in ['Diamantes','Picas','Treboles','Corazones']]


def mazo(baraja):
    shuffle(baraja)
    return baraja

def valor_carta(carta):
    if carta[0] in ['J','Q','K']:
        return 10
    elif carta[0] == 'A':
        return 1
    else:
        return int(carta[0])

def evaluar(mano):
    if mano == []:
        return 0
    else:
        return valor_carta(mano[0])+evaluar(mano[1:])

def jugar(mazo, mesa, jugador):
    if mazo == []:
        print "Mesa:____________________________________"
        print evaluar(mesa)
        print ""
        print "Jugador:____________________________________"
        print evaluar(jugador)
        print ""
    else:
        print "Mesa:____________________________________"
        print mesa 
        print evaluar(mesa)
        print ""
        print "Jugador:____________________________________"
        print jugador
        print evaluar(jugador)
        print ""
        if (len(jugador) < 2 and len(mesa) < 2):
            jugar(mazo[2:], mesa + [mazo[0]], jugador + [mazo[1]])
        elif ((evaluar(jugador) < 18 or evaluar(jugador) <= evaluar(mesa)) and evaluar(mesa) <= 21):
		    jugar(mazo[1:], mesa, jugador + [mazo[0]])
        elif (evaluar(mesa) < evaluar(jugador) and evaluar(mesa) < 21 and evaluar(jugador) <= 21):
		    jugar(mazo[1:], mesa + [mazo[0]], jugador)
        #jugar(mazo[2:], mesa + [mazo[0]], jugador + [mazo[1]])

jugar(mazo(baraja()), [], [])
