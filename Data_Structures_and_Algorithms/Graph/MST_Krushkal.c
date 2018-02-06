//Minimum Spanning Tree: Krushkal's Algorithm
//Reference:CLRS
//Note:-Optimize the code, also take input from file instead of console, if possible
//Some commented portions are kept for debugging

#include<stdio.h>
#include "Dependencies/Struct_Edges.h"
#include "Dependencies/Merge_Sort_Edges.c"
#include "Dependencies/Stack_Linked_List.c"

struct set
{
	int size;
	struct node* head;
};

void MST_Krushkal(struct links*, int, int*, int, struct set*);
void showMST(struct links*, int);
void setUnion(int, int, int*, struct set*);

int main()
{
	int nodesSize,edgesSize,counter=0;
	int* nodeSet;
	struct links* edgeSet;
	struct set* setArray;
	
	printf("\nEnter Number of Nodes:");
	scanf("%d",&nodesSize);
	
	printf("\nEnter Number of Edges:");
	scanf("%d",&edgesSize);
	
	nodeSet=new int[nodesSize];
	setArray=new struct set[nodesSize];
	edgeSet=new struct links[edgesSize];
	
	for(int i=0;i<nodesSize;i++)
	{
		nodeSet[i]=-2;
		setArray[i].size=1;
		setArray[i].head=NULL;
		
		top=setArray[i].head;
		push(i);
		setArray[i].head=top;
		
	}
	
	printf("\nEnter the edge details:-\n");
	
	for(int i=0;i<edgesSize;i++)
	{
		printf("\nEnter for Edge-%d:-\n",i+1);
		
		printf("\nEnter Node 1:");
		scanf("%d", &edgeSet[i].n1);
		
		printf("\nEnter Node 2:");
		scanf("%d", &edgeSet[i].n2);
		
		printf("\nEnter Weight:");
		scanf("%d", &edgeSet[i].weight);
		
		edgeSet[i].set=i;
		
		if(nodeSet[edgeSet[i].n1]==-2)
		{
			nodeSet[edgeSet[i].n1]=counter;
			counter++;
		}
		
		if(nodeSet[edgeSet[i].n2]==-2)
		{
			nodeSet[edgeSet[i].n2]=counter;
			counter++;
		}
	}
	
	divide(edgeSet,edgesSize);		//Merge Sorting
	
	MST_Krushkal(edgeSet, edgesSize, nodeSet, nodesSize, setArray);	//Making MST
	showMST(edgeSet, edgesSize);	//Showing MST
	
	return 0;
}

//edgeSet[i].set=-1 means that edge is added to set A;

void MST_Krushkal(struct links* edgeSet, int edgesSize, int* nodeSet, int nodesSize, struct set* setArray)
{
	int temp;
	
	for(int i=0;i<edgesSize;i++)
	{
		/*
		printf("\nIteration %d",i);
		printf("\nBefore");
		printf("\nSet of Element %d is %d",edgeSet[i].n1,nodeSet[edgeSet[i].n1]);
		printf("\nSet of Element %d is %d",edgeSet[i].n2,nodeSet[edgeSet[i].n2]);
		printf("\n**********");
		*/
		
		if(nodeSet[edgeSet[i].n1] != nodeSet[edgeSet[i].n2])
		{
			edgeSet[i].set=-1;
			
			setUnion(edgeSet[i].n1, edgeSet[i].n2, nodeSet, setArray);
		}
		
		/*
		printf("\n**********");
		printf("\nAfter");
		printf("\nSet of Element %d is %d",edgeSet[i].n1,nodeSet[edgeSet[i].n1]);
		printf("\nSet of Element %d is %d",edgeSet[i].n2,nodeSet[edgeSet[i].n2]);
		
		//printf("\n**********");
		//printf("\nEdge Element 1 %d",edgeSet[i].n1);
		//printf("\nEdge Element 2 %d",edgeSet[i].n2);
		//printf("\nEdge Weight %d",edgeSet[i].weight);
		//printf("\nEdge Set %d",edgeSet[i].set);
		
		printf("\n----------------------\n");
		*/
	}
}

void showMST(struct links* edgeSet, int edgesSize)
{
	printf("\nThe MST is:-\n");
	
	for(int i=0;i<edgesSize;i++)
	{
		if(edgeSet[i].set==-1)
		{
			printf("\n%d<->%d",edgeSet[i].n1,edgeSet[i].n2);
		}
	}
}

void setUnion(int a, int b, int* nodeSet, struct set* setArray)
{
	int tempSize=0,temp_hold;
	int setA, setB;
	
	setA=nodeSet[a];
	setB=nodeSet[b];
	
	if(setArray[setA].size>setArray[setB].size)
	{
		tempSize=setArray[setB].size;
		
		while(tempSize!=0)
		{
			top=setArray[setB].head;
			temp_hold=pop();
			setArray[setB].head=top;
			
			//printf("\nSet %d, of %d:-\n",setB,b);
			//display();
			
			top=setArray[setA].head;
			push(temp_hold);
			setArray[setA].head=top;
			
			//printf("\nSet %d, of %d:-\n",setA,a);
			//display();
			
			nodeSet[temp_hold]=setA;
			
			tempSize--;
		}
		
		setArray[setA].size=setArray[setA].size+setArray[setB].size;
		setArray[setB].size=0;
		
		//printf("\nSize of Set %d is %d",setA,setArray[setA].size);
		//printf("\nSize of Set %d is %d",setB,setArray[setB].size);
		
	}
	else
	{
		tempSize=setArray[setA].size;
		
		while(tempSize!=0)
		{
			top=setArray[setA].head;
			temp_hold=pop();
			setArray[setA].head=top;
			
			//printf("\nSet %d, of %d:-\n",setA,a);
			//display();
			
			top=setArray[setB].head;
			push(temp_hold);
			setArray[setB].head=top;
			
			//printf("\nSet %d, of %d:-\n",setB,b);
			//display();
			
			nodeSet[temp_hold]=setB;
			
			tempSize--;
		}
		
		setArray[setB].size=setArray[setB].size+setArray[setA].size;
		setArray[setA].size=0;
		
		//printf("\nSize of Set %d is %d",setA,setArray[setA].size);
		//printf("\nSize of Set %d is %d",setB,setArray[setB].size);
		
	}
}