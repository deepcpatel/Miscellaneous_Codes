#include<stdio.h>
#include<conio.h>

void main()
{
    int i,num;

    printf("\nEnter the Number for whom you want to see Multiplication Table:");
    scanf("%d", &num);

    for(i=1;i<=10;i++)
    {
        printf("\n%d x %d = %d", num,i,num*i);
    }

    getch();
}
