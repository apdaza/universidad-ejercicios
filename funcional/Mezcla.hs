module Mezcla where

data IntOrChar = Ent Int | Car Char
                 deriving (Show)
                 
xs :: [IntOrChar]
xs = [ Ent 1, Car 'a', Ent 2, Ent 3 ]
