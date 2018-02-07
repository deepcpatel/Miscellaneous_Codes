#include <stdio.h>
#include <stdlib.h>

// Declaring a stack structure

struct node_stack
{
    float x;
    float y;
    struct node_stack *link;

} *top;

float globalX, globalY;

void push(float, float); // Add in queue
int pop(); // Delete from queue
void display(); // Show queue
int getSize();
int peekS();

int stack_size=0;

// Function body for push elements
void push(float valx, float valy)
{
    struct node_stack *temp = malloc(sizeof(struct node_stack));

    temp->x=valx;
    temp->y=valy;

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
    struct node_stack *temp;
    int val;

    if(top==NULL)
    {
        val=-2231;    //NULL Value
    }
    else
    {
        globalX=top->x;
        globalY=top->y;

        temp=top;
        top=top->link;

        free(temp);

        stack_size--;
        val=1;
    }

    return val;
}

// Function body for show stack elements
void display()
{
    struct node_stack *temp;

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
            printf("\n X:%f, Y:%f", temp->x,temp->y);
            temp=temp->link;
        }
    }
}

int peekS()
{
    int val;

    if(top==NULL)
    {
        val=-2231;    //NULL Value
    }
    else
    {
        globalX=top->x;
        globalY=top->y;

        val=1;
    }

    return val;
}

int getSize()
{
    return stack_size;
}
