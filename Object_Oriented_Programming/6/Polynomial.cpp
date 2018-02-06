#include<iostream>
#include<conio.h>
#include<stdlib.h>

using namespace std;

class Polynomial        //Class Polynomial
{
  private:
      float* coefficient;       //Variable Declaration
      float* degree;
      int no;


  public:

      Polynomial(int);                      //Constructor Definition

      void add();                           //Function Declaration

      void sorting();

      int totalterms(Polynomial);

      int totalterms();

      Polynomial operator +(Polynomial);

      Polynomial operator *(int);

      Polynomial operator -();

      friend void operator >>(std::istream &,Polynomial&);

      friend ostream& operator <<(std::ostream &,Polynomial);

};

Polynomial::Polynomial(int n)                       //Construction
{
    no=n;
    coefficient=new float[no];
    degree=new float[no];
}

void Polynomial::add()                          //Function to enter the elements in the Polynomial
{
    int i;
    for(i=0;i<no;i++)
    {
        cout<<"\nEnter the "<<i<<" term's Coefficient:";
        cin>>coefficient[i];

        cout<<"\nEnter the "<<i<<" term's Degree:";
        cin>>degree[i];

    }
}

void Polynomial::sorting()                  //Function to Arrange the Polynomial in proper Sequence
{
    int j,k,temp=0;

    for(j=0;j<no;j++)
    {
        for(k=no-1;k>0;k--)
        {
            if(degree[k]>degree[k-1])
            {
                temp=degree[k];
                degree[k]=degree[k-1];
                degree[k-1]=temp;

                temp=coefficient[k];
                coefficient[k]=coefficient[k-1];
                coefficient[k-1]=temp;
            }
        }
    }
}

int Polynomial::totalterms()                        //Function to return the total terms of the two array
{
    return no;
}

int Polynomial::totalterms(Polynomial p1)
{
    Polynomial p2(p1.no+no);

    int j=p1.no+no,i,k,cnt=0;

    for(i=0;i<no;i++)
    {
        p2.degree[i]=degree[i];
    }

    for(i=0;i<p1.no;i++)
    {
        p2.degree[no+i]=p1.degree[i];
    }

    for(i=0;i<j;i++)
    {
        for(k=0;k<j;k++)
        {
            if(p2.degree[i]==p2.degree[k])
            {
                if(k!=i)
                {
                    p2.degree[k]=(0-20716);
                }
            }
        }
    }

    for(i=0;i<j;i++)
    {
            if(p2.degree[i]!=(-20716))
            {
                cnt++;
            }
    }

    return cnt;

}

ostream& operator <<(std::ostream & out,Polynomial p1)              //Operator overloading of << Operator
{
    int i;
    cout<<"\nThe Polynomial is:";
    for(i=0;i<p1.no;i++)
    {
        if(i!=0)
        {
            out<<"+";
        }
        out<<"("<<p1.coefficient[i]<<" X^"<<p1.degree[i]<<")";
    }

    return out;
}

void operator >>(std::istream& in,Polynomial& p1)               //Operator Overloading of the >> Operator
{
    p1.add();
}

Polynomial Polynomial::operator +(Polynomial p1)                //Overloading + Operator
{

    int j=p1.no+no,i,k,cnt=0,m=0;

    Polynomial p2(j);

    for(i=0;i<no;i++)
    {
        p2.degree[i]=degree[i];
        p2.coefficient[i]=coefficient[i];
    }

    for(i=0;i<p1.no;i++)
    {
        p2.degree[no+i]=p1.degree[i];
        p2.coefficient[no+i]=p1.coefficient[i];
    }

    for(i=0;i<j;i++)
    {
        for(k=0;k<j;k++)
        {
            if(p2.degree[i]==p2.degree[k])
            {
                if(k!=i)
                {
                    p2.coefficient[i]=p2.coefficient[i]+p2.coefficient[k];
                    p2.degree[k]=(int)'\0';
                }
            }
        }
    }

    for(i=0;i<j;i++)
    {
            if(p2.degree[i]!=((int)'\0'))
            {
                cnt++;
            }
    }

    Polynomial p3(cnt);

    for(i=0;i<j;i++)
    {
            if(p2.degree[i]!=(-20716))
            {
                p3.degree[m]=p2.degree[i];
                p3.coefficient[m]=p2.coefficient[i];
                m++;
            }
    }

    return p3;

}

Polynomial Polynomial::operator *(int n)                //Overloading the * Operator
{
    Polynomial p1(no);
    int i;
    for(i=0;i<no;i++)
    {
        p1.degree[i]=degree[i];
        p1.coefficient[i]=(n*coefficient[i]);
    }

    return p1;

}

Polynomial Polynomial::operator -()                 //Overloading the - Operator
{
    Polynomial p1(no);
    int i;
    for(i=0;i<no;i++)
    {
        p1.degree[i]=degree[i];
        p1.coefficient[i]=(0-coefficient[i]);
    }

    return p1;

}


int main()
{
    int n,s;

    cout<<"\nEnter the Size of the Polynomial 1:";          //Entering the Polynomial 1
    cin>>n;
    Polynomial p1(n);
    p1.add();
    p1.sorting();

    cout<<p1<<"\n";
    cout<<"\nPress Enter....";

    getch();

    system("cls");

    cout<<"\n\nEnter the Size of the Polynomial 2:";        //Entering the Polynomial 2
    cin>>n;
    Polynomial p2(n);
    p2.add();
    p2.sorting();

    cout<<p2<<"\n";
    cout<<"\nPress Enter.....";

    getch();

    system("cls");

    s=p1.totalterms(p2);

    Polynomial p3(s);

    p3=p1+p2;                                               //Performing p1+p2

    p3.sorting();

    cout<<"\n\nThe Sum of both the polynomial is:\n\n"<<p3;                                       //Overloading <<Operator
    cout<<"\n\nPress Enter...";

    getch();

    system("cls");

    cout<<"\n\nEnter the Scalar to Multiply the Polynomial:";
    cin>>n;

    p1=p1*n;                                                //Overloading * Operator
    p2=p2*n;
    p3=p3*n;

    cout<<"\n\nThe Polynomials after the Scalar Multiplication is:\n";
    cout<<"\n\nPolynomial 1"<<p1;
    cout<<"\n\nPolynomial 2"<<p2;
    cout<<"\n\nPolynomial 3"<<p3<<"\n";
    cout<<"\n\nPress Enter.....";

    getch();

    system("cls");

    cout<<"\nEnter the Length of the Polynomial 4:";
    cin>>n;

    Polynomial p4(n);                               //Declaring the p4 Polynomial

    cout<<"\nThis Polynomial Will take its value through Operator >> Overloading. Press Enter to continue....";
    getch();

    cin>>p4;                                        //Overloading >> Operator

    p4.sorting();

    cout<<p4<<"\n";

    return 0;                                      //Return 0
}
