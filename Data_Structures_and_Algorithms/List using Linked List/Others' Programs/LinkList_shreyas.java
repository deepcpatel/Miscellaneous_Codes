import java.util.*;

class Node
{
	public int Data;
	public Node Next;
	
	public Node(int data)
	{
		Data=data;
		Next=null;
	}
	
	public int GetData()
	{return Data;}
}

class LinkedList
{
	private Node Head;
	
	public LinkedList()
	{
		Head=null;
	}
	
	public void Add_Data(int Pos,int Data)
	{
		Node Previous_Address=null;
		Node Dummy=Head;
		int counter=0;
		
		while(true)
		{
			if(Dummy!=null)
			{
				counter++;
				if(counter==Pos-1)
				{
					Previous_Address=Dummy;
				}
				if(counter==Pos)
				{
					Node n=new Node(Data);
					if(Pos==1)
					{
						n.Next=Head;
						Head=n;							
					}
					else
					{
						n.Next=Dummy;
						Dummy=n;
						Previous_Address.Next=Dummy;
					}
					break;
				}
				else
				{
					Dummy=Dummy.Next;
				}
			}
			else
			{
				Node n=new Node(Data);				
				n.Next=Dummy;
				Dummy=n;
			}
		}
	}
	
	
	public void Delete_Data(int Pos)
	{
		Node Dummy=Head;
		Node Previous_Address=null;
		int counter=0;
		
		while(true)
		{
			if(Dummy!=null)
			{
				counter++;
				if(counter==Pos-1)
				{
					Previous_Address=Dummy;
				}
				if(counter==Pos)
				{
					if(Pos==1)
					{
						Head=Head.Next;
					}
					else
					{
						Dummy=Dummy.Next;
						Previous_Address.Next=Dummy;
					}
					break;
				}
				else
				{
					Dummy=Dummy.Next;
				}
			}
			else
			{
				System.out.println("Sorry, no position is not found...\n");
				break;
			}
			
		}
	}
	
	public void Display()
	{
		Node Dummy=Head;
		while(true)
		{
			if(Dummy!=null)
			{
				System.out.println(Dummy.GetData());
				Dummy=Dummy.Next;
			}
			else
			{
				break;
			}
		}
	}
	
	
	public int SearchElementByValue(int Value)
	{
		Node Dummy=Head;
		int counter=0;
		while(Dummy!=null)
		{
			counter++;
			if(Dummy.GetData()==Value)
			{
				return counter;
			}
			Dummy=Dummy.Next;
		}
		return -1;
	}
	
	public int SearchByPosition(int Pos)
	{
		Node Dummy=Head;
		int counter=0;
		while(Dummy!=null)
		{
			counter++;
			if(counter==Pos)
			{
				break;
			}
			else
			{
				Dummy=Dummy.Next;
			}	
		}
		return Dummy.GetData();
	}
	
	public int GetSize()
	{
		Node Dummy=Head;
		int counter=0;
		while(Dummy!=null)
		{
			counter++;
			Dummy=Dummy.Next;
		}
		return counter;			
	}
	
	public void Sorting()
	{

		for(int i=1;i<GetSize();i++)
		{
			Node Dummy=Head;
			Node Dummy1=null;
			
			while(Dummy.Next!=null)
			{
				Dummy1 = Dummy;
				Dummy=Dummy.Next;
				
				if(Dummy.Data<Dummy1.Data)
				{
					int Temp=Dummy.GetData();
					Dummy.Data=Dummy1.Data;
					Dummy1.Data=Temp;
				}
				
			}
			
		}
	}
}


class LinkList
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		boolean t=true;int Item;
		
		LinkedList L=new LinkedList();
	

		do{
			System.out.println("\n\n");
			System.out.println("WHAT YOU WANT TO DO?");
			System.out.println("1) :- Add Member");
			System.out.println("2) :- Delete Member");
			System.out.println("3) :- Display Member");
			System.out.println("4) :- Search Member");			
			System.out.println("5) :- Sorting");
			System.out.println("6) :- Exit");
			System.out.print("CHOICE :- ");
			int choice = input.nextInt();
			
			switch(choice)
			{
				case 1:
							System.out.print("\n\nEnter Item :- ");
							Item=input.nextInt();
							boolean d=false;
							do{
								
								System.out.println("\n\n");
								System.out.println("1) :- First ADD");
								System.out.println("2) :- LAST ADD");
								System.out.println("3) :- POSITION ADD");
								System.out.print("CHOICE :- ");
								int choice1 = input.nextInt();
								
								switch(choice1)
								{
									case 1:
											L.Add_Data(1,Item);
									break;
									case 2:
											L.Add_Data(L.GetSize(),Item);											
									break;
									case 3:
											System.out.print("\n\nEnter Position :- ");
											int P=input.nextInt();
											L.Add_Data(P,Item);
									break;
									default:
										d=true;
								}
							}while(d);
						
				break;
				case 2:
							boolean s=false;
							System.out.print("\n\nFrom Which Position YOU WANT TO DELETE ITEM?? [ENTER INT]");
							System.out.print("\n1 ) First Position");
							System.out.print("\n2 ) Last Position [ENTER INT]");
							System.out.print("\n3 ) AT Given Position [ENTER INT]\n");
							System.out.print("\nCHOICE :- ");
							int choice2=input.nextInt();
							
							do{
								
								if(choice2==1)
								{
									L.Delete_Data(1);	
								}
								else if(choice2==2)
								{
									L.Delete_Data(L.GetSize());	
								}
								else if(choice2==3)
								{
									L.Display();
									System.out.println("From which position you want to delete? [Enter int]");
									int choice3=input.nextInt();
									L.Delete_Data(choice3);
								}
								else
								{
									s=true;
								}
									
								
							}while(s);
				break;
				case 3:
						L.Display();
				break;
				case 4:
							System.out.println("\n\n\n1 :- Search by Value");
							System.out.println("2 :- Search by Position");
							System.out.print("CHOICE :- ");
							int choice4=input.nextInt();
							
							switch(choice4)
							{
								case 1:
										System.out.print("Enter Item :- ");
										Item=input.nextInt();
										if(L.SearchElementByValue(Item)!=-1)
										{
											System.out.println("\n\nPOSITION :- "+L.SearchElementByValue(Item));
										}
										else
										{
											System.out.println("\n\nNO POSITION FOUND");
										}								
								break;
								case 2:
										System.out.print("Enter Position :- ");
										int position_temp=input.nextInt();
										if(L.SearchByPosition(position_temp)!=0)
										{
											System.out.println("\n\nVALUE AT THAT POSITION :- "+L.SearchByPosition(position_temp));
										}
										else
										{
											System.out.println("\n\nNO VALUE FOUND");
										}																
								break;
								default:
										System.out.println("\nINVALID CHOICE\n");
							}
				break;
				case 5:
						L.Sorting();
						L.Display();
				break;
				case 6:
						t=false;
				break;
				default:
					System.out.println("INVALID CHOICE");
			}
		}while(t);					
	}
}