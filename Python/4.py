adn1, adn2 = input().split()
bases = ""
#ctgactga actgagc
#cgtaattgcgat cgtacagtagc

for i in range (len(adn1), 0, -1):
    #print(i)
    for j in range (0, i):
        if (adn1[j:i] in adn2) and len(bases) < len(adn1[j:i]):
            bases = adn1[j:i]     
            
print(bases)        

