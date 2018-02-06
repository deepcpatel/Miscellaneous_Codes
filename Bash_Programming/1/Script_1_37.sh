#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter Path:"
read path

echo "Enter Date(yyyy-mm-dd):"
read dt

echo "Enter from below:-"
echo "1).Show files newer than the Date"
echo "2).Show files older than the Date"
echo -e "Enter:\c"
read choice

if [ $choice == `echo "1"` ]
then

	find $path -type f -newermt $dt	#You can add B instead of m for comparing birth time of file, see "man find -newerXY" for more details

elif [ $choice == `echo "2"` ]
then

	find $path -type f ! -newermt $dt
	
else

	echo "Invalid Choice"

fi
