import java.util.Scanner;

class Prime
{
	public static void main(String arg[])
	{
		int prime,i,count=0;
		
		System.out.print("Enter an Integer Number:");
		
		Scanner x=new Scanner(System.in);
		
		prime=x.nextInt();
		
		if(prime==1)
		{
			System.out.println("This is Neither prime nor Composite");
		}
		
		for(i=1;i<=prime;i++)
		{
			if(prime%i==0)
			{
				count++;			
			}
			
		}
		
		if(count==2)
		{
			System.out.println(prime + " is a Prime Number");
							
		}
		
		else if(count!=1)
		{
			System.out.println(prime+" is not a Prime Number");

		}
		
		
		
	}
	
}
