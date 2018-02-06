#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

//Quicksort is Divide and Conquer Method
//Reference:- https://www.youtube.com/watch?v=y_G9BkAm6B8

int partition(int*, int, int);
void quicksort(int*, int, int);

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
		/*printf("\nEnter the Element %d:", i);
		scanf("%d", &array[i]);	*/
		
		array[i]=rand();					//For Large Scale Experiments
	}	
	
	t0=clock();					//Time Watch

	quicksort(array,0,(size-1));					//[0][1][2]|[3][4][5][6]
	
	t0=clock()-t0;				//Time Watch
	
	elapsed = (((double)t0)/CLOCKS_PER_SEC)*1000000;	//uSec
	
	printf("\nThe Sorted Array is:-\n");
	
	for(int i=0;i<size;i++)
	{
		printf("\nElement %d:%d", i,array[i]);
	}
	
	printf("\n\nTime Elapsed:%f microseconds", elapsed);
	
	getch();
	return 0;
}

int partition(int* array, int start, int stop)	//Hoare-Partition
{	
	int index=start+(rand()%((stop-start)+1));//stop-1;// start+1;// (start+stop)/2;	//Random pivot vs Fixed Pivot
	int pivot=array[index];
	int temp,flag=0;
	int pivotIndex=index;
	
	int i=start, j=stop;
	
	//printf("\nPivot:%d", pivot);
	
	while((i!=j) && ((i-1)!=j))
	{
		if(array[i]<pivot)
		{
			i++;
		}
		
		if(array[j]>pivot)
		{
			j--;
		}
		
		if(array[i]>=pivot && array[j]<=pivot)
		{
			temp=array[i];
			array[i]=array[j];
			array[j]=temp;
			
			if(i==pivotIndex)
			{
				pivotIndex=j;
				flag=1;
			}
			
			if(j==pivotIndex && flag==0)
			{
				pivotIndex=i;
			}
			
			flag=0;
		}
	
		if(array[i]==array[j])
		{
			i++;
		}
		
	}
	
	return pivotIndex;
}

void quicksort(int* array, int start, int stop)
{
	int q;
	
	if(start<stop)
	{
		q=partition(array,start,stop);
		quicksort(array,start,(q-1));
		quicksort(array,(q+1),stop);
	}
}