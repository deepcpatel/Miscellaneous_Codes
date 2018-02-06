#include <stdio.h>

// Declaring a queue structure

struct node
{
	int data;
	node *link;
	
} *front=NULL, *rear=NULL;

void insertQ(int); // Add in queue
int deleteQ(); // Delete from queue
void displayQ(); // Show queue
int sizeQ();

int size=0;

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

int sizeQ()
{
	return size;
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