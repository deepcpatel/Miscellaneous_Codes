//Practical 5(2)

import java.util.Scanner;

class list                  //class list is created
{
	private int array[];        //data members of the class
	private int size;
	private int i=0, j;
	private int counter;

	list(int s)                 //constructor which takes size of the array from the user
	{
		array=new int[s];
		size=s;

		for(int j=0;j<size;j++)         //initializing all the array elements to 0
        {
            array[j]=0;
        }
	}

	public boolean add(int element)             //function to enter the element from the user when he/she wants
	{                                           //the functions return false when the array is full

		if(i<size)
		{
                array[i]=element;
                i++;
                System.out.println("\nElement entered Successfully..");

                if(i==size)
                {
                    return false;
                }

                return true;
		}

		else
        {

            return false;

        }

	}

	public void delete(int el)              //function to delete the specific element from the array
	{

        for(j=0;j<i;j++)            //loop to find the element to be deleted
		{


			if(array[j]==el)
			{
                for(int k=j;k<i-1;k++)
                {
                    array[k]=array[k+1];
                }
                j=-1;
                i--;
			}

		}

		System.out.print("\nElement Deleted Successfully from the Array......\n");

	}

	public boolean duplicate(int ans, boolean b1)           //function to find the duplicate elements and remove them if user say
	{
        int pos=0;



        if(ans==1)              //this find the duplicates
        {
            int[] ar=new int[size];
            int cntr=0;

            for(int j=0;j<size;j++)
            {
                ar[j]=0;
            }

            for(j=0; j<i; j++)
            {
                counter=0;
                int s=1;
                for(int k=0;k<i;k++)
                {
                    if(array[j]==array[k])
                    {
                        counter++;
                        ar[k]=s;
                        s--;
                    }
                }



                if(counter>1&&ar[j]==1)
                {

                    System.out.print("\nNumber "+array[j]+" has "+counter+" duplicates\n");
                    cntr++;


                }

            }

            if(cntr==0)
            {
                System.out.print("\nNo Duplicate elements exists\n");
            }



        }

        else if(ans==2)         //this removes the duplicate
        {
            int num;

            Scanner y=new Scanner(System.in);

            System.out.print("\nEnter which duplicate number you want to delete:");

            num=y.nextInt();

            counter=0;

            for(int j=0;j<i;j++)
            {
                if(array[j]==num)
                {
                    counter++;
                }
            }

            if(counter<=1)
            {
                System.out.println("\nSorry no duplicate of that number found or the number don't exist");

            }

            else
            {
                while(counter!=1)
                {
                    for(int j=0;j<i;j++)
                    {
                        if(array[j]==num)
                        {
                            pos=j;
                        }
                    }

                    for(int k=pos;k<i-1;k++)
                    {
                        array[k]=array[k+1];
                    }
                    i--;
                    counter--;
                }

                 System.out.print("\nAll the Duplicate elements were removed...\n");

                 return true;
            }


        }

        return b1;
	}


	public boolean search(int element)          //function to search the element from the array and returns true if it is found
	{
	    for(j=0;j<i;j++)
        {
            if(array[j]==element)
            {
                return true;
            }
        }


        return false;

	}

	public void show()                              //function to show the array
	{
	    System.out.print("\nThe Array is:\n");

	    for(j=0;j<i;j++)
        {
            System.out.print("\n"+array[j]+"\n");
        }
	}

	public void sort(int ans)           //function to sort the array in descending and ascending order
	{
	    int temp=0;

        if(ans==1)                  //ascending order
        {
            for(int j=0;j<i;j++)
            {
                for(int k=0;k<i-1;k++)
                {
                    if(array[k]>array[k+1])
                    {
                        temp=array[k];
                        array[k]=array[k+1];
                        array[k+1]=temp;
                    }
                }
            }
        }

        else                //descending order
        {
             for(int j=0;j<i;j++)
             {
                for(int k=i-1;k>0;k--)
                {
                    if(array[k]>array[k-1])
                    {
                        temp=array[k];
                        array[k]=array[k-1];
                        array[k-1]=temp;
                    }
                }
             }
        }

        System.out.println("\nThe Array is Sorted Successfully...");
	}

	public void reverse()               //the program to reverse the array
	{
	    int temp;

	    if(i%2==0)
        {
            for(int j=0;j<=((i-1)/2);j++)
            {
                temp=array[j];
                array[j]=array[i-j-1];
                array[i-j-1]=temp;
            }

        }

        else
        {
                for(int j=0;j<((i-1)/2);j++)
                {
                    temp=array[j];
                    array[j]=array[i-j-1];
                    array[i-j-1]=temp;
                }
        }

        System.out.print("\nThe array is Reversed\n");
	}

	public void operation(int n)            //function to do the operations on array like find mean, mode, median
	{                                       //also standard deviation, sum and max and min elements
        int sum=0;

        for(int j=0;j<i;j++)
        {
            sum=sum+array[j];
        }

        if(n==1)
        {

            System.out.print("\nThe sum of all elements of the array is:"+sum+"\n");

        }

        else if(n==2)
        {

            int[] ar=new int[size];
            int[][] a=new int[size][2];
            int cntr=0,z=0,mode,index=0;

            for(int j=0;j<size;j++)
            {
                ar[j]=0;
            }

            for(j=0; j<i; j++)
            {
                counter=0;
                int s=1;
                for(int k=0;k<i;k++)
                {
                    if(array[j]==array[k])
                    {
                        counter++;
                        ar[k]=s;
                        s--;
                    }
                }



                if(counter>1&&ar[j]==1)
                {

                    a[z][0]=array[j];
                    a[z][1]=counter;
                    cntr++;
                    z++;


                }

            }

            mode=a[0][1];

            for(int j=0;j<z;j++)
            {
                if(mode<a[j][1])
                {
                    mode=a[j][1];
                    index=j;
                }
            }

            System.out.print("The mode of the array is:"+a[index][0]);



        }

        else if(n==3)
        {
            int temp;
            int[] ar=new int[size];

            for(int j=0;j<i;j++)
            {
                ar[j]=array[j];
            }

            for(int j=0;j<i;j++)
            {
                for(int k=0;k<i-1;k++)
                {
                    if(ar[k]>ar[k+1])
                    {
                        temp=ar[k];
                        ar[k]=ar[k+1];
                        ar[k+1]=temp;
                    }
                }
            }

            if(i%2==0)
            {
                int m1,m2;
                float mean;

                m1=((i-2)/2);
                m2=(i/2);

                mean=(((float)(ar[m1]+ar[m2]))/2);

                System.out.print("\nThe Median of the array is:"+mean+"\n");

            }

            else
            {
                int m1;

                m1=((i-1)/2);

                System.out.print("\nThe Median of the Array is:"+ar[m1]+"\n");
            }

        }

        else if(n==4)
        {
            double mean=0.0000;

            if(i==0)
            {
                System.out.print("The mean is:0");
            }

            else
            {
                mean=(((float)sum)/i);

                System.out.print("\nThe Mean of the array is:"+mean+"\n");
            }

        }

        else if(n==5)
        {
            int max=array[0];

            for(int j=0;j<i;j++)
            {
                if(max<array[j])
                {
                    max=array[j];
                }
            }

            System.out.print("\nThe Maximum element of the array is:"+max+"\n");
        }

        else if(n==6)
        {
            int min=array[0];

            for(int j=0;j<i;j++)
            {
                if(min>array[j])
                {
                    min=array[j];
                }
            }

            System.out.print("\nThe Minimum element of the array is:"+min+"\n");
        }

        else
        {
            float mean;
            float s=0;


            float ar[]=new float[i];

            mean=(((float)sum)/i);

            for(int j=0;j<i;j++)
            {
                ar[j]=(((float)array[j]-mean)*((float)array[j]-mean));
            }

            for(int j=0;j<i;j++)
            {
                s=s+ar[j];
            }

            mean=s/i;

            System.out.print("\nThe Standard Deviation is:"+Math.sqrt(mean));


        }
	}
};


class class2                                                  //main class
{
    public static void main(String arg[])           //main function
    {
        Scanner x=new Scanner(System.in);

        int n,ans=1,input,element;      //variables declared

        boolean b1=true,b2;

        System.out.print("\nEnter the size of the Array:");

        n=x.nextInt();

        list l1=new list(n);                //new object of the class list initialized

        while(ans==1)               //menu driven program
        {

            System.out.println("\n\nEnter from the Following:-");
            System.out.println("1).Add the Element in the Array");
            System.out.println("2).Delete the Elements from the Array");
            System.out.println("3).Show the Array");
            System.out.println("4).Deal with Duplicate Function");
            System.out.println("5).Sort the Array");
            System.out.println("6).Reverse the Array");
            System.out.println("7).Perform Mathematical operations on the array");
            System.out.print("Enter:");
            input=x.nextInt();

            switch(input)
            {

                case 1:
                        if(b1==true)
                        {
                            System.out.print("\nEnter the element to enter:");      //to add element

                            element=x.nextInt();

                            b1=l1.add(element);

                        }

                        else
                        {
                            System.out.println("\nSorry The Array is Full...");
                        }

                        break;

                case 2: System.out.print("\nEnter the element to be deleted:");     //to delete element
                        element=x.nextInt();

                        b2=l1.search(element);

                        if(b2==true)
                        {
                             l1.delete(element);
                             b1=true;
                        }

                        else
                        {
                            System.out.print("\nSorry the element not found...\n");
                        }



                        break;

                case 3: l1.show();                                          //to show the array
                        break;

                case 4: System.out.println("\nEnter from the following:-");                 //to deal with duplicate function
                        System.out.println("1).To see the no of duplicate elements");
                        System.out.println("2).To remove the duplicate elements");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        switch(ans)
                        {
                            case 1:b1=l1.duplicate(1,b1);
                                    break;

                            case 2:b1=l1.duplicate(2,b1);
                                    break;

                            default: System.out.print("\nSorry invalid choice, Choose again...");
                                     break;
                        }

                        break;

                case 5: System.out.println("\nEnter from the following:-");             //to sort the array
                        System.out.println("1).Sort in the Ascending Order");
                        System.out.println("2).Sort in the Descending Order");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        switch(ans)
                        {
                            case 1: l1.sort(1);
                                    break;

                            case 2: l1.sort(2);
                                    break;

                            default: System.out.print("\nSorry invalid choice, Choose again...");
                                     break;
                        }

                        break;

                case 6: l1.reverse();

                        break;

                case 7: System.out.println("\nEnter from the following:-");             //to perform mathematical operations
                        System.out.println("1).Find the Sum of Elements of the Array");
                        System.out.println("2).Find the Mode");
                        System.out.println("3).Find the Median");
                        System.out.println("4).Find the Mean");
                        System.out.println("5).Find Maximum element from the Array");
                        System.out.println("6).Find Minimum element from the Array");
                        System.out.println("7).Find Standard Deviation of the Array");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        switch(ans)
                        {
                            case 1: l1.operation(1);
                                    break;

                            case 2: l1.operation(2);
                                    break;

                            case 3: l1.operation(3);
                                    break;

                            case 4: l1.operation(4);
                                    break;

                            case 5: l1.operation(5);
                                    break;

                            case 6: l1.operation(6);
                                    break;

                            case 7: l1.operation(7);
                                    break;

                            default: System.out.print("\nSorry invalid choice, Choose again...");
                                     break;
                        }

                        break;


                default:System.out.println("\nSorry wrong choice, Try again...");           //default case
                        break;
            }

            System.out.print("\nDo you want to choose again(y=1/n=2):");
            ans=x.nextInt();


        }
    }
};







