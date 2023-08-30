def cuadrado_magico(num):
    lista=[[0 for i in range(num)]for i in range(num)]
    lista[0][num//2]=1
    
    posicion_x=0
    posicion_y=num//2
    
    for i in range(2,num**2+1):
        if posicion_x-1<0:
            posicion_x=num-1
        else:
            posicion_x-=1
        if posicion_y+1==num:
            posicion_y=0
        else:
            posicion_y+=1
        while 1:
            if lista[posicion_x][posicion_y]==0:
                lista[posicion_x][posicion_y]=i
                break
            else:
                for l in range(num):
                    for n in range(num):
                        if lista[l][n]==i-1:
                            posant_x=l
                            posant_y=n
                
                posicion_x=posant_x+1
                posicion_y=posant_y
      
                if posicion_x>num-1:
                    posicion_x=0

    for i in lista:
        print(i)

num = int(input())
cuadrado_magico(num)

