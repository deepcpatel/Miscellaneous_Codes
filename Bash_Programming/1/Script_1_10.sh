#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter the Directory:"
read dir1

iterate=$( find $dir1 -executable -type f )				#Finding files of specific type and storing its path in iterate
														#-type f suggests regular file, -executable suggest find executable files

for f in $iterate										#Iterating for files in folder
do
	echo "Executable File is: ` basename "/$f" `"
	
done
