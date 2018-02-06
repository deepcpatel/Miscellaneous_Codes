#!/bin/bash

#Created by Deep C. Patel-1401010

clear
echo "Enter Directory:"
read path

echo "We are searching files starting with po and giving details of it:"

count=1

path1=$( echo $path | find -type f )

for name in $path1
do

	name1=$( basename "$name" )	
	var=$( echo $name1 | cut -c1-2 )
	
	if [ $var = "po" ]
	then
	
		echo "po $count : `ls -l $name`"
		
		count=$((count+1))
	
	fi

done
