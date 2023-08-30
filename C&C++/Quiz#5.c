typedef struct{
   char matricula[9], nombre[41];
   int cantcred, cantasig, totalpuntos;
}EST;


a.
EST *est;

est = (EST *) malloc(20 * sizeof(EST));

b.

est = (EST *) realloc(est,40 * sizeof(EST));

c.
EST *estnuevo;

estnuevo = (EST *) malloc(15 * sizeof(EST));

int ind;

for ( ind = 0; ind < 15; ind ++ )
   *(estnuevo+ind) = *(est+ind);
//   estnuevo[ind] = est[ind];

free(est);

est = estnuevo;

free (estnuevo);

int delete(EST *ests, int *n, char *matricula)
{
   int ind, ind2, lmat = strlen(matricula);

   for (ind = 0; ind < n; ind ++ )
      if (strnicmp((ests+ind)->matricula,matricula,lmat) == 0 )
      {
         for ( ind2 = ind; ind2 < n-1; ind2 ++ )
            est[ind2] = est[ind2+1];
         (*n) --;
         return 1;
      }

   return -1;
}













