#!/bin/bash

#Created by Deep C. Patel-1401010

while [ 1 ]
do
	clear
	
	echo "Welcome, Enter From Following Options:"
	echo "a).Display Current Directory"
	echo "b).List Directory"
	echo "c).Make Directory"
	echo "d).Change Directory"
	echo "e).Copy File"
	echo "f).Rename File"
	echo "g).Delete File"
	echo "h).Edit File"
	echo "i).Exit"
	echo -e "Enter:-\c"
	read ans
	
	case $ans in
		[aA]) 	echo -e "\nThe Current Directory is:`pwd`"
		
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
			
		[bB])	echo -e "\nEnter Directory Path:"
				read dir1
				
				if [ -e $dir1 ]
				then
				
					for f in `ls $dir1`
					do
				
						echo -e "\n$f"
				
					done
				
				else
				
					echo "Sorry The path does not exist......"
				fi
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[cC])	echo -e "\nEnter Directory Name:"
				read dir1
				
				echo -e "\nEnter Path:"
				read path
				
				if [ -e $path ]
				then
				
					mkdir $path/$dir1
				
				else
				
					echo "Sorry The path does not exist......"
				fi
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[dD])	echo -e "\nEnter Directory Path:"
				read dir1
				
				if [ -e $dir1 ]
				then
				
					cd $dir1
				
				else
				
					echo "Sorry The path does not exist......"
				fi
				
				echo -e "\nPress Any Key to Continue...."
				read v
					
				continue;;
		
		
		[eE])	echo "Enter the Host File Name(full path With Extension):"
				read v2
	
				echo "Enter the Destination Directory:"
				read v3
	
			 	if [ -e $v2 ]
				then
					if [ $v3 ]
					then
						cp -T $v2 $v3
					else
						echo "Less Arguments than Expected"
					fi
				else
					echo "Path Not Found..."
				fi
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[fF])	echo "Enter the File Name to Be Renamed(With Extension):"
				read v2
	
				echo "Enter the New name(With Extension):"
				read v3
	
				if [ -e $v2 ]
				then
					if [ $v3 ]
					then
						mv $v2 $v3
					else
						echo "Less Arguments than Expected"
					fi
				else
					echo "Path Not Found..."
				fi
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;

		[gG])	echo "Enter the File Name to Be Deleted(Full Path With Extension):"
				read v2
	
				if [ -e $v2 ]
				then
					rm -i $v2
				else
					echo "Path Not Found..."
				fi
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[hH])	echo "Enter the File Name to Be Edited(Full Path With Extension):"
				read v2
	
				if [ -e $v2 ]
				then
					nano $v2
				else
					echo "Path Not Found..."
				fi
				
				echo -e "\nPress Any Key to Continue...."
				read v
				
				continue;;
		
		[iI])	echo "Bye........"
				exit;;
		
		*)	echo "Choice Not Found, try again..."
			continue;;
			
	esac

done
