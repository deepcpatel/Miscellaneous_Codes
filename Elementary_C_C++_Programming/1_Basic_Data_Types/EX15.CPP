#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	int a;

	printf("\nEnter a Number:");
	scanf("%d", &a);

	if(a>100)
	{
		printf("\nThe Number is Greater than 100");
	}

	else
		if(a<100)
		{
			printf("\nThe Number is Smaller Than 100");
		}
	else
	{
		printf("\nThe Number is 100");
	}

	getch();
}


