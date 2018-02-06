#include<iostream.h>
#include<conio.h>
#include<stdio.h>

void main()
{
	clrscr();

	int a[5][4],total,b[5],min,max,m=1,index,mm,ind;
	cout<<"\nEnter the Marks of the students against their Roll Numbers:";

	for(int i=0;i<5;i++)
	{
		cout<<"\n\nRoll No.:";
		cin>>a[i][0];
		cout<<"\n";
		for(int j=1;j<4;j++)
		{
			cout<<"Subject "<<j<<":";
			cin>>a[i][j];
		}
	}

	printf("\nThe Total Marks Obtained By");

	for(i=0;i<5;i++)
	{       total=a[i][1]+a[i][2]+a[i][3];
		cout<<"\n\nStudent With Roll No. "<<a[i][0]<<" is:"<<total;
	}       b[i]=total;

	while(m!=4)
	{
		max=a[0][m];
		for(i=0;i<5;i++)
		{
			if(max<a[i][m])
			{
				max=a[i][m];
				index=i;
			}
		}
		cout<<"\n\nThe Maximum Marks Obtained In subject "<<m<<" is:"<<max<<" and is obtained by Roll Number.:"<<a[index][0];

		m++;
	}

	mm=b[0];
	for(i=0;i<5;i++)
	{
		if(mm<b[i])
		{
			mm=b[i];
			ind=i;
		}
	}
	cout<<"\n\nThe Highest Total Marks is "<<mm<<",and is obtained by Roll No.:"<<a[ind][0];

	getch();
}