#include<stdio.h>
#include<conio.h>

void main()
{
   int a,b,c,d;

   printf("\nEnter the Number that you want to reverse:");
   scanf("%d", &a);

   printf("\nThe reversed Number is:");

   do
   {
       printf("%d", a%10);
       a=a/10;
   }while(a!=0);
   getch();

}
