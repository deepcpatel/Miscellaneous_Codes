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
	
	public void show()		//display the stack elements
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
				System.out.print("\n"+temp.item);
				
				temp=temp.next;
			}
		}
	}
};


class Hanoi
{
	public static Stack[] s;
	public static int count=1;
	
	public static void hanoi(Stack a, Stack b, Stack c, int disk)	//a=source, b=destination, c=spare		//recursion function
	{	
		
		if(disk==1)
		{
			b.push(a.pop());
			
			System.out.print("\n---------------------------------------Step:"+count+"-------------------------------------------------\n");
			
			System.out.print("\nA:-\n");
			s[0].show();
			
			System.out.print("\n\nB:-\n");
			s[1].show();
			
			System.out.print("\n\nC:-\n");
			s[2].show();
			
			System.out.print("\n----------------------------------------------------------------------------------------------\n");
			
			count++;
		}
		else
		{
			hanoi(a, c, b, disk-1);	//---
			
			b.push(a.pop());	//---
			
			System.out.print("\n---------------------------------------Step:"+count+"-------------------------------------------------\n");
		
			System.out.print("\nA:-\n");
			s[0].show();
			
			System.out.print("\n\nB:-\n");
			s[1].show();
			
			System.out.print("\n\nC:-\n");
			s[2].show();
			
			System.out.print("\n----------------------------------------------------------------------------------------------\n");
			count++;
			
			hanoi(c, b, a, disk-1);	//---
			
		}
	}
	
	public static void main(String[] arg)
	{
		int no;
		s = new Stack[3];	//s[0]=A, s[1]=B, s[2]=C
		Scanner x = new Scanner(System.in);
		
		System.out.print("\nEnter the Number of Disk in Tower A:");
		no = x.nextInt();
		
		s[0] = new Stack();
		s[1] = new Stack();
		s[2] = new Stack();
		
		for(int i=no;i>0;i--)
		{
			s[0].push(i);
		}
		
		System.out.print("\n\n*****************************************************************\n");
		System.out.print("\nThe Towers Before Solving is:-\n\n");
		
		System.out.print("\nA:-\n");
		s[0].show();
			
		System.out.print("\n\nB:-\n");
		s[1].show();
			
		System.out.print("\n\nC:-\n");
		s[2].show();
		
		System.out.print("\n\n*****************************************************************\n");
		System.out.print("\nLet's Start Solving:-\n");
		System.out.print("\n*****************************************************************\n\n");
		
		hanoi(s[0], s[1], s[2], no);
		
		System.out.print("\n\nThe Total Steps taken to Solve this Problems are:"+(count-1)+"\n\n");
	}
};
