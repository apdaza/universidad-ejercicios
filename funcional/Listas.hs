{-
	modulo para trabajar con listas
-}

module Listas where
cuadrado::Int->Int 
cuadrado n = n*n

doblarLista::[Int]
doblarLista = [2*x | x <- [0..10]]

doblarLista2::[Int]->[Int]
doblarLista2 l = [2*x | x <- l]

sumaLista::[Int]->Int
sumaLista [] = 0
sumaLista(x:xs) = x + sumaLista xs

ultimo_elemento::[Int]->Int
ultimo_elemento [x] = x
ultimo_elemento (x:xs) = ultimo_elemento xs

cuadradoLista::[Int]->[Int]
cuadradoLista [] = []
cuadradoLista lista = [x*x | x <- lista]

cuadradoLista2::[Int]->[Int]
cuadradoLista2 [] = []
cuadradoLista2 (y:ys) = y*y : cuadradoLista2 ys

cuadradoLista3::[Int]->[Int]
cuadradoLista3 lista = map cuadrado lista
