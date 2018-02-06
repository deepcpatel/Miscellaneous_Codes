import java.util.Scanner;

class Matrix
{
	int m;
	int n;
	int[][] matrix;


    	Matrix(int row, int column)     //constructor
    	{
    		m=row;
    		n=column;
    		matrix=new int[m][n];
    	}

    	Matrix(Matrix m1)		// Copy Constructer
    	{
    		this.m=m1.m;
    		this.n=m1.n;

    		matrix=new int[m][n];


    		for(int i=0;i<m;i++)
    		{

    			for(int j=0;j<n;j++)
    			{
    				this.matrix[i][j]=m1.matrix[i][j];
    			}
    		}
    	}

    	public void add()       //function to enter the matrix
    	{
    		Scanner x=new Scanner(System.in);
    		for(int i=0;i<m;i++)
    		{
    			for(int j=0;j<n;j++)
    			{
    				System.out.print("\nEnter the element for "+i+" Row and "+j+" Column:");
    				matrix[i][j]=x.nextInt();
    			}
    		}
    	}

    	public void show()  //function to show the matrix
    	{
    		System.out.print("\nThe Matrix is:\n\n");

    		for(int i=0;i<m;i++)
    		{
    			System.out.print("\n\n");

    			for(int j=0;j<n;j++)
    			{

    				System.out.print("  "+matrix[i][j]);

    			}
    		}
    	}

    	public void transpose()         //function to transpose the matrix
    	{
    		System.out.print("\nThe Transpose of the Matrix is:\n\n");

    		for(int j=0;j<n;j++)
    		{
    			System.out.print("\n\n");

    			for(int i=0;i<m;i++)
    			{

    				System.out.print("  "+matrix[i][j]);
    			}
    		}
    	}

    	public void sum(Matrix m1)      //function to add the two matrix
    	{
    		if((m==m1.m)&&(n==m1.n))
    		{
    			System.out.print("\nThe Sum of the Matrix is:");
    			for(int i=0;i<m;i++)
    			{
    				System.out.print("\n\n");

    				for(int j=0;j<n;j++)
    				{

    					System.out.print("  "+(matrix[i][j]+m1.matrix[i][j]));

    				}
    			}


    		}

    		else
    		{
    			System.out.print("\nSorry the size of both the matrix cannot match, So cannot be Added\n");
    		}
    	}

    	public void multiply(Matrix m1)             //function to multiply two matrix
    	{
    		int ans;
    		Scanner x=new Scanner(System.in);

    		System.out.print("\nEnter from following Choices:-");
    		System.out.print("\n1)Matrix-1 X Matrix-2");
    		System.out.print("\n2)Matrix-2 X Matrix-1");
    		System.out.print("\nEnter:");
    		ans=x.nextInt();

    		switch(ans)
    		{
    			case 1: if(this.n==m1.m)
    				{
    					System.out.print("\nThe Product of the Two Matrix is:");

    					for(int i=0;i<m;i++)
    					{
    						System.out.print("\n\n");

    						for(int j=0;j<m1.n;j++)
    						{
    							int sum=0;

    							for(int k=0;k<n;k++)
    							{
    								sum=sum+(matrix[i][k]*(m1.matrix[k][j]));
    							}

    							System.out.print("  "+sum);

    						}
    					}
    					System.out.print("\n");

    				}

    				else
    				{
    					System.out.print("\nSorry could not Multiply, size not Matched\n");
    				}

    				break;

			case 2: if(m1.n==this.m)
    				{
    					System.out.print("\nThe Product of the Two Matrix is:");
    					for(int i=0;i<m1.m;i++)
    					{
    						System.out.print("\n\n");

    						for(int j=0;j<n;j++)
    						{
    							int sum=0;

    							for(int k=0;k<m1.n;k++)
    							{
    								sum=sum+(m1.matrix[i][k]*(matrix[k][j]));
    							}

    							System.out.print("  "+sum);

    						}
    					}

    					System.out.print("\n");
    				}

    				else
    				{
    					System.out.print("\nSorry could not Multiply, size not Matched\n");


    				}

    				break;

    			default:System.out.print("\nInvalid choice.......\n");
    			    	break;
    		}
    	}

    	public void scalar(int k)               //function to multiply the scalar with the matrix
    	{

    		for(int i=0;i<m;i++)
    		{
    			for(int j=0;j<n;j++)
    			{

    				matrix[i][j]=(k*(matrix[i][j]));
    			}
    		}

    		System.out.print("\nThe Scalar is Multiplied Successfully....");

    	}




};

class main                                      //main class
{
	public static void main(String[] arg)
	{
        Scanner x=new Scanner(System.in);

        int i=0, ans, r, c, scalar;

        char ch='y';

        Matrix[] m=new Matrix[2];

        System.out.print("\nEnter the Row Size for Matrix "+(i+1)+":");
        r=x.nextInt();

        System.out.print("\nEnter the Column Size for Matrix "+(i+1)+":");
        c=x.nextInt();

        m[i]=new Matrix(r,c);

        m[i].add();

        i++;

        while(ch=='y'||ch=='y')                                 //menu driven program
        {

            System.out.print("\nEnter from the Following Choices:-");
            System.out.print("\n1).Enter Matrix 2");
            System.out.print("\n2).See the Matrix");
            System.out.print("\n3).Add two Matrix");
            System.out.print("\n4).Transpose the Matrix");
            System.out.print("\n5).Multiply the Matrix");
            System.out.print("\n6).Multiply Scalar to the Matrix");
            System.out.print("\nEnter:");

            ans=x.nextInt();

            switch(ans)
            {
                case 1: if(i==1)
                        {
                            System.out.print("\nEnter from the Following Choices:-");
                            System.out.print("\n1).Make Matrix 2 Same as Matrix 1");
                            System.out.print("\n2).Enter the Matrix 2 with same Row size and Column Size as Matrix 1");
                            System.out.print("\n3).Enter a Different Matrix 2");
                            System.out.print("\nEnter:");

                            ans=x.nextInt();

                            if(ans==1)
                            {
                                m[i]=new Matrix(m[i-1]);
                                i++;
                            }

                            else if(ans==2)
                            {
                                m[i]=new Matrix(r,c);

                                m[i].add();

                                i++;

                            }

                            else if(ans==3)
                            {
                                System.out.print("\nEnter the Row Size for Matrix "+(i+1)+":");
                                r=x.nextInt();

                                System.out.print("\nEnter the Column Size for Matrix "+(i+1)+":");
                                c=x.nextInt();

                                m[i]=new Matrix(r,c);

                                m[i].add();

                                i++;

                            }

                            else
                            {
                                System.out.print("\nSorry Wrong Choice...");
                            }
                        }

                        else
                        {
                            System.out.print("\nMatrix 2 already made, Cannot be re-made, Sorry.... ");
                        }



                        break;

                case 2: System.out.print("\nEnter from the Following Choices:-");
                        System.out.print("\n1).See Matrix 1");
                        System.out.print("\n2).See Matrix 2");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        if(ans==1)
                        {
                            m[0].show();
                        }

                        else if(ans==2)
                        {
                            if(i==2)
                            {
                                m[1].show();
                            }

                            else
                            {
                                System.out.print("\nThe Second Matrix not Exist");
                            }

                        }

                         else
                        {
                            System.out.print("\nSorry Wrong Choice...");
                        }

                        break;

                case 3: if(i==2)
                        {
                            m[0].sum(m[1]);

                        }

                        else
                        {
                            System.out.print("\nMake the Matrix 2 First and then do this Operation...");
                        }

                        break;


                case 4: System.out.print("\nEnter from the Following Choices:-");
                        System.out.print("\n1).Transpose Matrix 1");
                        System.out.print("\n2).Transpose Matrix 2");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        if(ans==1)
                        {
                            m[0].transpose();
                        }

                        else if(ans==2)
                        {

                            if(i==2)
                            {
                                m[1].transpose();
                            }

                            else
                            {
                                System.out.print("\nThe Second Matrix not Exist");
                            }
                        }

                         else
                        {
                            System.out.print("\nSorry Wrong Choice...");
                        }

                        break;

                case 5: if(i==2)
                        {
                            m[0].multiply(m[1]);
                        }

                        else
                        {
                            System.out.print("\nMake the Matrix 2 First and then do this Operation...");
                        }

                        break;

                case 6: System.out.print("\nEnter the Scalar to Multiply the Matrix with:");
                        scalar=x.nextInt();

                        System.out.print("\n\nEnter from the Following Choices:-");
                        System.out.print("\n1).Multiply the Scalar with Matrix 1");
                        System.out.print("\n2).Multiply the Scalar with Matrix 2");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        if(ans==1)
                        {
                            m[0].scalar(scalar);
                        }

                        else if(ans==2)
                        {
                            if(i==2)
                            {
                                 m[1].scalar(scalar);
                            }

                            else
                            {
                                System.out.print("\nThe Second Matrix not Exist");
                            }



                        }

                         else
                        {
                            System.out.print("\nSorry Wrong Choice...");
                        }


                        break;

                default:System.out.print("\nInvalid Choice, Try Again......");
                        break;

            }



            System.out.print("\n\nDo you want to Continue(y/n):");
            ch=x.next().charAt(0);
        }


    }
};

/*

        Matrix m1=new Matrix(2,3);

		m1.add();


		Matrix m2=new Matrix(3,2);

		m2.add();



		m1.show();
		m2.show();


		m1.sum(m2);
		m1.multiply(m2);


*/
