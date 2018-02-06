import java.util.Scanner;

class Media                         //media class declared
{
	private String title;               //data members declared
	private int yearOfPublication;
	private int price;

	public  Media()                             //default constructor
		{
			title=null;
			yearOfPublication=0;
			price=0;
		}

	public Media(String str,int a,int b)       //argument constructor
	       {
			yearOfPublication=a;
			price=b;
			title=new String(str);
	       }

	protected void display()                                    //display function
	       {
			System.out.print("\nThe Title is:"+title);
			System.out.print("\nYear of publication is:"+yearOfPublication);
			System.out.print("\nThe Title Price is:"+price);
	       }



};

class Book extends Media                    //class book inheriting from media class
{
	private String author;                  //data members
	private int no_of_pages;

	public Book()                              //default constructor
	       {
	       		super();                        //calling the constructor of super class
	       		author=null;
	       		no_of_pages=0;


	       }

	public Book(String str1,int year,int price, String str, int pg)             //argument construction
	       {
	       		super(str1,year,price);                                     //calling the super class constructor
	       		author=new String(str);
	       		no_of_pages=pg;

	       		System.out.print("\nDetails entered Successfully");

	       }

	public void display()                                                       //display function for book
	       {
			super.display();                                                    //calling the display function of super class
			System.out.print("\nThe Pages of the Book is:"+no_of_pages);
			System.out.print("\nThe author of the book:"+author);
	       }


};

class CD extends Media                          //class CD inheriting details from class Media
{
	private int sizeInMB;                       //data members
	private int playtime;

	public CD()                                 //default constructor
	       {
	       		super();                        //calling super class constructor
	       		sizeInMB=0;
	       		playtime=0;

	       }

	public CD(String str1,int year,int price,int size, int pt)      //argument constructor of class CD
	       {

	       		super(str1,year,price);                             //calling super class constructor
	       		sizeInMB=size;
	       		playtime=pt;

	       		System.out.print("\nDetails entered Successfully");
	       }

	public void display()                                               //display function for CD
	       {
			super.display();                                            //calling display function for super class
			System.out.print("\nThe Size of the CD is:"+sizeInMB);
			System.out.print("\nThe playtime of the CD is:"+playtime);
	       }
};

class main1                                                          //main function
{
   	public static void main(String[] arg)
   	{
   		int no_of_books,no_of_CD;

   		Scanner input=new Scanner(System.in);

   		System.out.print("\nHow many books you want to buy:");
		no_of_books=input.nextInt();

		System.out.print("\nHow many CD you want to buy:");
		no_of_CD=input.nextInt();


   		Book[] b=new Book[no_of_books];                             //creating Book class object

		CD[] c=new CD[no_of_CD];                                    //creating CD class object

		int i,j,bookNo,cdNo,ans,k=0,l=0,sel=1;

		String tl,author,take;          //take variable is to clear the buffer

		int yr,pgno,pr,size,playtime;


		while(sel==1)                                           //menu driven program
		{
			System.out.print("\nEnter from the choice below:-");
			System.out.print("\n1).To enter Book details");
			System.out.print("\n2).To enter CD details");
			System.out.print("\n3).To display Book Details");
			System.out.print("\n4).To Display CD Details");
			System.out.print("\nEnter:-");
			ans=input.nextInt();

			switch(ans)
			{
				case 1:
                        if(no_of_books!=0)
                            k=1;

			       		for(i=0;i<no_of_books;i++)
				       	{
				       	    System.out.print("\nEnter the details of Book "+(i+1));

				       	    take=input.nextLine();                              //take is to flush the buffer

                            System.out.print("\nEnter book Title:");
                            tl=input.nextLine();

                            System.out.print("\nEnter book's Author name:");
                            author=input.nextLine();

                            System.out.print("\nEnter Year of release:");
                            yr=input.nextInt();

                            System.out.print("\nEnter Pages in the Book:");
                            pgno=input.nextInt();

                            System.out.print("\nEnter Price of the Book:Rs.");
                            pr=input.nextInt();

                            b[i]=new Book(tl,yr,pr,author,pgno);

			       		}


			       		break;

			       	case 2:
                            if(no_of_CD!=0)
                                l=1;

                            for(i=0;i<no_of_CD;i++)
                            {
                                System.out.print("\nEnter the Details of CD "+(i+1));

                                take=input.nextLine();                                  //take is to flush buffer

                                System.out.print("\nEnter CD Title:");
                                tl=input.nextLine();

                                System.out.print("\nEnter CD size in MB:");
                                size=input.nextInt();

                                System.out.print("\nEnter Year of release:");
                                yr=input.nextInt();

                                System.out.print("\nEnter Playtime of the CD:");
                                playtime=input.nextInt();

                                System.out.print("\nEnter Price of the CD:Rs.");
                                pr=input.nextInt();

                                c[i]=new CD(tl,yr,pr,size,playtime);

                            }

                            break;

			        case 3: if(k!=0)
                            {


                                System.out.print("\nEnter which book details to display:");
                                bookNo=input.nextInt();

                                b[bookNo-1].display();
                            }

                            else
                            {
                                System.out.print("\nFirst enter the book");
                            }
                            break;

			        case 4: if(l!=0)
                            {
                                System.out.print("\nEnter which CD details to display:");
                                cdNo=input.nextInt();

                                c[cdNo-1].display();


                            }

                            else
                            {
                                System.out.print("\nFirst enter the CD");
                            }

                            break;

			        default:System.out.print("\nChoice not matched.......");
                            break;
			}

			System.out.print("\n\nDo you want to continue(1/2)");
			sel=input.nextInt();

		}

   	}


};
