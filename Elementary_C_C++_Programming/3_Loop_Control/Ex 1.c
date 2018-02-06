#include<stdio.h>
#include<conio.h>

void main()
{
	int i=1,num=0,m,a=0,n;

	printf("\nEnter the 'm' till which you want to run Fibonacii Series:");
	scanf("%d", &m);
    
    if(m==0)
    {
        printf("\nSorry no Number printed so go for 1");
    }
    
    else
    {
        do
        {
    		printf("\n%d", i);
    		n=i;
    		i=i+num;
    		num=n;
    		a++;
        }while(a!=m);
    }

    getch();

}
