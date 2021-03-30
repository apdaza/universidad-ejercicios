from Tkinter import *


class MyApp:
    def __init__(self, parent):
        self.myParent = parent
        self.myContainer1 = Frame(parent)
        self.myContainer1.pack()

        self.button1 = Button(self.myContainer1)
        self.button1.configure(text="OK", background="green")
        self.button1.pack(side=LEFT)
        self.button1.bind("<Button-1>", self.funcion1)

        self.button2 = Button(self.myContainer1)
        self.button2.configure(text="Cancel", background="red")
        self.button2.pack(side=RIGHT)
        self.button2.bind("<Button-1>", self.funcion2)

    def funcion1(self, event):
        if self.button1["background"] == "green":
            self.button1["background"] = "yellow"
        else:
            self.button1["background"] = "green"

    def funcion2(self, event):
        self.myParent.destroy()

root = Tk()
myapp = MyApp(root)
root.mainloop()