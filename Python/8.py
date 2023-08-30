global numero
global reina

reina = [None] * 8 
numero = 0

CAPACIDAD = 8

def mesa():
    global numero
    x=y=0
    numero+=1
    print('')
    print ('Solución para el problema de las ocho reinas número: %d \t' %numero)
    for x in range(CAPACIDAD):
        for y in range(CAPACIDAD):
            if x==reina[y]:
                print('<♔>',end='')
            else:
                print('<->',end='')
        print('\t')
        
 
 
def ataque(fila,columna):
    global reina
    i=0
    ataq=0
    offset_fila=offset_columna=0
    while (ataq!=1)and i<columna:
        offset_columna=abs(i-columna)
        offset_fila=abs(reina[i]-fila)
                
        if reina[i]==fila or offset_fila==offset_columna:
            ataq=1
        i=i+1
    return ataq
 
def posicion(val):
    global reina
    i=0
    while i<CAPACIDAD:
        if ataque(i,val)!=1:
            reina[val]=i
            if val==7:
                mesa()
            else:
                posicion(val+1)
        i=i+1
 

posicion(0)
