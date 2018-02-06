import java.util.*;

class Point
{
    private int[] point;
    private int dimension;

    public Point(int d)
    {
        dimension=d;
        point=new int[d];
    }

    public Point(Point p)
    {
        dimension=p.dimension;

        point=new int[dimension];

        for(int i=0;i<dimension;i++)
        {
            point[i]=p.point[i];
        }
    }


    public void enter()
    {
        Scanner x=new Scanner(System.in);
        int take;

        for(int i=0;i<dimension;i++)
        {
            System.out.print("\nEnter the Co-ordinate "+i+" of the point:");
            take=x.nextInt();

            point[i]=take;
        }

    }

    public int isEqual(Point p)
    {
        if(this.dimension==p.dimension)
        {
            int counter=0;

            for(int i=0;i<dimension;i++)
            {
                    if(point[i]==p.point[i])
                    {
                        counter=counter+1;
                    }
            }

            if(counter==dimension)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        else
        {
            return 0;
        }
    }
};


class createPoint
{
    public static void main(String[] arg)
    {
        Scanner x=new Scanner(System.in);

        int take,dimension,a;

        System.out.print("\nHow many points do you want to create?:");
        take=x.nextInt();

        System.out.print("\nEnter the Dimension of the points:");
        dimension=x.nextInt();

        Point[] p=new Point[take];

        for(int i=0;i<take;i++)
        {
            p[i]=new Point(dimension);

            System.out.print("\nEnter the Details about point "+(i+1)+":-\n");

            p[i].enter();

            System.out.print("\nPoint "+(i+1)+" is Created Successfully..\n");
        }

        for(int i=0;i<take;i++)
        {
            for(int j=0;j<take;j++)
            {
                a=p[i].isEqual(p[j]);

                if(a==1)
                {
                    if(i!=j)
                    System.out.print("\nThe Point "+(i+1)+" is Equal to Point "+(j+1)+"...\n");
                }

                else
                {
                    System.out.print("\nThe point "+(i+1)+" is Not Equal to Point "+(j+1)+"...\n");
                }
            }
        }


    }
};
