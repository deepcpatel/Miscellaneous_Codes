#include<stdio.h>
#include<conio.h>

void main()
{

        int i,credit,order,stock=1000,price=30,cust;
        printf("\nEnter the customer to be served:");
        scanf("%d", &cust);

        for(i=0;i<cust;i++)
        {
            printf("\nEnter the quantity of stock customer want:");
            scanf("%d", &order);
            printf("\nEnter the credit with customer:");
            scanf("%d", &credit);

            if(order<=stock&&credit>=(order*price))
            {
                    printf("\nOrder Supplied\n");
                    stock-=order;
            }

            else if(order<=stock&&credit<(order*price))
            {
                printf("\nSorry order not supplied your credit is low than required\n");
            }

            else if(order>=stock&&credit>=(order*price))
            {
                    printf("\nYou have been supplied with stock= %d", stock);
                    printf(", The remaining %d", order-stock);
                    printf(" stock will be supplied later\n");
                    stock=0;
            }

            else if(order>=stock&&credit<(order*price))
            {
                    printf("\nSorry order not supplied your credit is low than required\n");
            }



        }
        getch();
}
