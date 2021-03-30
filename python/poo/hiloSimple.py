from threading import Thread

class MiHilo(Thread):
   def run(self):
	   while True:
		   print(1)
...
# Arranque del hilo
hilo = MiHilo()
hilo.start()
