#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter the Directory:"
read dir1
count=0

path=$( find $dir1 -print )

for f in $path								#Iterating for files in folder
do 
	set -- `ls -l --block-size=K "$f"`	
	
	if [ $1 != "total" ]
	then
	
		echo "$9 $5 $6 $7 $8 $1 $3"
		count=$((count+1))
	fi
	
done

echo -e "\nTotal Files: $count"
echo "Total Size:"
echo `du -sh $dir1`

