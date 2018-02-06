#include<iostream.h>
#include<conio.h>
#include<stdio.h>

void main()
{
	clrscr();
	int a[5],min,m=0,temp;

	cout<<"\nEnter the elements in the array:";
	for(int i=0;i<5;i++)
	{
		cout<<"\n\nEnter The Element " <<i+1<<":";
		cin>>a[i];
	}

	printf("\nThe Sorted Array is(Selection Sort)");

	while(m!=5)
	{       int index=m;
		min=a[m];
		for(i=m;i<5;i++)
		{
			if(a[i]<min)
			{
				min=a[i];
				index=i;
			}
		}

		temp=a[m];
		a[m]=min;
		a[index]=temp;
		m++;
		cout<<"\n\nThe Array After pass "<<m<<"is:";
		for(int j=0;j<5;j++)
		{
			cout<<" "<<a[j];
		}


	}

	for(i=0;i<5;i++)
	{
		cout<<"\n\n"<<a[i];
	}

	getch();
}
