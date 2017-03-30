import System.Random

aleatorio n = randomRIO (0, n)

escribir::String->IO ()
escribir m= do putStr m
               putStr "\n"

getInt :: IO Int
getInt = do line <- getLine
            return (read line :: Int)
                
foo :: Int -> Int
foo x = x+1

comparar::Int -> IO ()
comparar x
  = do escribir "ingrese un entero: "
       n <- getInt
       if n==x then escribir "adivinaste"
       else 
          if n < x then (do 
                         escribir "quedaste corto "
                         comparar x)
          else (do escribir "te sobraste "
                   comparar x)

juego :: IO ()
juego = do
 x <- randomRIO (1,100) 
 comparar (foo x)
