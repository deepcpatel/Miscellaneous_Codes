/*Apex Bank Services Program to Manage Bank Accounts*/

#include<iostream>          //for input/output options
#include<stdio.h>           //standard input output library
#include<stdlib.h>          //to clear screen
#include<string.h>          //for string functions
#include<conio.h>           //for getch() function


using namespace std;

int z=0;

class account                  //Class account declared with its suitable member variables
{
    unsigned int account_number;
    int balance;
    char type[10];
    char customer_name[25];
    char customer_address[55];
    char branch_name[20];
    char branch_address[55];

public:

    account();                   //function decelerations-Here constructor

    void takeAcno(int);            //function to take account number separately

    void getDetail();              //function to get details from the user

    void updateDetail();          //function to update details from the user

    void putDetail();           //function to print the details from the user

    void balanceUpdate();       //function to update balance

    unsigned int getacno()      //function to return the account number for future use in this program
    {
        return account_number;
    }

    ~account()                  //destructor
    {

    }


};

account::account()   //Constructor
{
    account_number=0;
    balance=0;
    type[0]='\0';
    customer_name[0]='\0';
    customer_address[0]='\0';
    branch_name[0]='\0';
    branch_address[0]='\0';


}

void account::balanceUpdate()
{
    int i,amount;

   a:
    cout<<"\nEnter your Choice:";
    cout<<"\n\n1).To Withdraw";
    cout<<"\n2).To Deposit";
    cout<<"\nEnter:";
    cin>>i;

    switch(i)
    {
        case 1: cout<<"\nEnter the amount to withdraw:Rs.";
                cin>>amount;

                if((balance-amount)<0)
                {
                    cout<<"\nSorry!you don't have Enough balance to withdraw..";
                    cout<<"\nYour current balance is:Rs."<<balance;
                }

                else
                {
                    balance=balance-amount;
                    cout<<"\nYour New Balance is:Rs."<<balance;

                }
                break;

        case 2: cout<<"\nEnter the amount to deposit:Rs.";
                cin>>amount;

                balance=balance+amount;

                cout<<"\nYour Current balance is:Rs."<<balance;

                break;

        default: cout<<"\nInvalid Choice...Enter Again:";
                      goto a;

    }
}

void account::takeAcno(int a)                   //function to take account no separately
{
    account_number=a;
}

void account::getDetail()                           //function to get details from the user
{

    cout<<"\nEnter the account holder's Name:";
    gets(customer_name);
    gets(customer_name);


    cout<<"\nEnter the Address(char):";
    gets(customer_address);

    cout<<"\nEnter the Branch name(char):";
    gets(branch_name);

    cout<<"\nEnter the Branch Address(char):";
    gets(branch_address);

    cout<<"\nEnter the Account Balance(int):";
    cin>>balance;

    cout<<"\nEnter the Account type(char):";
    gets(type);
    gets(type);

}

void account::updateDetail()                           //function to get details from the user
{

    cout<<"\nEnter the account holder's Name:";
    gets(customer_name);
    gets(customer_name);


    cout<<"\nEnter the Address(char):";
    gets(customer_address);

    cout<<"\nEnter the Branch name(char):";
    gets(branch_name);

    cout<<"\nEnter the Branch Address(char):";
    gets(branch_address);

    cout<<"\nEnter the Account type(char):";
    gets(type);

}

void account::putDetail()     //Function to print the given user's details
{

    cout<<"\nThe Account Number is:"<<account_number;
    cout<<"\nThe Account holder's name is:"<<customer_name;
    cout<<"\nThe Address of the Customer is:"<<customer_address;
    cout<<"\nThe Branch of the Customer's Bank is:"<<branch_name;
    cout<<"\nThe Address of the Bank Branch of the Customer is:"<<branch_address;
    cout<<"\nThe Account type of the Customer's Account is:"<<type;
    cout<<"\nThe Balance in the Customer's Account is Rs."<<balance;

}

class node                      //class node to implement linked list
{
  public:
  class account ac;
  node*next;
}*start=NULL,*save,*newptr,*ptr,*cpy,*found, *ptr1, *star;


node* createNode(account a)         //function to create a new node(account)
{
    ptr=new node;
    ptr->ac=a;
    ptr->next=NULL;
    return ptr;
}

void insertbeg(node* np)            //function to insert a node in the linked list
{
    if(start==NULL)
    {
        start=np;
    }

    else
    {
        save=start;
        start=np;
        np->next=save;

    }
}

node*searchNode(unsigned int a)             //function to search account
{
        cpy=start;

        while(cpy!=NULL)
        {

            if(cpy->ac.getacno()==a)
            {

                    return cpy;

            }

            cpy=cpy->next;


        }

        return NULL;

}


void dt(node*np)                    //function to delete account
{
    class account acc;
    np->ac=acc;
    np->ac.takeAcno(--z);
}



int main()                         //starting of the main function
{
     class node *ptr2;       //pointers of node structure is declared to implement linked list

     int i=0,j,k,resp,m,l,p,an,q=0;       //variables declared and some of them are initialized

     unsigned int acno;

     char ans='y',username[50],pass[20];

     class account acnt;

  o:
     system("cls");

     cout<<"\nEnter your Username:"; //command to enter the username
     gets(username);

     cout<<"\nEnter your Password:"; //command to enter the password(Password:-password)
     gets(pass);

     if(strcmp(pass,"password")!=0)                    //condition statement to check whether the password is right or wrong
     {   q++;

         if(q!=3)
         {
              cout<<"\n\nSorry you entered wrong Password, try again\n";
              getch();

              goto o;
         }

        else
        {
            cout<<"\n\nSorry, you entered wrong password for all attempts, bye..."<<endl;
            goto x;
        }



     }


     do                                             //do-while loop to simulate menu driven program
     {
         system("cls");                             //clear screen command

         cout<<"\nCurrent User:"<<username<<"\n";

         cout<<"\n                        Welcome to the Apex Bank Services LLC\n";   //welcome page
         cout<<"\nPress the Number:-";                                                //menu
         cout<<"\n1).Add new account";
         cout<<"\n2).Update the existing account";
         cout<<"\n3).To delete an account";
         cout<<"\n4).To view details of the account";
         cout<<"\n5).Exit";
         cout<<"\n\nChoose:";

         cin>>resp;                                                 //scans user's response
         switch(resp)                                               //switch case to do actions according to user's choice
         {
             case 1:

                beg:
                    if(i==0)
                    {
                        cout<<"\nEnter client's Account Number(int):";
                        cin>>acno;
                        acnt.takeAcno(acno);
                        acnt.getDetail();

                        newptr=createNode(acnt);
                        insertbeg(newptr);

                        cout<<"\nAccount Successfully Created..";
                        getch();

                        i++;

                    }

                    else
                    {
                        cout<<"\nEnter client's Account Number(int):";
                        cin>>acno;

                        ptr2=searchNode(acno);

                        if(ptr2!=NULL)
                        {
                            cout<<"\n\nSorry the account with same Account Number already exist";
                            cout<<"\n\nTry with another account number";
                            getch();
                            goto beg;

                        }

                        acnt.takeAcno(acno);
                        acnt.getDetail();

                        newptr=createNode(acnt);
                        insertbeg(newptr);

                        cout<<"\nAccount Successfully Created..";
                        getch();
                    }


                     break;

            case 2: cout<<"\nEnter the Account number to be Updated:";  //commands to update account details
                    cin>>acno;                                          //command to enter account number



                    ptr2=searchNode(acno);


                    if(ptr2!=NULL)
                    {
                        z:

                            cout<<"\nEnter your Choice:-";
                            cout<<"\n\n1).To Update account Details";
                            cout<<"\n2).To Update Balance";
                            cout<<"\nEnter:";
                            cin>>an;
                            switch(an)
                            {
                               case 1:ptr2->ac.getDetail();                          //calling getDetail()to update account details
                                      cout<<"\n\nAccount details updated successfully\n";
                                      getch();

                                      break;

                               case 2:ptr2->ac.balanceUpdate();                      //calling balanceUpdate() to update account balance
                                      cout<<"\n\nAccount balance updated successfully\n";
                                      getch();

                                      break;

                               default: cout<<"\nInvalid Choice choose again:";
                                             goto z;
                            }
                    }

                    else
                    {
                             cout<<"\nSorry! no such Account with given Account number found:-(";


                    }


                     break;

            case 3: cout<<"\nEnter the Account number to be Deleted:";              //commands to delete desired
                    cin>>acno;                                                      //account from bank

                    p=0;

                    found=searchNode(acno);

                    if(found!=NULL)
                    {

                                p=1;            //counter variable
                                dt(found);
                                cout<<"\nThe Account is Deleted";  //feedback in case of account is deleted
                    }

                    else                             //condition when no response is matched
                    {
                        cout<<"\nSorry! no such Account with given Account number found:-(";
                    }

                    break;

            case 4: cout<<"\nEnter the Account Number whose Details you want to watch:"; //program to see account details
                    cin>>acno;

                    ptr2=searchNode(acno);


                    if(ptr2!=NULL)
                    {

                           ptr2->ac.putDetail();



                    }

                    else
                    {
                             cout<<"\nSorry! no such Account with given Account number found:-(";


                    }


                    break;

            case 5: cout<<"\n\nThank you for Using Our Account Management Service. Meet you Soon......\n";
                    goto x;                                                                  //to exit without doing anything

                    break;

            default: cout<<"\nSorry! your Choice matches neither of the option given:-(\n"; //default case

                     break;



         }


          cout<<"\n\nDo you want to choose more options(y/n)?-";   //request if user want to enter more
          cin>>ans;

          if(ans=='n'||ans=='N')
          {
              cout<<"\n\nThank you for Using Our Account Management Service. Meet you Soon......\n"; //greetings
          }



      }while(ans=='y'||ans=='Y');


    x:

        return 0;           //exit

}




