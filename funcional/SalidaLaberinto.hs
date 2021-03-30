module SalidaLaberinto where

data Direccion = Norte | Este | Sur | Oeste deriving Show

data Arbol a = Nodo a (Arbol a) (Arbol a) |
               Hoja a |
               Fin
               deriving Show


move :: Direccion -> (Int,Int) -> (Int,Int)
move Norte (x,y) = (x,y-1)
move Este (x,y) = (x+1,y)
move Sur (x,y) = (x,y+1)
move Oeste (x,y) = (x-1,y)
