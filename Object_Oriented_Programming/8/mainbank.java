import java.util.*;

abstract class Account              //account class
{
    private String accountNo;

    protected float balance;

    private float dummy;                        //to return

    public Account(String acc,float bal)                //constructor
    {
        accountNo=new String(acc);
        balance=bal;
        dummy=0;
    }

    public abstract boolean withDraw(float bal);            //abstract function for withdraw

    public String getAccountno()            //function returning account number
    {
        return accountNo;
    }

    public float getBalance()           //function returning account balance
    {
    	return balance;
    }

    public void deposit(float b)            //function to deposit in an account
    {
    	if(b>0)
        {
            balance=balance+b;

    	    System.out.print("\nAmount Deposited Successfully, ");
    	    System.out.print("\nYour Current Balance is Rs."+balance);

        }

        else
        {
            System.out.print("\nAmount Deposition Unsuccessful...");
        }

    }

    public void setOverdraft(float a)
    {

    }

     public float getOverdraft()
    {
        return dummy;
    }

    public void setRate(float r)
    {

    }

    public void setTerm(float t)
    {

    }

    public float interest(float months)            //function definitions in account for function overriding
    {
        return dummy;
    }

    public float getRate()
    {
        return dummy;
    }

    public float getTerm()
    {
        return dummy;
    }



};

class Savings extends Account                   //savings class
{
    private float interestRate;

    private float interestTerm;

    private float monthTrack;                   //data type to track the months elapsed till last interest deposition

    public Savings(String ac,float bal)         //savings class constructor
    {

    	super(ac,bal);

    	interestRate=3f;                    //default

    	interestTerm=3f;

    	monthTrack=0;

    }

    public boolean withDraw(float bal)              //withdraw function to with draw money
    {

    	if(bal>(balance-500))
    	    return false;

    	else
    	{
    	    balance=balance-bal;

    	    return true;
    	}


    }


    public void setRate(float r)        //function to set interest rate
    {

    	interestRate=r;

    	System.out.print("\nInterest rate updated...");

    }

    public void setTerm(float t)            //function to set interest term
    {
    	interestTerm=t;

    	System.out.print("\nInterest term updated...");
    }

    public float interest(float totMonths)                //function to calculate interest
    {
    	float interest;
    	float months;

        months=totMonths-monthTrack;

        monthTrack=totMonths;

    	float n=(interestTerm/12);


        interest=(balance*n*months*interestRate)/100;               //simple interest

        balance=balance+interest;

        return interest;

    }

    public float getRate()                      //function to get interest rate
    {
        return interestRate;
    }

    public float getTerm()                      //function to get interest term
    {
        return interestTerm;
    }


};

class Current extends Account                   //current account class
{
    private float overdraft;

    public Current(String ac,float bal)             //current constructor
    {

    	super(ac,bal);

    	overdraft=500;
    }

    public boolean withDraw(float bal)          //withdraw function
    {
    	if(bal>(balance+overdraft))
    		return false;

    	else
    	{
    		balance=balance-bal;

    		return true;
    	}

    }

    public void setOverdraft(float o)           //set overdraft function
    {

    	if(o>=500&&o<=10000000)
    	{
    		overdraft=o;
    		System.out.print("\nOverdraft updated...\n\n");


    	}

    	else
    	{
    		System.out.print("\nOverdraft Updated failed...\n\n");
    	}

    }

    public float getOverdraft()         //function to get overdraft value
    {
        return overdraft;
    }

};


class mainbank                                             //main class
{

    public static String new_accountNo(long acc_no)       //to convert the long to string
    {

        String s=Long.toString(acc_no);

        return s;
    }

    public static void main(String [] arg)                  //main function
    {
        Scanner x=new Scanner(System.in);

        Account[] a;

        a=new Account[1000];

        int input,ans,i=0,input1=-1;
        float balance,amount,od,interest;
        String m,s,pass,password="password",ss;
        char ch='Y';
        long acc_nos=1000000000, acc_noc=1100000000,acno,ac;
        boolean feed;

        p:
        do                                                                  //menu driven program
        {
            System.out.print("\n\n\nEnter from the following choices:-");
            System.out.print("\n1).Open a Bank Account");
            System.out.print("\n2).Go to the Account Menu");
            System.out.print("\n3).Exit");
            System.out.print("\nEnter:");

            input=x.nextInt();

            switch(input)
            {
                case 1: System.out.print("\n\n\nEnter from the following choices:-");
                        System.out.print("\n1).Open Savings Account");
                        System.out.print("\n2).Open Current Account");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        if(ans==1)
                        {
                            System.out.print("\nPlease Deposit the initial Amount to Open the Account(Minimum:Rs.1000):Rs.");
                            amount=x.nextFloat();

                            if(amount>=1000)
                            {
                                m=new_accountNo(acc_nos);

                                acc_nos=acc_nos+1;

                                a[i]=new Savings(m,amount);

                                System.out.print("\nAccount Created Successfully.....\n\n\n");
                                System.out.print("\nYour Account Number is:"+a[i].getAccountno());
                                System.out.print("\nYour Savings Account Balance is:Rs."+a[i].getBalance()+"\n\n\n");

                                i++;

                            }
                            else
                            {
                                System.out.print("\nAccount Creation Unsuccessful, Please Deposit the amount greater than 1000......");
                            }


                        }

                        else
                        {
                            System.out.print("\nPlease Deposit the initial Amount to Open the Account:Rs.");

                            amount=x.nextFloat();

                            m=new_accountNo(acc_noc);

                            acc_noc=acc_noc+1;

                            a[i]=new Current(m,amount);

                            System.out.print("\nAccount Created Successfully....\n\n\n");
                            System.out.print("\nYour Account Number is:"+a[i].getAccountno());
                            System.out.print("\nYour Current Account Balance is:Rs."+a[i].getBalance()+"\n\n\n");

                            i++;
                        }

                        continue p;

                case 2: input1=-1;

                        if(i==0)
                        {
                            System.out.print("\nFirst Create an Account....\n\n\n");
                            continue p;
                        }

                        System.out.print("\n\nEnter the Customer's Bank Account Number:");
                        acno=x.nextLong();

                        ss=Long.toString(acno);           //convert long to string

                        for(int j=0;j<i;j++)                //problem
                        {
                            s=a[j].getAccountno();

                            if(ss.equals(s))
                            {
                                input1=j;
                            }
                        }

                        if(input1==-1)
                        {
                            System.out.print("\n\nSorry the Account Number Not Found....\n\n\n");
                            continue p;
                        }

                        if(acno/100000000==11)
                        {
                            System.out.print("\n\nCurrent Account Menu:-");
                            System.out.print("\n1).Deposit Amount");
                            System.out.print("\n2).Withdraw Money from Account");
                            System.out.print("\n3).Set Overdraft Limit");
                            System.out.print("\n4).See the Balance");
                            System.out.print("\n5).See the Existing Overdraft Limit");
                            System.out.print("\n6).Exit");
                            System.out.print("\nEnter:");

                            ans=x.nextInt();

                            switch(ans)
                            {
                                case 1: System.out.print("\nEnter the Amount to Deposit:");
                                        amount=x.nextFloat();

                                        a[input1].deposit(amount);
                                        continue p;

                                case 2: System.out.print("\nEnter the Amount to Withdraw:");
                                        amount=x.nextFloat();

                                        feed=a[input1].withDraw(amount);

                                        if(feed==true)
                                        {
                                            System.out.print("\nWithdrawn Successful");
                                            System.out.print(", Your Current Balance is Rs."+a[input1].getBalance()+"\n\n");
                                        }
                                        else
                                        {
                                            System.out.print("\n\nWithdrawn Operation Failed, Your Withdrawal Amount exceeds Overdraft Limit\n\n");
                                        }
                                        continue p;

                                case 3: System.out.print("\nEnter the Password to Continue:");
                                        pass=x.next();

                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                   //compares the value of string
                                            System.out.print("\nEnter the Overdraft limit To be set:");

                                            od=x.nextFloat();

                                            a[input1].setOverdraft(od);
                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }

                                        continue p;

                                case 4: System.out.print("\nThe Balance is Rs."+a[input1].getBalance()+"\n\n");
                                        continue p;

                                case 5: System.out.print("\nThe existing Overdraft Limit is Rs."+a[input1].getOverdraft()+"\n\n\n");
                                        continue p;

                                default:continue p;


                            }


                        }
                        else
                        {

                            System.out.print("\nSavings Account Menu:-");
                            System.out.print("\n1).Deposit Amount");
                            System.out.print("\n2).Withdraw Money from Account");
                            System.out.print("\n3).Set Interest Rate");
                            System.out.print("\n4).Set Interest Period");
                            System.out.print("\n5).See the Balance");
                            System.out.print("\n6).See the Existing Interest Rate");
                            System.out.print("\n7).See the Interest Period");
                            System.out.print("\n8).See the Interest for the Account");
                            System.out.print("\n9).Exit");
                            System.out.print("\nEnter:");

                            ans=x.nextInt();

                            switch(ans)
                            {
                                case 1: System.out.print("\nEnter the Amount to Deposit:");
                                        amount=x.nextFloat();

                                        a[input1].deposit(amount);
                                        continue p;

                                case 2: System.out.print("\nEnter the Amount to Withdraw:");
                                        amount=x.nextFloat();

                                        feed=a[input1].withDraw(amount);

                                        if(feed==true)
                                        {
                                            System.out.print("\nWithdrawn Successful");
                                            System.out.print(", Your Current Balance is Rs."+a[input1].getBalance()+"\n\n");
                                        }
                                        else
                                        {
                                            System.out.print("\n\nWithdrawn Operation Failed, account balance goes to Negative....\n\n");
                                        }
                                        continue p;

                                case 3: System.out.print("\nEnter the Password to Continue:");
                                        pass=x.next();

                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                   //compares the value of string
                                            System.out.print("\nEnter the new Interest rate:");
                                            interest=x.nextFloat();

                                            a[input1].setRate(interest);
                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }

                                        continue p;

                                case 4: System.out.print("\nEnter the Password to Continue:");
                                        pass=x.next();


                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                    //compares the value of string
                                            System.out.print("\nEnter the new Interest Period:");
                                            interest=x.nextFloat();

                                            a[input1].setTerm(interest);
                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }

                                        continue p;

                                case 5: System.out.print("\nThe Balance is Rs."+a[input1].getBalance()+"\n\n");

                                        continue p;

                                case 6: System.out.print("\nThe Existing Interest Rate is:"+a[input1].getRate()+" %\n\n");

                                        continue p;

                                case 7: System.out.print("\nThe Interest Period is:"+a[input1].getTerm()+" Months\n\n");

                                        continue p;

                                case 8: System.out.print("\nEnter the total Months Passed since The Account Opened:");
                                        amount=x.nextFloat();

                                        System.out.print("\nCongratulations!, Your Account got Rs."+a[input1].interest(amount)+" as the interest amount,");
                                        System.out.print(" and The Current Balance after Interest Addition is Rs."+a[input1].getBalance()+"\n\n\n");

                                        continue p;

                                default:continue p;
                            }

                        }

                default:ch='n';
                        break;

            }


        }while(ch=='y'||ch=='Y');



    }
};

/*
  System.out.print("\u001b[2J");		//for clear Screen in very old version
  System.out.flush();
  System.out.print("\n2).Withdraw the Money From the account");
  System.out.print("\n3).Deposit the Money to the account");


long l = Long.parseLong(str);               //convert string to long
There is also this method: Long.valueOf(str);
Difference is that parseLong returns a primitive long while valueOf returns a new Long() object.
*/


