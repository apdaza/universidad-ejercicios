longitud([],0).
longitud([_|T], N):-longitud(T,N0),N is N0 + 1.

pertenece(X,[X|_]):-!.
pertenece(X,[_|T]):-pertenece(X, T).

elimina(X,[X|T],T).
elimina(X,[H|T],[H|T1]):-elimina(X,T,T1).

concatenar([],L,L).
concatenar([X|T],L,[X|T1]):-concatenar(T,L,T1).

inversa([],[]).
inversa([H|T],L):-inversa(T,R),concatenar(R,[H],L).