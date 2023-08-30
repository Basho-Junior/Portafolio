num = int(input())
cantSegmentos = 0
def reloj(H, M, S):
    Tiempo = ""
    if H < 10:
        Tiempo = Tiempo + '0'
    Tiempo = Tiempo + str(H)
    if M < 10:
        Tiempo = Tiempo + '0'
    Tiempo = Tiempo + str(M)
    if S < 10:
        Tiempo = Tiempo + '0'
    Tiempo = Tiempo + str(S)
    return Tiempo

for i in range(0, num + 1):
    Horas = int(i / 3600)
    Segundos = i % 3600
    Minutos = int(Segundos / 60)
    Segundos = i % 60
    Tiempo = reloj(Horas, Minutos, Segundos)
    for j in Tiempo:
        if j == '0' or j == '6' or j == '9':
            cantSegmentos = cantSegmentos + 6
        if j == '1':
            cantSegmentos = cantSegmentos + 2
        if j == '2' or j == '3' or j == '5':
            cantSegmentos = cantSegmentos + 5
        if j == '4':
            cantSegmentos = cantSegmentos + 4
        if j == '7':
            cantSegmentos = cantSegmentos + 3
        if j == '8':
            cantSegmentos = cantSegmentos + 7

print(cantSegmentos)
