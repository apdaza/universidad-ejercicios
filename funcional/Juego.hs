module Juego where

juego :: Int-> IO ()
juego clave = do limpiarPantalla
                 n <-pedirNum"Quénúmero he pensado?"
                 jugar clave n

limpiarPantalla:: IO ()
limpiarPantalla= putStr['\n' | x<-[1..30]]

pedirNum:: String-> IO Int
pedirNum msg = do putStrLn msg
                  s <-getLine
                  return(reads)

jugar :: Int-> Int-> IO ()
jugar clave n = do if n == clave 
                   then do putStrLn("Lo adivinaste era "++ show n) 
                   else 
                        do putStrLn("No lo adivinaste era "++ show n) 
                   {--if clave < n 
                        then do n'<-pedirNum("Mi número es menor que "++ show n) jugar clave n'
                        else do n'<-pedirNum("Mi número es mayor que "++ show n) jugar clave n'
                   --}
