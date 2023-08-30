salida = ""
entrada = input()
ACantidad = 0
Scantidad = 0

ACantidad = int(entrada)
while ACantidad > 0:
    abdicados = []
    String = input()
    ANombres = list(String.split(" "))
    for i in range (0, ACantidad):
        abdicados.append(ANombres[i])
    entrada2 = input() 
    Scantidad = int(entrada2)
    String2 = input()
    SNombres = list(String2.split(" "))

    for i in range (0, Scantidad):
        sucesor = SNombres[i]
        num = 1
        for ele in abdicados:
            if ele == sucesor:
                num = num + 1
        abdicados.append(sucesor)
        salida = salida + str(num) + "\n"

    salida = salida + "\n";
    entras = input()
    ACantidad = int(entras)

print(salida)

