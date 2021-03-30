module TextoPredictivo where

data Arbol a = Vacio | Hoja a | Nodo a [Arbol a]
               deriving Show

a1::Arbol String
a1 = Nodo "" [a_a, a_c, a_e]
   where 
   a_a = Nodo "a" [a_ad, a_al, a_an]
       where
       a_ad = Nodo "ad" [a_ade, a_ado, a_adr]
	    where
	    a_ade = Nodo "ade" [Hoja "adelina", Hoja "adelaida"]
	    a_ado = Nodo "ado" [Hoja "adolfo", Hoja "adonai"]
	    a_adr = Nodo "adr" [Hoja "adrian", Hoja "adriana"]
       a_al = Nodo "al" [a_ale, a_ali]
	    where
	    a_ale = Nodo "ale" [Hoja "alejandro", Hoja "alejandra"]
	    a_ali = Nodo "ali" [Hoja "alicia", Hoja "alina"]
       a_an = Nodo "an" [a_ana, a_and]
	    where
	    a_ana = Nodo "ana" [Hoja "ana", Hoja "anastacia", Hoja "anacleto"]
	    a_and = Nodo "and" [Hoja "andres", Hoja "andrea", Hoja "andy"]
   a_c = Nodo "c" [a_ca, a_co, a_cl]
       where
       a_ca = Nodo "ca" [a_cam,a_car, a_cas]
	    where
	    a_cam = Nodo "cam" [Hoja "camilo", Hoja "camila"]
	    a_car = Nodo "car" [Hoja "carola", Hoja "carolina"]
	    a_cas = Nodo "cas" [Hoja "casilda", Hoja "casimiro"]
       a_co = Nodo "co" [a_con, a_cor]
	    where
	    a_con = Nodo "con" [Hoja "concepcion", Hoja "constantino"]
	    a_cor = Nodo "cor" [Hoja "cordelia", Hoja "coral"]
       a_cl = Nodo "cl" [a_cla,a_cle]
	    where
	    a_cla = Nodo "cla" [Hoja "clara", Hoja "claudia", Hoja "claudio"]
	    a_cle = Nodo "cle" [Hoja "clemente", Hoja "cleopatra"]
   a_e = Nodo "e" [a_el, a_em, a_eu]
       where
       a_el = Nodo "el" [a_ele,a_eli, a_elo]
	    where
	    a_ele = Nodo "ele" [Hoja "elena", Hoja "eleonor"]
	    a_eli = Nodo "eli" [Hoja "eliza", Hoja "elizabeth"]
	    a_elo = Nodo "elo" [Hoja "eloisa", Hoja "eloy"]
       a_em = Nodo "em" [a_ema, a_emi]
	    where
	    a_ema = Nodo "ema" [Hoja "ema", Hoja "emanuel"]
	    a_emi = Nodo "emi" [Hoja "emilio", Hoja "emilia"]
       a_eu = Nodo "eu" [a_eud,a_euf, a_eul]
	    where
	    a_eud = Nodo "eud" [Hoja "eudosia", Hoja "eudoxio", Hoja "euclides"]
	    a_euf = Nodo "euf" [Hoja "eufemio", Hoja "eufracio"]
	    a_eul = Nodo "eul" [Hoja "eulalio", Hoja "eulalia"]


buscarArbol::String->Arbol String->[String]
buscarArbol s Vacio = []
buscarArbol s (Hoja n) = if n == s then [n]
                         else []
buscarArbol s (Nodo n xs) = if n == s then concat(map extraerHojas xs) 
							else concat(map (buscarArbol s) xs)

extraerHojas::Arbol String->[String]
extraerHojas Vacio = []
extraerHojas (Hoja n) = [n]
extraerHojas (Nodo n xs) = [n]++concat(map extraerHojas xs)
