sumaDigitos::Int->Int
sumaDigitos n = if n < 10 then n else sumaDigitos(div n 10) + mod(n 10)
