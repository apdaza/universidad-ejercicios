'''
Created on Apr 9, 2010

@author: Owner
'''

import pygame
from pygame.locals import Rect, K_ESCAPE, QUIT, KEYDOWN, KEYUP, K_UP, K_DOWN, K_q, K_a

SCREEN_DIMENSIONS = (800, 600)
screen = None
clock = None

paddle1 = None
paddle2 = None
ball = None

class Joystick:
    up = False
    down = False
    
class Ball:
    x = 0
    y = 0
    dx = 0
    dy = 0
    width = 10
    height = 10
    
    def __init__(self, x, y, dx, dy):
        self.x = x
        self.y = y
        self.dx = dx
        self.dy = dy
        
    def top(self):
        return self.y - self.height/2
    
    def left(self):
        return self.x - self.width/2
    
    def update(self, paddle1, paddle2):
        self.x += self.dx
        self.y += self.dy
        
        if paddle1.collides((self.x, self.y)):
            self.dx = -self.dx
        
        if paddle2.collides((self.x, self.y)):
            self.dx = -self.dx
        
        if (self.x < 0):
            self.x = 1
            self.dx = -self.dx
        
        if (self.x > SCREEN_DIMENSIONS[0]):
            self.x = SCREEN_DIMENSIONS[0]-1
            self.dx = -self.dx
        
        if (self.y < 0):
            self.y = 1
            self.dy = -self.dy
        
        if (self.y > SCREEN_DIMENSIONS[1]):
            self.y = SCREEN_DIMENSIONS[1]-1
            self.dy = -self.dy
    
class Paddle:
    x = 0
    y = 0
    dy = 8
    width = 10
    height = 120
    joystick = None
    
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.joystick = Joystick()
        
    def top(self):
        return self.y - self.height/2
    
    def bottom(self):
        return self.y + self.height/2
    
    def left(self):
        return self.x - self.width/2
    
    def right(self):
        return self.x + self.width/2
    
    def moveUp(self):
        self.y -= self.dy
        self.y = max([self.height/2, self.y])
        
    def moveDown(self):
        self.y += self.dy
        self.y = min([self.y, SCREEN_DIMENSIONS[1]-self.height/2])
    
    def collides(self, point):
        return (point[0] >= self.left() and point[0] <= self.right()) and \
               (point[1] >= self.top() and point[1] <= self.bottom())
            

def main():
    global screen
    global clock
    global SCREEN_DIMENSIONS
    
    pygame.init()
    screen = pygame.display.set_mode( SCREEN_DIMENSIONS )
    clock = pygame.time.Clock()
    
    initData()
    
    mainLoop()

def initData():
    global paddle1
    global paddle2
    global ball
    
    paddle1 = Paddle(30, 300)
    paddle2 = Paddle(770, 300)
    ball = Ball(400, 300, 3, 3)

def mainLoop():
    global clock
    
    while True:
        renderScreen()
        readInput()
        updateState()
        clock.tick(60)
        
def renderScreen():
    global screen
    s = screen
    
    s.lock()
    s.fill(0)
    s.fill(0xffffff, Rect(ball.left(), ball.top(), ball.width, ball.height))
    s.fill(0xccccff, Rect(paddle1.left(), paddle1.top(), paddle1.width, paddle1.height))
    s.fill(0xccccff, Rect(paddle2.left(), paddle2.top(), paddle2.width, paddle2.height))
    s.unlock()
    pygame.display.update()

def readInput():
    global paddle1
    global paddle2
    
    for event in pygame.event.get():
        if event.type == QUIT:
            quit()
        elif event.type == KEYDOWN:
            if event.key == K_ESCAPE:
                quit()
            
            if event.key == K_UP:
                paddle2.joystick.up = True
            elif event.key == K_DOWN:
                paddle2.joystick.down = True
            elif event.key == K_q:
                paddle1.joystick.up = True
            elif event.key == K_a:
                paddle1.joystick.down = True
            
        elif event.type == KEYUP:
            if event.key == K_UP:
                paddle2.joystick.up = False
            elif event.key == K_DOWN:
                paddle2.joystick.down = False
            elif event.key == K_q:
                paddle1.joystick.up = False
            elif event.key == K_a:
                paddle1.joystick.down = False
    
def updateState():
    global paddle1
    global paddle2
    global ball
    
    if (paddle1.joystick.up):
        paddle1.moveUp()
    elif (paddle1.joystick.down):
        paddle1.moveDown()
        
    if (paddle2.joystick.up):
        paddle2.moveUp()
    elif (paddle2.joystick.down):
        paddle2.moveDown()
        
    ball.update(paddle1, paddle2)
    
if __name__ == '__main__':
    main()
