#include<stdio.h>
#include<conio.h>
#define Pi 3.14

void main()
{
	clrscr();
	int r;
	printf("\nEnter the radius of the circle:");
	scanf("%d", &r);
	printf("\nThe area of the circle is:%f", Pi*r*r);
	getch();
}
