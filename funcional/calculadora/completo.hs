module Main where

suma::Int->Int->Int
suma a b = a + b

resta::Int->Int->Int
resta a b = a - b

producto::Int->Int->Int
producto a b = a * b

division::Int->Int->Int
division a b = div a b

convertir::[String]->[Int]
convertir lista = [read x :: Int | x <- lista]

operar::String->Int->Int->Int
operar op x y
    | op == "sumar" = suma x y
    | op == "restar" = resta x y
    | op == "multiplicar" = producto x y
    | op == "dividir" = division x y
    | otherwise = 0

main :: IO ()
main = do
  op <- getLine
  n1 <- getLine
  n2 <- getLine
  cadena <- getLine
  print (convertir (words cadena))
  putStrLn (show (operar op (read n1 :: Int) (read n2 :: Int)))

