#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter the Directory(Full Path):"
read dir1

iterate=$( find $dir1 -size 0 -print )

for f in $iterate								#Iterating for files in folder
do
	rm $f
	
done
