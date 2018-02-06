#include<stdio.h>
#include<conio.h>

void main()
{

    int a,b,c;
    float A, B;
    printf("\nEnter the marks in Subject A out of 100:");
    scanf("%d", &a);
    printf("\nEnter the marks in Subject B out of 70:");
    scanf("%d", &b);

    A=a;
    B=b*100/70;

    if((A>=55&&B>=45)||((A>=45&&A<=55)&&B>=55))
    {
        printf("\nCongratulations you are awarded a B.Tech degree");
    }
    else if(A>=65&&B<=45)
    {
        printf("\nYou have to reappear in Exam B");
    }
    else
    {
            printf("\nYou are Failed");

    }
    getch();
}






