#include<iostream>
#include<conio.h>
#include<stdlib.h>

using namespace std;

class queue                         //class queue is declared
{
    int *q;                         //data members
    int size;
    int head;
    int tail;

  public:

    queue(int s)                    //argument constructor taking size of queue as the argument
    {
        head=-1;
        tail=-1;
        size=s;
        q=new int[s];
        cout<<"\nNew Queue is Created...Press Enter\n";
    }

    void operator +(int);                           //function definitions

    int* operator --();

    friend ostream& operator <<(ostream&,queue);
    friend int check(queue);

};

void queue:: operator +(int i)              // operator overloading function declaration
                                            //to push an element in queue
{                                           //taking an element to push as argument

    if(tail==size-1)
    {

        cout<<"\nQueue is full, First Delete the Element........\n";

    }
    else
    {
        tail=tail+1;
        q[tail]=i;

        cout<<"\nThe Element is Pushed\n";
    }


}

int check(queue q1)                             //function to check whether the queue is full or not
{
    if(q1.tail==q1.size-1)
    {
        return 1;
    }

    else
     return 0;
}
int* queue::operator --()                   //function to pop an element from the
                                            //queue and returning the address of that element
{
    if(tail==-1)
    {
        return NULL;
    }

    else
    {
        int take;

        head=head+1;
        take=head;


        if(head==tail)
        {
            take=head;

            head=-1;
            tail=-1;
        }

        return &q[take];

    }
}

ostream& operator <<(ostream& out, queue q1)            //function to display the queue
{
    int i;
    if(q1.tail==-1)
    {
        out<<"\nQueue is Empty, First add something.....\n";
        return out;
    }

    else
    {
        out<<"\nThe Queue Elements are:-\n";
        for(i=q1.head+1;i<=q1.tail;i++)
        {
            out<<"->";
            out<<q1.q[i];
        }

        return out;

    }

}




int main()          //main function
{
    int length, element, input, a,*take;
    char ans='y';

    cout<<"\nEnter the Size of the Queue:";
    cin>>length;

    queue q(length);                //creating the object of queue class
    getch();

    while(ans=='y'||ans=='Y')               //menu driven program
    {
        system("cls");

        cout<<"\nEnter from the choice Below:-";
        cout<<"\n1).Push an element in the Queue";
        cout<<"\n2).Pop an element from the Queue";
        cout<<"\n3).Show the Queue";
        cout<<"\n4).Exit";
        cout<<"\nEnter:";
        cin>>input;

        switch(input)
        {
            case 1: a=check(q);

                    if(a==1)
                    {
                        cout<<"\nQueue is Full, First delete some element.....";
                    }


                    else
                    {
                        cout<<"\nEnter the Element to be pushed:";
                        cin>>element;

                        q+element;

                    }

                    break;

            case 2: take=--q;

                    if(take==NULL)
                    {
                        cout<<"\nQueue is Empty, First add something.....\n";
                    }

                    else
                    {
                        cout<<"\n"<<*take<<" Element is popped";
                    }


                    break;

            case 3: cout<<q;
                    break;

            default:goto a;

                    break;

        }

        cout<<"\n\nDo you want to continue(y/n):";
        cin>>ans;
    }



a:
    delete &q;                                  //statement to delete the object at the end
    cout<<"\nBye, Have a Nice Day.......\n";
    getch();

    return 0;
}
