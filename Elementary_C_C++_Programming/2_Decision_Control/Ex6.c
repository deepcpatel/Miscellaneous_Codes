#include<stdio.h>
#include<conio.h>

void main()
{
    float hrs;
     printf("\nEnter the no of days the person gave the book late:");
     scanf("%f", &hrs);

    if(hrs>1&&hrs<=5)
    {
        printf("\nFine is 50 Paisa");
    }
    else if(hrs>5&&hrs<=10)
    {
        printf("\nFine is 5 Rupees");
    }
    else if(hrs>10&&hrs<=30)
    {
        printf("\nFine is 10 Rupees");
    }
    if(hrs>30)
    {
        printf("\nMembership Cancelled");
    }

    getch();
}

