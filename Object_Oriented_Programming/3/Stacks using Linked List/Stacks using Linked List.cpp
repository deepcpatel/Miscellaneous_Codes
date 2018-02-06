#include<iostream>
#include<conio.h>
#include<stdlib.h>


using namespace std;

class node                          //class node to create nodes
{
    public:
	int info;
	node* next;
} *start,*newptr,*save,*ptr;            //pointers declared

node* Create_New_Node(int);             //function definition to create new node
void insertbeg(node*);                  //function definition to insert node in the stacks
void Display(node*);                    //function to display the stacks element
void dt(node*);                         //function to delete stacks element


int main()                      //main function
{
	start=NULL;
	int inf, rollno,ans;
	char n[20];
	char ch='y';
	while(ch=='y' || ch=='Y')
	{
	    x:
        system("cls");
        cout<<"\n                    Welcome to the Stacks Implementation Program\n\n";
        cout<<"\nChoose from the following:";
        cout<<"\n1).To Push an element in stack";
        cout<<"\n2).To Pop an element from stack";
        cout<<"\n3).To display the stack";
        cout<<"\n4).Exit";
        cout<<"\nEnter:";
        cin>>ans;

        switch(ans)
        {
            case 1:cout<<"\n\nEnter the Element:";
                   cin>>inf;

                   newptr=Create_New_Node(inf);

                   if(newptr!=NULL)
                   {
                        cout<<"\nNew Element is Successfully Pushed in Stack, Press Enter";
                        getch();
                   }

                   else
                   {
                        cout<<"Unsuccessful in Pushing the Element into the Stack, Press Enter"<<endl;
                        getch();
                        goto x;
                   }



                   insertbeg(newptr);
                   break;

            case 2:dt(start);
                   getch();

                   break;

            case 3:if(start==NULL)
                   {
                        cout<<"\n\nStack is Empty!";
                        goto z;
                   }

                   cout<<"\n\nNow the list is \n";
                   Display(start);

                   break;


            case 4:cout<<"\n\nBye..\n";
                   goto y;

                   break;

            default:cout<<"\nSorry invalid choice..Try again, Press Enter";
                    getch();
                    goto x;

                    break;



        }
        z:

        cout<<"\n\nPress Y continue, N to exit...:";
		cin>>ch;

		if(ch=='n'||ch=='N')
        {
            cout<<"\n\nBye..\n";
            getch();
        }
	}
	y:
	return 0;
}

node* Create_New_Node(int n)                    //function bodies
{
  ptr=new node;
  ptr->info=n;
  ptr->next=NULL;
  return ptr;
}

void insertbeg(node*np)                         //function bodies
{
	if(start==NULL)
	start=np;

	else
	{
		save=start;
		start=np;
		np->next=save;
	}
}

void Display(node*np)                   //function bodies
{
	while(np!=NULL)
	{
		cout<<" ->"<<np->info;
		np=np->next;
	}
	cout<<"\n";
}

void dt(node*np)                    //function bodies
{
    start=np;
    if(start==NULL)
    {
        cout<<"\nNo Element Exists to be Popped, Press Enter";
    }
    else
    {
        start=start->next;
        cout<<"\nElement Popped Successfully, Press Enter";
    }

}
