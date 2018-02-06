import java.util.*;

class list				//list class to create list node
{
	public int item;		//variable to store data
	public list next;		//variable to store address of next node
	
	public list(int data)
	{
		item=data;
		next=null;
	}
	
};

class linked_list_methods		//list class having methods to perform on list
{
	public list li;		//li is the head nodes
	public int pos;		//variable to store size of the array

	public linked_list_methods()
	{
		li=null;
		pos=0;
	}
	
	public void insert_front(int data)		//method to insert at front of the list
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
	
	public void insert_last(int data)	//method to insert atlast of the list
	{
		if(li==null)
		{
			li=new list(data);
			pos++;
		}
		
		else
		{
			list temp=null;
			list node=new list(data);
			
			temp=li;
			
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			
			temp.next=node;
			
			pos++;
		}
		
		System.out.print("\nThe Item is Inserted Successfully.....");
		
	}
	
	public void insert_position(int data, int position)		//method to insert at desired position in list
	{
		if(position>(pos+1)||position<1)
		{
			System.out.print("\nThe Position is Invalid!");
		}
		
		else if(position==1)
		{
			insert_front(data);
		}
		
		else if(position==(pos+1))
		{
			insert_last(data);
		}
		
		else
		{
			list temp=li.next;
			list base=null;
			list node = new list(data);
			int counter=2, store;
			
			while(counter!=position)
			{
				temp=temp.next;
				counter++;
			}
			
			store=temp.item;
			node.next=temp.next;
			temp.item=node.item;
			node.item=store;
			temp.next=node;
			
			pos++;
			
			System.out.print("\nThe Item is Inserted Successfully.....");
		}
		
	}
	
	public void delete_front()			//delete element at front
	{
		if(li==null)
		{
			System.out.print("\nSorry, the list is already empty.....");
		}
		else
		{
			System.out.print("\nThe First Item "+li.item+" is Deleted Successfully.....");
			li = li.next;
			pos--;
		}
	}
	
	public void delete_last()		//delete element at last
	{
		if(li==null)
		{
			System.out.print("\nSorry, the list is already empty.....");
		}
		else
		{
			
			list temp=li;
			
			while((temp.next).next!=null)
			{
				temp=temp.next;
			}
			
			System.out.print("\nThe Last Item "+(temp.next).item+" is Deleted Successfully.....");
			
			temp.next=null;
			
			pos--;
		}
	}
	
	public void delete_position(int position)		//delete from desired position
	{
		if(li==null)
		{
			System.out.print("\nSorry, the list is already empty.....");
		}
		
		else if(position>pos||position<1)
		{
			System.out.print("\nThe position is Invalid!");
		}
		
		else if(position==1)
		{
			delete_front();
		}
		
		else if(position==pos)
		{
			delete_last();
		}
		
		else
		{
			int post=1;
			
			list temp=li;
			
			while(post!=(position-1))
			{
				temp=temp.next;
				post++;
			}
			
			System.out.print("\nThe Item "+(temp.next).item+" at position "+position+" is Deleted Successfully.....");
			
			temp.next=(temp.next).next;
			
			pos--;
		}
	}
	
	public void sort()		//sorting the list using bubble sort
	{
		int take;
		
		for(int i=0;i<pos;i++)
		{
			list temp=li;
			list temp1=null;
			
			while(temp.next!=null)
			{
				temp1 = temp;
				temp=temp.next;
				
				if(temp1.item>temp.item)
				{
					take=temp.item;
					temp.item=temp1.item;
					temp1.item=take;
				}
				
			}
			
		}
		
		System.out.print("\n\nThe List is Sorted Successfully\n\n");
	}
	
	public void searchByPosition(int position)		//searching by position
	{
		if(li==null)
		{
			System.out.print("\nThe List is Empty\n");
		}
		
		else if(position>pos||position<1)
		{
			System.out.print("\nNo Such Position exists in the list!");
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
			
		}
	}
	
	public void searchByElement(int data)		//performing linear search in the list
	{
		if(li==null)
		{
			System.out.print("\nThe List is Empty\n");
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
				System.out.print("\nThe Item "+data+" is Nowhere found in the List\n");
			}
		}
	}
	
	public void reverse()			//performing reverse operation
	{
		list temp;
		int take_temp, take_pos=pos;
		
		for(int i=0;i<pos;i++)
		{
			temp=li;
			
			for(int j=1;j<take_pos;j++)
			{
				take_temp=temp.item;
				temp.item=(temp.next).item;
				(temp.next).item=take_temp;
				
				temp=temp.next;
			}
			take_pos--;
		}
		
		System.out.print("\nThe List is Reversed Successfully....\n");
	}
	
	public void show()		//display the list elements
	{
		if(li==null)
		{
			System.out.print("\nThe List is Empty\n");
		}
		
		else
		{
			list temp=li;
			System.out.print("\nThe List is:-\n");
			
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

class Linked_List
{
	public static void main(String arg[])			//main function
	{
		int choice, ans=1, element, position, size;
		
		Scanner x = new Scanner(System.in);
	
		linked_list_methods l = new linked_list_methods();
		
		while(ans==1)						//Menu Driven
		{
			System.out.print("\n\n\nEnter from Below:-");
			System.out.print("\n1).Add at First Position");
			System.out.print("\n2).Add at Desired Position");           
			System.out.print("\n3).Add at Last Position");
			System.out.print("\n4).Delete from First Position");
			System.out.print("\n5).Delete from Desired Position");
			System.out.print("\n6).Delete from Last Position");
			System.out.print("\n7).Sort");
			System.out.print("\n8).Search by Value");
			System.out.print("\n9).Search By Position");
			System.out.print("\n10).Display");
			System.out.print("\n11).See the Size of the List");
			System.out.print("\n12).Reverse the List");
			System.out.print("\n13).Exit");
			System.out.print("\n\nEnter:");
			
			choice = x.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					l.insert_front(element);
					break;
				}
				
				case 2:
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					System.out.print("\nEnter the Position at which to Insert:");
					position = x.nextInt();
					
					l.insert_position(element, position);
					break;

				}
				
				case 3:	
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					l.insert_last(element);
					break;

				}
				
				case 4:
				{
					
					l.delete_front();
					break;
				}
				
				case 5:
				{
					System.out.print("\nEnter the Position at which to Delete:");
					position = x.nextInt();
					
					l.delete_position(position);
					break;
				}
				
				case 6:
				{
					l.delete_last();
					break;
				}
				
				case 7:
				{
					l.sort();
					System.out.print("\nThe Sorted List is:-\n");
					l.show();
					break;
				}
				
				case 8:
				{
					System.out.print("\nEnter the Element to be searched:");
					element = x.nextInt();
					
					l.searchByElement(element);
					break;
				}
				
				case 9:
				{
					System.out.print("\nEnter the Position to be searched:");
					element = x.nextInt();
					
					l.searchByPosition(element);
					break;
				}
				
				case 10:
				{
					l.show();
					break;
				}
				
				case 11:
				{
					size=l.getListSize();
					
					System.out.print("\nThe Size of the List is:"+size+"\n");
					
					break;
				}
				
				case 12:
				{
					l.reverse();
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