#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	float temp;
	printf("\nEnter the temperature in Farheniet:");
	scanf("%f", &temp);
	(temp<32)?printf("\nBelow Freezing point"):printf("\nAbove Freezing point");
	getch();
}