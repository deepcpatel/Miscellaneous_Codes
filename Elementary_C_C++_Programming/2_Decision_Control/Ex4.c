#include<stdio.h>
#include<conio.h>


void main()
{
    float price,sum=0,c;
    int fed,quan,i;
     printf("\nEnter the no. of the item you want to buy:");
     scanf("%d", &fed);

    for(i=0; i<fed; i++)
    {
        printf("\nEnter the price of the item per piece:");
        scanf("%f", &price);
        printf("\nEnter the quantity:");
        scanf("%d", &quan);
        sum+=price*quan;
    }

    if(sum>1000)
    {
        c=sum*0.1;
        sum=sum-(sum*0.1);
        printf("\nYour total billing amount is:");
        printf("%f", sum);
        printf(" after ");
        printf("%f%", c);
        printf(" discount");
        printf("\nBye");
    }

    else
    {
      printf("\nYour total billing amount is:");
      printf("%f", sum);
    }
    getch();
}
