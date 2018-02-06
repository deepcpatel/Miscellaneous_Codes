#include<stdio.h>
#include<conio.h>

void main()
{
    int i,n,g=0;
    float num,maxi=0.0,x=0.0,mini=x;

    printf("\nEnter the size of the set:");
    scanf("%d", &n);

    printf("\nNow Enter the Numbers:");
    if(n!=1)
    {
        for(i=0;i<n;i++)
        {
            printf("\n");
            scanf("%f", &num);
            if(mini==0 && g==0)
            {
                mini=num;
                g++;
            }

            if(maxi<num)
            {
                maxi=num;
            }

            if(mini>num)
            {
                mini=num;
            }
        }

        printf("\nThe range of the set is %f:", maxi-mini);
    }

    else
    {
            printf("\nSorry no Output.........");
    }

    getch();
}
