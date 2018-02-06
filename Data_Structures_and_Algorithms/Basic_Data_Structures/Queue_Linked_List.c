#include <stdio.h>

// Declaring a queue structure

struct node
{
	int data;
	node *link;
	
} *front, *rear;

void insertQ(int); // Add in queue
int deleteQ(); // Delete from queue
void displayQ(); // Show queue

int size=0;


// Main programming logic

int main()
{	

	front=NULL;
	rear=NULL;
	
	int  choice, element;
	int ans=1;
	
	while(ans==1)
	{
		printf("\n\nMenu:");
		printf("\n1).Push");
		printf("\n2).Pop");
		printf("\n3).Display");
		printf("\n4).Show Size of Queue");
		printf("\n5).Exit");
		printf("\nEnter:");
		
		scanf("%d", &choice);
		
		switch (choice)
		{
			case 1:
					printf("\nEnter Element:");
					scanf("%d", &element);
					insertQ(element);
					break;
			
			
			case 2:
					element=deleteQ();
					
					if(element!=-2231)
					{
						printf("\nDeleted Element:%d", element);
					}
					else
					{
						printf("\nSorry, Queue is Empty..");
					}	
					break;
					
			case 3:
					
					displayQ();
					break;
				
			case 4:
					printf("\nThe size of Queue is:%d\n", size);
					break;
					
			case 5:
					ans=2;
					break;
					
			default:ans=2;
		}
	}
	
	return 0;
}

// Function body for adding queue elements
void insertQ(int val)
{
	node *temp;
	temp=new node;
	
	temp->data=val;
	temp->link=NULL;
	
	if (front == NULL)
	{
		front=temp;
		rear=temp;
	}
	else
	{
		rear->link=temp;
		rear=temp;
	}
	
	size++;
}

// Function body for delete queue elements
int deleteQ()
{
	node *temp;
	
	int val;
	
	if (front == NULL)
	{
		val=-2231;	//Null Value
	}
	else
	{
		val=front->data;
		
		temp=front;
		
		if (front == rear)
		{
			rear=NULL;
			front=NULL;
		}
		else
		{
			front=front->link;
		}
		
		delete temp;
		size--;
	}
	
	return val;
	
}

// Function body for show queue elements
void displayQ()
{
	node *temp;
	temp=front;
	printf("\nThe Queue Values are:");
	while (temp!=NULL)
	{
		printf("\n %d", temp->data);
		temp=temp->link;
	}
}