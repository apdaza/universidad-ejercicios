evalNum::Int->Int
evalNum a 
	| a > 0 = 1
	| a < 0 = -1
	| otherwise = 0

posNeg::Int->String
posNeg a 
	| a >= 0 = "positivo"
	| otherwise = "negativo"

multiplos::Int->Int->Bool
multiplos a b = mod a b == 0

sumaCuadrados::[Int]->Int
sumaCuadrados [] = 0
sumaCuadrados (x:xs) = x*x + sumaCuadrados (xs)

sumaImpares::[Int]->Int
sumaImpares [] = 0
sumaImpares (x:xs) 
	| even x = sumaImpares (xs)
	| otherwise = x + sumaImpares (xs)

sumaMultiplos::[Int]->Int->Int
sumaMultiplos l1 a = sum [x | x<-l1, multiplos x a]

factorial::Int->Int
factorial 0 = 1
factorial 1 = 1
factorial n = n * factorial (n-1)

combinatoria::Int->Int->Int
combinatoria n k = div (factorial n) (factorial k * factorial(n - k))

factoriales::Int->[Int]
factoriales n = [factorial x | x<-[0..n]]

multiplicarLista::[Int]->Int->[Int]
multiplicarLista l1 n = [x*(l1!!n) | x <-l1]

listarDiferentes::[Int]->[Int]->[Int]
listarDiferentes l1 l2 = [x | x<-l1, notElem x l2]++[y | y<-l2, notElem y l1]

compararListas::[Int]->[Int]->String
compararListas l1 l2 = if length (listarDiferentes l1 l2) > 2 then "Diferentes"
					   else if length (listarDiferentes l1 l2) == 0 then "Iguales"
					   else "Casi Iguales"

