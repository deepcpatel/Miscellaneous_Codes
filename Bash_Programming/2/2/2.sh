#!/bin/bash

#Created by Deep C. Patel - 1401010

clear

echo -e "\nEnter Path:"
read path

cd $path

clear

while true
do 

	echo -e "\nEnter from following:-" 	
	echo "1).See Biggest Files"
	echo "2).See Smallest Files"
	echo "3).Exit" 
	echo -e "Enter:\c"
	read choice

	case $choice in
		 [1])	
				set `ls -lR | awk '{ print $1 "\t" $5 "\t" $9 }'| awk '/^[-]/' | awk '{ print $2 "\t" $3 }' | sort -nr`
				
				echo $2
				
				stop=$1
				
				shift 2

				for true
				do
					if [ "$1" = "$stop" ]
					then
					
						echo $2
						shift 2
						
					else
					
						break;
						
					fi
					
				done
			
				echo -e "\nPress any Key to Continue"
				read ch
				continue;;

		[2])
				set `ls -lR | awk '{ print $1 "\t" $5 "\t" $9 }'| awk '/^[-]/' | awk '{ print $2 "\t" $3 }' | sort -n `
				
				echo $2
				
				stop=$1
				
				shift 2

				for true
				do
					if [ "$1" = "$stop" ]
					then
					
						echo $2
						shift 2
						
					else
					
						break;
						
					fi
					
				done
				
				echo -e "\nPress any Key to Continue"
				read ch
				continue;;
				
		[3]) exit;;
		
		*)
			echo -e "\nImproper Choice, Press any Key to Continue"
			read ch
			continue;;
			
	esac
done	

