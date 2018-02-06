#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	int x,y;
	printf("\nEnter the Number X:");
	scanf("%d", &x);

	printf("\nEnter the Number Y:");
	scanf("%d", &y);
	printf("\nX=%d", x);
	printf("\tY=%d", y);
	printf("\n\nSum=%d", x+y);
	printf("\t\tDifference=%d", x-y);
	printf("\n\nProduct=%d", x*y);
	printf("\tDivison=%d", x/y);

	getch();
}


