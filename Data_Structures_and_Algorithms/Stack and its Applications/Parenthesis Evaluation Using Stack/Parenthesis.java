import java.util.*;
import java.io.*;

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
	
	public int isEmpty()
	{
		if(li==null)
		{
			return -568971;
		}
		else
		{
			return -568972;
		}
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

class Parenthesis
{
	static public int symbolCode(char ch)	//My Unicode Values of { = 23224, [ = 23225, ( = 23226, )= -23226, ]=-23225, }=-23224
	{
		int take;
		
		if(ch=='{')
		{
			take=23224;
		}
		
		else if(ch=='[')
		{
			take=23225;
		}
		
		else if(ch=='(')
		{
			take=23226;
		}
		
		else if(ch==')')
		{
			take=-23226;
		}
		
		else if(ch==']')
		{
			take=-23225;
		}
		
		else				//for '}'	
		{
			take=-23224;
		}
		
		return take;
	}
	
	public static void check(int paren, Stack o)	//My Unicode Values of { = 23224, [ = 23225, ( = 23226, )= -23226, ]=-23225, }=-23224
	{												//this function checks whether the matching parenthesis is there or not
		int take;
		if(o.peak()==(-paren))
		{
			take=o.pop();
		}
		
		else
		{
			o.push(paren);
		}
	}	
	
	public static void main(String[] args)
	{
	
		Scanner x = new Scanner(System.in);
		
		String equation = new String();
		
		Stack optr = new Stack();
		
		
		int take, sum, take1, mult, numint, ch1, signal, ans;
		char ch;
		String line1, file1;
		Scanner line=null;
		
		System.out.print("\nEnter The File Path:-");
		file1 = x.next();
		
		File f = new File(file1);
		
		if(f.exists())
		{
			try
			{
				FileReader file=new FileReader(f);   //opening reader to read the file
				line = new Scanner(file);       //opening the scanner for file
			}
			catch(Exception e)
			{
				System.out.print("There is Some Error in file opening.......");
			}
			
			while(line.hasNextLine())
			{

				line1 = line.nextLine();         //takes the each line of file one by one
				
				char chArray[]=line1.toCharArray(); 
				
				for(int i=0;i<chArray.length;i++)
				{
					ch=chArray[i];
					
					if(ch=='{'||ch=='['||ch=='(')
					{
						optr.push(symbolCode(ch));		//pushing in operator stack
					}
					
					else if(ch=='}' || ch==']' || ch==')')
					{
						check(symbolCode(ch), optr);			//passing argument to check function
					}
					
				}
		
			}
			
			take=optr.isEmpty();
			
			if(take==-568971)
			{
				System.out.print("\n\nThe Program is Parenthetically Valid...(Parenthesis Matched)\n\n");
			}
			else
			{
				System.out.print("\n\nSorry! The Program is Parenthetically Not Valid...(Parenthesis Not Matched)\n\n");
			}
		}
		else
		{
			System.out.print("\nSorry the File does not exists....");
		}
	}

};
