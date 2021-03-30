import smtplib
 
sender = "ingsistemas@gudistrital.edu.co"
receiver = "apdaza@gmail.com"
 
msg =  "From: %s\n" % sender
msg += "To: %s\n" % receiver
msg += "Subject: pruebas\n\n"
msg += "vamos a enviar un test."
 
#server = smtplib.SMTP('fenix.udistrital.edu.co')
server = smtplib.SMTP('localhost')
server.sendmail(sender, receiver, msg)
server.quit()
#mail.udistrital.edu.co 110
#fenix.udistrital.edu.co
