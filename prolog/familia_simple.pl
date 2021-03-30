padrede('victor','alejandro').
padrede('victor','nicolay').
padrede('victor','ada').
padrede('victor','andrey').
padrede('victor','angelo').
padrede('victor','jonathan').
padrede('carmen','alejandro').
padrede('carmen','nicolay').
padrede('carmen','ada').
padrede('carmen','andrey').
padrede('carmen','angelo').
padrede('carmen','jonathan').
padrede('alejandro','paola').
padrede('alejandro','diego').
padrede('marcela','paola').
padrede('marcela','diego').
padrede('ada','isabella').
padrede('ada','victoria').
padrede('jose','isabella').
padrede('jose','victoria').
padrede('angelo','josue').
padrede('angelo','marcelo').
padrede('yanine','josue').
padrede('yanine','marcelo').
padrede('jonathan','leonardo').
padrede('deyo','leonardo').
padrede('ana','guillermo').
padrede('ana','alejo').
padrede('ana','juan').
padrede('ana','patricia').
padrede('ana','mauricio').
padrede('ana','marcela').
padrede('guillermo','luis').
padrede('angeles','luis').
padrede('juan','laura').
padrede('juan','angela').
padrede('juan','sebastian').
padrede('helena','laura').
padrede('helena','angela').
padrede('yesika','sebastian').
padrede('mauricio','andres').
padrede('mauricio','nicolas').
padrede('mauricio','paula').
padrede('andrea','andres').
padrede('janeth','nicolas').
padrede('janeth','paula').

hombre('victor').
hombre('alejandro').
hombre('nicolay').
hombre('andrey').
hombre('angelo').
hombre('jonathan').
hombre('diego').
hombre('jose').
hombre('marcelo').
hombre('leonardo').
hombre('guillermo').
hombre('alejo').
hombre('juan').
hombre('mauricio').
hombre('luis').
hombre('sebastian').
hombre('sebastian').
hombre('andres').
hombre('nicolas').
hombre('nicolas').

mujer('carmen').
mujer('paola').
mujer('yanine').
mujer('deyo').
mujer('marcela').
mujer('isabella').
mujer('victoria').
mujer('ana').
mujer('patricia').
mujer('angeles').
mujer('laura').
mujer('angela').
mujer('helena').
mujer('laura').
mujer('angela').
mujer('yesika').
mujer('paula').
mujer('andrea').
mujer('janeth').
mujer('paula').
mujer('ada').

hijode(A,B) :- padrede(B,A),hombre(A).
hijade(A,B) :- padrede(B,A),mujer(A).

madrede(A,B) :- padrede(A,B), mujer(A).

abuelode(A,B) :- padrede(A,C), padrede(C,B), hombre(A).
abuelade(A,B) :- padrede(A,C), padrede(C,B), mujer(A).

hermanode(A,B) :- padrede(C,A), padrede(C,B), A \== B.

hermanos(X,L) :- findall(Y,hermanode(X,Y),L).
