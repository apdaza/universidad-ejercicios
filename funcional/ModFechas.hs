module ModFechas where

type Fecha = (Int,Int,Int)

bisiesto::Int->Bool
bisiesto a = divisible a 4 && (not(divisible a 100) || divisible a 400)

siguiente::Fecha->Fecha
siguiente (x,y,z) = (x+1,y,z)

validar::Fecha->Bool
validar (d,m,a) = if m > 31 then False
                  else 
