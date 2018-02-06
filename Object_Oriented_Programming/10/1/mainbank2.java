import java.util.*;
import java.io.*;

class customException extends Exception                 //custom exception handling class
{
    String exception = "\nSorry! You entered a Negative Amount";

    public customException()
    {

    }

    public String getMessage()
    {
        return exception;
    }
};

class customExceptionw extends Exception                 //custom exception handling class
{
    String exception = "Sorry! You Withdrawed more than the withdrawl limit ";

    public customExceptionw()
    {

    }

    public String getMessage()
    {
        return exception;
    }
};

abstract class Account implements Serializable          //account class
{
    private String accountNo;

    protected float balance;

    private float dummy;                        //to return

    private static int st=-1;                   //to assign account no a negative value

    private String password;

    public Account(String acc,float bal,String pass)                //constructor
    {
        accountNo=new String(acc);
        balance=bal;
        dummy=0;
        password=pass;
    }

    public abstract boolean withDraw(float bal);            //abstract function for withdraw

    public String getAccountno()            //function returning account number
    {
        return accountNo;
    }

    public float getBalance()               //function returning account balance
    {
    	return balance;
    }

    public void deposit(float b) throws Exception           //function to deposit in an account
    {
    	if(b>0)
        {
            balance=balance+b;

    	    System.out.print("\nAmount Deposited Successfully, ");
    	    System.out.print("\nYour Current Balance is Rs."+balance);

        }

        else
        {
            throw new customException();
        }

    }

    public void setOverdraft(float a)
    {

    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String pass)
    {
        password=pass;

        System.out.print("\nPassword Changed Successfully...");
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

class Savings extends Account implements Serializable                  //savings class
{
    private float interestRate;

    private float interestTerm;

    private float monthTrack;                   //data type to track the months elapsed till last interest deposition

    public Savings(String ac,float bal,String pass)         //savings class constructor
    {

    	super(ac,bal,pass);

    	interestRate=3f;                    //default

    	interestTerm=3f;

    	monthTrack=0;

    }

    public boolean withDraw(float bal)                      //withdraw function to with draw money
    {

    	if(bal>(balance-500))
        {
            return false;
        }

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

class Current extends Account implements Serializable                  //current account class
{
    private float overdraft;

    public Current(String ac,float bal,String pass)             //current constructor
    {

    	super(ac,bal,pass);

    	overdraft=500;
    }

    public boolean withDraw(float bal)          //withdraw function
    {
    	if(bal>(balance+overdraft))
        {
            return false;
        }


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


class mainbank2                                        //main class
{

    public static String makePassword(long acc)         //function to generate random password
    {
        String password;
        int sum=0;

        for(int i=0;i<11;i++)
        {
            sum=sum+((int)(acc%10));
            acc=acc/10;
        }

        Random rand=new Random();
        int randomNum = rand.nextInt((sum*300) + 1);

        randomNum*=100;

        password=Integer.toString(randomNum);

        return password;


    }

    public static String new_accountNo(long acc_no)       //to convert the long to string
    {

        String s=Long.toString(acc_no);

        return s;
    }

    public static void main(String [] arg) throws Exception                  //main function
    {
        Scanner x=new Scanner(System.in);

        Account a, a1;

        int input,ans,i,j;
        float balance,amount,od,interest;
        String m,s,pass,password="password",ss,pa,p1,path,n;
        char ch='Y';
        long acc_nos, acc_noc ,acno,ac;
        boolean feed;



        p:
        do                                                                  //menu driven program
        {
          try
          {

            try
            {
                FileReader fr =new FileReader("acc_nos.bin");

                i=fr.read();

                fr.close();

            }
            catch(Exception e)
            {
                File dir =new File("Accounts");
                dir.mkdirs();

                FileWriter fw = new FileWriter("acc_nos.bin");

                fw.write(0);

                fw.close();

                FileWriter fw1 = new FileWriter("acc_noc.bin");

                fw1.write(0);

                fw1.close();

                continue p;
            }

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
                        System.out.print("\n3).Exit");
                        System.out.print("\nEnter:");

                        ans=x.nextInt();

                        if(ans==1)
                        {
                             FileReader fr1 =new FileReader("acc_nos.bin");

                             i=fr1.read();
                             acc_nos=1000000000+i;

                             fr1.close();

                            System.out.print("\nPlease Deposit the initial Amount to Open the Account(Minimum:Rs.1000):Rs.");
                            amount=x.nextFloat();

                            if(amount>=1000)
                            {
                                m=new_accountNo(acc_nos);
                                pa=makePassword(acc_nos);

                                FileOutputStream fout = new FileOutputStream("Accounts/"+m+".bin");
                                ObjectOutputStream oOut = new ObjectOutputStream(fout);

                                i=i+1;

                                a=new Savings(m,amount,pa);

                                FileWriter fw1= new FileWriter("acc_nos.bin");

                                fw1.write(i);

                                fw1.close();
//------------------------------------------------------------------

                                oOut.writeObject(a);
                                oOut.flush();

                                oOut.close();
                                fout.close();

                                System.out.print("\nAccount Created Successfully.....\n\n\n");
                                System.out.print("\nYour Account Number is:"+a.getAccountno());
                                System.out.print("\nYour password is:"+a.getPassword());
                                System.out.print("\nYour Savings Account Balance is:Rs."+a.getBalance()+"\n\n\n");


                            }
                            else
                            {
                                System.out.print("\nAccount Creation Unsuccessful, Please Deposit the amount greater than 1000......");
                            }


                        }

                        else if(ans==2)
                        {

                             FileReader fr1 =new FileReader("acc_noc.bin");

                             j=fr1.read();

                             acc_noc=1100000000+j;

                             fr1.close();


                            System.out.print("\nPlease Deposit the initial Amount to Open the Account:Rs.");

                            amount=x.nextFloat();

                            if(amount<0)
                            {
                                System.out.print("\nSorry You entered negative Balance, please restart again....");

                                continue p;
                            }

                            m=new_accountNo(acc_noc);

                            pa=makePassword(acc_noc);


                            j=j+1;

                            FileOutputStream fout = new FileOutputStream("Accounts/"+m+".bin");
                            ObjectOutputStream oOut = new ObjectOutputStream(fout);

                            a=new Current(m,amount,pa);

                            FileWriter fw1 = new FileWriter("acc_noc.bin");

                            fw1.write(j);

                            fw1.close();

                            oOut.writeObject(a);
                            oOut.flush();

                            oOut.close();
                            fout.close();


                            System.out.print("\nAccount Created Successfully....\n\n\n");
                            System.out.print("\nYour Account Number is:"+a.getAccountno());
                            System.out.print("\nYour password is:"+a.getPassword());
                            System.out.print("\nYour Current Account Balance is:Rs."+a.getBalance()+"\n\n\n");



                        }

                        else
                        {
                            continue p;
                        }

                        continue p;

                case 2:

                        System.out.print("\n\nEnter the Customer's Bank Account Number:");
                        acno=x.nextLong();


                        ss=Long.toString(acno);           //convert long to string

                        path="Accounts/"+ss+".bin";

                        File f=new File(path);

                        if(f.exists()==false)
                        {
                            System.out.print("\nSorry The Account Number Not found...");
                            continue p;
                        }

                        FileInputStream fin = new FileInputStream(path);
                        ObjectInputStream oIn1 = new ObjectInputStream(fin);

                        System.out.print("\nThe Account Number found, Enter the Account Password to Continue:");
                        pa=x.next();




                        if(acno/100000000==11)
                        {
                            a1=(Current) oIn1.readObject();

                            FileOutputStream fout = new FileOutputStream(path);
                            ObjectOutputStream oOut1 = new ObjectOutputStream(fout);


                            s=a1.getPassword();

                            if(!pa.equals(s))
                            {
                                System.out.print("\n\nSorry the Password is Incorrect....\n\n\n");

                                oOut1.writeObject(a1);
                                oOut1.flush();

                                oOut1.close();
                                oIn1.close();
                                fin.close();
                                fout.close();

                                continue p;
                            }


                            System.out.print("\n\nCurrent Account Menu:-");
                            System.out.print("\n1).Deposit Amount");
                            System.out.print("\n2).Withdraw Money from Account");
                            System.out.print("\n3).Set Overdraft Limit");
                            System.out.print("\n4).See the Balance");
                            System.out.print("\n5).See the Existing Overdraft Limit");
                            System.out.print("\n6).Change Account Password");
                            System.out.print("\n7).Delete This Account");
                            System.out.print("\n8).Exit");
                            System.out.print("\nEnter:");

                            ans=x.nextInt();

                            switch(ans)
                            {
                                case 1: System.out.print("\nEnter the Amount to Deposit:");
                                        amount=x.nextFloat();

                                        try
                                        {
                                            a1.deposit(amount);
                                        }
                                        catch(Exception e)
                                        {
                                            oOut1.writeObject(a1);
                                            oOut1.flush();

                                            System.out.print(e.getMessage());
                                            continue p;
                                        }


                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 2: System.out.print("\nEnter the Amount to Withdraw:");
                                        amount=x.nextFloat();

                                        feed=a1.withDraw(amount);

                                        try
                                        {
                                           if(feed==true)
                                           {
                                                    System.out.print("\nWithdrawn Successful");
                                                    System.out.print(", Your Current Balance is Rs."+a1.getBalance()+"\n\n");
                                           }

                                           else
                                           {
                                                    throw new customExceptionw();
                                           }
                                        }

                                        catch(Exception e)
                                        {
                                                    System.out.print(e.getMessage());

                                                    oOut1.writeObject(a1);
                                                    oOut1.flush();

                                                    continue p;
                                        }

                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 3: System.out.print("\nEnter the Bank Manager's Password to Continue:");
                                        pass=x.next();

                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                   //compares the value of string
                                            System.out.print("\nEnter the Overdraft limit To be set:");

                                            od=x.nextFloat();

                                            a1.setOverdraft(od);
                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }


                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 4: System.out.print("\nThe Balance is Rs."+a1.getBalance()+"\n\n");

                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 5: System.out.print("\nThe existing Overdraft Limit is Rs."+a1.getOverdraft()+"\n\n\n");

                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 6: System.out.print("\nEnter the Bank Manager's Password to Continue:");
                                        pass=x.next();

                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                   //compares the value of string
                                            System.out.print("\nEnter the New Password To be set(Min. 5 Characters):");

                                            p1=x.next();

                                            a1.setPassword(p1);

                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }


                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 7: oOut1.writeObject(a1);
                                        oOut1.flush();
                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        File f1 = new File(path);
                                        f1.delete();

                                        System.out.print("\nThe Account is Deleted, Hope You Open Another One...");


                                        continue p;

                                default:
                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;



                            }


                        }
                        else
                        {
                          a1=(Savings) oIn1.readObject();

                          FileOutputStream fout = new FileOutputStream(path);
                          ObjectOutputStream oOut1 = new ObjectOutputStream(fout);

                          s=a1.getPassword();

                           if(!pa.equals(s))
                            {
                                System.out.print("\n\nSorry the Password is Incorrect....\n\n\n");

                                oOut1.writeObject(a1);
                                oOut1.flush();

                                oOut1.close();
                                oIn1.close();
                                fin.close();
                                fout.close();

                                continue p;
                            }

                            System.out.print("\nSavings Account Menu:-");
                            System.out.print("\n1).Deposit Amount");
                            System.out.print("\n2).Withdraw Money from Account");
                            System.out.print("\n3).Set Interest Rate");
                            System.out.print("\n4).Set Interest Period");
                            System.out.print("\n5).See the Balance");
                            System.out.print("\n6).See the Existing Interest Rate");
                            System.out.print("\n7).See the Interest Period");
                            System.out.print("\n8).See the Interest for the Account");
                            System.out.print("\n9).Change Account Password");
                            System.out.print("\n10).Delete This Account");
                            System.out.print("\n11).Exit");
                            System.out.print("\nEnter:");

                            ans=x.nextInt();

                            switch(ans)
                            {
                                case 1: System.out.print("\nEnter the Amount to Deposit:");
                                        amount=x.nextFloat();

                                        try
                                        {
                                            a1.deposit(amount);
                                        }
                                        catch(Exception e)
                                        {
                                            oOut1.writeObject(a1);
                                            oOut1.flush();

                                            System.out.print(e.getMessage());
                                            continue p;
                                        }


                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 2: System.out.print("\nEnter the Amount to Withdraw:");
                                        amount=x.nextFloat();

                                        feed=a1.withDraw(amount);

                                        try
                                        {
                                           if(feed==true)
                                           {
                                                    System.out.print("\nWithdrawn Successful");
                                                    System.out.print(", Your Current Balance is Rs."+a1.getBalance()+"\n\n");
                                           }

                                           else
                                           {
                                                    throw new customExceptionw();
                                           }
                                        }

                                        catch(Exception e)
                                        {
                                                    System.out.print(e.getMessage());

                                                    oOut1.writeObject(a1);
                                                    oOut1.flush();

                                                    continue p;

                                        }


                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 3: System.out.print("\nEnter the Bank Manager's Password to Continue:");
                                        pass=x.next();

                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                   //compares the value of string
                                            System.out.print("\nEnter the new Interest rate:");
                                            interest=x.nextFloat();

                                            a1.setRate(interest);
                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }


                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 4: System.out.print("\nEnter the Bank Manager's Password to Continue:");
                                        pass=x.next();


                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                    //compares the value of string
                                            System.out.print("\nEnter the new Interest Period:");
                                            interest=x.nextFloat();

                                            a1.setTerm(interest);
                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }

                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 5: System.out.print("\nThe Balance is Rs."+a1.getBalance()+"\n\n");

                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 6: System.out.print("\nThe Existing Interest Rate is:"+a1.getRate()+" %\n\n");

                                        oOut1.writeObject(a1);
                                        oOut1.flush();


                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 7: System.out.print("\nThe Interest Period is:"+a1.getTerm()+" Months\n\n");

                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 8: System.out.print("\nEnter the total Months Passed since The Account Opened:");
                                        amount=x.nextFloat();

                                        System.out.print("\nCongratulations!, Your Account got Rs."+a1.interest(amount)+" as the interest amount,");
                                        System.out.print(" and The Current Balance after Interest Addition is Rs."+a1.getBalance()+"\n\n\n");


                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 9: System.out.print("\nEnter the Bank Manager's Password to Continue:");
                                        pass=x.next();

                                        if(pass.equals(password))           //==compares the two string object while .equals()
                                        {                                   //compares the value of string
                                            System.out.print("\nEnter the New Password To be set(min 5 Characters):");

                                            p1=x.next();

                                            a1.setPassword(p1);
                                        }
                                        else
                                        {
                                            System.out.print("\nPassword Incorrect....Sorry\n\n\n");
                                        }

                                        oOut1.writeObject(a1);
                                        oOut1.flush();


                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;

                                case 10:oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        File f1 = new File(path);
                                        f1.delete();

                                        System.out.print("\nThe Account is Deleted, Hope You Open Another One...");

                                        continue p;


                                default:
                                        oOut1.writeObject(a1);
                                        oOut1.flush();

                                        oOut1.close();
                                        oIn1.close();
                                        fin.close();
                                        fout.close();

                                        continue p;


                            }


                        }

                default:ch='n';
                        break;

            }

          }

          catch(InputMismatchException e)
          {
              System.out.print("\nYou Somewhere made a mistake Entering the Details(Hint:-Characters instead of Numbers), Try Again..\n");
              break;
          }

        }while(ch=='y'||ch=='Y');



    }
};