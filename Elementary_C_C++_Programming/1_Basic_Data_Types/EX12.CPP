#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	float a,b,c;

	printf("\nEnter the Number 1:");
	scanf("%f", &a);

	printf("\nEnter the Number 2:");
	scanf("%f", &b);

	printf("\nEnter the Number 3:");
	scanf("%f", &c);

	if(a>b)
	{
		if(b>c)
		{
			printf("\nNumber 1 is Greatest");
			printf("\nNumber 3 is Smallest");
		}

		else
			if(b<c)
		{
			if(a>c)
			{
				printf("\nNumber 1 is Greatest");
				printf("\nNumber 2 is Smallest");
			}
			else
			{
				printf("\nNumber 3 is Greatest");
				printf("\nNumber 2 is Smallest");
			}
		}
	}
	else
	{
		if(a>c)
		{
			printf("\nNumber 2 is Greatest");
			printf("\nNumber 3 is Smallest");
		}

		else
			if(a<c)
		{
			if(b>c)
			{
				printf("\nNumber 2 is Greatest");
				printf("\nNumber 1 is Smallest");
			}
			else
			{
				printf("\nNumber 3 is Greatest");
				printf("\nNumber 1 is Smallest");
			}
		}
	}
	getch();
}







