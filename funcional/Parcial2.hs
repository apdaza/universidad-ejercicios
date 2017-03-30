module Parcial2 where

sumaListaDoble::[Int]->Int
sumaListaDoble [] = 0
sumaListaDoble (x:xs) = 2*x + sumaListaDoble (xs)

cuentaElementos::[Int]->Int
cuentaElementos [] = 0
cuentaElementos (x:xs) = 1 + cuentaElementos (xs)

cuentaUnElemento::[Int]->Int->Int
cuentaUnElemento [] n = 0
cuentaUnElemento (x:xs) = if n==x then 1 + cuentaUnElemento (xs)
                          else cuentaUnElemento (xs)
                          

promedio::[Int]->Int
promedio (x:xs) = div (sumaListaDoble (x:xs)) (cuentaElementos (x:xs))
