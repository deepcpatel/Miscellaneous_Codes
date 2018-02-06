//BFS
//Reference:CLRS

#include <stdio.h>
#include "Dependencies/Queue_Linked_List.c"

int search(int, int, int**, int*, int);
void tracePath(int*, int, int);

int main()
{
	int** matrix;
	int* nodeColor;
	int sizeG;
	int startNode=-1;
	int destNode=-1;
	int success=-1;//1=Success, 0=Not Success
	char ch;

	printf("\nEnter Number of Nodes of Graph:");
	scanf("%d", &sizeG);

	matrix = new int*[sizeG];
	nodeColor= new int[sizeG];//0=White, 1=Black

	for(int i=0;i<sizeG;i++)
	{
		matrix[i]=new int[sizeG];

		nodeColor[i]=0;
	}

	printf("\nEnter Connections(1/0):");

	for(int i=0;i<sizeG;i++)
	{

		for(int j=0;j<sizeG;j++)
		{
			printf("\nConnect Node %d to Node %d:", i,j);
			scanf("%d", &matrix[i][j]);
		}

	}

	printf("\nEnter Start Node:");
	scanf("%d", &startNode);

	printf("\nEnter Destination Node:");
	scanf("%d", &destNode);

	success=search(startNode, destNode, matrix, nodeColor, sizeG);

	scanf("%c", &ch);

	return 0;
}

int search(int startNode, int destNode, int** matrix, int* nodeColor, int sizeG)
{
	int temp;
	int i=0;
	int parent[sizeG];

	for(int j=0;j<sizeG;j++)
	{
		parent[j]=-1;
	}

	insertQ(startNode);

	while(sizeQ()!=0)
	{
		temp=deleteQ();

		if(nodeColor[temp]==0)
		{
			for(i=0;i<sizeG;i++)
			{
				if(matrix[temp][i]==1 && nodeColor[i]==0)
				{
					insertQ(i);
					parent[i]=temp;

					if(i==destNode)
					{
						tracePath(parent,sizeG,i);
						return 1;
					}
				}
			}
		}

		nodeColor[temp]=1;
	}

	printf("\nSorry Node Not Found......");
	return 0;
}

void tracePath(int* parent, int sizeG, int destNode)
{
	printf("\nThe Path is:-\n\n");

	int i=destNode;

	do
	{
		printf("->%d",i);
		i=parent[i];

	}while(parent[i]!=-1);

	printf("->%d",i);
}