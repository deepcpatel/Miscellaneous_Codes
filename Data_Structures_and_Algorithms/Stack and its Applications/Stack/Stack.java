import java.util.*;

class list					//list class to create list node
{
	public int item;		//variable to store data
	public list next;		//variable to store address of next node
	
	public list(int data)
	{
		item=data;
		next=null;
	}
	
};

class Stack_methods		//list class having methods to perform on list
{
	public list li;		//li is the head nodes
	public int pos;		//variable to store size of the Stack

	public Stack_methods()
	{
		li=null;
		pos=0;
	}
	
	public void push(int data)		//method to insert at front of the Stack
	{
		if(li==null)
		{
			li=new list(data);
			pos++;
		}
		
		else
		{
			list node = new list(data);
			node.next=li;
			li=node;
			pos++;
		}
		
		System.out.print("\nThe Item is Inserted Successfully.....");
		
	}
	
	public int pop()			//delete element at front
	{
	
		int take;
		
		if(li==null)
		{
			System.out.print("\nSorry, the Stack is already empty.....");
			return -1328567;
		}
		else
		{	
			take = li.item;
			
			System.out.print("\nThe First Item "+li.item+" is Deleted Successfully.....");
			li = li.next;
			pos--;
			
			return take;
			
		}
	}
	
	public int searchByPosition(int position)		//searching by position
	{
		if(li==null)
		{
			System.out.print("\nThe Stack is Empty\n");
			return -1328567;
		}
		
		else if(position>pos||position<1)
		{
			System.out.print("\nNo Such Position exists in the Stack!");
			return -1328567;
		}
		
		else
		{
			int post=1;
			
			list temp=li;
			
			while(post!=position)
			{
				temp=temp.next;
				post++;
			}
			
			System.out.print("\nThe Item "+temp.item+" is at position "+position+"\n");
			
			return temp.item;
			
		}
	}
	
	public void replaceByPosition(int position, int data)		//replacing by position
	{
		if(li==null)
		{
			System.out.print("\nThe Stack is Empty\n");
		}
		
		else if(position>pos||position<1)
		{
			System.out.print("\nNo Such Position exists in the Stack!");
		}
		
		else
		{
			int post=1, take;
			
			list temp=li;
			
			while(post!=position)
			{
				temp=temp.next;
				post++;
			}
			
			take=temp.item;
			
			temp.item=data;
			
			System.out.print("\nThe Item "+take+" is Successfully replaced by "+data+" at position "+position+"\n");
			
		}
	}
	
	public void searchByElement(int data)		//performing linear search in the list
	{
		if(li==null)
		{
			System.out.print("\nThe Stack is Empty\n");
		}
		
		else
		{
			list temp=li;
			int post=1;
			int cnt=0;
			
			while(temp!=null)
			{
				if(temp.item==data)
				{
					System.out.print("\nThe Item "+data+" is at position "+post+"\n");
					cnt=1;
				}
				temp=temp.next;
				post++;
			}
			
			if(cnt==0)
			{
				System.out.print("\nThe Item "+data+" is Nowhere found in the Stack\n");
			}
		}
	}
	
	public void replaceByElement(int data, int data2)		//performing replacing in the list
	{
		if(li==null)
		{
			System.out.print("\nThe Stack is Empty\n");
		}
		
		else
		{
			list temp=li;
			int post=1;
			int cnt=0;
			
			while(temp!=null)
			{
				if(temp.item==data)
				{
					temp.item=data2;
					
					System.out.print("\nThe Item "+data+" is replaced by "+data2+" at position "+post+"\n");
					cnt=1;
				}
				temp=temp.next;
				post++;
			}
			
			if(cnt==0)
			{
				System.out.print("\nThe Item "+data+" is Nowhere found in the Stack\n");
			}
		}
	}
	
	public void show()		//display the list elements
	{
		if(li==null)
		{
			System.out.print("\nThe Stack is Empty\n");
		}
		
		else
		{
			list temp=li;
			System.out.print("\nThe Stack is:-\n");
			
			while(temp!=null)
			{
				System.out.print("\n"+temp.item);
				temp=temp.next;
			}
		}
	}
	
	public int getListSize()		//getting the size of the list
	{
		return pos;
	}
};

class Stack
{
	public static void main(String arg[])			//main function
	{
		int choice, ans=1, element, position, size, element1, take;
		
		Scanner x = new Scanner(System.in);
	
		Stack_methods l = new Stack_methods();
		
		while(ans==1)						//Menu Driven
		{
			System.out.print("\n\n\nEnter from Below:-");
			System.out.print("\n1).Push");
			System.out.print("\n2).Pop");
			System.out.print("\n3).Peep");
			System.out.print("\n4).Replace by Element");
			System.out.print("\n5).Replace by Position");
			System.out.print("\n6).Search by Value");
			System.out.print("\n7).Search By Position/Peak");
			System.out.print("\n8).Display");
			System.out.print("\n9).Exit");
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
					
					take=l.pop();
					break;
				}
			
				case 3:
				{
					take=l.searchByPosition(1);
					
					break;
				}
				
				case 4:
				{
					System.out.print("\nEnter the Element to be replaced:");
					element = x.nextInt();
					
					System.out.print("\nEnter the New Element:");
					element1 = x.nextInt();
					
					l.replaceByElement(element,element1);
					
					break;
				}
				
				case 5:
				{
					System.out.print("\nEnter the Position to be replaced:");
					element = x.nextInt();
					
					System.out.print("\nEnter the New Element:");
					element1 = x.nextInt();
					
					l.replaceByPosition(element,element1);
					
					break;
				}
			
				case 6:
				{
					System.out.print("\nEnter the Element to be searched:");
					element = x.nextInt();
					
					l.searchByElement(element);
					break;
				}
				
				case 7:
				{
					System.out.print("\nEnter the Position to be searched:");
					element = x.nextInt();
					
					take=l.searchByPosition(element);
					break;
				}
				
				case 8:
				{
					l.show();
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