factorial(0, 1).
factorial(N, F) :- N>0, N1 is N - 1, factorial(N1, F1), F is N * F1.

%%listas
plantas([manzana, naranja, limon, espinaca, gardenia, alfalfa,pino]). 
lista([1,2,3]).

longitud([],0).
longitud([_|T],N):-longitud(T,N0), N is N0 + 1.

pertenece(X,[X|_]) :- !.
pertenece(X,[_|R]):- pertenece(X,R). 

elimina(X,[X|T],T).
elimina(X,[H|T],[H|T1]):- elimina(X,T,T1).

concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]):-concatenar(L1,L2,L3).

inversa([],[]).
inversa([H|T],L):-  inversa(T,R),  concatenar(R,[H],L).


