#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void divide(int*, int);
void sort_merge(int*, int*, int, int);

int main()
{
	int size;
	clock_t t0;
	double elapsed;
	
	printf("\nEnter the Size of the Array:");
	scanf("%d", &size);
	
	int array[size];
	
	for(int i=0;i<size;i++)
	{
		printf("\nEnter the Element %d:", i);
		scanf("%d", &array[i]);

		//array[i]=rand();			//For Large Scale Experiments
	}	
	
	t0=clock();						//Time Watch

	divide(array,size);				//[0][1][2]|[3][4][5][6]
	
	t0=clock()-t0;					//Time Watch
	
	printf("\nThe Sorted Array is:-\n");
	
	for(int i=0;i<size;i++)
	{
		printf("\nElement %d:%d", i,array[i]);
	}
	
	elapsed = (((double)t0)/CLOCKS_PER_SEC)*1000000; //uSec
	
	printf("\n\nTime Elapsed:%f microseconds", elapsed);
	
	getch();
	return 0;
}

void divide(int* array, int size)		//Divide the array in half
{	
	if(size!=1)
	{
		int hSize=size/2;
		int dtSize=sizeof(int);
		int* pt1=array;
		int* pt2=(array+(size/2));
		int size1,size2;
		
		if(size%2==0)
		{
			size1=size/2;
			size2=size/2;
		}
		else
		{
			size1=size/2;
			size2=(size/2)+1;
		}
	
		divide(pt1,size1);
		divide(pt2,size2);
		
		sort_merge(pt1,pt2,size1,size2);
	}
}

void sort_merge(int* a, int* b, int sizeA, int sizeB)		//Merge the divided array
{
	int totalSize=sizeA+sizeB;
	int array[totalSize];
	int cntA=0,cntB=0,i=0;
	
	while(i<(totalSize))
	{
		if(cntA==sizeA)
		{
			array[i]=b[cntB];
			cntB++;
		}
		else if(cntB==sizeB)
		{
			array[i]=a[cntA];
			cntA++;
		}
		else
		{
			if(a[cntA]<=b[cntB])
			{
				array[i]=a[cntA];
				cntA++;
			}
			else
			{
				array[i]=b[cntB];
				cntB++;
			}
		}
		
		i++;
	}
	
	for(int j=0;j<totalSize;j++)
	{
		a[j]=array[j];
	}
}

