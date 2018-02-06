#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter the Directory:"
read dir1

iterate=$( find $dir1 -links +1 -type f )		#Finding files of specific type and storing its path in iterate
												#-type f suggests regular file, -links +1 means links greater than 1/multiple links

for f in $iterate								#Iterating for files in folder
do
	echo $f
	
done
