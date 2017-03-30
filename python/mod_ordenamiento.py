def burbuja(list):
	"""Este metodo de ordenacion consiste en recorrer los elementos 
	siempre en la misma direccion, intercambiando elementos adyacentes 
	si fuera necesario"""
	for n in range(len(list)):
		for m in range(n,len(list)):
			if list[n] > list[m]:
				intercambiar(list,n,m)

def seleccion(list):
	"""este metodo busca el minimo elemento del subvector a[i..n] 
	y lo intercambia con el elemento en la posicion i: """
	for n in range(len(list)):
		m=busca_posicion_menor(list,n,len(list))
		intercambiar(list,n,m)
	
def insercion(list):
	"""busca el menor elemento en la lista y lo va insertando en
	la posicion correcta"""
	for n in range(len(list)):
		m=busca_posicion_menor(list,n,len(list))
		insertar(list,m,n)

def insertar(list,x,y):
	"""inserta un elemento de la posicion x en la posicion y 
	y lo elimina de su posicion original"""
	list.insert(y,list[x])
	del(list[x+1])	
	
"""def hacer_pivote(list):
	p=int(len(list)/2)
	for n in range(p):
		if list[n]>list[p]:
			insertar(list,p,n)
			p-=1
	print list
"""
def intercambiar(list,x,y):
	"""permite intercambiar los elementos de las posiciones 
	x , y de la lista"""
	temp = list[x]
	list[x] = list[y]
	list[y] = temp
	
def busca_posicion_menor(list, i, f):
	"""busca la posicion del menor elemento de la lista entre las 
	posiciones i y f"""
	menor = list[i]
	pos_menor = i
	for n in range(i,f):
		if list[n] < menor:
			menor = list[n]
			pos_menor = n
	return pos_menor
