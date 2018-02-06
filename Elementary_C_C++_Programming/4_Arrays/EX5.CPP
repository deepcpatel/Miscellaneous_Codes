#include<iostream.h>
#include<conio.h>
#include<stdio.h>

void main()
{
	clrscr();
	int a[5],temp,b,c;

	cout<<"\nEnter the Elements of the Array:";
	for(int i=0;i<5;i++)
	{
		cout<<"\nEnter the Element "<<i+1<<":";
		cin>>a[i];
	}


	for(i=0;i<4;i++)
	{
		for(int j=0;j<4;j++)
		{
			if(a[j]>a[j+1])
			{
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}

		printf("\nThe Array After Pass %d is:", i+1);

		for(int m=0;m<5;m++)
		{
			cout<<" "<<a[m];
		}
	}

	cout<<"\nThe Sorted Array is:";
	for(i=0;i<5;i++)
	{
		cout<<"\n\n"<<a[i];
	}

	getch();
}
