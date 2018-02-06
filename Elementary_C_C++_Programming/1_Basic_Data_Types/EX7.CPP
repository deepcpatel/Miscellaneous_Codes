#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	int i;
	for(i=1;i<=10;i++)
	{
		printf("\n5x%d", i);
		printf("=%d", 5*i);
	}
	getch();
}