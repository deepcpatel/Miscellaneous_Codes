#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	int a,b,c,x;
	printf("\nEnter a:");
	scanf("%d", &a);

	printf("\nEnter b:");
	scanf("%d", &b);

	printf("\nEnter c:");
	scanf("%d", &c);

	x=a/(b-c);

	printf("\nX is: %d", x );

	getch();
}

/* Output

1).
Enter a:250

Enter b:85

Enter c:25

X is: 4

2).No Output

*/

