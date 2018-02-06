#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
	clrscr();
	float a,b,c,disc,root1,root2;
	printf("\nYou are going to enter data for the quadratic equation of the type Ax^2+Bx+C=0");

	printf("\n\nEnter A for the above Equation:");
	scanf("%f", &a);

	printf("\n\nEnter B for the above Equation:");
	scanf("%f", &b);

	printf("\n\nEnter C for the above Equation:");
	scanf("%f", &c);

	disc=(b*b)-(4*a*c);

	if(disc>0)
	{       root1=((-1*b)+(sqrt(disc)))/(2*a);

		root2=((-1*b)-(sqrt(disc)))/(2*a);

		printf("\n\nRoots of this equation are real and distinct and are as below:");
		printf("\n\nRoot 1=%f", root1);
		printf("\n\nRoot 2=%f", root2);
	}

	else if(disc==0)
	{
		root1=((-1*b)+(sqrt(disc)))/(2*a);

		root2=((-1*b)-(sqrt(disc)))/(2*a);

		printf("\n\nRoots of this equation are real and equal and are as below:");
		printf("\n\nRoot 1=%f", root1);
		printf("\n\nRoot 2=%f", root2);
	}

	else
	{
		printf("\n\nThe roots are imaginary and does not exist");
	}
	getch();
}





