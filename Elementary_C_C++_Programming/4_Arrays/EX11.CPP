#include<iostream.h>
#include<stdio.h>
#include<conio.h>

void main()
{
	clrscr();
	int a,b,siz=0,h=0;
	char str[100];

	cout<<"\nEnter the any Word:";
	cin>>str;

	for(int i=0;str[i]!='\0';i++)
	{
		siz++;
	}

	cout<<"\n\nThe Size of the Sring is:"<<siz<<" and:"<<i;

	if((i+1)%2==0)
	{       int k=0;
		for(int j=1;j<((i+1)/2);j++)
		{
			if(str[j-1]==str[siz-j])
			{
				k++;
			}
		}

		//cout<<"\n\nK="<<k;

		if(k==((i+1)/2)-1)
		{
			cout<<"\n\nThe Word You Have Entered is Palindrome";
			h++;
		}
	}

	else
	{
		int k=0;
		for(int j=1;j<=((i+1)/2);j++)
		{
			if(str[j-1]==str[siz-j])
			{
				k++;
			}
		}

		//cout<<"\nK="<<k;

		if(k==((i+1)/2))
		{
			cout<<"\n\nThe Word You Have Entered is Palindrome";
			h++;
		}
	}

	if(h==0)
	{
		cout<<"\n\nThe Word You Have Entered is not Palindrome";
	}

	getch();
}