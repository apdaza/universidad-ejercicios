module Calculadora where

import Basicas



operar::String->Int->Int->Int 
operar s a b
    | s == "suma" = a + b
    | s == "resta" = a - b
    | otherwise = 0
