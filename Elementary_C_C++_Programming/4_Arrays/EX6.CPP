#include<iostream.h>
#include<conio.h>
#include<stdio.h>
#include<limits.h>

void main()
{
	clrscr();
	int a[5],temp,b,c=0,min,index,mn;

	cout<<"\nEnter the Elements of the Array:";

	for(int i=0;i<5;i++)
	{
		cout<<"\n\nEnter the element "<<i+1<<":";
		cin>>a[i];
	}

	for(i=0;i<5;i++)
	{

	    min=a[0];

	    if(a[i]<min)
	    {
		index=i;


		for(int j=index;j>0;j--)
		{
			temp=a[j];
			a[j]=a[j-1];
			a[j-1]=temp;
		}

	    }

	    cout<<"\nThe Array After Pass "<<i+1<<" is:";
	    for(int m=0;m<5;m++)
	    {
		cout<<" "<<a[m];
	    }
	}

	cout<<"\nThe Sorted Array is:";

	for(int m=0;m<5;m++)
	{
		cout<<"\n"<<a[m];
	}

	getch();
}




