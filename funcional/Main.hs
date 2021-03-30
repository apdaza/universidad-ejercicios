module Main where

import Deck

import Data.List
import System.Random
import Control.Monad.State

-- |'main' is the entry point for the program. This function will bind a
-- random number generator and pass it into a new 'Game' state. Finally, it will
-- evaluate the 'gameLoop'.
main :: IO ()
main = do
  stdGen <- getStdGen
  evalStateT gameLoop $ mkGame stdGen hitUnlessTwentyOne

-- |The 'Game' data type contains all of the state information about a
-- blackjack game.
data Game = Game
  { deck :: Deck
  , playerHand :: [Card]
  , playerAction :: Action
  , dealerHand :: [Card]
  , dealerAction :: Action
  , dealerStrategy :: Strategy }

-- |The 'GameS' type represents the current state of the 'Game'.
type GameS a = StateT Game a

-- |The 'Action' data type represents the possible actions a player can take.
data Action = Hit | Stay deriving (Eq, Read)

-- |The 'Strategy' type is the signature of all AI functions used by the dealer.
type Strategy = [Card] -> GameS IO (Action)

-- |'gameLoop' will repeatedly evaluate an iteration of the game. It updates the
-- game state based on the actions of the player and the dealer, and then
-- determines if the game is over.
gameLoop :: GameS IO ()
gameLoop = do
  curr <- get
  when ((playerAction curr) == Hit) handlePlayer
  when ((dealerAction curr) == Hit) handleDealer
  gameOver <- isGameOver
  when gameOver handleGameOver
  when (not gameOver) gameLoop

handlePlayer :: GameS IO ()
handlePlayer = do
  curr <- get
  input <- liftIO $ do
    let playerH = playerHand curr
    putStrLn $ "Your hand: " ++ (show playerH)
    putStrLn $ "Dealer's hand: " ++ (showDealer $ dealerHand curr)
    putStrLn "What do you want to do? (Hit/Stay)"
    input <- getLine
    return input

  let action = read input :: Action
  when (action == Hit) $ do
    let (card, deck') = runState draw $ deck curr
    put curr { deck = deck'
             , playerHand = card : playerHand curr }
    new <- get
    let playerH = playerHand new
    liftIO . putStrLn $ "Your hand: " ++ (showDealer playerH)

  when (action == Stay) $ do
    put curr { playerAction = Stay }

handleDealer :: GameS IO ()
handleDealer = do
  curr <- get
  action <- dealerStrategy curr $ dealerHand curr
  when (action == Hit) $ do
    let (card, deck') = runState draw $ deck curr
    put curr { deck = deck'
             , dealerHand = card : dealerHand curr }
    new <- get
    let dealerH = dealerHand new
    liftIO . putStrLn $ "The dealer hit."
    liftIO . putStrLn $ "Dealer's hand: " ++ (showDealer dealerH)

  when (action == Stay) $ do
    put curr { dealerAction = Stay }
    liftIO . putStrLn $ "The dealer stayed."

isGameOver :: GameS IO Bool
isGameOver = do
  curr <- get
  let playerA    = playerAction curr
      dealerA    = dealerAction curr
      playerH    = playerHand curr
      dealerH    = dealerHand curr
      bothStayed = (playerA == Stay && dealerA == Stay)
      playerBust = bust playerH
      dealerBust = bust dealerH
      gameOver = bothStayed || playerBust || dealerBust

  when playerBust $ liftIO . putStrLn $ "You busted out!"
  when dealerBust $ liftIO . putStrLn $ "The dealer busted out!"

  return gameOver

handleGameOver :: GameS IO ()
handleGameOver = do
  curr <- get
  let playerH = playerHand curr
      dealerH = dealerHand curr
      winner  = won playerH dealerH
  liftIO . putStrLn $ "Your hand: " ++ (show playerH) ++ ", " ++ (show (possiblePoints playerH))
  liftIO . putStrLn $ "Dealer's hand: " ++ (show dealerH) ++ ", " ++ (show (possiblePoints dealerH))
  when winner $ liftIO . putStrLn $ "You win!"
  when (not winner) $ liftIO . putStrLn $ "You lose..."

won :: [Card] -> [Card] -> Bool
won playerH dealerH = playerScore > dealerScore
  where playerScore = score playerH
        dealerScore = score dealerH

score :: [Card] -> Int
score h 
  | bust h    = 0
  | otherwise = best h

bust :: [Card] -> Bool
bust = and . map ((<) 21) . possiblePoints

twentyOne :: [Card] -> Bool
twentyOne = any ((==) 21) . possiblePoints

best :: [Card] -> Int
best = maximum . filter ((>=) 21) . possiblePoints

showDealer :: [Card] -> String
showDealer hand = "[" ++ (show $ head hand) ++ "," ++ (intersperse ',' hidden) ++ "]"
  where n = length $ tail hand
        hidden = replicate n '?'

mkGame :: StdGen -> Strategy -> Game
mkGame g strat = Game
  { deck = d' 
  , playerHand = playerH
  , playerAction = Hit
  , dealerHand = dealerH
  , dealerAction = Hit
  , dealerStrategy = strat }
  where d = execState shuffle $ mkDeck g
        ((playerH, dealerH), d') = runState deal $ d

deal :: DeckS ([Card], [Card])
deal = do
  mine   <- draw
  yours  <- draw
  mine'  <- draw
  yours' <- draw
  let me = [mine, mine']
      you = [yours, yours']
  return (me, you)

hitUnlessTwentyOne :: Strategy
hitUnlessTwentyOne hand
  | twentyOne hand = return Stay
  | otherwise      = return Hit

hitSometimes :: Double -> Strategy
hitSometimes threshold _ = do
  curr <- get
  let deck' = deck curr
      (num, gen') = random $ gen deck'
  put curr { deck = deck' { gen = gen' } }
  if num > threshold
    then return Hit
    else return Stay
