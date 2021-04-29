module Calculadora where

import Basicas

operar::String->Int->Int->Int
operar op x y
    | op == "sumar" = suma x y
    | op == "restar" = resta x y
    | op == "multiplicar" = producto x y
    | op == "dividir" = division x y
    | otherwise = 0

operarLista::String->[Int]->Int
operarLista op lista = if op == "sumar" then
                            if lista == [] then 0
                            else suma (head lista) (operarLista op (tail (lista)))
                       else if op == "restar" then
                            if lista == [] then 0
                            else resta (head lista) (operarLista op (tail (lista)))
                       else if op == "multiplicar" then
                            if lista == [] then 1
                            else producto (head lista) (operarLista op (tail (lista)))
                       else if op == "dividir" then
                            if lista == [] then 1
                            else division (head lista) (operarLista op (tail (lista)))
                       else 0

operarListaGuardas::String->[Int]->Int
operarListaGuardas op lista
    | (op, lista) == ("sumar", []) = 0
    | op == "sumar" = suma (head lista) (operarListaGuardas op (tail (lista)))
    | (op, lista) == ("restar", []) = 0
    | op == "restar" = resta (head lista) (operarListaGuardas op (tail (lista)))
    | (op, lista) == ("multiplicar", []) = 1
    | op == "multiplicar" = producto (head lista) (operarListaGuardas op (tail (lista)))
    | (op, lista) == ("dividir", []) = 1
    | op == "dividir" = division (head lista) (operarListaGuardas op (tail (lista)))
    | otherwise = 0                       