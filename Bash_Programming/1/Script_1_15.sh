#!/bin/bash

#Created by Deep C. Patel-1401010

clear
	
echo "Enter the file Name(Full Path with Extension):"
read file1
	
while [ 1 ]
do
	clear
	
	echo "Welcome, Enter From Following Options:"
	echo "a).Show Count of Characters, Words and Lines"
	echo "b).Print File in a Reversed order"
	echo "c).Find Frequency of a Word in the File"
	echo "d).Show Lower case letters in place of Upper Case Alphabets"
	echo "e).Exit"
	echo -e "Enter:-\c"
	read ans
	
	case $ans in
	
		[aA]) 	echo -e "\nLines:`wc -l < $file1`"
				echo "Words:`wc -w < $file1`"
				echo "Characters:`wc -m < $file1`"
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
			
		[bB])	tac $file1 > "temp.txt"
				cat "temp.txt"
				rm "temp.txt"
		
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[cC])	echo -e "\nEnter Word:"
				read word
				
				count=0
				
				wrd=$( cat $file1 | tr [:space:] '\n' | tr -d '[:punct:]' | grep -v "^\s*$")
				
				for w in $wrd
				do
				
					if [ $w = $word ]
					then
					
						(( count++ )) 
					
					fi
				
				done
				
				echo -e "\nThe Word Appeared $count times"
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[dD])	tr '[A-Z]' '[a-z]' < $file1
				
				echo -e "\nPress Any Key to Continue...."
				read v
					
				continue;;
		
		
		[eE])	echo "Bye............"
				exit;;
				
		*)	echo "Choice Not Found, try again..."
			continue;;
			
	esac

done
