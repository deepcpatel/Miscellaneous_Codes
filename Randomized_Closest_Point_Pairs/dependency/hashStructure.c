#include <stdio.h>
#include <stdlib.h>
#include "Stack.c"

// Declaring a stack structure

typedef struct linked_list_node
{
    float s;
    float t;
    struct linked_list_node *link;

} linked_list_node;

typedef struct node
{
    //int list_size;
    linked_list_node *head;

} node;

node *array;
int node_array_size=-1;

void initialize_structure(int);
void insert(int,float,float);     			// Add in List
linked_list_node* retrieve(int index);     	// Delete from List
void clear_all();         					// Display

/*int main()
{
    return 0;
}*/

void initialize_structure(int size)
{
    array=malloc(sizeof(node) * size);    //Dynamically Declaring Array
    node_array_size=size;
    int i;

    for(i=0;i<node_array_size;i++)
    {
        array[i].head=NULL;
        //array[i].list_size=0;
    }

}

void insert(int index, float s1, float t1)
{
    linked_list_node *temp=malloc(sizeof(linked_list_node)); //Dynamically Declaring
    temp->s=s1;
    temp->t=t1;
    temp->link=NULL;

    temp->link=array[index].head;
    array[index].head=temp;

}

linked_list_node* retrieve(int index)
{
    return array[index].head;
}

void clear_all()
{
    int i;
    for(i=0;i<node_array_size;i++)
    {
        array[i].head=NULL;
    }
}

struct node_stack* backup()
{
    int i;
    linked_list_node *temp=malloc(sizeof(linked_list_node)); //Dynamically Declaring

    for(i=0;i<node_array_size;i++)
    {
        temp=array[i].head;

        while(temp!=NULL)
        {
            push(temp->s, temp->t);
            temp=temp->link;
        }
    }

    return top;

}
