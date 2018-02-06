#include<stdio.h>
#include<conio.h>

void main()
{
    float hrs;
     printf("\nEnter the no of hour the employ worked:");
     scanf("%f", &hrs);

    if(hrs>=2&&hrs<3)
    {
        printf("\nHighly Efficient");
    }
    else if(hrs>=3&&hrs<4)
    {
        printf("\nImprove Speed");
    }
    else if(hrs>=4&&hrs<5)
    {
        printf("\nYou will given training");
    }
    if(hrs>=5)
    {
        printf("\nYou are fired");
    }

    getch();
}





