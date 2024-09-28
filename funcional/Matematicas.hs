{-
  modulo que implementa funciones matematicas simples
  en programacion funcional
-}

module Matematicas where
-- calcula el cuadrado de un numero
cuadrado::Int->Int
cuadrado n = n*n

-- suma dos enteros
suma::Int->Int->Int
suma a b = a + b

--resta dos enteros
resta::Int->Int->Int
resta a b = a - b

--multiplica dos enteros
producto::Int->Int->Int
producto a b = a * b

--divide dos flotantes
division::Float->Float->Float
division a b = if b == 0 then 0.0
               else a/b

--factorial de un numero
factorial::Int->Int
factorial 0 = 1
factorial n = n * factorial(n-1)

-- calcula el termino n de la serie de fibonacci
fibonacci::Int->Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci(n-1)+fibonacci(n-2)

--calcula la potencia de a a la b
potencia::Int->Int->Int
potencia a b
  | b == 0 = 1
  | a == 1 = 1
  | otherwise = a*potencia a (b-1)

--potencia con pseudonimos
potenciaSeudo::Int->Int->Int
potenciaSeudo a 0 = 1
potenciaSeudo 1 b = 1
potenciaSeudo a b = a*potenciaSeudo a (b-1)

potenciaCondicional::Int->Int->Int
potenciaCondicional a b = if b == 0 then 1
                        else if a == 1 then 1
                        else a * potenciaCondicional a (b-1)

--suma los digitos de un numero
sumaDigitos::Int->Int
sumaDigitos n = if n < 10 then n
            else sumaDigitos(div n 10) + mod n 10

--suma los digitos de un numero usando guardas
sumaDigitosGuardas::Int->Int
sumaDigitosGuardas n
        | n < 10 = n
        | otherwise = sumaDigitosGuardas(div n 10) + mod n 10

--convierte de decimal a binario
diezAdos::Int->Int
diezAdos n = if n<2 then n
             else mod n 2 + diezAdos(div n 2) * 10

--convierte de binario a decimal
dosAdiez::Int->Int
dosAdiez n = if n<2 then n
             else mod n 10 + dosAdiez(div n 10) * 2

--genera el siguiente numero del parametros de entrada hasta 9 reiniciando en 1
siguiente::Int->Int
siguiente n = if n < 9 then n+1
              else 1

--genera el siguiente numero del parametros de entrada hasta 9 reiniciando en 1
anterior::Int->Int
anterior n = if n < 1 || n > 9 then 9
             else n-1

--expresión que permite multiplicar sin multiplicar
sinMultiplicar::Int->Int->Int
sinMultiplicar a b 
	| b == 0 = 0
	| b == 1 = a
	| otherwise = a + sinMultiplicar a (b-1)

-- expresión que permite dividir sin dividir
sinDividir::Int->Int->Int 
sinDividir a b
	| b > a = 0
	| otherwise = 1 + sinDividir (a-b) b
