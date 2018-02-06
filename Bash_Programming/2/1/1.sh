#!/bin/bash

#Created by Deep C. Patel - 1401010

clear

while true
do 

	echo -e "\nEnter from following:-" 	
	echo "1).Basic Operations Calculator-Floating Point"
	echo "2).Trigonometric Calculations"
	echo "3).Log Calculations"
	echo "4).Exponential Calculations" 
	echo "5).Exit" 
	echo -e "Enter:\c"
	read choice

	case $choice in
		 [1])	
				echo -e "\nEnter from following:-"
				echo "1).Addition"
				echo "2).Subtraction"
				echo "3).Multiplication"
				echo "4).Division"
				echo "5).Modulus"
				echo "6).Exit"
				echo -e "Enter:\c"
				read choice1

				case $choice1 in 
					 [1])  
						echo -e "\nEnter X:\c"
						read x;

						echo -e "Enter Y:\c"
						read y;

						echo -e "\nSum=\c"  
						echo "scale=3;$x+$y" | bc

						echo -e "\nPress any Key to Continue"
						read ch
						continue;;
					 
					[2])  
						echo -e "\nEnter X:\c"
						read x;

						echo -e "Enter Y:\c"
						read y;

						echo -e "\nDifference=\c"  
						echo "scale=3;$x-$y" | bc

						echo -e "\nPress any Key to Continue"
						read ch
						continue;;
			
					[3])	
						echo -e "\nEnter X:\c"
						read x;

						echo -e "Enter Y:\c"
						read y;

						echo -e "\nProduct=\c"  
						echo "scale=3;$x*$y" | bc

						echo -e "\nPress any Key to Continue"
						read ch
						continue;;
			
					[4]) 
						echo -e "\nEnter X:\c"
						read x;

						echo -e "Enter Y:\c"
						read y;

						echo -e "\nQuotient=\c"  
						echo "scale=3;$x/$y" | bc


						echo -e "\nPress any Key to Continue"
						read ch
						continue;;

					[5])   
						echo -e "\nEnter X:\c"
						read x;

						echo -e "Enter Y:\c"
						read y;

						echo -e "\nModulus=\c"  
						echo "$x%$y" | bc

						echo -e "\nPress any Key to Continue"
						read ch
						continue;;
						
					[6]) continue;;
				esac
				continue;;

		 [2])	
			echo -e "\nEnter Angle(degree): \c"
			read angle

			pi=$( echo "4*a(1)" | bc -l )
			rad=$( echo "$angle*($pi/180)" | bc -l )

			sin=$( echo "scale=5;s($rad)" | bc -l )
			cos=$( echo "scale=5;c($rad)" | bc -l )
			 
			echo -e "\nSIN($deg):$sin"
			echo "COS($deg):$cos"
			echo -e "TAN($deg):\c"
			echo "scale=5;$sin/$cos" | bc -l
			echo -e "COSEC($deg):\c"
			echo "scale=5;1/$sin" | bc -l
			echo -e "SEC($deg):\c"
			echo "scale=5;1/$cos" | bc -l
			echo -e "COT($deg):\c"
			echo "scale=5;$cos/$sin" | bc -l
			
			echo -e "\nPress any Key to Continue"
			read ch
			continue;;
			
		 [3])  
			echo -e "\nEnter Number:\c"
			read number
			echo -e "\nAnswer:\c"
			echo "l($number)/l(10)" | bc -l
			
			echo -e "\nPress any Key to Continue"
			read ch
			continue;;
		[4])	
			echo -e "\nEnter a Base:\c"
			read base
			echo -e "Enter Power:\c"
			read power 
			
			echo -e "\nExponent:\c"		
			echo "$base $power" | awk '{ print ((($1)^$2) ); }'		
			
			echo -e "\nPress any Key to Continue"
			read ch
			continue;;
			
		[5]) exit;;
		
		*)
			echo -e "\nImproper Choice, Press any Key to Continue"
			read ch
			continue;;
			
	esac
done	


