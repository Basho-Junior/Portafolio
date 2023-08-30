float promedio(float [ ], int);
float desvstand(float [ ],int);
float mayor(float [ ], int);
float menor(float [ ], int);
float bono(float,float,float);
void sumabono(float [],int);


int main()
{

   float arr[5] = {15.75,18.80,82.39,1.2}, result;

   result = promedio(arr,5);
   result = desvstand(arr,5);

}


float bono(float val, float prom, float stdev)
{
   float valbono;

   if (val > prom )
   {
      valbono = 100 - val - stdev;
   }
   else
   {
      valbono = 60 - prom + stdev;
   }

   return valbono;
}


void sumabono(float cal[],int n)
{
   float prom = promedio(cal,n),
         stdev = desvstand(cal,n);

   int ind;

   for ( ind = 0; ind < n; ind ++ )
   {
      cal[ind] += bono(cal[ind],prom,stdev);

      if ( cal[ind] > 100 )
         cal[ind] = 100;
   }

   return;
}
