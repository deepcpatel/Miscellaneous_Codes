import java.util.*;

class list
{
	public int[] list;
	public int size;
	public int pos;
	
	public list(int n)
	{
		size = n;
		list = new int[n];
		pos=0;
	
	}
	
	public void InsertFirst(int item)
	{
		if(pos==size)
		{
			System.out.print("\nSorry the list is full.......");
		}
		
		else
		{	
			pos++;
			
			for(int i=pos-1;i>0;i--)
			{
				list[i]=list[i-1];
			}
			
			list[0]=item;
		
			System.out.print("\nThe item Inserted Successfully.....");
		}
		
	}
	
	public void InsertLast(int item)
	{
		if(pos==size)
		{
			System.out.print("\nSorry the list is full.......");
		}
		
		else
		{	

			list[pos]=item;
			
			pos++;
		
			System.out.print("\nThe item Inserted Successfully.....");
		}
		
	}
	
	public void InsertAtPosition(int item, int position)
	{
		if(pos==size)
		{
			System.out.print("\nSorry the list is full.......");
		}
		
		else if(position-1>pos||position-1<0)
		{
			System.out.print("\nThe position is Invalid!");
		}
		
		else
		{	
			pos++;
			
			int temp_pos=position-1;
			
			for(int i=pos-1;i>temp_pos;i--)
			{
				list[i]=list[i-1];
			}
			
			list[temp_pos]=item;
			
			System.out.print("\nThe item Inserted Successfully.....");
		}
		
	}

	public void DeleteFirst()
	{
		if(pos==0)
		{
			System.out.print("\nSorry the list is already Empty.......");
		}
		
		else
		{	
			System.out.print("\nThe first item:"+list[0]+" is Deleted Successfully.....");
			
			for(int i=0;i<pos-1;i++)
			{
				list[i]=list[i+1];
			}
			
			pos--;
			
		}
		
	}
	
	public void DeleteLast()
	{
		if(pos==0)
		{
			System.out.print("\nSorry the list is already Empty.......");
		}
		
		else
		{	
			System.out.print("\nThe last item:"+list[pos-1]+" is Deleted Successfully.....");
			pos--;
		
		}
		
	}
	
	public void DeleteAtPosition(int position)
	{
		if(pos==0)
		{
			System.out.print("\nSorry the list is already Empty.......");
		}
		
		else if(position-1>pos||position-1<0)
		{
			System.out.print("\nThe position is Invalid!");
		}
		
		else
		{	
			int temp_pos=position-1;
		
			System.out.print("\nThe Item "+list[temp_pos]+" at Position "+position+" is Deleted Successfully.....");
			
			for(int i=temp_pos;i<pos-1;i++)
			{
				list[i]=list[i+1];
			}
			
			pos--;
			
		}
		
	}
	
	public void Display()
	{
	
		System.out.print("\n\nThe List is:-\n");
		
		for(int i=0;i<pos;i++)
		{
			System.out.print("\n"+list[i]+"\n");
		}
	
	}
	
	public void SearchByValue(int item)	//Linear Search
	{
		
		int flag=0;
		
		for(int i=0;i<pos;i++)
		{
			
			if(list[i]==item)
			{
				flag=1;
				
				System.out.print("\nThe Element is at Position:"+(i+1)+"\n");
			}
		}
		
		if(flag==0)
		{
			System.out.print("\nThe Element you were searching for was not found.....");
		}
	}
	
	public void SearchByPosition(int position)	//Linear Search
	{
		if(pos==0)
		{
			System.out.print("\nSorry the list is already Empty.......");
		}
		
		else if(position-1>pos||position-1<0)
		{
			System.out.print("\nThe position is Invalid!");
		}
		else
		{
			System.out.print("\nThe Value at Posiion "+position+" is:"+list[position-1]);
		}
	}
	
	public void Sort()		//Bubble Sort
	{
		int temp;
		
		for(int i=0;i<pos-1;i++)
		{
			for(int j=0;j<pos-1;j++)
			{
				if(list[j]>list[j+1])
				{
					temp=list[j];
					list[j]=list[j+1];
					list[j+1]=temp;
				}
			}
		}
		
		System.out.print("\nThe List is Sorted Successfully............");
	}
	
};

class Array
{
	public static void main(String[] arg)
	{
		int n, choice, ans=1, element, position;
		Scanner x = new Scanner(System.in);
		
		System.out.print("\nEnter Size of List:");
		n = x.nextInt();
		
		list l = new list(n);
		
		while(ans==1)
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
			System.out.print("\n11).Exit");
			System.out.print("\n\nEnter:");
			
			choice = x.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					l.InsertFirst(element);
					break;
				}
				
				case 2:
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					System.out.print("\nEnter the Position at which to Insert:");
					position = x.nextInt();
					
					l.InsertAtPosition(element, position);
					break;

				}
				
				case 3:	
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					l.InsertLast(element);
					break;

				}
				
				case 4:
				{
					
					l.DeleteFirst();
					break;
				}
				
				case 5:
				{
					System.out.print("\nEnter the Position at which to Insert:");
					position = x.nextInt();
					
					l.DeleteAtPosition(position);
					break;
				}
				
				case 6:
				{
					l.DeleteLast();
					break;
				}
				
				case 7:
				{
					l.Sort();
					break;
				}
				
				case 8:
				{
					System.out.print("\nEnter the Element to be searched:");
					element = x.nextInt();
					
					l.SearchByValue(element);
					break;
				}
				
				case 9:
				{
					System.out.print("\nEnter the Position to be searched:");
					element = x.nextInt();
					
					l.SearchByPosition(element);
					break;
				}
				
				case 10:
				{
					l.Display();
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