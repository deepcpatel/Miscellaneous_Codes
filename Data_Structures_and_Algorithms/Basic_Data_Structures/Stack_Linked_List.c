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

int size=0;


// Main programming logic

int main()
{	
	top=NULL;

	int  choice, element;
	int ans=1;
	
	while(ans==1)
	{
		printf("\n\nMenu:");
		printf("\n1).Push");
		printf("\n2).Pop");
		printf("\n3).Display");
		printf("\n4).Show Size of Stack");
		printf("\n5).Exit");
		printf("\nEnter:");
		
		scanf("%d", &choice);
		
		switch (choice)
		{
			case 1:
					printf("\nEnter Element:");
					scanf("%d", &element);
					push(element);
					break;
			
			
			case 2:
					element=pop();
					
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
					
					display();
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
	
	size++;
}

// Function body for pop elements
int pop()
{
	node *temp;
	int val;
	
	if(top==NULL)
	{
		val=-2231;
	}
	else
	{
		val=top->data;
		temp=top;
		top=top->link;
		
		delete temp;
		
		size--;
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