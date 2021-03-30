conecta(inicio, 2).
conecta(1, 7).
conecta(2, 3).
conecta(2, 8).
conecta(3, 4).
conecta(3, 9).
conecta(4, 10).
conecta(5, 6).
conecta(5, 11).
conecta(7, 13).
conecta(8, 9).
conecta(10, 16).
conecta(11, 17).
conecta(12, 18).
conecta(13, 14).
conecta(14, 15).
conecta(14, fin).
conecta(16, 22).
conecta(22, 21).
conecta(21, 15).


conectado(Pos1,Pos2) :- conecta(Pos1,Pos2).
conectado(Pos1,Pos2) :- conecta(Pos2,Pos1).

miembro(X,[X|_]).
miembro(X,[_|Y]) :- miembro(X,Y) .

sol :- camino([inicio],Sol),write(Sol) .

camino([fin|RestoDelCamino],[fin|RestoDelCamino]).
camino([PosActual|RestoDelCamino],Sol) :- conectado(PosActual,PosSiguiente),\+ miembro(PosSiguiente,RestoDelCamino),
					   camino([PosSiguiente,PosActual|RestoDelCamino],Sol).
