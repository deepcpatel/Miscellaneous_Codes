#include<stdio.h>
#include<conio.h>
void main()
{
	clrscr();
	float base=1500.0,gross,sales,bonus,commn,price;
	int pieces;

	printf("\nEnter the price of Each Computer piece:");
	scanf("%f", &price);

	printf("\n\nEnter the number of pieces of Computer sold in a Month:");
	scanf("%d", &pieces);

	sales=price*pieces;
	bonus=200*pieces;
	commn=0.02*sales;
	gross=commn+bonus+base;

	printf("\n\nThe Bonus for this Month is:%f", bonus);
	printf("\n\nThe Commision for this Month is:%f", commn);
	printf("\n\nThe Gross Salary for this Month is:%f", gross);
	getch();
}


