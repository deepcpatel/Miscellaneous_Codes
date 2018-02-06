import java.util.*;
class list
{
    public int data;
    public list next;
    public list(int val)
    {
		data = val;	
        next = null;
    }
}
public class main_maunil
{
		list head;
		
		public void insertstart(int val)
		{
			list temp=null;
			//what this mean?
			if(head == null)
			{
				temp = new list(val);
				head = temp;
			}
			else
			{	
				temp = new list(val);
				temp.next = head;
				head = temp;	
			}
			
		}
		public void view()
		{
			list temp = head;
			if(temp== null)
			{
				System.out.println("Null");
			}
			else
			{
				while(temp!=null)
				{
					System.out.println("Your value is "+temp.data);
					temp = temp.next;
				}
			}
			
			
		}
		
		public void insertlast(int val)
		{
			list temp = head;
			list base;
			while(temp.next!=null)
			{
				temp = temp.next;
			}  
			base = new list(val);
			temp.next = base; 
		}	
		public void insertbetween(int po,int val)
		{
            list temp=head;
			list temp1;
			list base=head;
			for (int i=0;i<po-1;i++)
			{
				temp = temp.next;
			}
			for(int j = 0;j<po-2;j++)
			{
				base = base.next;
			}
			temp1 = new list(val);
			temp1.next = temp;
			base.next = temp1;
		}
		public void deletefirst()
		{     
               head = head.next;		   
		}
	    public void deletepostion(int po)
        {
            list temp=head;
			list temp1=head;
			for(int i=0;i<po-2;i++)
			{
				temp = temp.next;
			}
			for(int i=0;i<po;i++)
			{	
				temp1 = temp1.next;
			}
			temp.next = temp1;
			
        }
        public void deletelast() // look this tomorrow 
        {
				int c=0;
				list temp = head;
				list temp2= head;
				while(temp!=null)
				{
					 temp = temp.next;
					 c = c+1;
				}
				
				while(temp2.next!=temp)
				{
					temp2=temp2.next;
				}
			
				temp2.next=null;				
        }
        public void search(int n)
        {
			int c=0;
			list temp  = head;
			if(temp==null)
			{
				System.out.println("List is Empty");
			
			}
			else
			{
				while(temp.data!=n && temp!=null)
				{
						temp=temp.next;
						c = c+1;	
				}
			
				if(temp==null)
				{
						System.out.println("There  is no such value exist");
				}
				else
				{
					System.out.println("Your Data Position is ="+(c+1));
				}
			}
        }
        /*public void sort()
        {
            for(int i=0;i<pos;i++)
            {
                for(int j=i+1;j<=pos-1;j++)
                {
                        if(list[i]>list[j])
                        {
                            int y;
                            y = list[i];
                            list[i]=list[j];
                            list[j]=y;
                        }
                }       
            }
            view();
        }*/
	public static void main(String[] args)
    {
		
				Scanner in = new Scanner(System.in);
				int always=1,va,choice;
				main_maunil li= new main_maunil();
				while(always==1)
                {
				System.out.println("\nPress 0 to add element in list");
				System.out.println("\nPress 1 to do  See List");           
				System.out.println("\nPress 2 to do Delete at any position");
				System.out.println("\nPress 3 to add at the end");
				System.out.println("\nPress 4 to add in between");
				System.out.println("\nPress 5 to Delete first one");
                System.out.println("\nPress 6 to Delete at last");
                System.out.println("\nPress 7 to Sort Ellements");
                System.out.println("\nPress 8 to Search");
				System.out.println("\nPress 9 to do exit");
				System.out.println("\nEnter Your Choice->");
				choice = in.nextInt();
				switch(choice)
				{
						case 0:
						{
							System.out.println("Enter Element");
							va = in.nextInt();
							li.insertstart(va);
							break;
						}
						case 1:
						{
							li.view();
							break;	
						}
						case 2:
						{
							System.out.println("Enter Position");
							va=in.nextInt();
							li.deletepostion(va);
							break;
						}
						case 3:	
						{
							System.out.println("Enter value=");
							va =in.nextInt();
							li.insertlast(va);
							break;
						}
						case 4:
						{
							System.out.println("Enter Position");
							int po = in.nextInt();
							System.out.println("Enter value");
							va=in.nextInt();
							li.insertbetween(po,va);
							break;
						}
						case 5:
						{
							li.deletefirst();
							break;
						}
						/*case 6:
						{
							li.deletelast();
							break;
						}
						/*case 7:
						{
							System.out.println("Here You can see Bybble Sort");
							obj.sort();
							break;
						}*/
						case 8:
						{
							System.out.println("Enter value for Search");
							va = in.nextInt();
							li.search(va);
							break;
							
						}
						/*case 9:
						{
							System.exit(0);
						}
						default:
						{
							System.exit(0);
				
						}*/
						}
							System.out.println("Do you want to continue then Press (1) or else Press (2)");
							always = in.nextInt();
						}
		
		
		
			}

	}


