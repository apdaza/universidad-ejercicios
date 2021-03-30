sumaDigitos::Int->Int
sumaDigitos n = if n < 10 then if mod n 2 == 0 then n else 0
                else if mod (mod n 10) 2 == 0 then sumaDigitos(div n 10) + (mod n 10)
                else sumaDigitos(div n 10)

numeroLista::Int->[Int]
numeroLista n 
    | n < 10 = [n]
    | otherwise = numeroLista (div n 10) ++ [mod n 10]

listaNumero::[Int]->Int
listaNumero [] = 0
listaNumero (x:xs) = x + (listaNumero xs) * 10

invertirLista::[Int]->[Int]
invertirLista [] = []
invertirLista (x:xs) = invertirLista xs ++ [x]

listaNumero2::[Int]->Int
listaNumero2 lista = listaNumero (invertirLista lista)

menor::[Int]->Int
menor [n] = n
menor (x:y:xs) = if x < y then menor (x:xs) else menor (y:xs)

menoresLista::[[Int]]->[Int]
menoresLista lista = [menor x | x <- lista]

sumaLista::[Int]->Int
sumaLista [] = 0
sumaLista (x:xs) = x + sumaLista xs

cantidadLista::[Int]->Int
cantidadLista [] = 0
cantidadLista (x:xs) = 1 + cantidadLista xs

cubo::[[[Int]]]->[[(Int,Int,Int,Int)]]
cubo lista = [[(minimum x, maximum x, sumaLista x, cantidadLista x) | x <- sublista] | sublista <- lista]
