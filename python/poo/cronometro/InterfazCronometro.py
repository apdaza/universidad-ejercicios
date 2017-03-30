from tkinter import *
from threading import *
from time import sleep
from Cronometro import *

class InterfaceCronometros(Thread):

    def __init__(self):
        self.root = Tk()
        self.crono = Cronometro()
        self.crono.cambiarEstado()
        self.frame = Frame(self.root)
        self.frame.pack()

        self.cadena = StringVar()
        self.display = Entry(self.frame, textvariable=self.cadena)
        self.display.pack(side=TOP,padx=10,pady=10)

        self.buttonIniciar = Button(self.frame, text="Iniciar/Parar")
        self.buttonIniciar.bind("<Button-1>", self.cambio)
        self.buttonIniciar.pack(side=LEFT)


        self.buttonBorrar = Button(self.frame, text="Borrar")
        self.buttonBorrar.bind("<Button-1>", self.borrar)
        self.buttonBorrar.pack(side=RIGHT)

        Thread.__init__(self)
        self.start()
        
        self.root.mainloop()



    def cambio(self, event):
        self.crono.cambiarEstado()

    def borrar(self, event):
        self.crono.borrar()

    def run(self):
        while True:
            if not self.crono.parado:
                self.crono.avanzar()
            sleep(0.5)
            self.cadena.set(self.crono.getTiempo())

    def callback(self):
        self.root.quit()


app = InterfaceCronometros()

