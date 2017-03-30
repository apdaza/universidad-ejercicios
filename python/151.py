cant = -1
while cant !=0:
	cant = int(raw_input())
	if cant!=0:
		estaciones = range(1,cant+1)
		copia = estaciones[:]
		inc = 1
		while True:
			x = 0
			while len(copia)>1:
				del(copia[x])
				for n in range(inc-1):
					if x < len(copia)-1:
						x+=1
					else:
						x = x-(len(copia)-1)
			if copia[0] == 13 or inc >= cant:
				break
			else:
				copia = estaciones[:]
				inc+=1
		print inc


