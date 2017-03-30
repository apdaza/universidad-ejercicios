
module Cartas where

import System.Random

data Suit = Club | Diamond | Heart | Spade deriving (Read, Show, Enum, Eq, Ord)

data Color = Red | Black deriving (Read, Show, Enum, Eq, Ord) 

data CardValue = Two | Three | Four | Five | Six | Seven | Eight | Nine | Ten 
     | Jack | Queen | King | Ace deriving (Read,  Show, Enum, Eq, Ord)

data Card = Card {value :: CardValue, suit :: Suit} deriving (Read, Show, Eq)
    
type Deck = [Card]
 
--retorna un mazo
deck::Deck
deck = [Card val su | val <- [Two .. Ace], su <- [Club .. Spade]]

--retorna el color de una carta
card_color::Card->Color
card_color Card {value = _, suit = Club} = Black
card_color Card {value = _, suit = Spade} = Black
card_color Card {value = _, suit = Diamond} = Red
card_color Card {value = _, suit = Heart} = Red

--retorna el valor de una carta
card_value::Card->Int
card_value Card {value = Ace, suit = _} = 11
card_value Card {value = Two, suit = _} = 2
card_value Card {value = Three, suit = _} = 3
card_value Card {value = Four, suit = _} = 4
card_value Card {value = Five, suit = _} = 5
card_value Card {value = Six, suit = _} = 6
card_value Card {value = Seven, suit = _} = 7
card_value Card {value = Eight, suit = _} = 8
card_value Card {value = Nine, suit = _} = 9
card_value Card {value = _, suit = _} = 10

--verifica si un mazo es del mismo color
all_same_color::[Card]->Bool
all_same_color [] = True
all_same_color [_] = True
all_same_color (x:y:xs) = card_color x == card_color y && all_same_color (y:xs)

--verifica si la carta es un ace
an_ace::Card->Bool
an_ace Card {value = Ace, suit = _} = True
an_ace Card {value = _, suit = _} = False

has_an_ace::[Card]->Bool
has_an_ace [] = False
has_an_ace (x:xs) = an_ace x || has_an_ace xs

--suma los puntos de un mazo
score::[Card]->Int
score [] = 0
score (x:xs) = if not (has_an_ace xs) then
	              card_value x + score xs
	           else
	           	  if an_ace x then
	           	  	1 + score xs
	           	  else
	           	  	card_value x + score xs

mix_decks::[Card]->[Card]->[Card]
mix_decks cards1 [] = cards1 
mix_decks [] cards2 = cards2
mix_decks (x:xs) (y:ys) = x:y:(mix_decks xs ys)

mix_deck::[Card]->[Card]
mix_deck [] = []
mix_deck (x:y:xs) = [x] ++ mix_deck(xs) ++ [y]

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


jugar::[Card]->[Card]->[Card]->IO ()
jugar mazo mano1 mano2 
	= do 
		let x = randomRIO (1,(length mazo))
		let y = randomRIO (1,(length mazo))
		foo x