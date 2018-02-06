//DFS and Topological Sort
//Reference:CLRS

#include<stdio.h>
#include "Dependencies/Stack_Linked_List.c"

struct nodes
{
	//You can add here"(int/char/string/float) nodes_label;" variable for 
	//name of items in topological sort if you want
	int nodes_label;
	int startTime;
	int stopTime;
	int nodeColor;	//0=White, 1=Black
};

struct topological_list
{
	int item_code;
	struct topological_list* next;
	
}*head;

void traverse(int**, struct nodes*, int, int);
void topological_insert(int);
void show_list(struct topological_list*);

int main()
{
	int** matrix;
	struct nodes* nodeG;
	int sizeG;
	int startNode=-1;
	int time=0;
	char ch;
	head=NULL;
	
	printf("\nEnter Number of Nodes of Graph:");
	scanf("%d", &sizeG);
	
	matrix = new int*[sizeG];
	nodeG = new struct nodes[sizeG];
	
	printf("\nEnter items' Code Number:-\n");
	
	for(int i=0;i<sizeG;i++)
	{
		matrix[i]=new int[sizeG];
		
		nodeG[i].nodeColor=0;
		nodeG[i].startTime=0;
		nodeG[i].stopTime=0;
		
		//printf("\nEnter item %d's Code Number:",i);
		scanf("%d", &nodeG[i].nodes_label);
	}
	
	printf("\nEnter Connections(1/0) Matrix:-\n");
	
	for(int i=0;i<sizeG;i++)
	{
		
		for(int j=0;j<sizeG;j++)
		{
			//printf("\nConnect Node %d to Node %d:", i,j);
			scanf("%d", &matrix[i][j]);
		}
		
	}
	
	for(int i=0;i<sizeG;i++)
	{
		if(nodeG[i].nodeColor==0)
		{
			push(i);
			traverse(matrix, nodeG, sizeG, time);
		}
	}
	
	show_list(head);
	
	scanf("%c", &ch);
	
	return 0;
}

void traverse(int** matrix, struct nodes* nodeG, int sizeG, int time)	//Recursive DFS
{
	int temp,peek;
	
	temp=pop();
	peek=peekS();
	
	nodeG[temp].startTime=time;
	time++;
	
	for(int i=0;i<sizeG;i++)
	{
		if(matrix[temp][i]==1 && nodeG[i].nodeColor==0)
		{
			push(i);
		}
	}
	
	while(peekS()!=peek)
	{
		traverse(matrix, nodeG, sizeG, time);
	}
	
	nodeG[temp].stopTime=time;
	nodeG[temp].nodeColor=1;	//Making Node Black as Visited
	
	topological_insert(nodeG[temp].nodes_label);
	
}

void topological_insert(int code)		//Insert function for making topological list
{
	struct topological_list* temp;
	
	temp=new struct topological_list;
	
	temp->item_code=code;
	temp->next=NULL;
	
	if(head==NULL)
	{
		head=temp;
	}
	else
	{
		temp->next=head;
		head=temp;
	}
	
}

void show_list(struct topological_list* temp)	//Show List Function
{
	printf("\nThe List is:-\n");
	
	while(temp!=NULL)
	{
		printf("\n->%d",temp->item_code);
		temp=temp->next;
	}
}