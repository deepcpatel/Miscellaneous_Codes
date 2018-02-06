//This code count char and all those things

import java.util.*;
import java.io.*;       //for file handling

public class count1
{

    public static void main(String[] args)      //main function
    {
        String name;                            //string to take the file address

        Scanner x1=new Scanner(System.in);

        System.out.print("\nEnter the Text File Name(In Your Working Directory):");
        name=x1.next();
        try
        {
            FileReader file=new FileReader(name);       //opening reader to read the file
            Scanner line = new Scanner(file);       //opening the scanner for file

            int lineNo = 0, wordCnt = 0, charCnt = 0, spaceCnt=0;           //initializing to zero all the variables

            String line1;

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
            System.out.print("\nNumber of Spaces Are:"+spaceCnt+"\n\n");
            System.out.print("\nTotal Number of Characters Are(Without Space):"+(charCnt-spaceCnt)+"\n\n");


            line.close();               //closing the file
        }

        catch (FileNotFoundException x)             //exception handling
        {
            System.out.print("\n\nSorry The File was Not Found.\n");
        }
    }
};
