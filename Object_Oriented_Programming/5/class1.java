//Lab Assignment 5(1)

import java.util.Scanner;

class item
{
	int itemNo;
	int itemValue;
	static int cnt=0;                   //static variable

	Scanner x=new Scanner(System.in);
	item()
	{
		cnt++;              //counter variable

	}

	public void set()                       //function to get details from the user
	{
		System.out.print("\nEnter the itemno:");
		itemNo=x.nextInt();

		System.out.print("\nEnter the Value:");
		itemValue=x.nextInt();
	}

	public void get()           //function to show details to the user
	{
		System.out.print("\nThe itemNo is:"+itemNo);

		System.out.print("\nThe itemValue is:"+itemValue);


	}

	public static int cnt()
	{
		return cnt;         //returning count
	}


};

class class1
{
	public static void main(String arg[])
	{
		item i1=new item();

		System.out.print("\nThe class "+i1.cnt()+" is Created");        //cnt constructor called
		i1.set();

		item i2=new item();

		System.out.print("\nThe class "+i2.cnt()+" is Created");
		i2.set();


		i1.get();       //get details

		i2.get();



	}
};
