#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	int x,y,temp;

	printf("\nEnter X:");
	scanf("%d", &x);

	printf("\nEnter Y:");
	scanf("%d", &y);

	temp=x;
	x=y;
	y=temp;

	printf("\nThe Interchanged Variables are:");
	printf("\nX=%d", x);
	printf("\nY=%d", y);

	getch();
}
