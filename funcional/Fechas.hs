module Fechas where

divisible::Int->Int->Bool
divisible a b = mod a b == 0

bisiesto::Int->Bool
bisiesto a = divisible a 4 && (not(divisible a 100) || divisible a 400)

meses::Int->[Int]
meses a = [31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
          where feb | bisiesto a = 29
                    | otherwise = 28

numeroDia::Int->Int->Int->Int
numeroDia d m a = rem ( (a-1)*365 
                  + div (a-1) 4 
                  - div (a-1) 100 
                  + div (a-1) 400
                  + sum (take (m-1) (meses a))
                  + d
                  ) 7

diaSemana::Int->String
diaSemana 0 = "Domingo"
diaSemana 1 = "Lunes"
diaSemana 2 = "Martes"
diaSemana 3 = "Miercoles"
diaSemana 4 = "Jueves"
diaSemana 5 = "Viernes"
diaSemana 6 = "Sabado"

dia::Int->Int->Int->String
dia d m a = diaSemana (numeroDia d m a)
                 
