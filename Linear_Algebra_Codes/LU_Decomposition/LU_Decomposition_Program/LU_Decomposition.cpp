/*

Program Title:Conversion of Input Matrix to the Row Reduced Echelon Form

Programmer:Deep C. Patel

Date:12/07/2015

*/

#include <iostream>
#include <conio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <stdio.h>

using namespace std;

float timedifference_msec(struct timeval t0, struct timeval t1)
{
    return (t1.tv_sec - t0.tv_sec) * 1000.0f + (t1.tv_usec - t0.tv_usec) / 1000.0f;
}

void exchange(int row1, int row2, int columns, int rows, double **mtx)
{
    double temp;

    for(int i=0;i<columns;i++)
    {
        temp=mtx[row1][i];
        mtx[row1][i]=mtx[row2][i];
        mtx[row2][i]=temp;
    }

    cout<<"----------------------------------------------";
    cout<<"\nPerforming Operation:R"<<row1+1<<"<->R"<<row2+1<<"\n";

    cout<<"\nThe Matrix after Row Swapping is:-\n\n";

    for(int i=0;i<rows;i++)
    {
        for(int j=0;j<columns;j++)
        {
            cout<<mtx[i][j]<<" ";
        }

        cout<<"\n";
    }


}

void add(double k1, int row1, double k2, int row2, int columns, int rows, double **mtx, double k3)
{

    for(int i=0;i<columns;i++)
    {
        mtx[row1][i]=((k1*mtx[row1][i])+(k2*(mtx[row2][i]/k3)));
    }

    cout<<"----------------------------------------------";
    cout<<"\nPerforming Operation:R"<<row1+1<<"->("<<k1<<")R"<<row1+1<<"+(("<<k2<<")R"<<row2+1<<")/("<<k3<<")\n";

    cout<<"\nThe Matrix after Row Addition/ Scalar Multiplication is:-\n\n";

    for(int i=0;i<rows;i++)
    {
        for(int j=0;j<columns;j++)
        {
            cout<<mtx[i][j]<<" ";
        }

        cout<<"\n";
    }
}

int zero_column_checker(int columns, int rows, double **mtx)
{
    int cnt=0, cnt1=-1;

    for(int j=0;j<columns;j++)
    {
        for(int i=0;i<rows;i++)
        {
            if(mtx[i][j]==0)
            {
                cnt++;
            }
        }

        if(cnt==rows)
        {
            cnt=0;
            cnt1++;
        }
        else
        {
            break;
        }
    }

    return cnt1;
}


int main()
{

    system("cls");

    int row, column, ans, base, counter, rrefcounter, flag=0, watch=0,rowCount=0;
    double **matrix, **L, *aray;
    struct timeval t0;
    struct timeval t1;
    float elapsed;


    cout<<"\nEnter the Row-size of the matrix:";
    cin>>row;

    cout<<"\nEnter the Column-size of the matrix:";
    cin>>column;

    matrix=new double* [row];
    L=new double* [row];
    aray = new double [row];

    for(int i=0;i<row;i++)
    {
        matrix[i] = new double [column];
    }

    for(int i=0;i<row;i++)      //Initializing L Matrix
    {
        L[i] = new double [row];
    }
//---------------------------------------------------------------------
    cout<<"\nEnter the Matrix Elements:-\n";

    for(int i=0;i<row;i++)
    {
        for(int j=0;j<column;j++)
        {
            cout<<"\nEnter the element ("<<i+1<<","<<j+1<<") of the matrix:";
            cin>>matrix[i][j];
        }
    }

    for(int i=0;i<row;i++)      //Entering values for L
    {
        for(int j=0;j<row;j++)
        {
            if(i==j)
            {
                L[i][j]=1;
            }
            else
            {
                L[i][j]=0;
            }
        }
    }
//------------------------------------------------------------
    system("cls");
//------------------------------------------------------------
    cout<<"\nThe Matrix is:-\n\n";

    for(int i=0;i<row;i++)
    {
        for(int j=0;j<column;j++)
        {
            cout<<matrix[i][j]<<" ";
        }

        cout<<"\n";
    }

    cout<<"\nPress any Key to Continue:";
    getch();

    system("cls");
//-------------------------------------------------------------
    gettimeofday(&t0, 0);

    cout<<"\n----------------------------------------------";
    cout<<"\nConverting the Matrix to the Echelon Form:-\n";

    for(int i=0;i<row;i++)      //duplicate row remover
    {
        for(int j=i+1;j<row;j++)
        {
            int rcnt=0;

            for(int k=0;k<column;k++)
            {
                if(matrix[i][k]==matrix[j][k])
                {
                    rcnt++;
                }
            }

            if(rcnt==column)
            {
                add(1, j, -1, i, column, row, matrix, 1);
            }
        }
    }


    ans=zero_column_checker(column, row, matrix);


    base=ans+1;

    if(matrix[0][base]==0)
    {
        for(int j=0;j<row;j++)
        {
            if(matrix[j][base]!=0)
            {
                exchange(0, j, column, row, matrix);
                flag=1;
                break;
            }
        }
    }

    counter=0;

    for(int i=base;i<column;i++)    //converting to the echelon form
    {
        watch=0;

        for(int q=0;q<row;q++)
        {
            aray[q]=matrix[q][i];
        }

        if(counter<row)
        {
            if(matrix[counter][i]==0)
            {
                for(int j=counter;j<row;j++)
                {
                    if(matrix[j][i]!=0)
                    {
                        exchange(counter, j, column, row, matrix);
                        watch=1;
                        flag=1;
                        break;
                    }
                }
                if(watch==0)
                {
                    continue;
                }
            }


            for(int j=counter+1;j<row;j++)
            {
                if(matrix[j][i]!=0)
                {
                    add(1, j, -(matrix[j][i]), counter, column, row, matrix, matrix[counter][i]);
                }
            }

            if(rowCount<row)
            {
                for(int k=counter+1;k<row;k++)
                {
                    L[k][rowCount]=aray[k]/aray[counter];
                }
            }

            counter++;
            rowCount++;
        }

    }


    for(int i=0;i<row;i++)      //duplicate row remover
    {
        for(int j=i+1;j<row;j++)
        {
            int rcnt=0;

            for(int k=0;k<column;k++)
            {
                if(matrix[i][k]==matrix[j][k])
                {
                    rcnt++;
                }
            }

            if(rcnt==column)
            {
                add(1, j, -1, i, column, row, matrix,1);
            }
        }
    }

    gettimeofday(&t1, 0);
    elapsed = timedifference_msec(t0, t1);

    cout<<"\n------------------------------------------------------------\n";
    cout<<"The Matrix in Echelon Form or U form is:-";
    cout<<"\n------------------------------------------------------------\n\n";

    for(int i=0;i<row;i++)
    {
        for(int j=0;j<column;j++)
        {
            cout<<matrix[i][j]<<" ";
        }

        cout<<"\n";
    }

    if(flag==1)
    {
        cout<<"\nThe L form does not exists for A, so A cannot be decomposed to LU";
    }
    else
    {
        cout<<"\nThe L form is:-\n";

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<row;j++)
            {
                cout<<L[i][j]<<" ";
            }

            cout<<"\n";
        }
    }

    cout<<"\n\n------------------------------------------------------------";
    cout<<"\nThe Execution Time is:"<<elapsed<<" milli seconds";
    cout<<"\n------------------------------------------------------------\n\n";

    getch();
    return 0;
}
