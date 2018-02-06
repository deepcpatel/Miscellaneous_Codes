#include<stdio.h>

void main()
{
    int a,b,c,clas;
    printf("\nEnter the class got by student:");
    scanf("%d", &clas);
    printf("\nEnter the subjects failed by the student:");
    scanf("%d", &a);
    switch(clas)
    {
        case 1:
            if(a>3)
            {
                printf("\nSorry no grace");
            }
            else
            {
                printf("\nGot grace as 5 marks in all failed subject");
            }
            break;
        case 2:
            if(a>2)
            {
                printf("\nSorry no grace");
            }
            else
            {
                printf("\nGot grace as 5 marks in all failed subject");
            }
            break;

        case 3:
            if(a>1)
            {
                printf("\nSorry no grace");
            }
            else
            {
                printf("\nGot grace as 5 marks in all failed subject");
            }
            break;

    }
    getch();


}
