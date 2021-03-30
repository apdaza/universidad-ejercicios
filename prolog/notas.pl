calificacion(juan,5).
calificacion(ana,3).
calificacion(maria,2).
calificacion(diana,4).
calificacion(miguel,3).
calificacion(jose,1.5).
calificacion(juan,1).
calificacion(pedro,0.5).
calificacion(palomino,1).

nota(X,Y):-
	X < 2 -> Y = perdido; 
	X < 3.5 -> Y = suspenso;
	X < 4.5 -> Y = aprobado;
	true -> Y = sobresaliente.

enperdida(X):-calificacion(X,Z),nota(Z,W),W=perdido.
ensuspenso(X):-calificacion(X,Z),nota(Z,W),W=suspenso.
enaprobado(X):-calificacion(X,Z),nota(Z,W),W=aprobado.
ensobresaliente(X):-calificacion(X,Z),nota(Z,W),W=sobresaliente.

listaperdidas(L):-findall(X,enperdida(X),L).
listasuspenso(L):-findall(X,ensuspenso(X),L).
listaaprobados(L):-findall(X,enaprobado(X),L).
listasobresalientes(L):-findall(X,ensobresaliente(X),L).

notasperdidas(L):-findall(X,(calificacion(_,X),nota(X,perdido)),L).
notassuspenso(L):-findall(X,(calificacion(_,X),nota(X,suspenso)),L).
notasaprobados(L):-findall(X,(calificacion(_,X),nota(X,aprobado)),L).
notassobresalientes(L):-findall(X,(calificacion(_,X),nota(X,sobresaliente)),L).

suma([],0).
suma([X|Y],R):- suma(Y, R1), R is R1 + X.

long([],0).
long([_|Y],R):- long(Y, R1), R is R1 + 1.

promedioperdidas(R):-notasperdidas(L1), suma(L1,S),long(L1,T),R is S/T.
promediosuspenso(R):-notassuspenso(L1), suma(L1,S),long(L1,T),R is S/T.
promedioaprobados(R):-notasaprobados(L1), suma(L1,S),long(L1,T),R is S/T.
promediosobresalientes(R):-notassobresalientes(L1), suma(L1,S),long(L1,T),R is S/T.
