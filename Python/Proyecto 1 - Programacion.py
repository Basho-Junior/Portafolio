from Tkinter import *
def suma():
	total = int(entrada1.get()) + int(entrada2.get())
	Label(root,text=total).pack()
 
root = Tk()
root.title("Suma")
numero1 = IntVar()
numero2 = IntVar()
entrada1 = Entry(root,textvariable=numero1)
entrada1.pack()
entrada2 = Entry(root,textvariable=numero2)
entrada2.pack()
aceptar = Button(root,text="Sumar",command=suma)
aceptar.pack()
root.mainloop()
