module ArbolesN where

data ArbolN a = Nodo a [ArbolN a] deriving Show

a1::ArbolN Int
a1 = Nodo 2 [ Nodo 4 [Nodo 12 [], Nodo 24 [], Nodo 40 []], Nodo 8 [Nodo 16 [], Nodo 32 []], Nodo 5 [Nodo 25 [], Nodo 50 []]]

buscarEnArbol::Int->ArbolN Int->Bool
buscarEnArbol n (Nodo x []) = if x == n then True else False
buscarEnArbol n (Nodo x (y:ys)) = if n == x then True
                                  else buscarEnArbol n y || buscarEnArbol2 n ys
buscarEnArbol2 n [] = False
buscarEnArbol2 n (y:ys) = buscarEnArbol n y || buscarEnArbol2 n ys
