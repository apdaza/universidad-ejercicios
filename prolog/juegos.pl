ganados( juan, 7 ).
ganados( susana, 6 ).
ganados( pedro, 2 ).
ganados( rosa, 5 ).
jugados( rosa, 10 ).
jugados( juan, 13 ).
jugados( pedro, 3 ).
jugados( susana, 7 ).

porcentaje( X,Y ):- ganados( X,Z ),jugados( X,Q ),Y is ( Z/Q )*100.
