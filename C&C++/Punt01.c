#include <stdio.h>
#include <stdlib.h>

void swap(int *, int *);

int main()
{
   int a, b;

   printf("Ingrese a:");
   scanf("%d",&a);

   printf("Ingrese b:");
   scanf("%d",&b);

   printf("a = %d y b = %d\n",a,b);
   swap(&a,&b);
   printf("a = %d y b = %d\n",a,b);

   return 0;
}


void swap(int *a, int *b)
{
   int temp;

   temp = *a, *a = *b, *b = temp;

   return;
}
