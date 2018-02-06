import java.util.*;

class list				//list class to create queue node
{
	public int item;		//variable to store data
	public list next1;		//variable to store address of previous node
	public list next2;		//variable to store address of next node
	
	public list(int data)
	{
		item=data;
		next1=null;
		next2=null;
	}
	
};

class QueueGeneration		//performs Operations on and Generation of Circular Queue
{
	public list li;			//li is the head node
	public list li1;		//li1 is the tail node
	public int last;		//Stores Last Operation Performed
	public int pos;		    //Current Size of Queue
	public int Finalpos;	//size of the Queue
	
	public QueueGeneration()
	{
		li=null;
		li1=null;
		pos=1;
		last=-1;
		Finalpos=-1;
	}
	
	public void generate(int no)
	{
		Finalpos=no;
		
		for(int i=0;i<no;i++)
		{
			insert_last(-1);
		}
		
		li.next1=li1;
		li1.next2=li;
		li1=li;
	}
	
	public void insert_last(int data)	//method to insert at last of the Queue
	{
		if(li==null)
		{
			li=new list(data);
		}
		
		else
		{
			if(li1==null)
			{
				li1 = new list(data);
				li.next2 = li1;
				li1.next1 = li;
			}
			
			else
			{
				list node=new list(data);
				
				li1.next2 = node;
				node.next1 = li1;
				li1 = node;
			}
		}
		
	}
	
	public void push(int data)								//method to push into the Queue
	{
		if(li==li1 && last == 1)
		{
			System.out.print("\n\nSorry! the Queue is Full\n\n");
		}
		
		else
		{
			li.item = data;
			li = li.next2;
			last=1;
			pos++;
			System.out.print("\n\nThe Element is Inserted Successfully.........\n\n");
		}
	}
	
	public void pop()								//method to push into the Queue
	{
		if(li==li1 && last == -1)
		{
			System.out.print("\n\nSorry! the Queue is Empty\n\n");
		}
		
		else
		{
			System.out.print("\n\nThe "+li1.item+" is popped out...\n\n");
			li1 = li1.next2;
			last=-1;
			pos--;
		}
	}
	
	public void show()		//display the Queue elements
	{
		if(li==li1 && last==-1)
		{
			System.out.print("\nThe Circular Queue is Empty\n");
		}
		
		else
		{
			list temp=li1;
			System.out.print("\nThe Circular Queue is:-\n");
			
			int counter=1;
			
			while(counter!=pos)
			{
				System.out.print("\n"+temp.item);
				temp=temp.next2;
				counter++;
			}
		}
	}
	
	public int getQueueSize()		//getting the size of the Queue
	{
		return Finalpos;
	}
};

class CircularQueue
{
	public static void main(String arg[])			//main function
	{
		int choice, ans=1, element, position, size;
		
		Scanner x = new Scanner(System.in);
	
		QueueGeneration l = new QueueGeneration();
		
		System.out.print("\nEnter the Size of The Circular Queue:");
		size = x.nextInt();
		
		l.generate(size);
		
		while(ans==1)						//Menu Driven
		{
			System.out.print("\n\n\nEnter from Below:-");
			System.out.print("\n1).Push");
			System.out.print("\n2).Pop");           
			System.out.print("\n3).See the Size of the Queue");
			System.out.print("\n4).Display the Queue");
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
					size=l.getQueueSize();
					
					System.out.print("\nThe Size of the Circular Queue is:"+size+"\n");
					
					break;
				}
				
				case 4:
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