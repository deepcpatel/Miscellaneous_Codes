//Reference: Algorithms 4th Ed, Robert Sedgewick, Kevin Wayne (2011)

#include<stdio.h>

//typedef enum { false, true } bool for boolean capabilities
/*

 Had problem with passing a pointer and then reassigning it in function
 this post helped me:-
 
 http://stackoverflow.com/questions/766893/how-do-i-modify-a-pointer-that-has-been-passed-into-a-function-in-c
 
*/

struct node
{
	int key;
	int value;
	struct node* lc=NULL;
	struct node* rc=NULL;
	int link_color=1;			//0=Black,1=Red
	int N=1;					//No of nodes in this subtree
	
};

//Functions List

struct node* left_rotate(struct node*);
struct node* right_rotate(struct node*);
int isRed(struct node*);
int size(struct node*);
struct node* insert_initialize(struct node*, int, int);
struct node* insert(struct node*,struct node*);
void flipColors(struct node*);
struct node* search(struct node*, int);
struct node* balance(struct node*, int);
struct node* deleteNode_init(struct node*, int);
struct node* deleteNode(struct node*, int);
struct node* deleteMin_init(struct node*);
struct node* deleteMin(struct node*);
struct node* moveRedLeft(struct node*);
struct node* deleteMax_init(struct node*);
struct node* deleteMax(struct node*);
struct node* moveRedRight(struct node*);
struct node* min(struct node*);
struct node* max(struct node*);
int changeVal(struct node*, int, int);

struct node* nodeParent=NULL;

int main()
{
	int choice, s=0, counter=0, temp_val;
	struct node* tempNode;
	struct node* root=NULL;
	
	while(s!=1)
	{
		printf("\n\n==============================================");
		printf("\nEnter From Below List:-");
		printf("\n1).Insert Node");
		printf("\n2).Delete Node");
		printf("\n3).Search Node");
		printf("\n4).Change Value in Node");
		//printf("\n5).Traverse Red-Black Tree");
		printf("\n5).Exit");
		printf("\nEnter:");
		scanf("%d", &choice);
		
		switch(choice)
		{
			case 1: printf("\nEnter Value:");
					scanf("%d",&temp_val);
					
					root=insert_initialize(root,counter,temp_val);
					
					counter++;
					continue;
					
			case 2: if(root==NULL)
					{
						printf("\nSorry tree Does not exist....");
					}
					else
					{
						printf("\nEnter Key:");
						scanf("%d",&temp_val);
						tempNode=deleteNode_init(root,temp_val);
						
						if(tempNode==NULL)
						{
							printf("\nKey does not exist.....");
						}
						else
						{
							root=tempNode;
							printf("\nDelete is Successful.....");
						}
					}
					continue;
					
			case 3: if(counter==0)
					{
						printf("\nSorry tree Does not exist....");
					}
					else
					{
						printf("\nEnter Key:");
						scanf("%d",&temp_val);
						tempNode=search(root,temp_val);
						
						if(tempNode==NULL)
						{
							printf("\nKey does not exist.....");
						}
						else
						{
							printf("\nKey Found");
							printf("\nValue:%d", tempNode->value);
							printf("\nColor(1=>Red,0=>Black):%d", tempNode->link_color);
							if(tempNode==root)
							{
								printf("\nParent Node:No Parent, this is Root");
							}
							else
							{
								printf("\nParent Node:%d", nodeParent->key);
							}
							
						}
					}
					continue;
					
			case 4: if(root==NULL)
					{
						printf("\nSorry tree Does not exist....");
					}
					else
					{
						printf("\nEnter Key:");
						scanf("%d",&temp_val);
						printf("\nEnter new Value:");
						scanf("%d",&choice);		//Variable Reuse
						temp_val=changeVal(root,temp_val,choice);
						
						if(temp_val==-1)
						{
							printf("\nKey does not exist, change operation unsuccessful.....");
						}
						else
						{
							printf("\nChange operation is Successful.....");
						}
					}
					continue;
			/*case 5: 
					continue;*/
					
			case 5: s=1;
					continue;
					
			default: printf("Enter Valid Choice,,");
		}
	}
	
	return 0;
}

struct node* left_rotate(struct node* h)
{
	struct node* x = h->rc;
	h->rc = x->lc;
	x->lc = h;
	
	x->link_color = h->link_color;
	h->link_color = 1;
	
	x->N = h->N;
	h->N = 1 + size(h->lc) + size(h->rc);
	
	return x;
	
}

struct node* right_rotate(struct node* h)
{
	struct node* x = h->lc;
	h->lc = x->rc;
	x->rc = h;
	
	x->link_color = h->link_color;
	h->link_color = 1;
	
	x->N = h->N;
	h->N = 1 + size(h->lc)+ size(h->rc);
	
	return x;
}

int isRed(struct node* n)
{
	if (n == NULL) 
	{
		return 0;
	}
	
	if(n->link_color == 1)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

void flipColors(struct node* n)
{
	n->link_color=!(n->link_color);
	(n->rc)->link_color=!((n->rc)->link_color);
	(n->lc)->link_color=!((n->lc)->link_color);
}

int size(struct node* n)
{
	if(n == NULL)
	{
		return 0;
	}
	else
	{
		return (n->N);
	}
}

struct node* insert_initialize(struct node* root, int ky, int val)
{
	struct node* temp = new struct node;
	temp->key=ky;
	temp->value=val;

	root=insert(root,temp);	//See Here double passing of pointer problem
	root->link_color=0;	//Initializing to Black
	
	return root;
	
}

struct node* insert(struct node* n, struct node* temp)
{
	int success;
	
	if(n==NULL)
	{	
		n=temp;
		return n;
	}
	
	if((temp->key)>(n->key))
	{
		n->rc=insert(n->rc, temp);
	}
	else
	{
		n->lc=insert(n->lc, temp);
	}
	
	n=balance(n,0);
	
}

struct node* search(struct node* root, int ky)
{
	int flag=0;
	struct node* temp=root;
	
	while(temp!=NULL)
	{
		if(temp->key==ky)
		{
			return temp;
		}
		else
		{
			nodeParent=temp;
			(ky>temp->key)?(temp=temp->rc):(temp=temp->lc);
		}
	}
	
	return NULL;	//Search Failure
}

struct node* deleteNode_init(struct node* root, int key)
{
	//Assume that root is not NULL, if it is Null then tree is empty and no need for delete
	if(!search(root,key))
	{
		return NULL;//NULL
	}

	// if both children of root are black, set root to red
	if(!isRed(root->lc) && !isRed(root->rc))
	{
		root->link_color=1;
	}
	
	root=deleteNode(root, key);
	
	if(root==NULL)
	{
		root->link_color=0;
	}
	
	return root;
}

struct node* deleteNode(struct node* h, int key) 
{ 
	if(key<h->key)  
	{
		if(!isRed(h->lc) && !isRed((h->lc)->lc))
		{
			h=moveRedLeft(h);
		}		
		h->lc = deleteNode(h->lc, key);
	}
	else 
	{
		if(isRed(h->lc))
		{
			h=right_rotate(h);
		}
		
		if((key==h->key) && (h->rc == NULL))
		{
			return NULL;
		}
		
		if(!isRed(h->rc) && !isRed((h->rc)->lc))
		{
			h=moveRedRight(h);
		}
	
		if(key==h->key) 
		{
			struct node* x = min(h->rc);
			h->key = x->key;
			h->value = x->value;
			
			h->rc=deleteMin(h->rc);
		}
		else 
		{
			h->rc = deleteNode(h->rc, key);
		}
	}
	
	h=balance(h,1);
	
	return h;
}

//For finding minimum node in tree pass the root as parameter where root!=NULL
struct node* min(struct node* x) 
{ 
	//Assume x!=NULL
	if (x->lc==NULL)
	{
		return x; 
	}		
	else                
	{
		return min(x->lc); 
	}
} 

//For finding maximum node in tree pass the root as parameter where root!=NULL
struct node* max(struct node* x) 
{ 
	//Assume x!=NULL
	if (x->rc==NULL)
	{
		return x; 
	}		
	else                
	{
		return max(x->rc); 
	}
} 

struct node* balance(struct node* n, int val)
{
	if(isRed(n->rc) && (val || !isRed(n->lc)))
	{
		n=left_rotate(n);
	}
	
	if(isRed(n->lc) && isRed((n->lc)->lc))
	{
		n=right_rotate(n);
	}
	
	if(isRed(n->lc) && isRed(n->rc))
	{
		flipColors(n);
	}
	
	n->N = size(n->lc) + size(n->rc) + 1;
	
	return n;
	
}

int changeVal(struct node* root, int ky, int newVal)
{
	int flag=0;
	struct node* temp=root;
	
	while(temp!=NULL)
	{
		if(temp->key==ky)
		{
			temp->value=newVal;
			return 1;
		}
		else
		{
			(ky>temp->key)?(temp=temp->rc):(temp=temp->lc);
		}
	}
	
	return -1;	//Search Failure
}

struct node* moveRedLeft(struct node* h) 
{
	// assert (h!= NULL);
	// assert isRed(h) && !isRed(h->lc) && !isRed((h->lc)->lc);

	flipColors(h);
	
	if(isRed((h->rc)->lc)) 
	{ 
		h->rc=right_rotate(h->rc);
		h=left_rotate(h);
		flipColors(h);
	}
	
	return h;
}

struct node* moveRedRight(struct node* h) 
{
	// assert (h!= NULL);
	// assert isRed(h) && !isRed(h->lc) && !isRed((h->lc)->lc);

	flipColors(h);
	
	if(isRed((h->lc)->lc)) 
	{ 
		h->rc=right_rotate(h->rc);
		flipColors(h);
	}
	
	return h;
}

struct node* deleteMin_init(struct node* root) 
{
	//Assume that root is not NULL, if it is Null then tree is empty and no need for delete
	// if both children of root are black, set root to red
	if(!isRed(root->lc) && !isRed(root->rc))
	{
		root->link_color=1;
	}
	
	root=deleteMin(root);
	
	if(root!=NULL)
	{
		root->link_color=0;
	}
	
	return root;
}

// delete the key-value pair with the minimum key rooted at h
struct node* deleteMin(struct node* h) 
{ 
	if(h->lc==NULL)
	{
		return NULL;
	}

	if(!isRed(h->lc) && !isRed((h->lc)->lc))
	{
		h=moveRedLeft(h);
	}
	
	h->lc=deleteMin(h->lc);
	
	h=balance(h,1);
	
	return h;
}

struct node* deleteMax_init(struct node* root) 
{
	//Assume that root is not NULL, if it is Null then tree is empty and no need for delete
	// if both children of root are black, set root to red
	if(!isRed(root->lc) && !isRed(root->rc))
	{
		root->link_color=1;
	}
	
	root=deleteMax(root);
	
	if(root!=NULL)
	{
		root->link_color=0;
	}
	
	return root;
}

// delete the key-value pair with the minimum key rooted at h
struct node* deleteMax(struct node* h) 
{ 
	if (isRed(h->lc))
	{
		h=right_rotate(h);
	}

	if(h->rc==NULL)
	{
		return NULL;
	}

	if(!isRed(h->rc) && !isRed((h->rc)->lc))
	{
		h=moveRedRight(h);
	}
	
	h->rc=deleteMax(h->rc);
	
	h=balance(h,1);
	
	return h;
}
