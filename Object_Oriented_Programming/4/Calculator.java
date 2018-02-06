import java.util.Scanner;

class Calculator
{
	public static void main(String arg[])
	{
		Scanner in=new Scanner(System.in);

		int x,y,ans;

		char ch='y';

		System.out.print("Enter X:");
		x=in.nextInt();

		System.out.print("Enter Y:");
		y=in.nextInt();

		while(ch=='y'||ch=='Y')
		{
		    for (int k=0;k<50;k++)   //to clear
            {
                System.out.println();
            }

			System.out.println("Enter Your Choice from below:-");
			System.out.println("1).Addition");
			System.out.println("2).Substraction");
			System.out.println("3).Multiplication");
			System.out.println("4).Divison");
			System.out.println("5).Modulus");
			System.out.print("Enter:");
			ans=in.nextInt();

			switch(ans)
			{
				case 1:System.out.println( x+"+"+ y+"="+ (x+y));

				       break;

				case 2:System.out.println( x+"-"+ y+"="+ (x-y));

				       break;

				case 3:System.out.println( x+"x"+ y+"="+ (x*y));

				       break;

				case 4:System.out.println( x+"/"+ y+"="+ (x/y));

				       break;

				case 5:System.out.println( x+"%"+ y+"="+ (x%y));

				       break;

				default:System.out.println("Invalid Choice");

				       break;
			}

			System.out.print("Do you want to Continue(y/n):");

			ch=in.next().charAt(0);



		}


	}
}
