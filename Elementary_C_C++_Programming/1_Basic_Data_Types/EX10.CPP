#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	float a,b;
	int c;
	printf("\nEnter the Number 1:");
	scanf("%f", &a);
	printf("\nEnter the Number 2:");
	scanf("%f", &b);
	c=(a>b)?1:2;
	printf("\nThe Greatest Number of the two is:Number %d", c);
	getch();
}

