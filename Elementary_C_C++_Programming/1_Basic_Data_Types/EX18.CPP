#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	float a,b,c,d,e,total=500.0,agg,percent;

	printf("\nEnter the marks obtained by the Student in English out of 100:");
	scanf("%f", &a);
	printf("\nEnter the marks obtained by the Student in Mathematics out of 100:");
	scanf("%f", &b);
	printf("\nEnter the marks obtained by the Student in Physics out of 100:");
	scanf("%f", &c);
	printf("\nEnter the marks obtained by the Student in Chemistry out of 100:");
	scanf("%f", &d);
	printf("\nEnter the marks obtained by the Student in Computer out of 100:");
	scanf("%f", &e);

	agg=a+b+c+d+e;
	percent=agg*100/total;
	printf("\nAggregate marks of the Student out of 500 is:%f", agg);
	printf("\n\nPercentage obtained by the Student is:%f", percent);
	getch();
}


