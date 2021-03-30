--01. Calcula el producto usando sumas recursivas
producto::Int->Int->Int
producto n 1 = n
producto n m = n + producto n (m - 1)

--02. Calcula la division usando restas recursivas
division::Int->Int->Int
division n m 
    | n < m = 0
    | otherwise = (division (n - m) m) + 1

--03. Calcula la potencia de forma recursiva
potencia::Int->Int->Int
potencia n 1 = n
potencia n m = n * potencia n (m - 1)

--04. Calcula factorial de forma recursiva
factorial::Int->Int
factorial 0 = 1
factorial n = n * factorial (n -1)

--05. Calcula el termino n de la serie de fibonacci de forma recursiva
fibonacci::Int->Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci(n-1)+fibonacci(n-2)

--06. Suma los digitos de un numero de forma recursiva
suma_digitos::Int->Int
suma_digitos n 
	| n < 10 = n 
	| otherwise = suma_digitos(div n 10) + mod n 10
	    
--07. Calcula la longitud de un numero de forma recursiva
cuenta_digitos::Int->Int
cuenta_digitos n 
	| n < 10 = 1 
	| otherwise = cuenta_digitos(div n 10) + 1

--08. Invierte un numero de forma recursiva
invertir_digitos::Int->Int
invertir_digitos n 
	| n < 10 = n 
	| otherwise = (mod n 10) * (potencia 10 (cuenta_digitos (div n 10))) + invertir_digitos (div n 10) 


--09. Combierte un numero de base 10 a base 2 de forma recursiva
diez_dos::Int->Int
diez_dos n 
	| n<2 = n
	| otherwise = mod n 2 + diez_dos(div n 2) * 10

--10. Combierte un numero de base 2 a base 10 de forma recursiva
dos_diez::Int->Int
dos_diez n 
	| n<2 = n
	| otherwise = mod n 10 + dos_diez(div n 10) * 2
	     
--11. Cuenta los elementos de una lista
cuenta_elementos::[Int]->Int
cuenta_elementos [] = 0
cuenta_elementos (x:xs) = 1 + cuenta_elementos xs

--12. Suma los elementos de una lista
suma_elementos::[Int]->Int
suma_elementos [] = 0
suma_elementos (x:xs) = x + suma_elementos xs

--13. Suma los elementos de las pocisiones pares de una lista
suma_elementos_pares::[Int]->Int
suma_elementos_pares [] = 0
suma_elementos_pares [x] = x
suma_elementos_pares (x:y:xs) = x + suma_elementos_pares xs

--14 quita los elementos de las posiciones pares de la lista
quitar_pares::[Int]->[Int]
quitar_pares [] = []
quitar_pares [x] = []
quitar_pares (x:y:xs) = y : quitar_pares xs

--15 promedio de los elemntos de posiciones impares
promedio_impares::[Int]->Int
promedio_impares lista = div (suma_elementos (quitar_pares lista)) (cuenta_elementos (quitar_pares lista))

--16 elevar al cuadrado los elementos de una lista
cuadrado::[Int]->[Int]
cuadrado lista = [x*x | x <- lista]

--17 mayor de cada lista
mayor::[Int]->Int
mayor [x] = x
mayor (x:y:ys) 
    | x >= y = mayor (x:ys)
    | otherwise = mayor (y:ys)

mayores::[[Int]]->[Int]
mayores lista = [mayor x | x <- lista]

