import sys
import functools

args = input().split()
vacas = []
pesos = args[2].split(",")
leches = args[3].split(",")

#constructor para la vaca
class Vaca:
	def __init__(self, peso, leche):
		self.leche = leche
		self.peso = peso
		
	def calculo(self):
		return float(self.leche) / float(self.peso)	

	def __cmp__(self, other):
		if self.calculo() < other.calculo():
			return -1
		elif self.calculo() == other.calculo():
			return 0
		else:
			return 1
		
	
def sel_vacas(limite, transporte, vacas):
	
	transporte_peso = functools.reduce(lambda x,y: x + y.peso, transporte, 0)
	
	for i in reversed(vacas):
		if transporte_peso + i.peso <= limite:
			transporte.append(i)
			vacas.remove(i)
			return sel_vacas(limite, transporte, vacas)
	
		
	for i in reversed(vacas):
		vacas_remover = 0
		peso_liberar = limite - transporte_peso
		for j in reversed(transporte):
			if peso_liberar >= i.peso:
				break
			vacas_remover += 1
			peso_liberar += j.peso
					
		if functools.reduce(lambda x,y: x + y.leche, transporte[-vacas_remover:], 0) < i.leche:
			
			while vacas_remover > 0:
				vacas_remover -= 1
				vacas.append(transporte.pop())
			vacas.remove(i)
			transporte.append(i)
			return sel_vacas(limite, transporte, vacas)
		
	return (transporte, vacas)
	



for j in range(0,int(args[0])):    
        vacas.append(Vaca(int(pesos[j]), int(leches[j])))

print (functools.reduce(lambda x,y: x+y.leche, sel_vacas(int(args[1]), [], vacas)[0], 0))



