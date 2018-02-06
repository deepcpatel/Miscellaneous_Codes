#!/bin/bash

#Created by Deep C. Patel-1401010

clear
	
echo "Enter the Name of the User:"
read name

parsed=$( who | tr -c [:alpha:] "\n" | sort | uniq )

for nm in $parsed
do

	if [ $nm = $name ]
	then
	
		echo -e "\nUser is Active on the Terminal"
		exit;
	
	fi 

done

echo -e "\nUser Not Active on the Terminal"
