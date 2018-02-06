#!/bin/bash

#Created by Deep C. Patel-1401010

clear

file="/home/ramkabir/Documents/Deep/OS/Lab/Lab-1/poem.txt"

while [ 1 ]
do
	clear
	
	echo "Welcome, Enter From Following Options:"
	echo "a).Count the Lines, Words, Characters"
	echo "b).Pick up the lines containing word ‘fleas’ from file poem"
	echo "c).Pick up the lines not containing word ‘fleas’ from file poem"
	echo "d).Sort the file poem in line-by-line fashion in"
	echo "e).Print last three lines of the file poem"
	echo "f).Print last lines starting from 3rd line one."
	echo "g).Create poem and poem_new and compare them"
	echo "h).Exit"
	echo -e "Enter:-\c"
	read ans
	
	case $ans in
		[aA]) 	set -- `wc $file`
				echo -e "\nLines:$1"
				echo "Words:$2"
				echo "Characters:$3"
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
			
		[bB])	echo -e "\n"
				grep -w "fleas" $file
		
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[cC])	echo -e "\n"
				grep -v "fleas" $file
		
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[dD])	echo -e "\n1).Reverse normal"
				echo "2).Numeric"
				echo "3).Reverse numeric"
				echo "4).Fold high and lower case together"
				echo "5).Sort starting at (n+1) th field"
				echo -e "Enter:-\c"
				read a1
				echo -e "\n"
				
				case $a1 in
					[1])	cat $file | sort -r
							;;
					
					[2]) 	cat $file | sort -n
							;;
					
					[3]) 	cat $file | sort -n -r
							;;
					
					[4]) 	cat $file | sort -f	#export LC_ALL=C
							;;
					
					[5])	echo -e "\nEnter n(<15):\c"
							read no
							echo -e "\n"
							
							var=`tail -n+$no $file`
							
							grep -v "$var" $file
							
							echo "$var" | sort
							
							;;
					
					*)	echo "Choice Not Found, try again..."
				
				esac
				
				echo -e "\nPress Any Key to Continue...."
				read v
					
				continue;;
		
		
		[eE])	echo -e "\n"
				tail -n+13 $file
		
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[fF])	echo -e "\n"
				tail -n+3 $file
		
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;

		[gG])	echo -e "\nPress Any Key to Continue...."
				read v
				continue;;
		
		[hH])	echo "Bye........"
				exit;;
		
		*)	echo "Choice Not Found, try again..."
		
			echo -e "\nPress Any Key to Continue...."
			read v
			
			continue;;
			
	esac

done
