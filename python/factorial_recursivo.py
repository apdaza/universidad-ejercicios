def getFactorial(n):
	"""returns the factorial of n"""
	if n == 0:
		return 1
	else:
		k = n * getFactorial(n-1)
		return k
 
for k in range(1, 70):
	print "factorial of", k,"=", getFactorial(k)
