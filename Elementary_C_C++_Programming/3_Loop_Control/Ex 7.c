#include<stdio.h>
#include<conio.h>

void main()
{
    int i;
    float population=100000.0,pop;

    for(i=1; i<=10;i++)
    {
        pop=population+0.1*population;

        printf("\nThe population of the town in the %dth year is:%.2f", i,pop);

        population=pop;
    }
    getch();

}
