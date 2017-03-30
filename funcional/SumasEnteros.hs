getInt :: IO Int
getInt = do line <- getLine
            return (read line :: Int)

escribir::String->IO ()
escribir m= do putStr m
               putStr "\n"

sumInts :: IO Int
sumInts
  = do escribir "ingrese un entero: "
       n <- getInt
       if n==0 
          then return 0
       else (do m <- sumInts
                return (n+m))
