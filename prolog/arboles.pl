a=a( +, a( *, 3, 9 ), a( /, a( -, 1, a( *,4,8 ) ), a(^,7,2) ) ).

inord( a(OP,HI,HD) ):- write('('),inord(HI),write(OP),inord(HD),write(')').
inord(X):-write(X).
