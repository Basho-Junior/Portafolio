# This is a sample Python script.

# Press Mayús+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

#Fuente: https://stackoverflow.com/questions/115316/how-can-i-consume-a-wsdl-soap-web-service-in-python

from suds.client import Client

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print("Cliente")
    url = "http://localhost:7000/ws/EstudianteWebServices?wsdl"
    cliente = Client(url)
    decision = 0
    while decision != 4:
        print('--BIENVENIDO AL PROGRAMA DE PRUEBA CON SOAP--')
        print('1 - LISTAR')
        print('2 - CONSULTAR')
        print('3 - CREAR')
        print('4 - BORRAR')
        decision = int(input('QUE DESE HACER?(INGRESAR NUMERO)-> '))

        if decision == 1:
            estudiante = cliente.service.getListaEstudiante()
            print(str(estudiante))

        elif decision == 2:
            matricula = int(input('MATRICULA DEL ESTUDIANTE-> '))
            estudiante = cliente.service.getEstudiante(matricula)
            print(estudiante)

        elif decision == 3:
            matricula = int(input('MATRICULA-> '))
            nombre = input('NOMBRE-> ')
            carrera = input('CARRERA-> ')
            estudiante = cliente.factory.create('estudiante')
            estudiante.matricula = matricula
            estudiante.nombre = nombre
            estudiante.carrera = carrera
            cliente.service.crearEstudiante(estudiante)
            print('ESTUDIANTE CREADO CON EXITO')

        elif decision == 4:
            matricula = int(input('MATRICULA DEL ESTUDIANTE-> '))
            #El metodo no existe en EstudianteWebService pero si en fakeservices no lo esta llamando
            # PD: RECORDARLE AL PROFESOR
            cliente.service.eliminandoEstudiante(matricula)
            print('ESTUDIANTE BORRADO CON EXITO')

        else:
            print('LA OPCION COMO CLARITA ES INVALIDA!')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
