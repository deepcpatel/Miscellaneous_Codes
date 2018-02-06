import java.util.*;

class list					//list class to create BST node
{
	public int item;		//variable to store data
	public list left;		//variable to store address of left node
	public list right;		//variable to store address of right node
	
	public list(int data)
	{
		item=data;
		left=null;
		right=null;
	}
	
};

class bst_methods		//bst_methods class having methods to perform on Binary Search Trees(BST)
{
	public list li;			//li is the root node
	public int pos;			//variable to store height/depth of the tree
	private int leftright;	//left=1, right=2, stores the last direction of the child
	private list parent;	//storing the parent node
	
	public bst_methods()	//constructor
	{
		li=null;
		pos=0;
		leftright=-1;
		parent=null;
	}
	
	public void insert(int data)		//method to insert in the BST
	{
		if(li==null)
		{
			li=new list(data);
		}
		
		else
		{
			int i=0;
			list node = new list(data);
			list temp=li;
			
			while(true)
			{
				if(data<temp.item)
				{
					if(temp.left==null)
					{
						temp.left=node;
						break;
					}
					else
					{
						temp=temp.left;
					}
				}
				else
				{
					if(temp.right==null)
					{
						temp.right=node;
						break;
					}
					else
					{
						temp=temp.right;
					}
				}
				i++;
			}
			
		}
		
		pos++;
		
		System.out.print("\nThe Item is Inserted Successfully.....");
		
	}
	

	public void delete(int element)		//delete element in BST
	{
		list temp;
		int lrc;
		
		if(li==null)
		{
			System.out.print("\nSorry the Tree is Empty....");
		}
		else 
		{
			
			temp = searchByElementParent(element);
			
			if(temp==li)
			{
				lrc = checklr(temp);
				
				switch(lrc)
				{
					case 0: li=null;
							break;
					
					case 1: li=li.right;
							break;
					
					case 2: li=li.left;
							break;
					
					default:li.item=minimum(li);
							if(leftright==1)
							{
								parent.left=null;
							}
							else
							{
								parent.right=null;
							}
							
							break;
							
				}
				pos--;
				System.out.print("\n\nThe Node is Deleted Successfully...\n");
			}
			else if(temp==null && parent==null)
			{
				System.out.print("\n\nSorry the element is not Found......\n");	
			}
			else
			{
				lrc = checklr(temp);
				
				switch(lrc)
				{
					case 0: if(leftright==1)
							{
								parent.left=null;
							}
							else
							{
								parent.right=null;;
							}
							break;
					
					case 1: if(leftright==1)
							{
								parent.left=(parent.left).right;
							}
							else
							{
								parent.right=(parent.right).right;
							}
							break;
					
					case 2: if(leftright==1)
							{
								parent.left=(parent.left).left;
							}
							else
							{
								parent.right=(parent.right).left;
							}
							break;
					
					default:temp.item=minimum(temp);
							if(leftright==1)
							{
								parent.left=null;
							}
							else
							{
								parent.right=null;
							}
							
							break;
							
				}
				
				pos--;
				System.out.print("\n\nThe Node is Deleted Successfully...\n");
			}
			
		}

	}
	
	private int checklr(list node)		//checking whether right as well as left child is present or not for internal use
	{
		if(node.left==null && node.right==null)
		{
			return 0;
		}
		
		else if(node.left==null && node.right!=null)
		{
			return 1;
		}
		
		else if(node.left!=null && node.right==null)
		{
			return 2;
		}
		
		else
		{
			return 3;
		}
	}
	
	private int minimum(list root)		//finding minimum element as well as its parent in BST for internal use
	{
		list dummy=null;
		
		if(root.right!=null)
		{
			dummy=root.right;
			parent=root;
			leftright=2;
			
			while(dummy.left!=null)
			{
				parent=dummy;
				dummy = dummy.left;
				leftright=1;
			}
		}
		
		return dummy.item;
	}
	
	private list searchByElementParent(int data)		//performing search of parent node as well as required node in the BST for internal use
	{
		list temp=null;
		parent=null;
		
		if(li==null)
		{
			return null;
		}
		else
		{
			temp = li;
			
			while(temp!=null)
			{
				if(data==temp.item)
				{
					break;
				}
				else if(data>temp.item)
				{
					if(temp.right!=null)
					{
						parent=temp;
					}
					else
					{
						parent=null;
					}
					temp=temp.right;
					leftright=2;
				}
				else
				{
					if(temp.left!=null)
					{
						parent=temp;
					}
					else
					{
						parent=null;
					}
					temp=temp.left;
					leftright=1;
				}
			}
				
			return temp;
		}
	}
	
	public list searchByElement(int data)		//performing node search in the BST
	{
		if(li==null)
		{
			System.out.print("\nSorry the BST is Empty...\n");
			return null;
		}
		else
		{
			list temp = li;
		
			while(temp!=null)
			{
				if(data==temp.item)
				{
					break;
				}
				else if(data>temp.item)
				{
					temp=temp.right;
				}
				else
				{
					temp=temp.left;
				}
			}
				
			return temp;
		}
	}
	
	public void show(int sel)		//display the BST elements
	{
		if(li==null)
		{
			System.out.print("\nThe List is Empty\n");
		}
		
		else
		{
			list temp=li;
			System.out.print("\nThe Tree is:-\n");
			
			if(sel==1)
			{
				recursionShow_Preorder(li);	//will call Function to perform Preorder Traversal
			}	
			
			else if(sel==2)
			{
				recursionShow_Postorder(li); //will call Function to perform Postorder Traversal
			}	
			
			else
			{
				recursionShow_Inorder(li); //will call Function to perform Inorder Traversal
			}	
			
		}
	}
	
	private void recursionShow_Preorder(list l)	//1		//recursion function for Preorder traversal
	{
		System.out.print(l.item+"\n");
		
		if(l.left!=null)
		{
			recursionShow_Preorder(l.left);
		}
		
		if(l.right!=null)
		{
			recursionShow_Preorder(l.right);
		}
	}
	
	private void recursionShow_Postorder(list l) //2	//recursion function for Postorder traversal
	{
		if(l.left!=null)
		{
			recursionShow_Postorder(l.left);
		}
		
		if(l.right!=null)
		{
			recursionShow_Postorder(l.right);
		}
		
		System.out.print(l.item+"\n");
	}
	
	private void recursionShow_Inorder(list l)	//3		//recursion function for Inorder traversal
	{
		if(l.left!=null)
		{
			recursionShow_Inorder(l.left);
		}
		
		System.out.print(l.item+"\n");
		
		if(l.right!=null)
		{
			recursionShow_Inorder(l.right);
		}
	}
	
	public int getTreeSize()
	{
		return pos;
	}
	
};

class Binary_Search_Tree
{
	public static void main(String arg[])			//Main function
	{
		int choice, ans=1, element, position, size;
		list lt=null;
		
		Scanner x = new Scanner(System.in);
	
		bst_methods l = new bst_methods();
		
		while(ans==1)						//Menu Driven
		{
			System.out.print("\n\n\nEnter from Below:-");
			System.out.print("\n1).Insert");
			System.out.print("\n2).Remove");
			System.out.print("\n3).Search by Value");
			System.out.print("\n4).Preorder Traversal");	//1
			System.out.print("\n5).Postorder Traversal");	//2
			System.out.print("\n6).Inorder Traversal");		//3
			System.out.print("\n7).Get Size of the BST");
			System.out.print("\n8).Sorted BST");			//the inorder traversal will provide sorted BST
			System.out.print("\n9).Exit");
			System.out.print("\n\nEnter:");
			
			choice = x.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					System.out.print("\nEnter the Element to Insert:");
					element = x.nextInt();
					
					l.insert(element);
					break;
				}
				
				case 2:
				{
					System.out.print("\nEnter the Element to Delete:");
					element = x.nextInt();
					
					l.delete(element);
					break;
				}
				
				case 3:
				{
					System.out.print("\nEnter the Element to be searched:");
					element = x.nextInt();
					
					lt=l.searchByElement(element);
					if(lt==null)
					{
						System.out.print("\nThe Element is not found in the Tree...\n");
					}
					else
					{
						System.out.print("\nThe Element is found in the Tree...\n");
					}
					break;
				}
				
				case 4:
				{
					l.show(1);
					break;
				}
				
				case 5:
				{
					l.show(2);
					break;
				}
				
				case 6:
				{
					l.show(3);
					break;
				}
				
				case 7:
				{
					size=l.getTreeSize();
					System.out.print("\nThe Size of the BST is:"+size+"\n");
					break;
				}
				
				case 8:
				{
					System.out.print("\nAfter Sorting:-");
					l.show(3);
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