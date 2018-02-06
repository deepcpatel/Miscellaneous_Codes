#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	float basic,hra,da,gross;

	printf("\nEnter the Basic Salary of Ramesh:");
	scanf("%f", &basic);

	da=0.4*basic;
	hra=0.2*basic;
	gross=da+hra+basic;

	printf("\nGross Salary of Ramesh is=%f", gross);
	getch();
}



