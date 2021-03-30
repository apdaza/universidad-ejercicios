module EjercicioDivisores where

divisor::Int->Int->Bool
divisor a b = (mod a b) == 0 

divisores::Int->[Bool]
divisores a = map divisor a [1..9]
