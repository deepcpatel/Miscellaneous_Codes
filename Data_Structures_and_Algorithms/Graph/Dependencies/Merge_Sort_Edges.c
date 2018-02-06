#include<stdio.h>
#include "Struct_Edges.h"

void divide(struct links*, int);
void sort_merge(struct links*, struct links*, int, int);

void divide(struct links* array, int size)		//Divide the array in half
{	
	if(size!=1)
	{
		int hSize=size/2;
		int dtSize=sizeof(int);
		struct links* pt1=array;
		struct links* pt2=(array+(size/2));
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

void sort_merge(struct links* a, struct links* b, int sizeA, int sizeB)		//Merge the divided array
{
	int totalSize=sizeA+sizeB;
	struct links array[totalSize];
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
			if(a[cntA].weight<=b[cntB].weight)
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