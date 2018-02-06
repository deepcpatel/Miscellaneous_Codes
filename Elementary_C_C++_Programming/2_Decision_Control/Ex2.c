#include<stdio.h>
#include<conio.h>

void main()
{
    int math,phy,chem,total,mp;
    printf("\nEnter the marks in Mathematics:");
    scanf("%d", &math);
    printf("\nEnter the marks in Chemistry:");
    scanf("%d", &chem);
    printf("\nEnter the marks in Physics:");
    scanf("%d", &phy);
    total=math+phy+chem;
    mp=math+phy;

    if((math>=60&&phy>=50&&chem>=40)&&(total>=200||mp>=150))
    {
        printf("\nThe Candidate is elegible :-)");

    }

    else
    {
        printf("\nThe Candidate is inelegible :-(");

    }
    getch();
}
