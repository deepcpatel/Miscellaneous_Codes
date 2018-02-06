import java.util.*;

class methods
{
	double A;
	double B;
	
	public methods(double a, double b)
	{
		A=a;
		B=b;
	}
	
	public void add()
	{
		System.out.print("\nSum(A+B)="+(A+B));
	}
	
	public void subtract()
	{
		System.out.print("\nDifference(A-B)="+(A-B));
	}
	
	public void multiply()
	{
		System.out.print("\nProduct(A*B)="+(A*B));
	}

	public void divide()
	{
		System.out.print("\nQuotient(A/B)="+(A/B));
	}
	
	public void square(double item)
	{
		System.out.print("\nSquare="+(item*item));
	}
	
	public void squareRoot(double item)
	{
		System.out.print("\nSquare Root="+Math.sqrt(item));
	}
	
	public void modulus()
	{
		System.out.print("\nModulus(A%B)="+(A%B));
	}
	
};

class Calculator
{
	public static void main(String []args)
	{
		double a, b;
		int ans=1, ans1=1, select;
		Scanner x = new Scanner(System.in);
		
		while(ans==1)
		{
			System.out.print("\nEnter A:");
			a = x.nextDouble();
		
			System.out.print("\nEnter B:");
			b = x.nextDouble();
			
			methods c = new methods(a,b);
			
			ans1 = 1;
			
			while(ans1==1)
			{	
				System.out.print("\n\nEnter from Below:-");
				System.out.print("\n1).Addition");
				System.out.print("\n2).Substraction(A-B)");
				System.out.print("\n3).Multiplication");
				System.out.print("\n4).Divison(A/B)");
				System.out.print("\n5).Modulus(A%B)");
				System.out.print("\n6).Square of A");
				System.out.print("\n7).Square Root of A");
				System.out.print("\n8).Square of B");
				System.out.print("\n9).Square Root of B");
				System.out.print("\n10).Enter New A and B");
				System.out.print("\n11).Exit");
				System.out.print("\nEnter:");
				
				select = x.nextInt();
				
				switch(select)
				{
					
					case 1: c.add();
							break;
							
					case 2: c.subtract();
							break;
							
					case 3: c.multiply();
							break;
							
					case 4: c.divide();
							break;
							
					case 5: c.modulus();
							break;
							
					case 6: c.square(a);
							break;
							
					case 7: c.squareRoot(a);
							break;
							
					case 8: c.square(b);
							break;
							
					case 9: c.squareRoot(b);
							break;
							
					case 10:ans1=2;
							break;
					
					default:ans1=2;
							ans=2;
							break;
				}
				
			}
		}
		
		
	}
};