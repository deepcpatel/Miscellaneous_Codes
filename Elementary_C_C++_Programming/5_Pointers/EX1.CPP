#include<iostream.h>
#include<conio.h>
#include<stdio.h>

void main()
{
	clrscr();
	int  *p,a[]={1,4,5,6,7,2},temp;
	p=a;

	cout<<"\nThe Original array is:";
	for(int i=0;i<6;i++)
	{
		cout<<" "<<a[i];
	}

	for(i=0;i<3;i++)
	{
		temp=*(p+i);
		*(p+i)=*(p+(5-i));
		*(p+(5-i))=temp;
	}

	cout<<"\nThe Reversed array is:";

	for(i=0;i<6;i++)
	{
		cout<<" "<<a[i];
	}

	getch();
}
