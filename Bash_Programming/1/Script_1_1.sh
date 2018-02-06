#!/bin/bash

#Created By:-Deep C. Patel, 1401010

clear

echo "Enter the Mode (-r->Rename, -c->Copy Contents, -d->Delete File)"
read v1

if [ $v1 = "-r" ]
then	
	echo "Enter the File Name to Be Renamed(With Extension)"
	read v2
	
	echo "Enter the New name(With Extension)"
	read v3
	
	if [ -e $v2 ]
	then
		if [ $v3 ]
		then
			mv -i $v2 $v3
		else
			echo "Less Arguments than Expected"
		fi
	else
		echo "Path Not Found..."
	fi

elif [ $v1 = "-d" ]
then

	echo "Enter the File Name to Be Deleted(With Extension)"
	read v2
	
	if [ -e $v2 ]
	then
		rm -i $v2
	else
		echo "Path Not Found..."
	fi

elif [ $v1 = "-c" ]
then
	echo "Enter the Host File Name(With Extension)"
	read v2
	
	echo "Enter the Destination File Name(With Extension)"
	read v3
	
 	if [ -e $v2 ]
	then
		if [ $v3 ]
		then
			cp -Ti $v2 $v3
		else
			echo "Less Arguments than Expected"
		fi
	else
		echo "Path Not Found..."
	fi

else
	echo "Error:Syntax Wrong.."
fi

