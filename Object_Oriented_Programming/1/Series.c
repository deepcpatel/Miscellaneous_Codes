#include<conio.h>
#include<stdio.h>

void main()
{

        unsigned long n=124398043,i;
        int  a=1, b=2;
        //printf("\nEnter the Value of the n:");
        //scanf("%d", &n);

        for(i=1; i<n+1; i++)
        {
            if(i%2!=0)
            {
                a=a+b;


            }

            else
            {

                b=b-a;


            }
        }

           if(i%2!=0)
            {
                printf("\nThe nth term is:%d", a);

            }

            else
            {
                printf("\nThe nth term is:%d", b);
            }
        getch();
}
