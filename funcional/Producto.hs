suma::Int->Int->Int
suma a b = a+b

producto::Int->Int->Int
producto a 0 = 0
producto a 1 = a
producto a b = suma a (producto a (b-1))

dividir::Int->Int->Int
dividir a b = if b > a then 0
                  else 1 + (dividir (a-b) b) 
