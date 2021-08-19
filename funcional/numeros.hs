

siguiente :: Num a => a -> a 
siguiente x = x + 1

doble :: Num a => a -> a
doble x = 2 * x

mitad :: Fractional a => a -> a
mitad x = x / 2

inverso :: Fractional a => a -> a
inverso x = 1 / x

potencia_dos :: Num a => a -> a
potencia_dos x = x ^ 2

positivo :: (Ord a, Num a) => a -> Bool
positivo x = x>0

mi_map :: (t -> a) -> [t] -> [a]
mi_map f [] = []
mi_map f (x:xs) = f x : mi_map f xs

mi_map2 :: (t -> a) -> [t] -> [a]
mi_map2 f xs = [f x | x <- xs]

mi_filter :: (a -> Bool) -> [a] -> [a]
mi_filter p [] = []
mi_filter p (x:xs) 
    | p x = x : mi_filter p xs
    | otherwise = mi_filter p xs

mi_filter2 :: (a -> Bool) -> [a] -> [a]
mi_filter2 p xs = [x | x <- xs, p x]

suma :: Num p => [p] -> p
suma [] = 0
suma (x:xs) = x + suma xs

suma2 :: (Foldable t, Num b) => t b -> b
suma2 xs = foldr (+) 0 xs

producto :: Num p => [p] -> p
producto [] = 1
producto (x:xs) = x * producto xs

producto2 :: (Foldable t, Num b) => t b -> b
producto2 xs = foldr (*) 1 xs

incrementar :: Num a => a -> [a] -> [a]
incrementar n [] = []
incrementar n (x:xs) = x + n : incrementar n xs

incrementar2 :: Num a => a -> [a] -> [a]
incrementar2 n xs = [x + n | x <- xs] 

