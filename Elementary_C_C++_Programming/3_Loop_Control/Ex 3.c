#include<stdio.h>
#include<conio.h>

void main()
{
    int i,a,n;
    float y=1.0,x;

    printf("\nEnter the Base 'x':");
    scanf("%f", &x);

    printf("\nEnter the Power 'n':");
    scanf("%d", &n);

    printf("\nThe term Y=x^n is:");

    for(i=0; i<n; i++)
    {
        y=y*x;
    }

    printf("%f", y);

    getch();
}

