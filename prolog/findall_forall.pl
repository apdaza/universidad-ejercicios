ayudante(naty).
ayudante(toby).
ayudante(lucho).

ropaDeCasa(overall).
ropaDeCasa(pijama).
ropaDeCasa(remeraDeLaJuve).
ropaDeNoche(vestido).
ropaDeNoche(camisitaFloreada).
ropaDeNoche(shortBrilloso).
ropaDeOficina(corbata).
ropaDeOficina(saco).
ropaDeOficina(polleraLarga).

usa(lucho, camisitaFloreada).
usa(naty, remeraDeLaJuve).
usa(naty, shortBrilloso).
usa(toby,camisitaFloreada).
usa(toby, pijama).

compro(naty,shortBrilloso,2014).
compro(toby,camisitaFloreada,2013).

precio(shortBrilloso,300).
precio(camisitaFloreada,500).
precio(remeraDeLaJuve,700).

esNochero(P):- usa(P,_), forall(usa(P,Ropa), ropaDeNoche(Ropa)).
estaALaModa(P):- ayudante(P), forall(compro(P,Ropa,_),(comproEn2013(P,Ropa),cuestaMasDe300(Ropa))).
comproEn2013(Alguien,Prenda):- compro(Alguien,Prenda,2013).
cuestaMasDe300(Prenda):- precio(Prenda,Precio), Precio > 300.
cuantoCompro(Alguien,Cant):- ayudante(Alguien),	findall(Ropa,(compro(Alguien,Ropa,_), ropaDeNoche(Ropa)),Lista), length(Lista,Cant).
