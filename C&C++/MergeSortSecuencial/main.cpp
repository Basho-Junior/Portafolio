//Por Junior Hernandez 20180999
#include <iostream>
#include <algorithm>
#include <vector>
#include <chrono>
#include <ctime>

using namespace std;
using namespace std::chrono;
#define NUM_ELE 100000

void printvec(vector<int> vect);
vector<int> mergeSort(vector<int> avector);

int main()
{
   int tama;
   vector<int> Global;

   tama = NUM_ELE;

   srand(time(0));
   for(int i = 0; i < tama;++i){
      Global.push_back(rand()%NUM_ELE);
   }
   cout << "Mergesort secuencial para " << NUM_ELE << " elementos." << endl;
   auto start = high_resolution_clock::now();
   Global = mergeSort(Global);
   auto stop = high_resolution_clock::now();
   auto duration = duration_cast<microseconds>(stop - start);
   cout << "Tiempo que tomó ordenar " << NUM_ELE << " elementos: " << (double)duration.count() / 1000000.0 << " segundos" << endl;
   return 0;
}

void printvec(vector<int> vect) {
   cout << "[ ";
   for (int i = 0; i < vect.size(); i++)
      cout << vect[i] << ", ";
   cout << "]" << endl;
}

vector<int> mergeSort(vector<int> avector) {
   if (avector.size()>1) {
      int mid = avector.size()/2;

      vector<int> lefthalf(avector.begin(),avector.begin()+mid);
      vector<int> righthalf(avector.begin()+mid,avector.begin()+avector.size());

      lefthalf = mergeSort(lefthalf);
      righthalf = mergeSort(righthalf);

      unsigned i = 0;
      unsigned j = 0;
      unsigned k = 0;
      while (i < lefthalf.size() && j < righthalf.size()) {
         if (lefthalf[i] < righthalf[j]) {
             avector[k]=lefthalf[i];
             i++;
         } else {
             avector[k] = righthalf[j];
             j++;
         }
         k++;
      }

      while (i<lefthalf.size()) {
         avector[k] = lefthalf[i];
         i++;
         k++;
      }

      while (j<righthalf.size()) {
         avector[k]=righthalf[j];
         j++;
         k++;
      }

   }
   return avector;
}

