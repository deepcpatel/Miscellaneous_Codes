#include<stdio.h>
#include<conio.h>

void main()
{

    int pos=0, zero=0, neg=0;
    char ch;
    float a;
    do
    {
        printf("\nEnter the Number you want to enter:");
        scanf("%f", &a);

        if(a<0)
        {
            neg++;
        }

        else if(a>0)
        {
            pos++;
        }

        else
        {
            zero++;
        }

        printf("\nWant to enter more ?(y/n)");
        scanf(" %c", &ch);
    }while(ch=='y'||ch=='Y' );

    printf("\n You %d Positive Numbers, %d Zeroes and %d Negative Numbers", pos,zero,neg);

    getch();
}
