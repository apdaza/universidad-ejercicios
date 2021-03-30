from pyswip import Prolog
prolog = Prolog()
prolog.consult('c:/dev/universidad-ejercicios/prolog/familia_simple.pl')

prolog.assertz("father(michael,john)")
prolog.assertz("father(michael,gina)")

for result in prolog.query("father(X,Y)"):
	print(result['X'] + " padre de " + result['Y'])

for result in prolog.query("padrede(X,Y)"):
	print(result['X'] + " padre de " + result['Y'])

print()
for result in prolog.query("hijode(X,Y)"):
	print(result['X'] + " hijo de " + result['Y'])

print()
for result in prolog.query("abuelode(X,Y)"):
	print(result['X'] + " abuelo de " + result['Y'])
	
print()
for result in prolog.query("hermanode(X,Y)"):
	print(result['X'] + " hermano de " + result['Y'])
	
print()

lista = prolog.query("familiarde(X,Y)")
print(lista)
