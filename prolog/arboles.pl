#a=a( +, a( *, 3, 9 ), a( /, a( -, 1, a( *,4,8 ) ), a(^,7,2) ) ).

inord( a(OP,HI,HD) ):- write('('),inord(HI),write(OP),inord(HD),write(')').
inord(X):-write(X).

posord( a(OP,HI,HD) ):-posord(HI),write(' '),posord(HD),write(' '),write(OP).
posord(X):-write(X).

preord( a(OP,HI,HD) ):-write(OP),write(' '),preord(HI),write(' '),preord(HD).
preord(X):-write(X).