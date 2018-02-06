#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	float l,b;
	printf("\nEnter the Length of the rectangle(cm):");
	scanf("%f", &l);
	printf("\nEnter the Breadth of the rectangle(cm):");
	scanf("%f", &b);
	printf("\nThe area of the rectangle is:%f", l*b);
	printf(" Sq. cm");
	getch();
}
