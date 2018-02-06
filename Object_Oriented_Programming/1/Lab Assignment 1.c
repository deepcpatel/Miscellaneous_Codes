/*Apex Bank Services Program to Manage Bank Accounts*/

#include<stdio.h>           //for input/output options
#include<conio.h>           //for getch()
#include<stdlib.h>          //to clear screen

struct customer                  //Structure customer declared with its suitable variables
{
    char customer_name[25];
    char customer_address[55];

};

struct branch                    //Structure branch declared with its suitable member variables
{
     char branch_name[20];
     char branch_address[55];

};

struct account                  //Structure account declared with its suitable member variables
{
    unsigned int account_number;
    int balance;
    char type[10];
    struct customer c;         //a structure object c of customer declared for future use
    struct branch b;           //a structure object b of branch declared for future use

};


void main()                         //starting of the main function
{
     struct account ac[100];        //object of the structure account is declared to initialize the accounts
     int i=0,j,k,resp,m,l,p,pass;   //variables declared and some of them are initialized
     unsigned int acno;
     char ans='y',username[50];

     printf("\nEnter your Username:"); //command to enter the username
     scanf("%s", &username);

     printf("\nEnter your Password:"); //command to enter the password(Password:-12345)
     scanf("%d", &pass);

     if(pass!=12345)                    //condition statement to check whether the password is right or wrong
     {
         printf("\nSorry Wrong Password:-)\n");
         goto x;

     }

     system("cls");

     printf("\nCurrent User:%s\n", username);

     do                                             //do-while loop to simulate menu driven program
     {

         printf("\n                        Welcome to the Apex Bank Services LLC\n");   //welcome page
         printf("\nPress the Number:-");                                                //menu
         printf("\n1).Add new account");
         printf("\n2).Update the existing account");
         printf("\n3).To delete an account");
         printf("\n4).To view details of the account");
         printf("\n5).Exit");
         printf("\n\nChoose:");

         scanf("%d", &resp);                                        //scans user's response
         switch(resp)                                               //switch case to do actions according to user's choice
         {
             case 1: printf("\nEnter the Account Number(int):");    //commands to enter the customer's details in structure
                     scanf("%d", &ac[i].account_number);

                     printf("\nEnter the Name:");
                     scanf("%s", &ac[i].c.customer_name);

                     printf("\nEnter the Address(char):");
                     scanf("%s", &ac[i].c.customer_address);

                     printf("\nEnter the Branch name(char):");
                     scanf("%s", &ac[i].b.branch_name);

                     printf("\nEnter the Branch Address(char):");
                     scanf("%s", &ac[i].b.branch_address);

                     printf("\nEnter the Account Balance(int):");
                     scanf("%d", &ac[i].balance);

                     printf("\nEnter the Account type(char):");
                     scanf("%s", &ac[i].type);

                     i++;                                           //every time i increments different accounts are made

                     break;

            case 2: printf("\nEnter the Account number to be Updated:");  //commands to update account details
                    scanf("%d", &acno);                                   //command to enter account number

                    l=0;

                    for(j=0;j<i;j++)                                      //loop to find desired account searching
                    {                                                     //by account number
                        if(ac[j].account_number==acno)
                        {

                            printf("\nEnter the Name(char):");
                            scanf("%s", &ac[j].c.customer_name);

                            printf("\nEnter the Address(char):");
                            scanf("%s", &ac[j].c.customer_address);

                            printf("\nEnter the Branch name(char):");
                            scanf("%s", &ac[j].b.branch_name);

                            printf("\nEnter the Branch Address(char):");
                            scanf("%s", &ac[j].b.branch_address);

                            printf("\nEnter the Account Balance(int):");
                            scanf("%d", &ac[j].balance);

                            printf("\nEnter the Account type(char):");
                            scanf("%s", &ac[j].type);

                            l=1;

                        }


                    }

                    if(l==0)                                        //condition in case of no account number
                    {                                               //matches to the entered number
                        printf("\nSorry! no such Account with given Account number found:-(");
                    }

                    break;

            case 3: printf("\nEnter the Account number to be Deleted:");              //commands to delete desired
                    scanf("%d", &acno);                                               //account from bank

                    p=0;

                    for(j=0;j<i;j++)                                      //in case of deletion the account to be deleted
                    {                                                     //is overwritten by its next account details and its
                        if(ac[j].account_number==acno)                    //next account is over written by its next account
                        {
                            p=1; //counter variable

                            for(k=j;k<i-1;k++)
                            {
                                ac[k]=ac[k+1];
                            }
                            i--;                                         //and finally a account is decreased
                        }
                    }

                    if(p==0)                                       //condition when no response is matched
                    {
                        printf("\nSorry! no such Account with given Account number found:-(");
                    }

                    else
                    {

                        printf("\nThe Account is Deleted");  //feedback in case of account is deleted

                    }


                    break;

            case 4: printf("\nEnter the Account Number whose Details you want to watch:"); //program to see account details
                    scanf("%d", &acno);

                    m=0;

                    for(j=0;j<i;j++)
                    {
                        if(ac[j].account_number==acno)                  //program to find account with entered account no.
                        {
                            printf("\nThe Account Number is:%d", ac[j].account_number);
                            printf("\nThe Account holder's name is:%s", ac[j].c.customer_name);
                            printf("\nAddress of the Customer is:%s", ac[j].c.customer_address);
                            printf("\nThe Branch of the Customer's Bank is:%s", ac[j].b.branch_name);
                            printf("\nThe Address of the Bank Branch of the Customer is:%s", ac[j].b.branch_address);
                            printf("\nThe Account type of the Customer's Account is:%s", ac[j].type);
                            printf("\nThe Balance in the Customer's Account is Rs. %d", ac[j].balance);

                            m=1;

                        }

                    }

                    if(m==0)
                        {
                            printf("\nSorry! no such Account with given Account number found:-("); //in case of no account found
                        }

                    break;

            case 5: goto x;   //to exit without doing anything
                    break;

            default: printf("\nSorry! your Choice matches neither of the option given:-(\n"); //default case

                     break;



         }


          printf("\nDo you want to choose more options(y/n)?-"); //request if user want to enter more
          scanf(" %c", &ans);

          if(ans=='n'||ans=='N')
          {
              printf("\nThank you for Using Our Account Management Service. Meet you Soon......\n"); //greetings
          }



      }while(ans=='y'||ans=='Y');


    x:

        getch();  //getch()



}
