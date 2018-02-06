#include<stdio.h>
#include<conio.h>

void main()
{
    int i,a,b,c,d,e,f,num;
    printf("\nEnter from where you want to see Armstrong Numbers:");
    scanf("%d", &a);

    printf("\nEnter till where you want to see Armstrong Numbers:");
    scanf("%d", &b);

    printf("\nThe Armstrong numbers from %d to %d are:", a,b);

    for(i=a;i<b;i++)
    {
        int sum=0;
        num=i;
        do
        {
            a=i%10;
            i=i/10;
            sum=sum+(a*a*a);

        }while(i!=0);

        i=num;
        if(sum==i)
        {
            printf("\n%d", i);
        }

    }
    getch();

}
