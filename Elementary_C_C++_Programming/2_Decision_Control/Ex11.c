#include<stdio.h>

void main()
{
    char c[50];
    float units,charge,cost;
    int a,b,d,meter=100;
    printf("\nEnter the name of the user:");
    scanf("%s", &c);
    printf("\nEnter the units consumed by user:");
    scanf("%f", &units);

    if(units<=200)
    {
        charge=units*0.80;
    }
    else if(units<=300)
    {
        charge=200*0.8+(units-200)*0.90;
    }
    else
    {
        charge=(units-300)*1+200*0.8+100*0.9;
    }

    cost=charge+meter;

    if(cost>400)
    {
        cost=cost+(cost*0.15);
    }

    printf("\n%s", c);
    printf(" Your total charge is:%f", cost);

    getch();


}
