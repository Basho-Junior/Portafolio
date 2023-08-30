def divisoresMenores(num):
    cantDivisores = 0
    for i in range (1, num):
        if num%i == 0:
            cantDivisores = cantDivisores + 1

    return cantDivisores

def esPrimo(num):
    return divisoresMenores(num) == 1


def reversa(s):
    Reverse = 0
    Number = int(s)
    while(Number > 0):
        Reminder = Number %10
        Reverse = (Reverse *10) + Reminder
        Number = Number //10 

    return str(Reverse)
        

def esPalindromo(num):
    s = str(num)
    return s == reversa(s)
    
num = int(input())

while not(esPalindromo(num) and (esPrimo(num))):
    num = num + 1

print(num)
