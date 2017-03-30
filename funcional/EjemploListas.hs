module EjemploListas where

agregarElemento::a->[a]->[a]
agregarElemento n (x:xs) = (n:x:xs)

encolarElemento::a->[a]->[a]
encolarElemento n [] = [n]
encolarElemento n (x:xs) = agregarElemento x (encolarElemento n (xs))

unirListas::[a]->[a]->[a]
unirListas (x:xs) (b:bs) = (x:xs) ++ (b:bs)

sumaLista::[Int]->Int
sumaLista [] = 0
sumaLista (b:bs) = b + sumaLista (bs)

doblarLista::[Int]->[Int]
doblarLista (x:xs) = [2*x | x <- (x:xs)]



cuentaApariciones::[Int]->Int->Int
cuentaApariciones [] x = 0
cuentaApariciones (b:bs) x = if b == x then 1 + cuentaApariciones (bs) x
                             else cuentaApariciones (bs) x
