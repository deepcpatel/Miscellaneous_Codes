#include<stdio.h>

void main()
{
    char ch;
    printf("\nEnter the character:");
    scanf("%c", &ch);

    if(ch>=65&&ch<=90)
    {
        printf("\nThe Character is a Capital Alphabet");
    }
    else if(ch>=97&&ch<=122)
    {
        printf("\nThe Character is Small Alphabet");
    }
    else if(ch>=48&&ch<=57)
    {
        printf("\nThe Character is a Digit");
    }
    else
    {
        printf("\nThe Character is Special Symbols");
    }
    getch();
}
