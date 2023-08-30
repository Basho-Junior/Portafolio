"""Farmacia Hernandez"""
import os#Importamos el comando para imprimir
import sys#Importamos el sistema
from Tkinter import *#Importamos Tkinter que es 
import MySQLdb#Importamos la conexion entre MySQL
from tkMessageBox import *#Importamos la caja de mensaje para que muestre un mensaje cuando hagamos algo en especifico
window = Tk()#creacion de una ventana
window.title ("Farmacia Hernandez")#Titulo para la ventana
window.geometry ("350x150+500+250")#Tamaño para la ventana
Label(window, text = "Usuario:").pack()#Este es para colocar el cuadro para ingresar el usuario
caja1 = Entry(window)#Da entrada a lo que se escribe
caja1.pack()#Muestra y/o Guarda lo que se escribe

Label(window, text = "Contraseña:").pack()
caja2 = Entry(window, show = "*")#Especificamos que queremos al escribir algo se muestre aterisco (*)
caja2.pack()
Label(window, text = "Id:").pack()
caja3 = Entry(window)
caja3.pack()
    
def register(): #Declaramos una funcion para registrar a un usuario
 db_host = 'localhost'#Declaramos y le damos la entrada a el host para la base de datos
 usuario = 'root'#Declaramos el usuario root
 clave = 'junior'#Le colacamos la clave que tenemos en mysql
 base_de_datos = 'Farmacia'#Ponemos el nombre de la base de datos a utilizar
 db = MySQLdb.connect(host=db_host, user=usuario, passwd=clave, db=base_de_datos)#Aqui colocamos ya para que se conecte con toda la informacion que ya ingresamos 
 cursor=db.cursor()#Establecemos el cursor para ejecutar las conduciones que colocamos en Python para MySQL 
 usuario = caja1.get()#Recibe lo que escribimos en usuario
 contr = caja2.get()#Recibe lo que escribimos en contraseña
 try:
     Ide = caja3.get()#Recibe lo que escribimos en id
     sql = "Select * from usuarios Where Cod = %r" %(Ide)#Seleccionamos el id en los usuarios para que estos puedan entrar por medio dle login al programa
     cursor.execute(sql)
     resultados = cursor.fetchall()
     for registro in resultados:#Un for para poder obtener los campos Usuario y Contraseña :V
         Cod = registro[3]
     db.commit()
 except:
     showerror(title = "Registro incorrecto", message = "Id Ya Existe")#Abre una ventana mostrando el error
     
 sql = "Insert into usuarios values (%r, %r, %s)" %(usuario, contr, Ide)#Para el registro creamos un insertar la informacion ingresada en una tabla que guardara los usuarios
 cursor.execute(sql)#Esto es para que se ejecute la consulta :v
 db.commit()#Esto es para que pueda hacer la consulta sin problemas
Button (text = "Registrar", command = register).place(x=10, y=20)#Creamos el boton

def login():#Creamos una funcion para el login
 db_host = 'localhost'
 usuario = 'root'
 clave = 'junior'
 base_de_datos = 'Farmacia'
 db = MySQLdb.connect(host=db_host, user=usuario, passwd=clave, db=base_de_datos)
 cursor=db.cursor()   
 usuario = caja1.get()
 contr = caja2.get()
 Ide = caja3.get()
 sql = "Select * from usuarios Where Cod = %r" %(Ide)#Seleccionamos el id en los usuarios para que estos puedan entrar por medio dle login al programa
 cursor.execute(sql)
 resultados = cursor.fetchall()
 for registro in resultados:#Un for para poder obtener los campos Usuario y Contraseña :V
     Usur = registro[0]#Establece el orden de los registros desde el 0
     Contra = registro[1]
 db.commit()
 try:#Vamos a manejar los errores :D
     if usuario == Usur and contr == Contra:#Si el usuario que ingresamos es igual al usuario de la tabla usuarios y la contraseña igual que la contraseña en la tabla entonces:
       #Creando la ventana
       ventana=Tk()
       ventana.geometry("500x300")
       ventana.title("Menu De la Farmacia")
       a = open("Factura.txt","a")#Creamos Una variable para abrir abir el documento Factura y que este sea una de agregacion ya que la w es de reemplazo, Duh :V
       b = open("Factura.txt","a")
       c = open("Factura.txt","a")
       d = open("Factura.txt","a")
       e = open("Factura.txt","a")
       f = open("Factura.txt","a")
       g = open("Factura.txt","a")
       h = open("Factura.txt","a")
       i = open("Factura.txt","a")
       j = open("Factura.txt","a")
       k = open("Factura.txt","a")
       l = open("Factura.txt","a")
       m = open("Factura.txt","a")
       n = open("Factura.txt","w")

       def acetaminofeno(): #Creamos una funcion para cada medicina
          Cant = input("Ingrese cantidad que va a retirar: ")#Ingresamos la cantidad que quiere el usuario 
          sql = "SELECT * FROM Medicinas WHERE cod_product = 1" #Seleccionamos el codigo del producto 
          cursor.execute(sql)
          resultados = cursor.fetchall()#Utilizamos el cursor fetchal para seleccionar los resultados(lo que tiene) cada campo :v
          for registro in resultados:#Un for para poder obtener los campos 
             Cod_Product = registro[0]#Establece el orden de los registros desde el 0
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant#Multiplica el precio por la cantidad ingresada
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 1") %(Cant)#Le hacemos un update para que la cantidad ingresada se le reste a la cantidad que tiene el alamacen
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:#Una condicion para cantidad que si ya no queda que imprima no queda :v
                 print "No queda"
             else:#Si no realiza la factura
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 a.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))#Escribe esto en el documento txt
                 a.close()#Lo cerramos
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")#Lo llamamos para imprimirlo

       #Creando los botones
       Ejemplo=Button(ventana,text="Acetaminofen",command=acetaminofeno,font={"Agency", }).place(x=10, y=20)

       def aspirinas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 2"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 2") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 b.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 b.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       Ejemplo=Button(ventana,text="Aspirina",command=aspirinas,font={"Agency", }).place(x=130, y=20)

       def Iburo():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 3"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 3") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 c.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 c.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Ibuprofeno",command=Iburo,font={"Agency", }).place(x=211, y=20)

       def Codeinas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 4"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 4") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 d.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 d.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Codeina",command=Codeinas,font={"Agency", }).place(x=309, y=20)

       def ergometrinas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 5"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 5") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 e.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 e.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Ergometrina",command=ergometrinas,font={"Agency", }).place(x=393, y=20)

       def oxitocinas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 6"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 6") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 f.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 f.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Oxitocina",command=oxitocinas,font={"Agency", }).place(x=10, y=60)

       def misoprostolsons():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 7"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 7") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 g.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 g.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Misoprostolson",command=misoprostolsons,font={"Agency", }).place(x=98, y=60)

       def difenhidraminas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 8"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 8") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 h.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 h.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Difenhidramina",command=difenhidraminas,font={"Agency", }).place(x=225, y=60)

       def hidroxicinas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 9"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 9") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 i.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 i.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Hidroxicina",command=hidroxicinas,font={"Agency", }).place(x=350, y=60)

       def prometazinas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 10"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 10") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 j.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 j.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Prometazina",command=prometazinas,font={"Agency", }).place(x=10, y=100)

       def dexametasonas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 11"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 11") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 k.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 k.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Dexametasona",command=dexametasonas,font={"Agency", }).place(x=120, y=100)

       def hidrocortisonas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 12"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 12") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 l.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 l.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Hidrocortisona",command=hidrocortisonas,font={"Agency", }).place(x=248, y=100)

       def epinefrinas():
          Cant = int(input("Ingrese cantidad que va a retirar: "))
          sql = "SELECT * FROM Medicinas WHERE cod_product = 13"
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados:
             Cod_Product = registro[0]
             nombre = registro[1]
             cantidad = registro[2]
             precio = registro[3]
             precio2 = precio * Cant
             sql = ("UPDATE Medicinas SET Cantidad = Cantidad - %r WHERE cod_product = 13") %(Cant)
             cursor.execute(sql)
             db.commit()
             if cantidad == 0:
                 print "No queda"
             else:
                 print "-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio)
                 m.write("-----------------------------Farmacia Hernandez-------------------------------- \nCodigo del producto: %s \n\nNombre del producto: %s \n\nCantidad de producto: %d \n\nPrecio del producto: %d" % (Cod_Product, nombre, Cant, precio))
                 m.close()
                 os.startfile("C:\Users\junio\Desktop\Factura.txt","print")
             
       #Creando los botones
       Ejemplo=Button(ventana,text="Epinefrina",command=epinefrinas,font={"Agency", }).place(x=373, y=100)

          
       def Informes():#Funcion para crear un informe de lo vendido
          sql = "SELECT * FROM inforn"#Seleccionamos inforn una tabla que esta conectada con un trigger a la de productos
          cursor.execute(sql)
          resultados = cursor.fetchall()
          for registro in resultados: 
              cod_product = registro[0]
              nombre = registro[1]
              cantidad = registro[2]
              precio = registro[3]
              print "Codigo: %s, Usted Vendio: %s, Le queda: %s, El Precio: %s" %(cod_product, nombre, cantidad, precio)#Imprime y Reemplaza los valores
              
           
       Ejemplo=Button(ventana,text="Informe",command=Informes,font={"Agency", }).place(x=400, y=200)
       import sys

       def restart():#Funcion para cerrar y reiniciar el programa
        
           python = sys.executable#Lo llamamos para ejecutarlo
           os.execl(python, python, * sys.argv)#Realiza la accion
              
           
       Ejemplo=Button(ventana,text="Reiniciar",command=restart,font={"Agency", }).place(x=200, y=200)

       
       def suma():
               total = int(entrada1.get()) + int(entrada2.get())#Aqui coje de entrada dos numeros para sumarlos
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
       
           
       window.withdraw()
       


       ventana.mainloop()
   

     else:
      showerror(title = "Login incorrecto", message = "Usuario o contraseña incorrecta")

   
 except UnboundLocalError:
     showerror(title = "Login incorrecto", message = "Usuario o contraseña incorrecta")
     
Button (text = "Login", command = login).pack()
 
window.mainloop()
