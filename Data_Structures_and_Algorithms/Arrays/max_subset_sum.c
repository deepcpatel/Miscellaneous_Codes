//Reference: CLRS Page 1130, Approximation Algorithm->Subset Sum Problem

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void exact_subset_sum(int*, int*, int*, int, int);
void trim(int*, int);


int main()
{
	int array[]={1,4,5};
	int newSize,size=3,i;
	newSize=(int)(pow(2,size)-1);
	int new[newSize];
	int counter=0;
	
	for(i=0;i<newSize;i++)
	{
		new[i]=0;
	}
	
	exact_subset_sum(array,new,&counter,size,10);
	
	//printf("\nnewSize:%d",newSize);
	
	printf("\nThe New Array Element after Exact Subset is:-"); 
	
	for(i=0;i<counter;i++)
	{
		printf("\n%d",new[i]);
	}	
	
	trim(new,counter);
	
	return 0;
}

void exact_subset_sum(int* array, int* new, int* counter, int size, int t)
{
	int i=0,j=0;
	int count2=*(counter);
	
	for(i=0;i<size;i++)
	{
		count2=*(counter);
		
		for(j=0;j<count2+1;j++)
		{
			*(counter)=*(counter)+1;
			
			if(new[j]!=-1)
			{
				if(new[*(counter)-1]!=new[j]+array[i])
				{
					new[*(counter)]=new[j]+array[i];
				}
				else
				{
					*(counter)=*(counter)-1;
				}
			}
		}
		
		for(j=0;j<*(counter)+1;j++)
		{
			if(new[j]>t)
			{
				new[j]=-1;		
			}
		}
	
	}
	
	*(counter)=*(counter)+1;
	
}

void trim(int* new, int counter)
{
	float delta=0.15;
	int i;
	int last;
	
	for(i=1;i<counter;i++)
	{
		if(new[i-1]!=-1)
		{
			last=new[i-1];
		}
			
		if(new[i]!=-1)
		{
			if((float)last>=(float)((float)new[i]/(float)(1+delta)) && last<=new[i])
			{
				new[i]=-1;
			}
		}
		
	}
	
	printf("\n\nThe L' after Trimming is:-");
	for(i=0;i<counter;i++)
	{
		if(new[i]!=-1)
		{
			printf("\n%d",new[i]);
		}
	}
}