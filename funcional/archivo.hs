leer::String -> IO [String]
leer fileName = do x <- readFile fileName 
                return (words(show x))


main :: IO ()
main = do
  n <- countSpacesInFile "input.txt"
  print n
                
