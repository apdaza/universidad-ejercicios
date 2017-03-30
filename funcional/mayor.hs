module Ejercicios where
--mayor de varios numeros
mayor::Int->Int->Int->Int
mayor a b c = if ((a > b) && (a > c)) then a
              else if ((b > a) && (b > c)) then b
              else c

---meses del año
mes::Int->String
mes 1 = "Enero"
mes 2 = "Febrero"
mes 3 = "Marzo"
mes 4 = "Abril"
mes 5 = "Mayo"
mes 6 = "Jinuo"
mes 7 = "Julio"
mes 8 = "Agosto"
mes 9 = "Septiembre"
mes 10 = "Octubre"
mes 11 = "Noviembre"
mes 12 = "Diciembre" 
mes n = "Mes no valido"


