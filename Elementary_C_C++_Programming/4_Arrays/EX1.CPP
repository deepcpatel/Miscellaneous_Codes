#include<iostream.h>
#include<stdio.h>
#include<conio.h>

void main()
{       clrscr();

	int a[]={3,5,7,9,12}, b[]={1,4,6,7},c[9],m=0,n=0;

	cout<<"\n\nThe Unsorted Array A is:";
	for(int i=0; i<5; i++)
	{
		cout<<"\n"<<a[i];
	}

	cout<<"\n\nThe Unsorted Array B is:";
	for(i=0; i<4; i++)
	{
		cout<<"\n"<<b[i];
	}


	cout<<"\n\nThe Merged Array is:";

	for(i=0;i<9;i++)
	{       if(n<4)
		{
			if(a[m]>b[n])
			{
				c[i]=b[n];
				n++;
			}

			else if(b[n]>a[m])
			{
				c[i]=a[m];
				m++;
			}

			else
			{
				c[i]=a[m];
				c[i+1]=b[n];
				m++;
				n++;
				i++;
			}
		}

		else
		{
			c[i]=a[m];
			m++;
		}
	}

	for(i=0; i<9; i++)
	{
		cout<<"\n"<<c[i];
	}
	getch();
}





