import java.util.*;

class list				//list class to create Queue node
{
	public int item;		//variable to store data
	public list next;		//variable to store address of next node
	
	public list(int data)
	{
		item=data;
		next=null;
	}
	
};

class linked_list_methods		//list class having methods to perform on Queue
{
	public list li;		//li is the head node
	public list li1;	//li is the tail node
	public int pos;		//variable to store size of the Queue

	public linked_list_methods()
	{
		li=null;
		li1=null;
		pos=0;
	}
	
	public void push(int data)	//method to insert at last of the Queue
	{
		if(li==null)
		{
			li=new list(data);
			pos++;
		}
		
		else
		{
			if(li1==null)
			{
				li1 = new list(data);
				li.next = li1;
				pos++;
			}
			
			else
			{
				list node=new list(data);
				
				li1.next=node;
				li1=node;
				
				pos++;
			}
		}
		
		System.out.print("\nThe Item is Inserted Successfully.....");
		
	}
	
	public void pop()			//delete element at front
	{
		if(li==null)
		{
			System.out.print("\nSorry, the Queue is already empty.....");
		}
		else
		{
			System.out.print("\nThe First Item "+li.item+" is Deleted Successfully.....");
			
			if(li==li1)
			{
				li1 = null;
			}
			
			li = li.next;
			pos--;
		}
	}
	
	public void show()		//display the Queue elements
	{
		if(li==null)
		{
			System.out.print("\nThe Queue is Empty\n");
		}
		
		else
		{
			list temp=li;
			System.out.print("\nThe Queue is:-\n");
			
			while(temp!=null)
			{
				System.out.print("\n"+temp.item);
				temp=temp.next;
			}
		}
	}
	
	public int getQueueSize()		//getting the size of the Queue
	{
		return pos;
	}
};

class Queue
{
	public static void main(String arg[])			//main function
	{
		int choice, ans=1, element, position, size;
		
		Scanner x = new Scanner(System.in);
	
		linked_list_methods l = new linked_list_methods();
		
		while(ans==1)						//Menu Driven
		{
			System.out.print("\n\n\nEnter from Below:-");    
			System.out.print("\n1).Push");
			System.out.print("\n2).Pop");
			System.out.print("\n3).Display");
			System.out.print("\n4).See the Size of the Queue");
			System.out.print("\n5).Exit");
			System.out.print("\n\nEnter:");
			
			choice = x.nextInt();
			
			switch(choice)
			{
				case 1:	
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					l.push(element);
					break;

				}
				
				case 2:
				{
					l.pop();
					break;
				}
				
				case 3:
				{
					l.show();
					break;
				}
				
				case 4:
				{
					size=l.getQueueSize();
					
					System.out.print("\nThe Size of the Queue is:"+size+"\n");
					
					break;
				}
				
				default:
				{
					System.out.print("\nBye.....\n\n");
					ans=2;
					
				}

			}
		
		}
	}
};