producto::[Int]->[Int]
producto l1 = [x * 10 | x <- l1]


listaAcumular::[Int]->Int
listaAcumular [] = 0
listaAcumular l1 = last l1 + listaAcumular (producto(init l1))

numToList::Int->[Int]
numToList a = if a < 10 then [a] else
			  [mod a 10] ++ numToList (div a 10)

invertir::Int->Int
invertir a = listaAcumular(numToList a)

invertirLista::[Int]->[Int]
invertirLista l1 = map invertir l1
