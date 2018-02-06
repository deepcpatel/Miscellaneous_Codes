#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	int f,c,ans;

	printf("\nChoose the option:\n\n1).F->C\n2).C->F\n");
	scanf("%d", &ans);

	if(ans==1)
	{
		printf("\nEnter the temperature in Farheniet:");
		scanf("%d", &f);
		c=((f-32)*5)/9;
		printf("\nThe Temperature in Celsius is:%d", c);
	}

	else
	{
		printf("\nEnter the temperature in Celsius:");
		scanf("%d", &c);
		f=((9*c)/5)+32;
		printf("\nThe Temperature in Farheniet is:%d", f);
	}

	getch();
}
