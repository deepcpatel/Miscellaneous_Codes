/*
    Topic:-
        
        Randomized algorithm to find the closest pair of the given points in a given plain.
    
    Creators:-

        Name_1:-Deep C. Patel
        Name_2:-Maunil R. Vyas
        
    Reference:-
        
        Algorithm Design - Jon Kleinberg, Eva Tardos (2005)
    
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include "dependency/hashStructure.c"

//printf("\nLine No:%d",__LINE__);

linked_list_node *temp;
struct node_stack *st;

int hash_function(float, float, int, int);            //The universal hash function to calculate index
float distance(float, float, float, float);           //Calculates the euclidean distance between 2 points
void traverse(int, int, float, float, float *);       //Used to traverse the 25 sub square
int randomizer(int*, int);                            //Used to randomize the point selection

int global_r1, global_r2, global_size;

int gS, gT;
float xa, ya, xb, yb;

int* pointCounter;

int main()
{
    time_t t;
    int size=101;                   //Hash Size
    int size_points;                //No. of Points taken
    int index,i;
    int gS1, gT1;
    float dist;

    initialize_structure(size);
    srand((unsigned) time(&t));    //Initialize Random Number Generator

    global_r1=rand()%size;
    global_r2=rand()%size;
    
    global_size=size;

    printf("\nEnter how many points you want to add:");
    scanf("%d",&size_points);

    pointCounter=malloc(sizeof(int)*size_points);
    
    float point[size_points][2];

    for(i=0;i<size_points;i++)
    {
        printf("\nEnter X Cordinate:");
        scanf("%f",&point[i][0]);
        printf("\nEnter Y Cordinate:");
        scanf("%f",&point[i][1]);
        
        pointCounter[i]=0;
    }

    dist = distance(point[0][0],point[0][1],point[1][0],point[1][1]);
    
    xa=point[0][0];
    ya=point[0][1];
    xb=point[1][0];
    yb=point[1][1];
    
    pointCounter[0]=-1;        //We have used first two points
    pointCounter[1]=-1;

    index=hash_function(point[0][0],point[0][1],dist,1);
    insert(index,point[0][0],point[0][1]);

    index=hash_function(point[1][0],point[1][1],dist,1);
    insert(index,point[1][0],point[1][1]);

    index=randomizer(pointCounter,size_points);    
    
    while(index!=-1)
    {
        hash_function(point[index][0],point[index][1],dist,0);
        traverse(gS,gT,point[index][0],point[index][1],&dist);
        index=randomizer(pointCounter,size_points);
    }
    
    printf("\nMinimum Distance:%f",dist);
    printf("\nX1:%f",xa);
    printf("\nY1:%f",ya);
    printf("\nX2:%f",xb);
    printf("\nY2:%f",yb);
    
    return 0;
}

int randomizer(int* pointCounter, int size_points)
{
    int r,back,front,counter=1;
    r=rand()%size_points;
    back=r-1;
    front=r+1;
    
    if(pointCounter[r]==-1)
    {
        while(back!=-1 || front!=size_points)
        {
            
            if(front!=size_points)
            {
                if(pointCounter[front]!=-1)
                {
                    pointCounter[front]=-1;
                    return front;
                }
                front=front+1;
            }
            
            if(back!=-1)
            {
                if(pointCounter[back]!=-1)
                {
                    pointCounter[back]=-1;
                    return back;
                }
                back=back-1;
            }
        }
        
        return -1;
    }
    else
    {
        pointCounter[r]=-1;
        return r;
    }
}

int hash_function(float x, float y, int dist, int arg)
{
    int s,t,p=global_size;

    s=abs((int)((2*floor(x))/dist));
    t=abs((int)((2*floor(y))/dist));


    if(arg==1)
    {
        return abs(((global_r1*s)+(global_r2*t))%p);                //For co-ordinates x, y
    }
    else if(arg==2)
    {
        return abs(((global_r1*(int)x)+(global_r2*(int)y))%p);      //For direct s and t
    }
    else                                                            //For just setting s and t to global vars
    {
        gS = s;
        gT = t;

        return 0;
    }
}

float distance(float x1, float y1, float x2, float y2)
{
    return sqrt(pow(x2-x1,2)+pow(y2-y1,2));
}

void traverse(int s, int t, float x, float y, float *dist)
{
    int temps=s-2, tempt=t-2, i, index, tempx, tempy, k;
    float minDist=*dist, j;

    for(k=0;k<=4;k++)
    {
        tempt=t+k;

        for(i=0;i<=4;i++)
        {
            index=hash_function(temps+i,tempt,*dist,2);
            temp=retrieve(index);
            
            /*
            printf("\nDisplay tempS:%d",temps+i);
            printf("\nDisplay tempT:%d",tempt);
            
            printf("\nDisplay Index:%d",index);
            */

            while(temp!=NULL)
            {
                tempx=temp->s;
                tempy=temp->t;
                
                j=distance(x, y, tempx, tempy);
                
                //printf("\nDistance=%f",j);
                //printf("\n MinDistance=%f",minDist);

                if(j<minDist)
                {
                    minDist=j;
                }

                temp=temp->link;
                
            }

            if(minDist<(*dist))
            {
                *(dist)=minDist;
                
                xa=x;
                ya=y;
                xb=tempx;
                yb=tempy;
                
                st=backup();
                clear_all();

                while(st!=NULL)
                {
                    index=hash_function(st->x,st->y,minDist,1);
                    insert(index,st->x,st->y);

                    st=st->link;
                }

            }
            
        }

    }
    
    index=hash_function(x,y,minDist,1);
    insert(index,x,y);

}
