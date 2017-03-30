partido( local( nombre( 'America' ), ciudad('Cali') ), visitante( nombre('Tolima'), ciudad('Tolima') ), glocal(10), gvisit(0) ).
partido( local( nombre( 'Nacional' ), ciudad('Medellin') ), visitante( nombre('Equidad'), ciudad('Bogotá') ), glocal(1), gvisit(2) ).

ganacasa(X,Y,Z,V):-partido(local(nombre(X),ciudad(Y)),_,glocal(Z),gvisit(V)), Z>V.
