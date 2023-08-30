# This is a sample Python script.

# Press Mayús+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

#Fuente: https://stackoverflow.com/questions/115316/how-can-i-consume-a-wsdl-soap-web-service-in-python

from suds.client import Client

# Press the green button in the gutter to run the script.

user = 'ANONIMO'
enlacesAnonimo = []
url = "http://localhost:7000/ws/JABON?wsdl"
cliente = Client(url)

def consultas(cliente):
    menu1 = '\nCLIENTE ACORTADOR EN SOAP\n 1 - LOGIN\n 2- SEGUIR SIENDO ANONIMO \n 3- SALIR'
    res = 0

    while(res != 3):
        print(menu1)
        res = int(input('\n->: '))

        if res > 0 and res < 4:
            if res == 1:
                autentificar(cliente)
            if res == 2:
                masOpciones(cliente)

def autentificar(cliente):
    aux = True
    global user
    while(aux):
        print('\n\n-----LOGIN-----\n')

        us = input('USUARIO-> ')
        pas = input('CONTRASENIA-> ')
        res = cliente.service.autentificacion(us, pas)

        if(res):
            user = us
            masOpciones(cliente)
            return
        else:
            res = int(input('\nINFORMACION INCORRECTA!\n 1 - VOLVER A INTENTAR\n 2 - SER ANONIMO\n -> '))

            if(res < 1 or res > 2):
                print('\nNO EXISTE LA OPCION\n')
            elif(res == 2):
                masOpciones(cliente)
                return

def masOpciones(cliente):
    res = 0
    global user
    global enlacesAnonimo
    while(res != 4):
        res = int(input("\nOPCIONES:\n 1 - ACORTAR ENLACE\n 2 - LISTAR ENLACES\n 3 - VISUALIZAR ENLACE POR ID\n 4 - LOGOUT\n 5 - SALIR\n-> "))

        if(res > 0 and res < 6):
            if(res == 1):
                acortar(cliente)
            if(res == 2):
                listar(cliente)
            if(res == 3):
                mostrar(cliente)
            if(res == 4):
                user = 'ANONIMO'
                enlacesAnonimo = []
            if(res == 5):
                exit()
        else:
            print('\n\nNO EXISTE LA OPCION')

def acortar(cliente):
    url = input('\nURL A ACORTAR-> ')
    res = cliente.service.makeLink(url,user)

    if(res == None):
        print('\nError! Por favor revise la URL')
    else:
        print('\n\n===================RESULTADO===================')
        print("ID: " + str(res.idEnlace))
        print('URL Original: '+  res.URL)
        print('URL Acortada: ' + res.URLAcostarda)
        print('Fecha de creacion: '+ str(res.fecha))
        print('Foto en Base64: '+ res.fotoBase64[0:20]+'...')
        print('===================================================\n\n')

    if user == 'ANONIMO':
        enlacesAnonimo.append(res)

def listar(cliente):
    if user == 'ANONIMO':
        res = enlacesAnonimo
    else:
        res = cliente.service.getLinks(user)

    print('----------------Resultado----------------')

    for enlace in res:
        print("ID: " + str(enlace.idEnlace))
        print('URL Original: '+  enlace.URL)
        print('URL Acortada: ' + enlace.URLAcostarda)
        print('Fecha de creacion: '+ str(enlace.fecha))
        print('Cantidad de veces accedidas: '+ str(enlace.vecesAccesidas))
        print('Foto en Base64: '+ enlace.fotoBase64[0:20]+'...')
        print('----------------')

def mostrar(cliente):
    id = int(input('\nID DEL ENLACE-> '))
    if(id > 0):
        res = cliente.service.getLink(id,user)
        print('\n\n----------------RESULTADO----------------\n')
        print("ID: " + str(res.idEnlace))
        print('URL Original: '+  res.URL)
        print('URL Acortada: ' + res.URLAcostarda)
        print('Fecha de creacion: '+ str(res.fecha))
        print('Cantidad de veces accedidas: '+ str(res.vecesAccesidas))
        print('Foto en Base64: '+ res.fotoBase64[0:20]+'...')
        print('\n----------------STATISTICS----------------\n')

        clientes = cliente.service.getVisitantes(res.idEnlace)
        if res.vecesAccesidas > 0:
            for cliente in clientes:
               print(' IP -> '+cliente.ip + ' Navegador -> ' + cliente.navegador+ ' Sistema -> '+cliente.sistema + ' Fecha -> ' + str(cliente.fecha))
        else:
           print('NO HAY ESTADISTICAS QUE SE PUEDAN VISUALIZAR!')

consultas(cliente)