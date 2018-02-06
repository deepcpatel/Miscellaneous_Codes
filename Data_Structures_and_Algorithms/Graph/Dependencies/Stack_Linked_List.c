#include <stdio.h>

// Declaring a stack structure

struct node
{
	int data;
	node *link;
	
} *top;

void push(int); // Add in queue
int pop(); // Delete from queue
void display(); // Show queue
int getSize();
int peekS();

int stack_size=0;

// Function body for push elements
void push(int val)
{
	node *temp;
	temp=new node;
	
	temp->data=val;
	temp->link=NULL;
	
	if(top ==NULL)
	{
		top=temp;
	}	
	else
	{
		temp->link=top;
		top=temp;
	}
	
	stack_size++;
}

// Function body for pop elements
int pop()
{
	node *temp;
	int val;
	
	if(top==NULL)
	{
		val=-2231;	//NULL Value
	}
	else
	{
		val=top->data;
		temp=top;
		top=top->link;
		
		delete temp;
		
		stack_size--;
	}
	
	return val;
}

// Function body for show stack elements
void display()
{
	node *temp;
	
	if(top==NULL)
	{
		printf("\nSorry, Stack is Empty.....");
	}
	else
	{
		temp=top;
		
		printf("\nThe Stack Elements are:");
		
		while (temp!=NULL)
		{
			printf("\n %d", temp->data);
			temp=temp->link;
		}
	}
}

int peekS()
{
	int val;
	
	if(top==NULL)
	{
		val=-2231;	//NULL Value
	}
	else
	{
		val=top->data;
	}
	
	return val;
}

int getSize()
{
	return stack_size;
}