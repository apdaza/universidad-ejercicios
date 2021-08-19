cuadrado :: Num a => a -> a
cuadrado x = x*x

suma_de_cuadrados :: [Int] -> Int
suma_de_cuadrados l = sum (map cuadrado l)

convertir::[String]->[Int]
convertir lista = [read x :: Int | x <- lista]



main :: IO ()
main = do
  cadena <- getLine
  print (suma_de_cuadrados (convertir (words cadena)))
