module Arboles where

data Arbol a = Nodo a (Arbol a) (Arbol a) | Hoja a | Fin
               deriving Show

a1::Arbol Int
a1 = Nodo 12 (Nodo 8
                (Hoja 4) (Nodo 10
                           (Hoja 9) (Hoja 11)
                         )
             ) 
             (Nodo 25
                (Hoja 17) (Nodo 30
                              (Hoja 28) (Hoja 50)
                          )
             )

buscarEnArbol::Int->Arbol Int->Bool
buscarEnArbol n (Hoja x) = if x == n then True else False
buscarEnArbol n (Nodo x izq der) = if n == x then True
                                   else if n<x then buscarEnArbol n izq
                                   else buscarEnArbol n der  
                                   
contarNodos::Arbol Int->Int
contarNodos Fin = 0
contarNodos (Hoja x) = 0
contarNodos (Nodo x izq der) = 1 + contarNodos izq + contarNodos der

contarHojas::Arbol Int->Int
contarHojas Fin = 0
contarHojas (Hoja x) = 1
contarHojas (Nodo x izq der) = contarHojas izq + contarHojas der                               

contarElementos::Arbol Int->Int
contarElementos Fin = 0
contarElementos (Hoja x) = 1
contarElementos (Nodo x izq der) = 1 + contarElementos izq + contarElementos der

insertarElemento::Int->Arbol Int->Arbol Int
insertarElemento n Fin = (Hoja n)
insertarElemento n (Hoja x) | n<=x = Nodo x (Hoja n) Fin  
                            | n>x = Nodo x Fin (Hoja n)  
insertarElemento n (Nodo x izq der) | n<=x = Nodo x (insertarElemento n izq) der
                                    | n>x = Nodo x izq (insertarElemento n der)

--FUNCION QUE INSERTA UNA LISTA EN UN ARBOL



--FUNCION QUE RECORRE UN ARBOL EN PREORDEN
preOrden::Arbol Int->[Int]
preOrden Fin = []
preOrden (Hoja x) = [x]
preOrden (Nodo x izq der) = [x] ++ preOrden izq ++ preOrden der

posOrden::Arbol Int->[Int]
posOrden Fin = []
posOrden (Hoja x) = [x]
posOrden (Nodo x izq der) = posOrden izq ++ posOrden der ++ [x]

enOrden::Arbol Int->[Int]
enOrden Fin = []
enOrden (Hoja x) = [x]
enOrden (Nodo x izq der) = enOrden izq ++ [x] ++ enOrden der

