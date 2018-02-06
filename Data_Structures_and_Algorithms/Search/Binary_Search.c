#include<stdio.h>

//It is only for sorted array

int binarySearch(int*,int,int);

int main()
{
	int size, item, position;
	int* array;
	
	printf("\nEnter Size of the Array:");
	scanf("%d", &size);
	
	array=new int[size];
	
	printf("\nEnter Elements in Sorted form\n");
	
	for(int i=0; i<size; i++)
	{
		printf("\nEnter Element %d:", i);
		scanf("%d", &array[i]);
	}
	
	printf("\nEnter Element to Search for:");
	scanf("%d", &item);
	
	position=binarySearch(array,size,item);
	
	if(position!=-1)
	{
		printf("\nThe Element is at Position:%d",position);
	}
	else
	{
		printf("\nSorry, the element is not found.......");
	}
	
	return 0;
}


int binarySearch(int* ar,int size,int item)
{
	int first,last,mid;
	first=0;
	last=size-1;
	
	while(first<=last)
	{
		mid=(first+last)/2;
		
		if(ar[mid]==item)
		{
			return mid;
		}	
		else if(ar[mid]<item)
		{
			first = mid + 1;
		}	
		else
		{
			last = mid - 1;
		}
	}
	
	return -1;
}