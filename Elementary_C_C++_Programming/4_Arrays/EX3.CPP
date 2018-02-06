#include<iostream.h>
#include<conio.h>
#include<stdio.h>

void main()
{
	clrscr();
	int temp=0,a[]={1,4,7,12,45,3,2,12},c[8];
	cout<<"\nThe Original Array is:";
	for(int i=0;i<8;i++)
	{
		printf("\n\n%d", a[i]);
	}

	printf("\n\n\nThe Reversed Array is:");
	for(i=0;i<8;i++)
	{
		c[i]=a[7-i];
	}

	for(i=0;i<8;i++)
	{
		cout<<"\n\n"<<c[i];
	}

	getch();
}
