#include<stdio.h>
#include<conio.h>

float fact(float n)
{
    float i,x=1;
    for(i=n;i>0.0;i--)
    {
        x=x*i;
    }
    return x;
}

void main()
{
    float i,sum=0.0;

    for(i=1;i<=7;i++)
    {
            sum=sum+(i/fact(i));
            //printf("\n%.0f", fact(i));
    }

    printf("\n\nThe sum of the series is:%f", sum);

    getch();

}
