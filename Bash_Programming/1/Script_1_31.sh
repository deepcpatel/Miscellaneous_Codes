#!/bin/bash

#Created by Deep C. Patel-1401010

clear

echo "Enter Source Directory:"
read dir1

echo "Enter Destination Directory:"
read dir3

for f in $dir1/*
do

	cp $f $dir3

done
	
