#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	int a;
	printf("\nEnter a Number:");
	scanf("%d", &a);

	if(a%2==0)
	{
		printf("\nThe Number is Even");
	}
	else
	{
		printf("\nThe Number is Odd");
	}
	getch();
}