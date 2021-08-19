fact :: Int -> Int
fact n
  | n == 0 = 1
  | otherwise = n * fact (n-1)

convertir::[String]->[Int]
convertir lista = [read x :: Int | x <- lista]


main :: IO ()
main = do
  cadena <- getLine
  print (map fact (convertir (words cadena)))
