#include<stdio.h>
#include<conio.h>

void main()
{

    int level,gross,basic,ent,all,no;
    float house,tax,sal;

    printf("\nEnter the Employee Number of the employee:");
    scanf("%d", &no);
    printf("\nEnter the level of the employee:");
    scanf("%d", &level);
    printf("\nEnter the Basic Salary of the employee:");
    scanf("%d", &basic);

    if(level==1)
    {
        ent=500;
        all=1000;
    }

    else if(level==2)
    {
        ent=200;
        all=750;
    }

    else if(level==3)
    {
        ent=100;
        all=500;
    }

    else
    {
        ent=0;
        all=250;
    }

    house=0.25*basic;
    gross=basic+house+ent+all;

    if(gross<=2000)
    {
        tax=0;
    }

    else if(gross>2000&&gross<=4000)
    {
        tax=0.03*gross;
    }

    else if(gross>4000&&gross<=5000)
    {
        tax=0.05*gross;
    }

    else
    {
        tax=0.08*gross;
    }

    sal=gross-tax;

    printf("\nThe salary of the employee is:%f", sal);

    getch();


}
