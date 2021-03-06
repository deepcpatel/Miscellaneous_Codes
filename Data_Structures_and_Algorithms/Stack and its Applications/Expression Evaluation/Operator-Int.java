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
	
	public void show()		//display the stack elements
	{
		if(li==null)
		{
			System.out.print("\nThe Stack is Empty\n");
		}
		
		else
		{
			node temp=li;
			System.out.print("\nThe Stack is:-\n\n");
			
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
					System.out.print(", "+temp.item);
				}
				
				temp=temp.next;
			}
		}
	}
};

//-----------------------------------------------------------------------------------

class Operator
{

	static public int precedence(int a, int b)
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
	
	static public int symbolCode(char ch)	//My Unicode Values of + = -23224, - = -23225, * = -23226, / = -23227
	{
		int take;
		
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
	
	static public int evaluation(Stack p1)
	{
		int ans=-568971, temp, t1, t2;
		Stack tp = new Stack();
		Stack o1 = new Stack();
		
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
				o1.push(temp);
			}
		}
		
		ans=o1.pop();
			
		return ans;
	}
	
	static public void pHandler(int operator, Stack o1, Stack p1)
	{
		int take=0, temp, peakt;
		
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
		
	}
	
	public static void main(String[] args)
	{
	
		Scanner x = new Scanner(System.in);
		
		String equation = new String();
		
		Stack optr = new Stack();
		Stack store = new Stack();
		Stack p = new Stack();
		
		int take, sum, take1, mult, numint, ch1, signal, ans;
		char ch;
		
		System.out.print("\nEnter The Equation:-");
		equation = x.next();
		
		char[] charEquation = equation.toCharArray();
		
		for(int i=0;i<charEquation.length;i++)
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

//int j=java.lang.Character.getNumericValue(a);		//char to int		