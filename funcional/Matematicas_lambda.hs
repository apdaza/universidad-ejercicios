module Matematicas_lambda where

suma = (\x y -> x + y)
resta = (\x y -> x - y)
cuadrado = (\x -> x*x)

doble :: Int -> Int
doble x = x * 2

sumaDoble :: Int -> Int -> Int
sumaDoble x y = doble (suma x y)

sumaDoble2 :: Int -> Int -> Int
sumaDoble2 x = doble . suma x
