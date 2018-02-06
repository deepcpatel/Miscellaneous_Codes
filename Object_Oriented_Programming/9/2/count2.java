
import java.util.*;
import java.io.*;

//class count
public class count2
{

    public static void main(String[] args) throws IOException
	{
	    Scanner x=new Scanner(System.in);

        int ans=1,i1,ans1;

        String name, line1, newName, name2;//string to take the file address

        System.out.print("\n------------------------------------------------------\n");
        System.out.print("\nEnter the Text File Name(In Your Working Directory) to Work Upon:");
        name=x.next();

      p:
        while(ans==1)
        {
            System.out.print("\n----------------------------------------------------\n");
            System.out.print("\nEnter from the Following Choices:-\n\n");
            System.out.print("\n(1).Count the Characters, Lines and Words");
            System.out.print("\n(2).Rename File");
            System.out.print("\n(3).Copy the Content of One File to Another");
            System.out.print("\n(4).Exit");
            System.out.print("\n\nEnter Your Choice:");

            i1=x.nextInt();

            switch(i1)
            {
                case 1:
                        try
                        {       System.out.print("\nDo you want to change file name(1/2):");
                                ans1=x.nextInt();

                                name2=name;         //saving old name

                                if(ans1==1)
                                {
                                    System.out.print("\n------------------------------------------------------\n");
                                    System.out.print("\nEnter the Text File Name(In Your Working Directory) to Work Upon:");
                                    name=x.next();
                                }

                                FileReader file=new FileReader(name+".txt");       //opening reader to read the file
                                Scanner line = new Scanner(file);       //opening the scanner for file

                                int lineNo = 0, wordCnt = 0, charCnt = 0, spaceCnt=0;           //initializing to zero all the variables

                                while (line.hasNextLine())
                                {

                                    line1 = line.nextLine();         //takes the each line of file one by one

                                    lineNo++;                       //counting no of lines

                                    String str [] = line1.split((" "));     //splitting the line to words removing the space characters

                                    for ( int i = 0; i <str.length ; i ++)  //counts the word
                                    {
                                        if (str [i].length() > 0)
                                        {
                                            wordCnt ++;
                                        }


                                    }
                                    charCnt=charCnt+(line1.length());       //counts the characters with spaces

                                    char chArray[]=line1.toCharArray();     //converting string to character array

                                    for(int i=0; i<chArray.length; i++)     //counting no of spaces
                                    {
                                        if(chArray[i]==' ')
                                        {
                                            spaceCnt++;
                                        }
                                    }


                                }

                                System.out.print("\nTotal Number of Lines Are:"+lineNo+"\n\n");
                                System.out.print("\nTotal Numbers of Words Are:"+wordCnt+"\n\n");
                                System.out.print("\nTotal Number of Characters Are(Including Space):"+charCnt+"\n\n");
                                System.out.print("\nTotal Number of Characters Are(Without Space):"+(charCnt-spaceCnt)+"\n\n");
                                System.out.print("\nNumber of Spaces Are:"+spaceCnt+"\n\n");

                                name=name2;

                                line.close();               //closing the file

                        }

                        catch (FileNotFoundException x1)             //exception handling
                        {
                            System.out.print("\n\nSorry The File was Not Found....\n");
                        }

                        continue p;

                case 2:
                        try
                        {
                                System.out.print("\nEnter the New Name:");          //entering the file by the User

                                newName=x.next();

                                File old= new File(name+".txt");                       //Old file Name
                                File newName1 = new File(newName+".txt");              //New file name

                                old.renameTo(newName1);                     //renaming the old file

                                System.out.print("\n\nFile Renamed Successfully......");

                                name=newName;

                        }

                        catch(Exception e)              //exception handling
                        {
                            System.out.print("\nThere was an Error Renaming the file...Sorry");
                        }


                        continue p;

                case 3: String line2 = null;        //variable to take the line from file
                        System.out.print("\n-----------------------------------------------\n");
                        System.out.print("\nEnter the File Name In Which to be Copied:");       //file given by user

                        newName=x.next();

                        File dir = new File(".");
                        String source =name+".txt";                     //From this file we get Content
                        String destination =newName+".txt";             //Copy File

                        FileInputStream fis = new FileInputStream(source);
                        BufferedReader in = new BufferedReader(new InputStreamReader(fis)); //Read Data

                        FileWriter fstream = new FileWriter(destination,true);//Write File
                        BufferedWriter out = new BufferedWriter(fstream);

                        while ((line2 = in.readLine()) != null)
                        {

                            out.write(line2);
                            out.newLine();
                        }

                        System.out.print("\nFile Copied Successfully...\n\n");

                        in.close();
                        out.close();

                        continue p;

                default:System.out.print("\n\nThank you Meet you Soon .........\n");
                        ans=2;

                        continue p;

            }

        }


    }

};


