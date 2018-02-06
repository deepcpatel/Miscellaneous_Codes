#!/bin/bash

#Created by Deep C. Patel-1401010

clear

path=$( cut -d : -f1 "/etc/passwd" | sort )

for nm in $path
do 

	set -- `sudo passwd -S $nm`
	
	if [ ! `echo $2` = "P" ]
	then
		echo $nm
	fi
	
done
