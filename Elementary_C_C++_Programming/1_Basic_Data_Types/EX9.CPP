#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	float a,b;
	printf("\nEnter the First Number:");
	scanf("%f", &a);
	printf("\nEnter the Second Number:");
	scanf("%f", &b);
	printf("\nThe average of the two Number is:%f", (a+b)/2);
	getch();

}