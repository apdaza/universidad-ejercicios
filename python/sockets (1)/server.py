'''
Created on 20/02/2009
@author: Chuidiang


Ejemplo de socket en python. Un servidor que acepta clientes.
Si el cliente envia "hola", el servidor contesta "pues hola".
Si el cliente envia "adios", el servidor contesta "pues adios" y
cierra la conexion.
El servidor no acepta multiples clientes simultaneamente.
'''

import socket
from threading import Thread


#Clase con el hilo para atender a los clientes.
#En el constructor recibe el socket con el cliente y los datos del
#cliente para escribir por pantalla
class Cliente(Thread):
    def __init__(self, server, socket_cliente, datos_cliente):
        Thread.__init__(self)
        self.server = server
        self.socket = socket_cliente
        self.datos = datos_cliente

    def send_msg(self, msg):
        self.socket.send(msg)

    # Bucle para atender al cliente.
    def run(self):
      # Bucle indefinido hasta que el cliente envie "adios"
      seguir = True
      while seguir:
         # Espera por datos
         peticion = self.socket.recv(1024)

         # Contestacion a "hola"
         if ("hola"==peticion):
             print str(self.datos)+ " envia hola: contesto"
             self.socket.send("pues hola")

         # Contestacion y cierre a "adios"
         elif ("adios"==peticion):
             print str(self.datos)+ " envia adios: contesto y desconecto"
             self.socket.send("pues adios")
             self.socket.close()
             print "desconectado "+str(self.datos)
             seguir = False
         if ("cerrar" == peticion):
             print "ok..."
             self.server.shutdown(socket.SHUT_RDWR)
             break
         else:
            print str(self.datos)+ " envia otra cosa: y no me importa"
            self.socket.send("y a mi que")




if __name__ == '__main__':
   # Se prepara el servidor
   server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
   server.bind(("", 8094))
   server.listen(1)
   print "Esperando clientes..."

   # bucle para atender clientes
   while 1:

      # Se espera a un cliente
      socket_cliente, datos_cliente = server.accept()

      # Se escribe su informacion
      print "conectado "+str(datos_cliente)

      # Se crea la clase con el hilo y se arranca.
      hilo = Cliente(server, socket_cliente, datos_cliente)
      hilo.start()
