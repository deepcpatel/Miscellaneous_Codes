/*

Program Title:Conversion of Input Matrix to the Row Reduced Echelon Form

Programmer:Deep C. Patel

Date:12/07/2015

*/

#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<time.h>
#include <sys/time.h>
#include <stdio.h>

using namespace std;

float timedifference_msec(struct timeval t0, struct timeval t1)
{
    return (t1.tv_sec - t0.tv_sec) * 1000.0f + (t1.tv_usec - t0.tv_usec) / 1000.0f;
}

void exchange(int row1, int row2, int columns, int rows, float **mtx)
{
    float temp;

    for(int i=0;i<columns;i++)
    {
        temp=mtx[row1][i];
        mtx[row1][i]=mtx[row2][i];
        mtx[row2][i]=temp;
    }
}

void add(float k1, int row1, float k2, int row2, int columns, int rows, float **mtx)
{

    for(int i=0;i<columns;i++)
    {
        mtx[row1][i]=((k1*mtx[row1][i])+(k2*mtx[row2][i]));
    }
}

int zero_column_checker(int columns, int rows, float **mtx)
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

    int row, column, ans, base, counter, rrefcounter;
    float **matrix;
    struct timeval t0;
    struct timeval t1;
    float elapsed;

    for(int z=250;z<400;z++)
    {
            row=z;
            column=z;

            matrix=new float* [row];

            for(int i=0;i<row;i++)
            {
                matrix[i] = new float [column];
            }

            for(int i=0;i<row;i++)
            {
                for(int j=0;j<column;j++)
                {
                    matrix[i][j]=rand();
                }
            }

            gettimeofday(&t0, 0);

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
                        add(1, j, -1, i, column, row, matrix);
                    }
                }
            }


            ans=zero_column_checker(column, row, matrix);

            if(ans==-1)
            {
                if(matrix[0][0]!=1)
                {
                    for(int i=0;i<row;i++)
                    {
                        if(matrix[i][0]==1)
                        {
                            exchange(0, i, column, row, matrix);
                            break;
                        }
                    }

                }

                if(matrix[0][0]==0)
                {
                   for(int j=0;j<row;j++)
                   {
                       if(matrix[j][0]!=0)
                       {
                           exchange(0, j, column, row, matrix);
                           break;
                       }
                   }
                }

                for(int i=0;i<column;i++)    //converting to the echelon form
                {
                    if(!(row<column&&i>row-1))
                    {
                        if(matrix[i][i]!=1&&matrix[i][i]!=0)
                        {
                           add(0,i,(1/matrix[i][i]),i,column,row,matrix);
                        }

                        if(matrix[i][i]==0)
                        {
                            for(int j=i;j<row;j++)
                            {
                                if(matrix[j][i]!=0)
                                {
                                    exchange(i, j, column, row, matrix);
                                    break;
                                }
                            }
                        }


                        for(int j=i+1;j<row;j++)
                        {
                           if(matrix[j][i]!=0)
                           {
                               add(1, j, -(matrix[j][i]), i, column, row, matrix);
                           }

                        }

                    }

                }
            }

            else
            {
                base=ans+1;

                if(matrix[0][base]!=1)
                {
                    for(int i=0;i<row;i++)
                    {
                        if(matrix[i][base]==1)
                        {
                            exchange(0, i, column, row, matrix);
                            break;
                        }
                    }

                }

                if(matrix[0][base]==0)
                {
                   for(int j=0;j<row;j++)
                   {
                       if(matrix[j][base]!=0)
                       {
                           exchange(0, j, column, row, matrix);
                           break;
                       }
                   }
                }

                counter=0;

                for(int i=base;i<column;i++)    //converting to the echelon form
                {
                    if(!(row<column&&i>row-1))
                    {
                       if(matrix[counter][i]!=1&&matrix[counter][i]!=0)
                       {
                           add(0,counter,(1/matrix[counter][i]),counter,column,row,matrix);
                       }

                       if(matrix[counter][i]==0)
                       {
                            for(int j=counter;j<row;j++)
                            {
                                if(matrix[j][i]!=0)
                                {
                                    exchange(counter, j, column, row, matrix);
                                    break;
                                }
                            }
                        }


                       for(int j=counter+1;j<row;j++)
                       {
                           if(matrix[j][i]!=0)
                           {
                               add(1, j, -(matrix[j][i]), counter, column, row, matrix);
                           }

                       }

                       counter++;
                    }

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
                        add(1, j, -1, i, column, row, matrix);
                    }
                }
            }

            for(int i=row-1;i>0;i--)        //rref
            {
                for(int j=0;j<column;j++)
                {
                    rrefcounter=i;
                    if(matrix[i][j]!=0)
                    {
                        if(matrix[i][j]!=1)
                        {
                            add(0,i,(1/matrix[i][j]),i,column,row,matrix);
                        }

                        while(rrefcounter!=0)
                        {
                            add(1, (rrefcounter-1), -(matrix[rrefcounter-1][j]), i, column, row, matrix);
                            rrefcounter--;
                        }

                        break;
                    }
                }

            }

            gettimeofday(&t1, 0);

            elapsed = timedifference_msec(t0, t1);

            cout<<"\n"<<elapsed;
            cout<<"\n"<<z<<"x"<<z<<"\n";

    }

    getch();
    return 0;
}
