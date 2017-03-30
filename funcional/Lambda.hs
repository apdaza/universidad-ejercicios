{- ejemplos de expresiones lambda y 
   currificacion en haskell
-}

module Lambda where

-- funcion que retorna una lista
lista::[Int]
lista = [2..25]

-- funcion que usa una expresion lambda para calcular el cuadrado
cuadrado = \x -> x*x


-- aplicacion de currificacion y expresiones lambda
incrementador = \n -> \x -> x + n

suma2 = incrementador 2
suma3 = incrementador 3

impares = filter (\x -> (mod x 2) /= 0) lista
pares = filter (\x -> (mod x 2) == 0) lista

suma = map (+4) lista
