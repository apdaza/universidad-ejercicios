potencia::Int->Int->Int
potencia a b
| b ==0 = 1
| a ==1 = 1
| otherwise = a * potencia a (b-1)
