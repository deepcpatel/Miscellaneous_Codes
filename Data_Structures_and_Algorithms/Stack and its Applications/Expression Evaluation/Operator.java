import java.util.*;

class node					//node class to create stack node
{
	public int item;		//variable to store data
	public node next;		//variable to store address of next node
	
	public node(int data)
	{
		item=data;
		next=null;
	}
	
};

class node_double					//node class to create stack node
{
	public double item;				//variable to store data
	public node_double next;		//variable to store address of next node
	
	public node_double(double data)
	{
		item=data;
		next=null;
	}
	
};

//-----------------------------------------------------------------------------------------------------------------

class Stack				//stack class having methods to perform on stack
{
	public node li;		//li is the head nodes
	public int pos;		//variable to store size of the stack

	public Stack()
	{
		li=null;
		pos=0;
	}
	
	public void push(int data)		//method to insert at front of the stack
	{
		if(li==null)
		{
			li=new node(data);
			pos++;
		}
		
		else
		{
			node temp = new node(data);
			temp.next=li;
			li=temp;
			pos++;
		}
		
	}
	
	public int pop()			//delete element at front
	{
	
		int take;
		
		if(li==null)
		{
			return -568971;		//it is to return null
		}
		else
		{	
			take = li.item;
			
			li = li.next;
			pos--;
			
			return take;
			
		}
	}
	
	public int peak()		//Return the first position of the stack
	{
		if(li==null)
		{
			return -568971;
		}
		
		else
		{
			int take;
			take=li.item;
			
			return take;
		}
	}
	
	public int getStackSize()		//getting the size of the stack
	{
		return pos;
	}
	
	public void show()				//display the stack elements
	{
		if(li==null)
		{
			System.out.print("\nThe Stack is Empty\n");
		}
		
		else
		{
			node temp=li;
			
			while(temp!=null)
			{
				if(temp.item==-23224)
				{
					System.out.print(", +");
				}
				
				else if(temp.item==-23225)
				{
					System.out.print(", -");
				}
				
				else if(temp.item==-23226)
				{
					System.out.print(", *");
				}
				
				else if(temp.item==-23227)
				{
					System.out.print(", /");
				}
				
				else
				{
					if(temp==li)
					{
						System.out.print(temp.item);
					}
					else
					{
						System.out.print(", "+temp.item);
					}
				}
				
				temp=temp.next;
			}
		}
	}
};

//-----------------------------------------------------------------------------------

class Stack_double				//stack class having methods to perform on stack
{								//for storing double value
	public node_double li;		//li is the head nodes
	public int pos;				//variable to store size of the stack

	public Stack_double()
	{
		li=null;
		pos=0;
	}
	
	public void push(double data)		//method to insert at front of the stack
	{
		if(li==null)
		{
			li=new node_double(data);
			pos++;
		}
		
		else
		{
			node_double temp = new node_double(data);
			temp.next=li;
			li=temp;
			pos++;
		}
		
	}
	
	public double pop()			//delete element at front
	{
	
		double take;
		
		if(li==null)
		{
			return (double)-568971;		//it is to return null
		}
		else
		{	
			take = li.item;
			
			li = li.next;
			pos--;
			
			return take;
			
		}
	}
};


//-----------------------------------------------------------------------------------

class Operator							//main class
{

	static public int precedence(int a, int b)		//decides precedence of the operators
	{
										//a=peak Value
		if(a==(-23224)||a==(-23225))	//My Unicode Values of + = -23224, - = -23225, * = -23226, / = -23227
		{
			if(b==(-23224)||b==(-23225))
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
			return 1;
		}
	}
	
	static public int symbolCode(char ch)	//My Symbols Values of + = -23224, - = -23225, * = -23226, / = -23227
	{
		int take;							//Returns unique values of each operator
		
		if(ch=='+')
		{
			take=-23224;
		}
		
		else if(ch=='-')
		{
			take=-23225;
		}
		
		else if(ch=='*')
		{
			take=-23226;
		}
		
		else 				//for '/'
		{
			take=-23227;
		}
		
		return take;
	}
	
	static public double evaluation(Stack p1)		//performs arithmetic operation on postfix equation
	{
		double ans=(double)-568971, t1, t2;
		int temp;
		Stack tp = new Stack();
		Stack_double o1 = new Stack_double();
		
		while(p1.peak()!=-568971)	//reverse
		{
			tp.push(p1.pop());
		}
		
		System.out.print("\nThe Postfix Version of the Equation is:-\n");
		tp.show();
			
		while(tp.peak()!=-568971)
		{
			temp=tp.pop();
				
			if(temp==-23224||temp==-23225||temp==-23226||temp==-23227)
			{
				t1=o1.pop();
				t2=o1.pop();
					
				if(temp==-23224)
				{
					ans=t2+t1;
				}
				else if(temp==-23225)
				{
					ans=t2-t1;
				}	
				
				else if(temp==-23226)
				{
					ans=t2*t1;
				}	
				
				else
				{
					ans=t2/t1;
				}	
				
				o1.push(ans);
			}
			else
			{
				o1.push((double)temp);
			}
		}
		
		ans=o1.pop();
			
		return ans;
	}
	
	static public void pHandler(int operator, Stack o1, Stack p1)	//converts to postfix form
	{
		int take=0, temp, peakt;		//take stores the precedence value(0/1) of the operators
		
		peakt = o1.peak();
			
		if(peakt!=-568971)
		{
			take=precedence(peakt, operator);	
		}
			
		if(take==1 && operator!=-1)
		{
			temp=o1.pop();
			p1.push(temp);
			
			while((o1.peak()!=-568971)&&(precedence(o1.peak(), operator)!=0))
			{
				temp=o1.pop();
				p1.push(temp);
			}
			
			o1.push(operator);
		}
		
		else if(operator==-1 && o1.peak()!=-568971)
		{
			while(o1.peak()!=-568971)
			{
				temp=o1.pop();
				p1.push(temp);
			}
		}
		
		else
		{
			o1.push(operator);
		}
		
		System.out.print("\n->\n");
		System.out.print("\nStack:");
		o1.show();
		System.out.print("\nOutput(Read Right to Left):");
		p1.show();
		System.out.print("\n---------------------------------------------------------");
		
		
	}
	
	public static void main(String[] args)		//main function
	{
	
		Scanner x = new Scanner(System.in);		//variable decleration
		
		String equation = new String();
		
		Stack optr = new Stack();
		Stack store = new Stack();
		Stack p = new Stack();
		
		int take, sum, take1, mult, numint, ch1, signal;
		double ans;
		char ch;
		
		System.out.print("\nEnter The Equation:-");	
		equation = x.next();							//storing equations in the string
		
		char[] charEquation = equation.toCharArray();	//converting string equation to the character array
		
		for(int i=0;i<charEquation.length;i++)			//building the P stack storing the postfix form
		{
			ch=charEquation[i];
			
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||i==(charEquation.length-1))
			{
				if(i==(charEquation.length-1))
				{
					numint=java.lang.Character.getNumericValue(ch);
					store.push(numint);
				}
				
				sum=0;
				ch1=0;
				mult=0;
				
				while(ch1!=(-568971))
				{
					sum=sum+(ch1*mult);
					ch1=store.pop();
					mult=mult*10;
					
					if(mult==0)
					{
						mult=1;
					}
				}
				
				take=symbolCode(ch);
				p.push(sum);
				
				if(i!=(charEquation.length-1))
				{
					pHandler(take, optr, p);
				}
				else
				{
					pHandler(-1, optr, p);
				}
			}
			else
			{
				numint=java.lang.Character.getNumericValue(ch);
				store.push(numint);
			}
			
		}
		
		ans = evaluation(p);
		
		System.out.print("\n\nThe answer of the Equation = "+ans+"\n\n");
		
		
	}

}; 

//Here the all characters(including operators) are converted to integer value for easy management
//Here the number -568971 is treated as the null return code
//int j=java.lang.Character.getNumericValue(a);		//converts char to int		