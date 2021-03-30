module Deck 
  ( Card
  , possiblePoints
  , Deck
  , DeckS
  , cards
  , gen
  , mkDeck
  , draw
  , shuffle
  , takeRandomCard
  , takeCardAt ) where

import System.Random
import Control.Monad.State

-- |The 'Card' data type represents the possible playing card ranks.
data Card = Ace
          | Two
          | Three
          | Four
          | Five
          | Six
          | Seven
          | Eight
          | Nine
          | Ten
          | Jack
          | Queen
          | King
          deriving (Enum, Show)

-- |'possiblePoints' calculates all possible scores for a given hand.
possiblePoints :: [Card] -> [Int]
possiblePoints = go [0]
  where go n []           = n
        go ns (Ace:rest)   = go (map ((+) 1) ns ++ map ((+) 11) ns) rest
        go ns (Two:rest)   = go (map ((+) 2) ns) rest
        go ns (Three:rest) = go (map ((+) 3) ns) rest
        go ns (Four:rest)  = go (map ((+) 4) ns) rest
        go ns (Five:rest)  = go (map ((+) 5) ns) rest
        go ns (Six:rest)   = go (map ((+) 6) ns) rest
        go ns (Seven:rest) = go (map ((+) 7) ns) rest
        go ns (Eight:rest) = go (map ((+) 8) ns) rest
        go ns (Nine:rest)  = go (map ((+) 9) ns) rest
        go ns (Ten:rest)   = go (map ((+) 10) ns) rest
        go ns (Jack:rest)  = go (map ((+) 10) ns) rest
        go ns (Queen:rest) = go (map ((+) 10) ns) rest
        go ns (King:rest)  = go (map ((+) 10) ns) rest

-- |The 'Deck' data type represents a deck of cards that can be shuffled.
data Deck = Deck
  { cards :: [Card]
  , gen :: StdGen }
  deriving (Show)

-- |'mkDeck' will construct a 52-card deck.
mkDeck :: StdGen -> Deck
mkDeck g = 
  Deck { cards = [ card | card <- [Ace ..], _ <- [1..4] :: [Int] ]
       , gen = g }

-- |The 'DeckS' is the current state of the 'Deck'.
type DeckS a = State Deck a

-- |'draw' will take one card off the top of the deck.
draw :: DeckS Card
draw = takeCardAt 0

-- |'shuffle' takes a 52-card deck and randomly shuffles its elements.
shuffle :: DeckS ()
shuffle = do
  curr <- get
  shuffled <- replicateM 52 takeRandomCard
  put curr { cards = shuffled }

-- |'takeRandomCard' will pick one random card from the deck and remove it.
-- It is a helper-function used by 'shuffle'.
takeRandomCard :: DeckS Card
takeRandomCard = do
  curr <- get
  let n = length $ cards curr
      (i, gen') = randomR (0, n) $ gen curr
  card <- takeCardAt i
  put curr { gen = gen' }
  return card

-- |'takeCardAt' will pick the card at the given index and remove it from the
-- deck.
takeCardAt :: Int -> DeckS Card
takeCardAt i = do
  curr <- get
  let (cards', cards'') = splitAt (i + 1) $ cards curr
      card              = last cards'
      newCards          = init cards' ++ cards''
  put curr { cards = newCards }
  return card