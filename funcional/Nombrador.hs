module Nombrador where

saludo:: IO()
saludo = putStr "Ingrese su nombre:\n" >>
	 getLine >>= \variable ->
	 putStr("Hola " ++ variable ++ "\n")