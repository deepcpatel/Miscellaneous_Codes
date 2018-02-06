//The Sorting Technique is the Bubble Sort

import java.util.Scanner;

class Sort
{
    public static void main(String []arg)
    {
        Scanner var=new Scanner(System.in);

        int n, i, ar[]=new int[50], j, temp;

        System.out.print("Enter the Number of the elements for the Array:");

        n=var.nextInt();

        for(i=0;i<n;i++)
        {
            System.out.print("Enter the Element "+(i+1)+":");
            ar[i]=var.nextInt();
        }

        System.out.println("The Array after sorting is:-");

        for(i=0;i<n;i++)
        {
            for(j=0;j<n-1;j++)
            {
                if(ar[j]>ar[j+1])
                {
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                }
            }
        }

        for(i=0;i<n;i++)
        {
            System.out.print("->"+ar[i]+"\n");
        }
    }
};
