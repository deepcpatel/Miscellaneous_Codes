#include<iostream.h>
#include<conio.h>

int cmp( int *x, int *y)
{
	if(*x==*y)
	{
		return 1;
	}

	else
	{
		return 0;
	}
}

void main()
{
	clrscr();

	int a,b,ans;

	cout<<"\nEnter a:";
	cin>>a;

	cout<<"\nEnter b:";
	cin>>b;

	ans=cmp(&a,&b);

	cout<<"\nThe Output is:"<<ans;
	getch();
}