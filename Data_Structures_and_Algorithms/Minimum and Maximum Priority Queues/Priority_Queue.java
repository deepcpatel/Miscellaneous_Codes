import java.util.*;


abstract class parentQueue		//parent class declared abstract
{
	public int[] array=null;	//variables required for priority queues
	public int size;
	public int front;
	public int rear;
	
	public parentQueue(int sz)
	{
		size=sz;
		array = new int[size+1];
		array[0]=-1;
		front=1;
		rear=1;
	}
	
	public abstract void push(int data);	//compulsory functions
	public abstract int pop();
	public abstract int getQueueSize();
	public abstract void show();
}

class MinQueueMethods extends parentQueue		//Child Class having methods to perform on Minimum Priority Queue
{
	
	public MinQueueMethods(int sz)		//constructor
	{
		super(sz);
	}
	
	public void push(int data)	//push function to insert in priority queue
	{
		if(front>size)
		{
			System.out.print("\nSorry The Priority Queue is Full........");
		}
		else
		{
			if(front==1)
			{
				array[front]=data;
				front++;
			}
			else
			{
				int temp=front;
				int tempvar;
				
				array[front]=data;
				
				while(temp!=1)
				{
					if(array[temp]<array[(temp/2)])
					{
						tempvar=array[(temp/2)];
						array[(temp/2)]=array[temp];
						array[temp]=tempvar;
						
						temp=temp/2;
					}
					else
					{
						break;
					}
				}
				
				
				front++;
			}
			
			System.out.print("\nData is Pushed Successfully in The Priority Queue...");
		}
	}
	
	public int pop()		//pop function to delete from priority queue
	{
		int deleted;
		int temp;
		int tempPt;
		int minimum;
		
		if(front==rear)
		{
			System.out.print("\nSorry The Priority Queue is Already Empty..\n");
			front=1;
			rear=1;
			deleted=-23221;		//null number
			
		}
		else
		{
			tempPt=rear;
			deleted=array[rear];
			array[rear]=array[(front-1)];
			front--;
			
			while(tempPt<front)						//Min Heapify
			{
				if(((2*tempPt)<front)||(((2*tempPt)+1)<front))
				{
					if(((2*tempPt)+1)<front)
					{
						minimum=min((2*tempPt),((2*tempPt)+1));
						
						if(array[tempPt]>array[minimum])
						{
							temp=array[tempPt];
							array[tempPt]=array[minimum];
							array[minimum]=temp;
							
							tempPt=minimum;
						}
						else
						{
							break;
						}
					}
					else if(((2*tempPt)+1)>(front-1))
					{
						if(array[tempPt]>array[2*tempPt])
						{
							temp=array[tempPt];
							array[tempPt]=array[2*tempPt];
							array[2*tempPt]=temp;
							
							tempPt=2*tempPt;
						}
						else
						{
							break;
						}
					}
				}
				else
				{
					break;
				}
			}
			
			
		}
		
		return deleted;
	}
	
	private int min(int a, int b)		//private function to find minimum of child nodes
	{
		if(array[a]<=array[b])
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	
	public void show()		//display function
	{
		if(rear==front)
		{
			System.out.print("\nSorry The Priority Queue is Empty....\n");
		}
		else
		{
			System.out.print("\nThe Priority Queue is:-\n");
			
			for(int i=rear; i<front; i++)
			{
				System.out.print(array[i]+"\n");
			}
		}
	}
	
	public int getQueueSize()		//getting the size of the Queue
	{
		return (front-rear);
	}
};

class MaxQueueMethods extends parentQueue	//Child Class having methods to perform on Maximum Priority Queue
{
	
	public MaxQueueMethods(int sz)	//constructor
	{
		super(sz);
	}
	
	public void push(int data)	//push function to insert in priority queue
	{
		if(front>size)
		{
			System.out.print("\nSorry The Priority Queue is Full........");
		}
		else
		{
			if(front==1)
			{
				array[front]=data;
				front++;
			}
			else
			{
				int temp=front;
				int tempvar;
				
				array[front]=data;
				
				while(temp!=1)
				{
					if(array[temp]>array[(temp/2)])
					{
						tempvar=array[(temp/2)];
						array[(temp/2)]=array[temp];
						array[temp]=tempvar;
						
						temp=temp/2;
					}
					else
					{
						break;
					}
				}
				
				
				front++;
			}
			
			System.out.print("\nData is Pushed Successfully in The Priority Queue...");
		}
	}
	
	public int pop()		//pop function to delete from priority queue
	{
		int deleted;
		int temp;
		int tempPt;
		int maximum;
		
		if(front==rear)
		{
			System.out.print("\nSorry The Priority Queue is Already Empty..\n");
			front=1;
			rear=1;
			deleted=-23221;		//null number
			
		}
		else
		{
			tempPt=rear;
			deleted=array[rear];
			array[rear]=array[(front-1)];
			front--;
			
			while(tempPt<front)				//Max Heapify
			{
				if(((2*tempPt)<front)||(((2*tempPt)+1)<front))
				{
					if(((2*tempPt)+1)<front)
					{
						maximum=max((2*tempPt),((2*tempPt)+1));
						
						if(array[tempPt]<array[maximum])
						{
							temp=array[tempPt];
							array[tempPt]=array[maximum];
							array[maximum]=temp;
							
							tempPt=maximum;
						}
						else
						{
							break;
						}
					}
					else if(((2*tempPt)+1)>(front-1))
					{
						if(array[tempPt]<array[2*tempPt])
						{
							temp=array[tempPt];
							array[tempPt]=array[2*tempPt];
							array[2*tempPt]=temp;
							
							tempPt=2*tempPt;
						}
						else
						{
							break;
						}
					}
				}
				else
				{
					break;
				}
			}
			
			
		}
		
		return deleted;
	}
	
	private int max(int a, int b)	//private function to get max of child nodes
	{
		if(array[a]<=array[b])
		{
			return b;
		}
		else
		{
			return a;
		}
	}
	
	public void show()		//display functions
	{
		if(rear==front)
		{
			System.out.print("\nSorry The Priority Queue is Empty....\n");
		}
		else
		{
			System.out.print("\nThe Priority Queue is:-\n");
			
			for(int i=rear; i<front; i++)
			{
				System.out.print(array[i]+"\n");
			}
		}
	}
	
	public int getQueueSize()		//getting the size of the Queue
	{
		return (front-rear);
	}
};

//-----------------------------------------------------------------------------------------------

class Priority_Queue
{
	public static void main(String arg[])			//main function
	{
		int choice, ans=1, element, position, size, take;
		parentQueue l=null;
		
		Scanner x = new Scanner(System.in);
		
		System.out.print("\nEnter the Size of the Priority Queue:");
		size = x.nextInt();
		
		System.out.print("\n\n\nEnter from Below:-");
		System.out.print("\n1).Max Priority Queue");
		System.out.print("\n2).Min Priority Queue");
		System.out.print("\nEnter:");
		choice = x.nextInt();
		
		if(choice==1)
		{
			l = new MaxQueueMethods(size);
		}
		else
		{
			l = new MinQueueMethods(size);
		}
		
		while(ans==1)						//Menu Driven Code
		{
			System.out.print("\n\n\nEnter from Below:-");    
			System.out.print("\n1).Push");
			System.out.print("\n2).Pop");
			System.out.print("\n3).Display");
			System.out.print("\n4).See the Size of the Priority Queue");
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
					take=l.pop();
					if(take!=-23221)
					{
						System.out.print("\nThe Deleted Element is:"+take+"\n");
					}
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