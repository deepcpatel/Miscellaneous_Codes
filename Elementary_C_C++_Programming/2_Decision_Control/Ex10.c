#include<stdio.h>

void main()
{
    float a,b,c;
    int clas;
    printf("\nWe have following products:-");
    printf("\n(1).Mill Cloth");
    printf("\n(2).Handloom Items");
    printf("\nEnter the item number:");

    scanf("%d", &clas);
    printf("\nEnter the purchase amount:");
    scanf("%f", &a);
    switch(clas)
    {
        case 1:
            if(a>0&&a<=100)
            {
                printf("\nYou have to pay Rupees:%f", a );
            }
            else if(a>100&&a<=200)
            {
                printf("\nYou have to pay Rupees:%f", a-(a*0.05) );
            }
            else if(a>200&&a<=300)
            {
                printf("\nYou have to pay Rupees:%f", a-(a*0.075) );
            }
            else
            {
                printf("\nYou have to pay Rupees:%f", a-(a*0.1) );
            }

           break;

        case 2:
            if(a>0&&a<=100)
            {
                printf("\nYou have to pay Rupees:%f", a-(a*0.05) );
            }
            else if(a>100&&a<=200)
            {
                printf("\nYou have to pay Rupees:%f", a-(a*0.075) );
            }
            else if(a>200&&a<=300)
            {
                printf("\nYou have to pay Rupees:%f", a-(a*0.1) );
            }
            else
            {
                printf("\nYou have to pay Rupees:%f", a-(a*0.15) );
            }

            break;


        default:
             printf("\nSorry...we dont have this");

            break;
    }
    getch();


}
