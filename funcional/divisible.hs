divisibleNueve::Int->Bool
divisibleNueve a = if mod a 9 == 0 then True
                   else False

divisibleOcho::Int->Bool
divisibleOcho a = if mod a 8 == 0 then True
                   else False

divisibleSiete::Int->Bool
divisibleSiete a = if mod a 7 == 0 then True
                   else False

divisibleSeis::Int->Bool
divisibleSeis a = if mod a 6 == 0 then True
                   else False

divisibleCinco::Int->Bool
divisibleCinco a = if mod a 5 == 0 then True
                   else False

divisibleCuatro::Int->Bool
divisibleCuatro a = if mod a 4 == 0 then True
                   else False

divisibleTres::Int->Bool
divisibleTres a = if mod a 3 == 0 then True
                   else False

divisibleDos::Int->Bool
divisibleDos a = if mod a 2 == 0 then True
                   else False

divisible::Int->String
divisible n = if divisibleNueve then "Es divisible por 9"
              else if divisibleOcho then "Es divisible por 8"
              else if divisibleSiete then "Es divisible por 7"
              else if divisibleSeis then "Es divisible por 6"
              else if divisibleCinco then "Es divisible por 5"
              else if divisibleCuatro then "Es divisible por 4"
              else if divisibleTres then "Es divisible por 3"
              else if divisibleDos then "Es divisible por 2"
              else "divisible por 1"

