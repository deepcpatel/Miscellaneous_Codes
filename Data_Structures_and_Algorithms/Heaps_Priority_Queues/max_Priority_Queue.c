/*Maximum Priority Queue using Heap */

#include<stdio.h>

void push(int*, int&, int&, int&, int);		//compulsory functions
int pop(int*, int&, int&, int&);
void max_heapify(int*, int&, int&, int&);
void show(int*, int&, int&, int&);

int main()
{
	int *array;	//variables required for priority queues
	int size;
	int front=1, rear=1;
	int element;
	
	int ans=1, choice, take;	//Variables for loop invariant
	
	
	printf("\nEnter the Size of the Queue:");
	scanf("%d", &size);
	
	array = new int[size+1];
	
	array[0]=-1;
	
	while(ans==1)						//Menu Driven Code
	{
		printf("\n\n\nEnter from Below:-");    
		printf("\n1).Push");
		printf("\n2).Pop");
		printf("\n3).Display");
		printf("\n4).See the Size of the Priority Queue");
		printf("\n5).Exit");
		printf("\n\nEnter:");
		
		scanf("%d", &choice);
		
		switch(choice)
		{
			case 1:	
			{
				printf("\nEnter the Element to Insert:");
				scanf("%d", &element);
				
				push(array, size, front, rear, element);
				
				break;

			}
			
			case 2:
			{
				take=pop(array, size, front, rear);
				
				if(take!=-232278)
				{
					printf("\nThe Deleted Element is:%d \n", take);
				}
				else
				{
					printf("\nSorry The Priority Queue is Already Empty..\n");
				}
				
				break;
			}
			
			case 3:
			{
				show(array, size, front, rear);
				
				break;
			}
			
			case 4:
			{
				printf("\nThe Size of the Queue is:%d \n", (front-rear));
				
				break;
			}
			
			default:
			{
				printf("\nBye.....\n\n");
				ans=2;
				
			}

		}
	
	}
	
	return 0;
}

//Pass by reference
void push(int *array, int &size, int &front, int &rear, int data)	//push function to insert in priority queue
{
	if(front>size)
	{
		printf("\nSorry The Priority Queue is Full........");
	}
	else
	{
		if(front==1)
		{
			array[front]=data;
			front++;
		}
		else
		{
			int temp=front;
			int tempvar;
			
			array[front]=data;
			
			while(temp!=1)
			{
				if(array[temp]>array[(temp/2)])
				{
					tempvar=array[(temp/2)];
					array[(temp/2)]=array[temp];
					array[temp]=tempvar;
					
					temp=temp/2;
				}
				else
				{
					break;
				}
			}
			
			
			front++;
		}
		
		printf("\nData is Pushed Successfully in The Priority Queue...");
	}
}

int pop(int *array, int &size, int &front, int &rear)		//pop function to delete from priority queue
{
	int deleted;
	int temp;
	int tempPt;
	
	if(front==rear)
	{
		front=1;
		rear=1;
		deleted=-232278;		//null number
	}
	else
	{
		
		tempPt=rear;
		deleted = array[rear];
		
		array[rear]=array[(front-1)];
		front--;
		
		max_heapify(array, size, front, rear);
		
	}
	
	return deleted;
}

void max_heapify(int *array, int &size, int &front, int &i)
{
	int large, temp;
	int left=2*i;
	int right=(2*i)+1;
	
	if(left<front && array[left]>array[i])
	{
		large=left;
	}
	else
	{
		large=i;
	}
	
	if(right<front && array[right]>array[large])
	{
		large=right;
	}
	
	if(large!=i)
	{
		temp=array[i];
		array[i]=array[large];
		array[large]=temp;
		
		max_heapify(array, size, front, large);
	}
}

void show(int *array, int &size, int &front, int &rear)		//display functions
{
	if(rear==front)
	{
		printf("\nSorry, The Priority Queue is Empty....\n");
	}
	else
	{
		printf("\nThe Priority Queue is:-\n");
		
		for(int i=rear; i<front; i++)
		{
			printf("\n%d", array[i]);
		}
	}
}
