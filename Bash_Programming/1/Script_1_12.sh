#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter the Directory:"
read dir1

path=$( find $dir1 -type f ) 

for f in `ls -S $path`
do

	echo `basename $f`

done
